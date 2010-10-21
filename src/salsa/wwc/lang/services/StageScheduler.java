package salsa.lang.services;


import java.util.LinkedList;
import java.util.List;

import salsa.lang.ActorRef;
import salsa.lang.ActorState;
import salsa.lang.Message;


public class StageScheduler implements Runnable {
    
    private List<ActorState> queue = new LinkedList<ActorState>();
//    private List<ActorRef> queue = new LinkedList<ActorRef>();
    
//    public synchronized void put(Message m) {
//        ActorRef target = m.getTarget();
//        if (!target.putDirectly(m)) {
//            System.err.println("Directly put failed.");
//        }
//        queue.add(target);
//        this.notify();
//    }
//    
//    private synchronized ActorRef getNext(){
//        while (queue.size() == 0) {
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//            }
//        }
//        return queue.remove(0);
//    }
    
    public synchronized void put(Message m) {
        ActorRef target = m.getTarget();
        if (target.putDirectly(m)) {
            // It is a local actor
            queue.add(target.getActorState());
        } else {
            System.err.println("Directly put failed.");
            // Search for actor table and put it. 
        }
        this.notify();
    }
    
    private synchronized void putBack(ActorState actorState) {
        queue.add(actorState);
    }
    
    private synchronized ActorState getNext() {
        while(queue.size() == 0) {
            try {
                System.err.println("Waiting");
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        if (queue.size() > 0)
            return queue.remove(0);
        else
            return null;
    }

    @Override
    public void run(){
        ActorState next;
        while ((next = getNext()) != null) {
            try {
                int status = next.invokeDirectly();
                switch (status) {
                case ActorState.SUCCEEDED:
                    break;
                case ActorState.ACTOR_EXECUTING:
                    System.err.println("put back");
                    putBack(next);
                    break;
                default:
                    System.err.println("default");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } 
        }
    }
}