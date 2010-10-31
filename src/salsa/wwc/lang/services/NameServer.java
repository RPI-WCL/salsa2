/**
 * SALSA/World Wide Computer Project
 *
 * Location Server - Universal Actor Name Daemon
 * Provides the location (Universal Actor Location) of an actor running on
 * the World Wide Computer from its name (Universal Actor Name).
 *
 * By Gregory Haik and Carlos Varela.  v0.1  June, 1999
 * Modified by WeiJen to support UANP 0.2
 */
package salsa.wwc.lang.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;




/**
 * Contains the main method of the UAN daemon.
 * 
 * @version %I%, %G%
 * @author Gregory Haik, Carlos Varela, WeiJen Wang, Wei Huang
 */
public class NameServer {

	private long accessCount = 0;

	/**
	 * The default port number is set to 3030.
	 */
	private int port = 3030;

	/**
	 * Mapping from uan to ual
	 */
	private HashMap<String, String> locationMap;

	/**
	 * The server will listen via this socket
	 */
	private ServerSocket serverSocket = null;

	/**
	 * Flag variable for while loop.
	 */
	private boolean flag = true;

	/**
	 * Server version
	 */
	public static final String serverVersion = new String("uand/0.2");
	
	private static Logger logger = Logger.getLogger(NameServer.class);

	public NameServer() {
		locationMap = new HashMap<String, String>();
	}

	public NameServer(int port) {
		this();
		this.port = port;
	}

	/**
	 * Listen on a local port, and wait for incoming connectoin.
	 * 
	 * @throws IOException
	 */
	public void startService() throws IOException {
		serverSocket = new ServerSocket(port);
		System.out.println("NameServer listening on port: " + port);

		int index = 0;
		while (true) {
			final Socket clientSocket = serverSocket.accept();
			Runnable handlerThread = new Runnable() {
				public void run() {
					handleRequest(clientSocket);
				}
			};
			new Thread(handlerThread, "NameServer Thread " + (index++)).start();
		}
	}

	public void handleRequest(Socket clientSocket) {
		BufferedReader ins = null;
		PrintWriter outs = null;
		try {
			ins = new BufferedReader(new InputStreamReader(clientSocket
					.getInputStream()));
			outs = new PrintWriter(clientSocket.getOutputStream(), true);

            while (true) {
                String request = ins.readLine();
                if (request == null)
                    break;
                String[] parameters = request.split("#");
                if (parameters.length != 4) {
                    // Bad request;
                    logger.error("Bad Request " + request + " from " + clientSocket.getLocalAddress());
                }
                String version = parameters[0];
                String command = parameters[1];
                String uan = parameters[2];
                String ual = parameters[3];

                StringBuffer sb = new StringBuffer();
                sb.append(UANProtocol.VERSION);
                sb.append('#');
                if (!version.equals(UANProtocol.VERSION)) {
                    sb.append(UANProtocol.BAD_REQUEST_STATUS_CODE);
                    sb.append('#');
                    sb.append("Wrong Version");
                } else if (command.equals(UANProtocol.GET_REQUEST_CODE)) {
                    // handle GET command
                    String mappedUAL = "";
                    synchronized (locationMap) {
                        mappedUAL = (String) locationMap.get(uan);
                    }
                    if (mappedUAL != null) {
                        sb.append(UANProtocol.FOUND_STATUS_CODE);
                        sb.append('#');
                        sb.append(mappedUAL);
                    } else {
                        sb.append(UANProtocol.NOT_FOUND_STATUS_CODE);
                        sb.append('#');
                        sb.append(UANProtocol.NOT_FOUND_STATUS_STR);
                    }
                    logger.info("Query " + uan + " Get " + mappedUAL + ", from " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());

                } else if (command.equals(UANProtocol.PUT_REQUEST_CODE) || command.equals(UANProtocol.UPDATE_REQUEST_CODE)) {
                    // handle PUT command
                    if (locationMap.get(uan) != null && command.equals(UANProtocol.PUT_REQUEST_CODE)) {
                        sb.append(UANProtocol.BAD_REQUEST_STATUS_CODE);
                        sb.append('#');
                        sb.append(UANProtocol.DUPLICATED_UAN_STR);
                    } else {
                        synchronized (locationMap) {
                            locationMap.put(uan, ual);
                        }
                        sb.append(UANProtocol.MODIFY_STATUS_CODE);
                        sb.append('#');
                        sb.append(UANProtocol.MODIFY_STATUS_STR);
                        if (command.equals(UANProtocol.UPDATE_REQUEST_CODE))
                            logger.info("Update " + uan + " to " + ual + ", from " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
                        else
                            logger.info("Bind " + uan + " to " + ual + ", from " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
                    }

                } else if (command.equals(UANProtocol.DELETE_REQUEST_CODE)) {
                    // Handle delete command
                    synchronized (locationMap) {
                        locationMap.remove(uan);
                    }
                    sb.append(UANProtocol.DELETE_STATUS_CODE);
                    sb.append('#');
                    sb.append(UANProtocol.DELETE_STATUS_STR);
                    logger.info("Delete " + uan + ", from "+ clientSocket.getInetAddress() + ":"+ clientSocket.getPort());                } else {
                }
                outs.println(sb.toString());
                outs.flush();
            }
		} catch (IOException e) {
			logger.info("Connection Closed: " + clientSocket.getInetAddress().getHostName() + ":" + clientSocket.getPort());
		} finally {
			try {
				if (outs != null)
					outs.close();
				if (ins != null)
					ins.close();
				if (clientSocket != null)
					clientSocket.close();
			} catch (Exception exc) {
			}
		}
	}

	static void helpMessage() {
		NameServer.printHelpMessage();
		System.exit(0);
	}

	static void helpMessage(String s) {
		System.out.println(s);
		NameServer.printHelpMessage();
		System.exit(1);
	}

	static void printHelpMessage() {
		System.out.println("usage:");
		System.out.println("  java ...NameServer");
		System.out.println("  java ...NameServer -h");
		System.out.println("  java ...NameServer -v");
		System.out.println("  java ...NameServer -p portNumber");
		System.out.println("options:");
		System.out.println("  -h : print this message");
		System.out.println("  -v : print version");
		System.out
				.println("  -p portNumber : set the listening port to portNumber");
		System.out.println("                  default port number is 3030");
	}

	static void printServerVersion() {
		System.out.println("Universal Actor Name Daemon.");
		System.out.println(serverVersion);
		System.exit(0);
	}

	public static void main(String[] args) {
		int port = 3030;
		for (int x = 0; x < args.length; x++) {
			if (args[x].equals("-h"))
				helpMessage();
			else if (args[x].equals("-v"))
				printServerVersion();
			else if (args[x].equals("-p")) {
				x++;
				try {
					port = Integer.parseInt(args[x]);
				} catch (Exception e) {
					helpMessage("Invalid port number: " + args[x]);
				}
			} else
				helpMessage("illegal option");
		}
		BasicConfigurator.configure();
		NameServer ns = new NameServer(port);
		try {
			ns.startService();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Could not listen on port: " + port + ", " + e);
			System.exit(1);
		}
	}
}
