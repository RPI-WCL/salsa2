package salsa.lang.services;


import java.util.LinkedList;
import java.util.List;

import salsa.lang.ActorRef;
import salsa.lang.ActorState;
import salsa.lang.Message;


/**
 * This thread wakes up every <code>wakeUpInterval</code> ms
 * @author Wei Huang
 * @date Sep 5, 2010
 */
public class StageScheduler2 implements Runnable {

    private List<ActorState> queue = new LinkedList<ActorState>();
    
    private int monitorInterval = 100;
    
    private int executerInterval = 1000;
    
    private boolean mark = false;
    
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
        if (queue.size() == 0) {
            try {
                this.wait(executerInterval);
            } catch (InterruptedException e) {
            }
        }
//        number++;
//        System.err.println("Msg Number: " + number);
        if (queue.size() > 0)
            return queue.remove(0);
        else
            return null;
    }

    @Override
    public void run() {
        new Thread(new Executer()).start();
        while(true) {
            try {
                mark = false;
                Thread.sleep(monitorInterval);
            } catch (InterruptedException e) {
            }
            if (!mark && queue.size() > 0 ) {
                new Thread(new Executer()).start();
                System.err.println("new thread");
            }
        }
    }
    int number = 0;
    class Executer implements Runnable {
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
                } finally {
                    mark = true;
                }
            }
        }
    }
}
