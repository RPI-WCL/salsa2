package salsa.lang.services;

import salsa.lang.ActorRef;
import salsa.lang.Message;

public class StageService {
    
    private StageScheduler2[] schedulers;
    
    private int stageNum = 1;
    
    public StageService() {
        schedulers = new StageScheduler2[stageNum];
        for (int i = 0; i < stageNum; i++) {
            schedulers[i] = new StageScheduler2();
            new Thread(schedulers[i]).start();
        }
    }

    public void send(Message m) {
        ActorRef target = m.getTarget();        
        schedulers[Math.abs(target.getHashcode() % stageNum)].put(m);    
    }

}
