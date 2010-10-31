package salsa.wwc.lang.services;

import salsa.wwc.lang.ActorRef;
import salsa.wwc.lang.ActorState;
import salsa.wwc.lang.Message;

public class StageService {
    
    private StageScheduler[] schedulers;
    
    private int stageNum = 1;
    
    public StageService() {
        schedulers = new StageScheduler[stageNum];
        for (int i = 0; i < stageNum; i++) {
            schedulers[i] = new StageScheduler();
            new Thread(schedulers[i], "scheduler" + i).start();
        }
    }

    public void send(Message m) {
        ActorRef target = m.getTarget();        
        schedulers[Math.abs(target.getHashcode() % stageNum)].put(m);    
    }

    public void registerActor(ActorState actorState) {
        schedulers[Math.abs(actorState.getHashcode() % stageNum)].registerActor(actorState);    
    }

    public void registerIncomingActor(ActorState actorState) {
        schedulers[Math.abs(actorState.getHashcode() % stageNum)].registerIncomingActor(actorState);    
    }

}
