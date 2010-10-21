package salsa.lang.services;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import com.tangosol.util.ExternalizableHelper;

import salsa.lang.Message;

/**
 * Reception service for remote message receiving
 * @author Travis Desell, Wei Huang
 * @date Apr 17, 2010
 */
public class ReceptionService implements Runnable {
	
	/**
	 * Host name, generated after initialize a socket 
	 */
	private String host = "";
	
	/**
	 * Given by the client 
	 */
	private int port = 4040;
	
	/**
	 * Server socket
	 */
	private ServerSocket server = null;
	
	
	public ReceptionService() {
		this(4040);
	}
	
	public ReceptionService(int port) {
		try {
			host = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		this.port = port;
		startService(true);
	}
	
	/**
	 * Start the reception service
	 * @return true if succeed, false if not
	 */
	public boolean startService() {
		boolean rev = false;
		try {
			server = new ServerSocket(port);
			new Thread(this, "Reception Service Thread").start();
			System.out.println("Reception Service listening on: " + host + ":"
					+ port);
			rev = true;
		} catch (IOException e) {
			System.err.println("Reception Service error:");
			System.err.println("\t" + e.getMessage());
		}
		return rev;
	}
	
	/**
	 * Automatically retry if the port has been used
	 * @param isRetry 
	 * @return
	 * @see salsa.wwc.transport.ReceptionService#startService()
	 */
	public boolean startService(boolean isRetry) {
		while (!startService()) 
			port++;
		return true;
	}

	public int getPort() {
		return port;
	}


	public String getHost() {
		return host;
	}
	
	/**
	 * Check if the message comming from local
	 * @param host
	 * @param port
	 * @return
	 */
	public boolean isLocal(String host, int port) {
		return (this.host.equalsIgnoreCase(host)
				|| host.equalsIgnoreCase("localhost") 
				|| host.equals("127.0.0.1")
				|| host.equals("127.0.1.1"))
				&& this.port == port;
	}
	
	public void run() {
		while (true) {
			try {
				Socket client = server.accept();
				handleIncomingSocket(client);
			} catch (IOException e) {
				System.err.println("Reception Service error: ");
				System.err.println("\tFailed to accept connection.");
				System.err.println("\teException: " + e);
			}
		}
	}

	/**
	 * Handle the incoming socket. The socket will be closed if there is no 
	 * message passing for a period of time.
	 * 
	 * @param clientSocket
	 */
	public void handleIncomingSocket(Socket clientSocket) {
		final Socket incomingSocket = clientSocket;
		Runnable incomingSocketHandler = new Runnable() {
			public void run() {
				String remoteHost;
				int remotePort;
				Object receivedObject = null;
				DataInputStream inputStream = null;
				DataOutputStream outputStream = null;

				try {
					try {
                        inputStream = new DataInputStream(incomingSocket
                                .getInputStream());
                        outputStream = new DataOutputStream(incomingSocket
                                .getOutputStream());
					} catch (IOException e) {
						System.err.println("Reception Service error: ");
						System.err
								.println("\tIOException occured creating " +
										"ObjectInputStream from remote host.");
						System.err.println("\tException: " + e);
						System.err.println("\tException Message: "
								+ e.getMessage());
						e.printStackTrace();
						return;
					}

					try {
						remoteHost = (String) inputStream.readUTF();
						remotePort = inputStream.readInt();
					} catch (Exception e) {
						System.err.println("Reception Service error: ");
						System.err
								.println("\tException occured reading remote " +
										"host and port.");
						System.err.println("\tException: " + e);
						System.err.println("\tException Message: "
								+ e.getMessage());
						e.printStackTrace();
						return;
					}

					if (ServiceFactory.getReceptionService().isLocal(
							remoteHost, remotePort)) {
						System.err
								.println("Reception Service WARNNING: received " +
										"incoming connection from same theater.");
						System.err.println("\thost:port = " + remoteHost + ":"
								+ remotePort);
					}

					Message receivedMessage = null;
					while (true) {
						try {
						    byte[] b = new byte[8192];
						    int len = inputStream.read(b);
						    if (len == -1)
						        break;
						    outputStream.writeByte(1);  // For sync
						    receivedObject = ExternalizableHelper.fromByteArray(b, Message.class.getClassLoader());
							receivedMessage = (Message)receivedObject;
						} catch (ClassCastException e) {
							System.err.println("Reception Service error: " + e.getMessage());
							System.err
									.println("\tIncomingSocketHandler received " +
											"an unknown object.");
							System.err.println("\treceived: " + receivedObject);
//							e.printStackTrace();
						} 
//						catch (ClassNotFoundException e) {
//							System.err.println("Reception Service error: " + e.getMessage());
//							System.err
//									.println("\tCould not load class for an " +
//											"incoming object");
//							System.err
//									.println("\tIs it in the theater CLASSPATH?");
//							System.err.println("\tException: " + e);
//							System.err.println("\treceived: " + receivedObject);
//						} 
						catch (IOException e) {
							System.err.println("Reception Service error: " + e.getMessage());
							System.err
									.println("\tIOException occured closing connection.");
							break;
						}
//                        if (receivedMessage != null) {
//                            if (receivedMessage.getType() == Message.FINAL_MESSAGE) {
//                                break;
//                            } else {
//                                StageService.sendMessage(receivedMessage);
//                            }
//                        } else  {
//                            System.err.println("receivedMessage = null");
//                            break;
//                        }

					}
				} finally {
					try {
						if (inputStream != null)
							inputStream.close();
						if (outputStream != null)
						    outputStream.close();
						if (incomingSocket != null)
							incomingSocket.close();
					} catch (IOException e) {
					}
				}
			}
		};
		new Thread(incomingSocketHandler, "IncomingSocketHandler").start();
	}



}