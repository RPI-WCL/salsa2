package salsa.wwc.lang.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Hashtable;

import org.apache.log4j.Logger;

import salsa.lib.UAN;

public class NamingService {
    
    private Hashtable<String, ConnectionWrapper> connections = new Hashtable<String, ConnectionWrapper>();
    
    private static Logger logger = Logger.getLogger(StageScheduler.class);

    public NamingService() {
    }

    class ConnectionWrapper {
        PrintWriter out = null;
        BufferedReader in = null;
        Socket clientSocket = null;
        long timestamp;

        public ConnectionWrapper(Socket socket) throws IOException {
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

        }

        void update() {
            timestamp = System.currentTimeMillis();
        }

        boolean isTimeOut() {
            return (System.currentTimeMillis() - timestamp) > 5000;
        }

        void close() {
            try {
                if (in != null)
                    in.close();
                if (out != null)
                    out.close();
                if (clientSocket != null)
                    clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private ConnectionWrapper getConnectoinWrapper(String host, int port)
            throws IOException {

        ConnectionWrapper cw = null;
        String key = host + ":" + port;
        synchronized (connections) {
            cw = connections.get(key);
            if (cw == null) {
                Socket clientSocket = new Socket(host, port);
                cw = new ConnectionWrapper(clientSocket);
                connections.put(key, cw);
            }
        }
        return cw;

    }

    public synchronized String get(UAN uan) {

        String version = null, returnCode = null, result = null;
        try {
            ConnectionWrapper cw = getConnectoinWrapper(uan.getHost(),
                    uan.getPort());
            PrintWriter out = cw.out;
            BufferedReader in = cw.in;

            StringBuilder sb = new StringBuilder();
            sb.append(UANProtocol.VERSION);
            sb.append('#');
            sb.append(UANProtocol.GET_REQUEST_CODE);
            sb.append('#');
            sb.append(uan.getIdentifier());
            sb.append('#');
            sb.append(UANProtocol.PSUDO_STR);

            String request = sb.toString();

            out.println(request);
            out.flush();

            /********
             * Read the response
             ********/
            String response = in.readLine();
            String[] parameters = response.split("#");
            if (parameters.length != 3) {
                // Bad Response;
                throw new BadRequestResponseException();
            }

            version = parameters[0];
            returnCode = parameters[1];
            result = parameters[2];

            if (!version.equals(UANProtocol.VERSION)) {
                System.err
                        .println("WWCNamingService warning.  Different Name Server version.");
                System.err.println("Local Version: " + UANProtocol.VERSION);
                System.err.println("Remote Version: " + version);
            } else if (!returnCode.equals(UANProtocol.FOUND_STATUS_CODE)) {
                /********
                 * UAN was not found at the name server
                 ********/
                logger.error("Cannot resolve uan [" + uan.toString() + "]");
            } 

        } catch (Exception e) {
            logger.error("Get " + uan.getIdentifier() + " failed, please check if your nameserver is running", e);
        }
        return result;
    }

    public synchronized void put(UAN uan, String location) {

        String version = null;
        String returnCode = null;
        String result = null;

        try {
            ConnectionWrapper cw = getConnectoinWrapper(uan.getHost(),
                    uan.getPort());
            PrintWriter out = cw.out;
            BufferedReader in = cw.in;

            StringBuilder sb = new StringBuilder();
            sb.append(UANProtocol.VERSION);
            sb.append('#');
            sb.append(UANProtocol.PUT_REQUEST_CODE);
            sb.append('#');
            sb.append(uan.getIdentifier());
            sb.append('#');
            sb.append(location);

            String request = sb.toString();

            /********
             * Send the request
             ********/

            out.println(request);
            out.flush();

            /********
             * Read the response
             ********/
            String response = in.readLine();
            String[] parameters = response.split("#");
            if (parameters.length != 3) {
                // Bad Response;
                throw new BadRequestResponseException();
            }

            version = parameters[0];
            returnCode = parameters[1];
            result = parameters[2];

            if (!version.equals(UANProtocol.VERSION)) {
                System.err
                        .println("WWCNamingService warning.  Different Name Server version.");
                System.err.println("Local Version: " + UANProtocol.VERSION);
                System.err.println("Remote Version: " + version);
            }
            if (!returnCode.equals(UANProtocol.MODIFY_STATUS_CODE)) {
                logger.error("Bind " + uan.getIdentifier() + " to " + location + " failed. Reason: "+ result);
            }
        } catch (Exception e) {
            logger.error("Bind " + uan.getIdentifier() + " to " + location + " failed, please check if your nameserver is running", e);
        }
//        } catch (UnknownHostException e) {
//            System.err.println(e.getMessage());
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        } catch (BadRequestResponseException e) {
//            System.err.println("WWCNamingService error: Bad response");
//        } finally {
//        }
    }

    public synchronized void update(UAN uan, String location) {
        String version = null;
        String returnCode = null;
        String result = null;

        try {
            ConnectionWrapper cw = getConnectoinWrapper(uan.getHost(),
                    uan.getPort());
            PrintWriter out = cw.out;
            BufferedReader in = cw.in;

            StringBuilder sb = new StringBuilder();
            sb.append(UANProtocol.VERSION);
            sb.append('#');
            sb.append(UANProtocol.UPDATE_REQUEST_CODE);
            sb.append('#');
            sb.append(uan.getIdentifier());
            sb.append('#');
            sb.append(location);

            String request = sb.toString();

            /********
             * Send the request
             ********/

            out.println(request);
            out.flush();

            /********
             * Read the response
             ********/
            String response = in.readLine();
            String[] parameters = response.split("#");
            if (parameters.length != 3) {
                // Bad Response;
                throw new BadRequestResponseException();
            }

            version = parameters[0];
            returnCode = parameters[1];
            result = parameters[2];

            if (!version.equals(UANProtocol.VERSION)) {
                System.err
                        .println("WWCNamingService warning.  Different Name Server version.");
                System.err.println("Local Version: " + UANProtocol.VERSION);
                System.err.println("Remote Version: " + version);
            }
            if (!returnCode.equals(UANProtocol.MODIFY_STATUS_CODE)) {
                logger.error("Update  " + uan.getIdentifier() + " to " + location + " failed. Reason: "+ result);
            }
        } catch (Exception e) {
            logger.error("Update " + uan.getIdentifier() + " to " + location + " failed, please check if your nameserver is running", e);
        }
    }

    public synchronized void delete(UAN uan) {

        String version = null;
        String returnCode = null;
        String result = null;

        try {
            ConnectionWrapper cw = getConnectoinWrapper(uan.getHost(),
                    uan.getPort());
            PrintWriter out = cw.out;
            BufferedReader in = cw.in;

            StringBuilder sb = new StringBuilder();
            sb.append(UANProtocol.VERSION);
            sb.append('#');
            sb.append(UANProtocol.PUT_REQUEST_CODE);
            sb.append('#');
            sb.append(uan.getIdentifier());
            sb.append('#');
            sb.append(UANProtocol.PSUDO_STR);

            String request = sb.toString();

            /********
             * Send the request
             ********/

            out.println(request);
            out.flush();

            /********
             * Read the response
             ********/
            String response = in.readLine();
            String[] parameters = response.split("#");
            if (parameters.length != 3) {
                // Bad Response;
                throw new BadRequestResponseException();
            }

            version = parameters[0];
            returnCode = parameters[1];
            result = parameters[2];

            if (!version.equals(UANProtocol.VERSION)) {
                System.err
                        .println("WWCNamingService warning.  Different Name Server version.");
                System.err.println("Local Version: " + UANProtocol.VERSION);
                System.err.println("Remote Version: " + version);
            }
            if (!returnCode.equals(UANProtocol.DELETE_STATUS_CODE)) {
                /********
                 * UAN was put at the name server
                 ********/
                System.err
                        .println("WWCNamingService error. UANP DELETE did not work for: "
                                + request);
            }
        } catch (Exception e) {
            logger.error("Delete " + uan.getIdentifier() + " failed, please check if your nameserver is running", e);
        }
//        } catch (UnknownHostException e) {
//            // TODO Auto-generated catch block
//            // e.printStackTrace();
//            System.err.println(e.getMessage());
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            // e.printStackTrace();
//            System.err.println(e.getMessage());
//        } catch (BadRequestResponseException e) {
//            System.err.println("WWCNamingService error: Bad response");
//            // e.printStackTrace();
//        } finally {
//        }
    }
}
