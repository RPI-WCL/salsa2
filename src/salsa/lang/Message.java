/**
 * This is the Message class.
 */

package salsa.lang;




public class Message {
    
    public static int ECHO_TYPE = 1;
    public static int DELEGATE_TYPE = 2;
    public static int NORMAL_TYPE = 3;
    
	private ActorRef target;
	private ActorRef source;
	private int msgId;
	private String msgName;
	private String assignTo;
	private Object[] arguments;	
	private int waitingTokenNum;


	public Message(ActorRef src, ActorRef target, int msgId, String msgName,
            String assignTo, Object[] args, int waitingTokenNum) {
	    this.source = src;
	    this.target = target;
	    this.msgId = msgId;
	    this.msgName = msgName;
	    this.assignTo = assignTo;
	    this.waitingTokenNum = waitingTokenNum;
	    this.arguments = args;
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

}
