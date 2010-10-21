package salsa.lang.services;

import java.io.IOException;
import java.util.Hashtable;

import com.tangosol.util.ExternalizableHelper;

import salsa.wwc.Message;
import salsa.wwc.ServiceFactory;
import salsa.wwc.WWCActorReference;
import salsa.wwc.WWCActorState;
import salsa.wwc.language.ContinuationDirector;
import salsa.wwc.naming.MalformedUALException;
import salsa.wwc.naming.MalformedUANException;
import salsa.wwc.naming.NamingService;
import salsa.wwc.naming.UAL;
import salsa.wwc.naming.UAN;
import salsa.wwc.naming.URI;

public class TransportService {

	private Hashtable<String, String> cachedActorLocations;

	private Hashtable<String, OutgoingSocketHandler> outgoingSockethandlers;

	private NamingService namingService;
	
	private ReceptionService receptionService;

	public TransportService() {
		cachedActorLocations = new Hashtable<String, String>();
		outgoingSockethandlers = new Hashtable<String, OutgoingSocketHandler>();
		namingService = ServiceFactory.getNamingService();
		receptionService = ServiceFactory.getReceptionService();
	}

	/**
	 * Migrate an actor
	 * @param arguments It contains following: 
	 * <li>0: actorState</li>
	 * <li>1: host</li>
	 * <li>2: port</li>
	 * <li>3: constructMessage if exists</li>
	 * @throws IOException
	 */
	public synchronized void migrateActor(Object[] arguments) throws IOException {
		if (arguments.length >= 3) {
			WWCActorState actorState = (WWCActorState)arguments[0];
			String host = (String) arguments[1];
			int port = (Integer) arguments[2];
			OutgoingSocketHandler out = getOutgoingSocketHandler(host, port);
			if (out != null) {
				Object[] objects;
				// Send construct message if necessary
				if (arguments.length >= 4) {
					objects = new Object[] { actorState, arguments[3] };
				} else {
					objects = new Object[] { actorState };
				}
				out.send(new Message(Message.MIGRATE_IN_MESSAGE,
						actorState.self, -1, objects, new char[]{'L', 'L'}));
				cachedActorLocations.put(actorState.getUniqueId(), host + ":"
						+ port);
				if (actorState.getUAN() != null) {
					try {
						namingService.put(actorState.getUAN(), new UAL(
								salsa.wwc.naming.URI.UAL_HEADER
										+ host + ":"
										+ port + "/"
										+ actorState.getUAN().getIdentifier()));
					} catch (MalformedUALException e) {
					}
				}
			} else {
				System.err.println("Error: Cannot connect to " + host + ":"
						+ port);
			}
		}
	}

	/**
	 * It try to resolve the destination in following order:
	 * <li>uan</li>
	 * <li>cached locations</li>
	 * <li>ual (extract its host and port)</li>
	 * @param message
	 * @throws IOException
	 */
	public synchronized void sendMessage(Message message) throws IOException {
		WWCActorReference targetRef = message.getTargetRef();
		String targetHost;
		int targetPort;
		if (targetRef != null) {
			OutgoingSocketHandler out = null;
			String cachedLocation = null;
			String uniqueId = targetRef.getUniqueId();
			String ual = null;
			if (uniqueId.startsWith(URI.UAN_HEADER)) {
                if ((cachedLocation = cachedActorLocations.get(uniqueId)) != null) {
                    //System.err.println("reuse uan");
                    out = getOutgoingSocketHandler(cachedLocation);
                } else {
                    // Resolve the uan
                    try {
                        UAL resolved;
                        resolved = namingService.get(new UAN(uniqueId));
                        if (resolved != null) {
                            targetHost = resolved.getHost();
                            targetPort = resolved.getPort();
                            out = getOutgoingSocketHandler(targetHost,
                                    targetPort);
                            cachedActorLocations.put(uniqueId, targetHost + ":"
                                    + targetPort);
                        } else
                            throw new MalformedUANException(null);
                    } catch (MalformedUANException e) {
                        System.err.println("Error while resolving the UAN:");
                    }
                }
			} else if ((cachedLocation = cachedActorLocations.get(uniqueId)) != null) {
				// Try to find the cached location
				out = getOutgoingSocketHandler(cachedLocation);
//			} else if (uniqueId.startsWith(URI.UAL_HEADER)) {
			} else if ((ual = targetRef.getUALString()) != null) {
				// Try to resolve by rmsp
				int slashpPos = ual.indexOf('/', URI.UAL_HEADER.length());
				String socketId = ual.substring(URI.UAL_HEADER.length(),
						slashpPos);
				out = getOutgoingSocketHandler(socketId);
			} 
			if (out != null) {
				out.send(message);
			}
			else {
				System.err
						.println("Error while sending a remote message:");
				System.err.println("\tCannot resolve reference " + uniqueId);
			}
		} else {
			System.err.println("Error! TargetRef is null!");
		}
	}

	/**
	 * Get <code>OutgoingSocketHandler</code> by host:port
	 * @param targetSocketId
	 * @return
	 */
	private OutgoingSocketHandler getOutgoingSocketHandler(String targetSocketId) {
		int i = targetSocketId.indexOf(':');
		String host = targetSocketId.substring(0, i);
		int port = Integer.valueOf(targetSocketId.substring(i + 1));
		return getOutgoingSocketHandler(host, port);
	}

	/**
	 * Get <code>OutgoingSocketHandler</code> by host and port
	 * @param targetHost
	 * @param targetPort
	 * @return
	 */
	private OutgoingSocketHandler getOutgoingSocketHandler(String targetHost,
			int targetPort) {
		String targetSocketId = targetHost + ":" + targetPort;
		OutgoingSocketHandler outgoing = outgoingSockethandlers
				.get(targetSocketId);

		if (outgoing == null) {
			outgoing = new OutgoingSocketHandler(targetHost, targetPort);
			outgoingSockethandlers.put(targetSocketId, outgoing);
		}
		return outgoing;
	}


}
