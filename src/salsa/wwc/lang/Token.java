package salsa.wwc.lang;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import salsa.wwc.lang.services.ServiceFactory;

public class Token implements Serializable {

    private String name;
    
    private Object result;
    
    private List<Message> waitingMessage;
    
    private List<Integer> tokenPositions;

    public Token(String assignTo) {
        this.name = assignTo;
        this.waitingMessage = new ArrayList<Message>(5);
        this.tokenPositions = new ArrayList<Integer>(5);
    }

    public void addWaitingMessage(Message m, int tokenPos) {
        if (!isBound()) {
            this.waitingMessage.add(m);
            this.tokenPositions.add(tokenPos);
        } else {
            m.setArgumentAt(tokenPos, m);
        }
    }

    public void bindResult(Object result, ActorState actorState) {
        this.result = result;
        for (int i = 0; i < waitingMessage.size(); i++) {
            Message m = waitingMessage.get(i);
            if (m.setArgumentAt(tokenPositions.get(i), result)) {
                // Send it
                ServiceFactory.getStageService().send(m);
            }
        }
        waitingMessage = null;
        tokenPositions = null;
    } 
    
    public boolean isBound() {
        return result != null;
    }

    @Override
    public String toString() {
        return "Token [result=" + result + "]";
    }    
    
}
