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
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.RollingFileAppender;

import salsa.compiler2.SalsaCompiler;

/**
 * Contains the main method of the UAN daemon.
 * 
 * @version %I%, %G%
 * @author Gregory Haik, Carlos Varela, WeiJen Wang, Wei Huang
 */
public class NameServer {

    static {
        if (new File("./log4j.properties").exists()) {
            PropertyConfigurator.configure("./log4j.properties");
        } else {
            Logger rootLogger = Logger.getRootLogger();
            if (!rootLogger.getAllAppenders().hasMoreElements()) {
                rootLogger.setLevel(Level.INFO);
                rootLogger.addAppender(new ConsoleAppender(new PatternLayout(
                        "%-5p - %m%n")));

                Logger fileLogger = rootLogger.getLoggerRepository().getLogger(
                        "salsa");
                try {
                    fileLogger.addAppender(new RollingFileAppender(
                            new PatternLayout(
                                    PatternLayout.TTCC_CONVERSION_PATTERN),
                            "salsa.log"));
                } catch (IOException e) {
                }
            }
        }
    }

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
        logger.info("NameServer listening on port: " + port);

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
            ins = new BufferedReader(new InputStreamReader(
                    clientSocket.getInputStream()));
            outs = new PrintWriter(clientSocket.getOutputStream(), true);

            while (true) {
                String request = ins.readLine();
                if (request == null)
                    break;
                String[] parameters = request.split("#");
                if (parameters.length != 4) {
                    // Bad request;
                    logger.error("Bad Request " + request + " from "
                            + clientSocket.getLocalAddress());
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
                    logger.info("Query " + uan + " Get " + mappedUAL
                            + ", from " + clientSocket.getInetAddress() + ":"
                            + clientSocket.getPort());

                } else if (command.equals(UANProtocol.PUT_REQUEST_CODE)
                        || command.equals(UANProtocol.UPDATE_REQUEST_CODE)) {
                    // handle PUT command
                    if (locationMap.get(uan) != null
                            && command.equals(UANProtocol.PUT_REQUEST_CODE)) {
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
                            logger.info("Update " + uan + " to " + ual
                                    + ", from " + clientSocket.getInetAddress()
                                    + ":" + clientSocket.getPort());
                        else
                            logger.info("Bind " + uan + " to " + ual
                                    + ", from " + clientSocket.getInetAddress()
                                    + ":" + clientSocket.getPort());
                    }

                } else if (command.equals(UANProtocol.DELETE_REQUEST_CODE)) {
                    // Handle delete command
                    synchronized (locationMap) {
                        locationMap.remove(uan);
                    }
                    sb.append(UANProtocol.DELETE_STATUS_CODE);
                    sb.append('#');
                    sb.append(UANProtocol.DELETE_STATUS_STR);
                    logger.info("Delete " + uan + ", from "
                            + clientSocket.getInetAddress() + ":"
                            + clientSocket.getPort());
                } else {
                }
                outs.println(sb.toString());
                outs.flush();
            }
        } catch (IOException e) {
            logger.info("Connection Closed: "
                    + clientSocket.getInetAddress().getHostName() + ":"
                    + clientSocket.getPort());
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

    private static void printUsage(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("theater <options>", options);
    }

    public static void main(String[] args) {
        Option help = new Option("h", "help", false, "Print this message");
        Option version = new Option("v", "version", false,
                "Print the version information and exit");

        Option portOption = OptionBuilder
                .withArgName("port number")
                .hasArg()
                .withDescription(
                        "Specify on which port the theater listens to, default is ")
                .create("p");
        Options options = new Options();
        options.addOption(portOption);
        options.addOption(version);
        options.addOption(help);

        CommandLineParser cmdParser = new GnuParser();
        try {
            // parse the command line arguments
            CommandLine line = cmdParser.parse(options, args);

            if (line.hasOption("h") || line.hasOption("help")) {
                printUsage(options);
                System.exit(0);
            }

            if (line.hasOption("v") || line.hasOption("version")) {
                System.out.println(SalsaCompiler.version);
                System.exit(0);
            }

            if (line.getArgList().size() > 0) {
                printUsage(options);
                System.exit(1);
            }

            int port = 3030;

            if (line.hasOption("p")) {
                try {
                    String s = line.getOptionValue("p");
                    port = Integer.valueOf(s);
                } catch (NumberFormatException e) {
                    throw new ParseException("Invalid port number");
                }
            }
            NameServer ns = new NameServer(port);
            try {
                ns.startService();
            } catch (IOException e) {
                logger.error("Could not listen on port: " + port + ", ", e);
               System.exit(1);
            }

        } catch (ParseException e) {
            System.err.println("" + e.getMessage());
            printUsage(options);
            System.exit(1);
        }
    }
}
