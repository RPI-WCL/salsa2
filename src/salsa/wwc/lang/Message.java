/**
 * This is the Message class.
 */

package salsa.wwc.lang;

import java.io.Serializable;

import salsa.wwc.lang.fullcopy.DeepCopy;




public class Message implements Serializable {
    
    public final static int ECHO_TYPE = 1;
    public final static int DELEGATE_TYPE = 2;
    public final static int NORMAL_TYPE = 3;
    public final static int MIGRATE_OUT_TYPE = 4;
    public final static int MIGRATE_IN_TYPE = 5;
    
	private ActorRef target;
	private ActorRef source;
	private int msgId;
	private String msgName;
	private String assignTo;
	private Object[] arguments;	
	private int waitingTokenNum;
	private int msgType = -1; 


	public Message(ActorRef src, ActorRef target, int msgId, String msgName,
            String assignTo, Object[] args, int waitingTokenNum, int msgType) {
	    this.source = src;
	    this.target = target;
	    this.msgId = msgId;
	    this.msgName = msgName;
	    this.assignTo = assignTo;
	    this.waitingTokenNum = waitingTokenNum;
	    this.arguments = args;
	    this.msgType = msgType;
    }


    public ActorRef getTarget() {
        return target;
    }


    public void setTarget(ActorRef target) {
        this.target = target;
    }


    public ActorRef getSource() {
        return source;
    }


    public void setSource(ActorRef source) {
        this.source = source;
    }


    public int getMsgId() {
        return msgId;
    }


    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }


    public String getMsgName() {
        return msgName;
    }


    public void setMsgName(String msgName) {
        this.msgName = msgName;
    }


    public String getAssignTo() {
        return assignTo;
    }


    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }


    public Object[] getArguments() {
        return arguments;
    }


    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }


    public int getWaitingTokenNum() {
        return waitingTokenNum;
    }


    public void setWaitingTokenNum(int waitingTokenNum) {
        this.waitingTokenNum = waitingTokenNum;
    }


    public int getMsgType() {
        return msgType;
    }


    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }


    /**
     * Set arguments
     * @param index  if index < 0, that means it is a continuation token
     * @param result
     * @return
     */
    public synchronized boolean setArgumentAt(int index, Object result) {
        if (index >= 0)
            arguments[index] = result;
        waitingTokenNum--;
        return waitingTokenNum <= 0;
    }


    @Override
    public String toString() {
        return this.msgName + "(" + this.msgId + ")";
    }
    
    
    public boolean isLocalMessage() {
        return this.source.equals(this.target);
    }

    public Message copy() {
        ActorRef src;
        ActorRef target;
        int msgId;
        String msgName;
        String assignTo;
        Object[] args;
        int waitingTokenNum;
        int msgType;

        src = this.source;
        target = this.target;
        msgId = this.msgId;
        msgName = this.msgName;
        assignTo = this.assignTo;
        waitingTokenNum = this.waitingTokenNum;
        msgType = this.msgType;
        args = new Object[this.arguments.length];
        for (int i = 0; i < this.arguments.length; i++) {
            args[i] = DeepCopy.copy(this.arguments[i]);
        }
        return new Message(src, target, msgId, msgName, assignTo, args,
                waitingTokenNum, msgType);
    }
}
