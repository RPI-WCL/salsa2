package salsa.wwc.lang.services;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.log4j.Logger;

import salsa.wwc.lang.ActorRef;
import salsa.wwc.lang.ActorState;
import salsa.wwc.lang.Message;


public class StageScheduler implements Runnable {
    
    private List<Message> mailbox = new LinkedList<Message>();
    
    private Map<String, ActorState> actorMap = new HashMap<String, ActorState>();

    /**
     * A map from actor id to its location
     */
//    private Map<String, String> remoteActorMap = new HashMap<String, String>();
    
    private ConcurrentLinkedQueue<ActorState> schedulingQueue = new ConcurrentLinkedQueue<ActorState>();
    
    /**
     * Cache messages for migrating actors;
     */
    private Map<String, List<Message>> cachedMessages = new HashMap<String, List<Message>>();
    
    private static NamingService namingService = ServiceFactory.getNamingService();
    
    private static ReceptionService receptionService = ServiceFactory.getReceptionService();
    
    private static TransportService transportService = ServiceFactory.getTransportService();
    
    private static Logger logger = Logger.getLogger(StageScheduler.class);
    
    public synchronized void put(Message m) {
        mailbox.add(m);
        this.notifyAll();
    }
    
    private synchronized Message getMessage() {
        while (mailbox.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        return mailbox.remove(0);
    }
    
    private void cacheMessages(String identifier, Message message) {
        List<Message> messages = cachedMessages.get(identifier);
        if (messages == null) {
            messages = new ArrayList<Message>();
            cachedMessages.put(identifier, messages);
        }
        messages.add(message);
    }
    
    @Override
    public void run() {
        new Thread(new Worker(), "worker1").start();
        new Thread(new Worker(), "worker2").start();
        Message message;
        while ((message = getMessage()) != null) {
           // Get the target of the message
            ActorRef targetRef = message.getTarget();
            String identifier = targetRef.getIdentifier();
            ActorState actorState = null;
            if (identifier != null) {
                // Search for hash table
                synchronized(actorMap) {
                    actorState = actorMap.get(identifier);
                }
            }
            if (actorState != null) {
                if (actorState.isMigrating()) {
                    cacheMessages(actorState.getIdentifier(), message);
                } else {
                    if (!message.isLocalMessage())
                        message = message.copy();
                    actorState.putMessage(message);
                    putSchedulable(actorState);
                }
            } else {
                transportService.sendMessage(message);
            }
        }
    }
    
    
    private class Worker implements Runnable {
        boolean isStop = false;
        @Override
        public void run() {
            while (!isStop) {
                boolean canRun = false;
                ActorState actorState = getNextSchedulable();
                if (actorState == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                    }
                    continue;
                }
                synchronized (actorState) {
                    if (actorState.isIdle()) {
                        actorState.setExecuting();
                        canRun = true;
                    }
                }
                if (canRun) {
                    actorState.schedule();
                    if (actorState.isMigrating()) {
                        // Send those cached messages
                        synchronized (actorMap) {
                            List<Message> messages = cachedMessages
                                    .get(actorState.getIdentifier());
                            if (messages != null) {
                                logger.info("Sending cached messages");
                                for (Message msg : messages)
                                    transportService.sendMessage(msg);
                            }
                            // If the actor has been migrated back to local machine, 
                            // we don't need to unregister it.
                            ActorState actorState2 = actorMap.get(actorState.getIdentifier());
                            if (actorState2.isMigrating()) {
                                unregisterActor(actorState.getIdentifier());
                                actorState.setMigrated();
                            }
                        }
                    } else {
                        actorState.setIdle();
                    }
                } else if (!actorState.isMigrated()){
                    putSchedulable(actorState);
                }
            }
        }
    }
    
    private void putSchedulable(ActorState actorState) {
        synchronized(schedulingQueue) {
            schedulingQueue.offer(actorState);
            schedulingQueue.notifyAll();
        }
    }
    
    private ActorState getNextSchedulable() {
        synchronized(schedulingQueue) {
         while (schedulingQueue.size() == 0) {
            try {
                schedulingQueue.wait();
            } catch (InterruptedException e) {
            }
        }
        }
       return schedulingQueue.poll();
    }
    
    
    public void registerIncomingActor(ActorState actorState) {
        synchronized(actorMap) {
            actorMap.put(actorState.getIdentifier(), actorState);
        }
        logger.info("Registered an incoming actor: " + actorState.getIdentifier());
        int num = actorState.getUnprocessedMsgNum();
        for (int i = 0; i < num; i++)
            putSchedulable(actorState);
    }

    public void registerActor(ActorState actorState) {
        synchronized(actorMap) {
            actorMap.put(actorState.getIdentifier(), actorState);
        }
        logger.info("Registered an new actor: " + actorState.getIdentifier());
    }
    
    public void unregisterActor(String identifier) {
        synchronized(actorMap) {
            actorMap.remove(identifier);
        }
        logger.info("Unregistered an actor: " + identifier);
    }
}
