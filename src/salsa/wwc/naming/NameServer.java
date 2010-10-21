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
package salsa.naming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

/**
 * Contains the main method of the UAN daemon.
 * 
 * @version %I%, %G%
 * @author Gregory Haik, Carlos Varela, WeiJen Wang
 */
public class NameServer {
	static long accessCount = 0;
	static int portNumber = 3030; // The default port number is set to 3030.
	static ServerSocket serverSocket = null; // The server will listen via this
												// socket.
	static final String serverVersion = new String("uand/0.2"); // Location
																// server
																// version.
	static Hashtable locationMap; // Mapping from UAN's to UAL's.
	// Used for communications.
	static private boolean flag = true; // Flag variable for while loop.

	public static void main(String[] argv) {
		for (int x = 0; x < argv.length; x++) {
			if (argv[x].equals("-h"))
				helpMessage();
			else if (argv[x].equals("-v"))
				printServerVersion();
			else if (argv[x].equals("-p")) {
				x++;
				try {
					portNumber = Integer.parseInt(argv[x]);
				} catch (Exception e) {
					helpMessage("Invalid port number: " + argv[x]);
				}
			} else
				helpMessage("illegal option");
		}

		try {
			serverSocket = new ServerSocket(portNumber);
		} catch (IOException e) {
			System.out.println("Could not listen on port: " + portNumber + ", "
					+ e);
			System.exit(1);
		}

		System.out.println("NameServer listening on port: " + portNumber);

		locationMap = new Hashtable();
		int i = 0;
		while (flag) {
			try {
				final Socket clientSocket = serverSocket.accept();

				Runnable handlerThread = new Runnable() {

					public void run() {
						handleRequest(clientSocket);
					}
				};
				new Thread(handlerThread, "NameServer Thread " + i).start();
				i++;
			} catch (IOException e) {
				System.out.println("Accept failed: " + portNumber + ", " + e);
				System.exit(1);
			}
		}
	}

	static void printServerVersion() {
		System.out.println("Universal Actor Name Daemon.");
		System.out.println(serverVersion);
		System.exit(0);
	}

	static void helpMessage(String s) {
		System.out.println(s);
		NameServer.printHelpMessage();
		System.exit(1);
	}

	static void helpMessage() {
		NameServer.printHelpMessage();
		System.exit(0);
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

	/*
   *
   */
	public static void handleRequest(Socket clientSocket) {
		BufferedReader ins = null;
		PrintWriter outs = null;
		try {
			ins = new BufferedReader(new InputStreamReader(clientSocket
					.getInputStream()));
			outs = new PrintWriter(clientSocket.getOutputStream(), true);

//			for (;;) {
				String version = ins.readLine();
				if (version == null) {
//					continue;
					return;
				}
				String command = ins.readLine();
				String parameter1 = ins.readLine();
				String parameter2 = ins.readLine();
				if (!version.equals(UANProtocol.VERSION)) {
					outs.println(UANProtocol.VERSION + "\n"
							+ UANProtocol.BAD_REQUEST_STATUS_CODE + "\n"
							+ "Wrong Version" + "\n");
					outs.flush();
//					continue;
					return;
				} else {
					// handle GET command
					if (command.equals(UANProtocol.GET_REQUEST_CODE)) {
						String mappedUAL = "";
						synchronized (locationMap) {
							mappedUAL = (String) locationMap.get(parameter1);
						}
						if (mappedUAL != null) {
							outs.println(UANProtocol.VERSION + "\n"
									+ UANProtocol.FOUND_STATUS_CODE + "\n"
									+ mappedUAL + "\n");
							outs.flush();
							System.out.println("Query " + parameter1 + " Get "
									+ mappedUAL + ", from "
									+ clientSocket.getInetAddress() + ":"
									+ clientSocket.getPort());
						} else {
							outs.println(UANProtocol.VERSION + "\n"
									+ UANProtocol.NOT_FOUND_STATUS_CODE + "\n"
									+ UANProtocol.NOT_FOUND_STATUS_STR + "\n");
							outs.flush();
							System.out.println("Query " + parameter1 + " Get "
									+ mappedUAL + ", from "
									+ clientSocket.getInetAddress() + ":"
									+ clientSocket.getPort());
						}
//						continue;
						return;

						// handle PUT command
					} else if (command.equals(UANProtocol.PUT_REQUEST_CODE)) {
						if (parameter2 != null) {
							synchronized (locationMap) {
								locationMap.put(parameter1, parameter2);
							}
							outs.println(UANProtocol.VERSION + "\n"
									+ UANProtocol.MODIFY_STATUS_CODE + "\n"
									+ UANProtocol.MODIFY_STATUS_STR + "\n");
							outs.flush();
						}
						System.out.println("Bind " + parameter1 + " to "
								+ parameter2 + ", from "
								+ clientSocket.getInetAddress() + ":"
								+ clientSocket.getPort());

					} else if (command.equals(UANProtocol.DELETE_REQUEST_CODE)) {
						Object obj = null;
						synchronized (locationMap) {
							obj = locationMap.remove(parameter1);
						}
						if (obj != null) {
							outs.println(UANProtocol.VERSION + "\n"
									+ UANProtocol.DELETE_STATUS_CODE + "\n"
									+ UANProtocol.DELETE_STATUS_STR + "\n");
							outs.flush();
							System.out.println("Delete " + parameter1
									+ ", from " + clientSocket.getInetAddress()
									+ ":" + clientSocket.getPort());
						}
					} else {
						outs.println(UANProtocol.VERSION + "\n"
								+ UANProtocol.BAD_REQUEST_STATUS_CODE + "\n"
								+ UANProtocol.BAD_REQUEST_STATUS_STR + "\n");
						outs.flush();
//						continue;
						return;
					}
				}
//			}
		} catch (IOException e) {
			System.out.println("Connection Closed: "
					+ clientSocket.getInetAddress().getHostName() + ":"
					+ clientSocket.getPort());
		} finally {
			try {
				outs.close();
				ins.close();
				clientSocket.close();
			} catch (Exception exc) {
			}
		}
	}
}
