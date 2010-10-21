package salsa.lang.services;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

import com.tangosol.util.ExternalizableHelper;

import salsa.wwc.Message;
import salsa.wwc.ServiceFactory;


/**
 * 
 * @author Travis
 * @author Wei Huang adds supports for timeout disconnection
 * @date Jan 23, 2010
 */
public class OutgoingSocketHandler implements Runnable {
	
	private Socket clientSocket = null;
//	private ObjectOutputStream outputStream = null;
	private DataOutputStream outputStream = null;
	private DataInputStream inputStream = null;
	private List<Object> objects;

	private String targetHost;
	private int targetPort;

	/**
	 * If this socket havn't been used for timeout seconds, close it. 
	 */
	private long timeout = 100000;
	
	private boolean isLive;
	
	public OutgoingSocketHandler(String targetHost, int targetPort) {
		this.targetHost = targetHost;
		this.targetPort = targetPort;
		this.isLive = false;
		objects = new LinkedList<Object>();

	}
	
	public OutgoingSocketHandler(String targetHost, int targetPort, long timeout) {
		this(targetHost, targetPort);
		this.timeout = timeout;
	}

	
	
	public synchronized boolean isLive() {
		return isLive;
	}


	private void initialize() throws IOException {
		try {
			clientSocket = new Socket(targetHost, targetPort);
			inputStream = new DataInputStream(clientSocket.getInputStream());
			outputStream = new DataOutputStream(clientSocket.getOutputStream());
            outputStream.writeUTF(ServiceFactory.getReceptionService()
                    .getHost());
            outputStream.writeInt(ServiceFactory.getReceptionService()
                    .getPort());
            outputStream.flush();
//			outputStream = new ObjectOutputStream((clientSocket
//					.getOutputStream()));
//			outputStream.writeObject(ServiceFactory.getReceptionService()
//					.getHost());
//			outputStream.writeObject(ServiceFactory.getReceptionService()
//					.getPort());
//			outputStream.flush();
			isLive = true;
		} catch(IOException ioe){
			cleanup();
			throw ioe;
		}
	}
	
	private synchronized void cleanup() {
		try {
			if (outputStream != null) {
                byte[] b = ExternalizableHelper.toByteArray(new Message(
                        Message.FINAL_MESSAGE, null, -1, null));
				outputStream.write(b);
				outputStream.flush();
				outputStream.close();
			}
			if (inputStream != null)
			    inputStream.close();
			if (clientSocket != null)
				clientSocket.close();
		} catch (IOException e) {
			
		} finally {
			isLive = false;
			outputStream = null;
			clientSocket = null;
		}
	}

	public synchronized void send(Object object) throws IOException {
		if (!isLive) {
			initialize();
			new Thread(this).start();
		}
		objects.add(object);
		notify();
	}

	private synchronized Object getNext() {
		if (objects.isEmpty()) {

			try {
				wait(timeout);
				// if woke up by timeout, close the connection.
				if (objects.isEmpty()) {
//				    System.err.println("timeout disconnect");
					cleanup();
					return null;
				}
			} catch (Exception e) {
				System.err.println("Error, OutgoingSocketHandler wait.");
				System.err.println("Exception: e");
				e.printStackTrace();
				return null;
			}

		}
		return objects.remove(0);
	}

	public void run() {


		while (true) {
			Object toSend = getNext();
			if (!isLive)
				break;
			try {
			    byte[] b = ExternalizableHelper.toByteArray(toSend);
			    outputStream.write(b);
			    outputStream.flush();
			    inputStream.read(); // For synchronization
			    
			} catch (Exception e) {
			    e.printStackTrace();
				System.err
						.println("Error in OutgoingSocketHandler, writing object: "
								+ toSend);
				System.err.println("Exception: " + e);
				break;
			}
		}
		cleanup();
	}
}
