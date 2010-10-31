package salsa.wwc.lang.services;

import java.io.IOException;
import java.net.URI;
import java.util.Hashtable;

import org.apache.log4j.Logger;

import salsa.lib.UAN;
import salsa.wwc.lang.ActorRef;
import salsa.wwc.lang.ActorState;
import salsa.wwc.lang.Message;

public class TransportService {

	private Hashtable<String, String> cachedActorLocations;

	private Hashtable<String, OutgoingSocketHandler> outgoingSockethandlers;

	private NamingService namingService;
	
	private ReceptionService receptionService;
	
	private static Logger logger = Logger.getLogger(TransportService.class);

	public TransportService() {
		cachedActorLocations = new Hashtable<String, String>();
		outgoingSockethandlers = new Hashtable<String, OutgoingSocketHandler>();
		namingService = ServiceFactory.getNamingService();
		receptionService = ServiceFactory.getReceptionService();
	}

	/**
	 * Migrate an actor
	 * @throws IOException
	 */
    public void migrateActor(ActorState actorState, String location) {
        if (receptionService.isLocal(location)) {
            logger.warn("Migrating an actor to local theater");
        }
        synchronized (this) {
            OutgoingSocketHandler out = getOutgoingSocketHandler(location);
            if (out != null) {
                try {
                    out.send(actorState);
                    cachedActorLocations.put(actorState.getIdentifier(),
                            location);
                    if (actorState.getUAN() != null) {
                        namingService.update(actorState.getUAN(), location);
                    }
                } catch (Exception e) {
                    logger.error("Migrate actor " + actorState.toString()
                            + " failed", e);
                }
            } else {
                logger.error("Unable to connect " + location);
            }
        }
    }

	/**
	 * It try to resolve the destination in following order:
	 * <li>uan</li>
	 * <li>cached locations</li>
	 * <li>anonymous actors with ual</li>
	 * @param message
	 * @throws IOException
	 */
	public void sendMessage(Message message) {
	    synchronized(this) {
		ActorRef targetRef = message.getTarget();
		String identifier = "";
		try {
            if (targetRef != null) {
                OutgoingSocketHandler out = null;
                String cachedLocation = null;
                identifier = targetRef.getIdentifier();
                UAN uan = targetRef.getUAN();
                if (uan != null) {
                    // Resolve the uan
                    String location = namingService.get(uan);
                    if (location != null) {
                        out = getOutgoingSocketHandler(location);
                    }
                } else if (identifier != null && (cachedLocation = cachedActorLocations
                        .get(identifier)) != null) {
                    // Try to find the cached location
                    out = getOutgoingSocketHandler(cachedLocation);
                } else if (identifier != null && identifier.startsWith("ual://")) {
                    // For anonymous actors
                    int prefixLen = "ual://".length();
                    int colonPos = identifier.indexOf(':');
                    int slashPos = identifier.indexOf('/', prefixLen);
                    if (colonPos > 0 && slashPos > 0) {
                        String location = identifier.substring(prefixLen, slashPos);
                        out = getOutgoingSocketHandler(location);
                    }
                }
                if (out != null) {
                    out.send(message);
                } else {
                    logger.error("Error while sending a remote message. Reason:"
                            + " cannot resolve reference " + identifier);
                }
            } else {
                logger.error("targetRef is null!");
            }
        } catch (Exception e) {
            logger.error("Sending message to " + identifier + "failed", e);
        }
	    }
	}

	/**
	 * Get <code>OutgoingSocketHandler</code> by host:port
	 * @param targetSocketId
	 * @return
	 */
//	private OutgoingSocketHandler getOutgoingSocketHandler(String targetSocketId) {
//		int i = targetSocketId.indexOf(':');
//		String host = targetSocketId.substring(0, i);
//		int port = Integer.valueOf(targetSocketId.substring(i + 1));
//		return getOutgoingSocketHandler(host, port);
//	}

	/**
	 * Get <code>OutgoingSocketHandler</code> by host and port
	 * @param targetHost
	 * @param targetPort
	 * @return
	 */
	private OutgoingSocketHandler getOutgoingSocketHandler(String location) {
		OutgoingSocketHandler outgoing = outgoingSockethandlers
				.get(location);
		int colonPos = location.indexOf(':');
		logger.info(location);
		if (colonPos > 0) {
            String targetHost = location.substring(0, colonPos);
            int targetPort = Integer.valueOf(location.substring(colonPos + 1));
            if (receptionService.isLocal(targetHost, targetPort))
                logger.warn("Sending message to local theater");
            if (outgoing == null) {
                outgoing = new OutgoingSocketHandler(targetHost, targetPort);
                outgoingSockethandlers.put(location, outgoing);
            }
		} else {
		    logger.error("Invalid location: " + location);
		}
		return outgoing;
	}


}
