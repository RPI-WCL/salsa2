/**
 * 
 */
package salsa.wwc.lang;

import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import salsa.lib.UAL;
import salsa.lib.UAN;
import salsa.wwc.lang.services.MalformedUANException;
import salsa.wwc.lang.services.ServiceFactory;

/**
 * @author Wei Huang
 * @date Apr 8, 2010
 */
public abstract class ActorState implements Serializable {
    


//    private static final long serialVersionUID = 1L;

    /**
     * Self reference
     */
    protected ActorRef self = null;    
    
    /**
     * Used to generate <code>assignTo</code>
     */
    private long varIndex = 0;
    
    /**
     * Maps from assignTo to token
     */
    private Map<String, Token> tokenMap = new HashMap<String, Token>();
    
   
    /**
     * The unique identifier of actors. It can be "uan://" or "ual://"
     */
    private String identifier = "";
    private UAN uan = null;
    private UAL ual = null;
    
    /**
     * For continuation
     */
    protected transient Token token;
    protected String echoObject = new String();
    
    
    /**
     * Define the status of actors, ACTOR_MIGRATING belongs to ACTOR_EXECUTIN
     */
    public static final int ACTOR_IDLE= 0x1;
    public static final int ACTOR_EXECUTING = 0x2;
    public static final int ACTOR_MIGRATING = 0x4;
    public static final int ACTOR_MIGRATED = 0x8;
    
    /**
     * Initial status is idle
     */
    private int status = ACTOR_IDLE;
    
    private List<Message> mailbox = new LinkedList<Message>();

    public ActorState() {
    }


    public ActorRef getSelfRef() {
        return self;
    }

    public int getHashcode() {
        if (identifier != null)
            return identifier.hashCode();
        return 0;
    }

    public UAN getUAN() {
        // TODO Auto-generated method stub
        return uan;
    }
    
    public UAL getUAL() {
        return ual;
    }
    
    public String getIdentifier() {
        return identifier;
    }
    
    public void initialize(String uanStr, String location) {
        if (uanStr != null && location != null) {
            try {
                uan = new UAN(uanStr);
                ServiceFactory.getNamingService().put(uan,
                        ServiceFactory.getReceptionService().getLocation());
                this.identifier = uanStr;
                this.ual = new UAL("ual://" + location + "/" + this.hashCode());
            } catch (MalformedUANException e) {
            }
        } else if (location != null) {
            this.identifier = "ual://" + location + "/" + this.hashCode();
            this.ual = new UAL(this.identifier);
        } else {
            this.identifier = ServiceFactory.getReceptionService().UAL_LOC_PREFIX
                    + "/" + this.hashCode();
            this.ual = new UAL(this.identifier);
        }
        self = new ActorRef();
        self.identifier = this.identifier;
        self.uan = uan;
        self.ual = ual;
        ServiceFactory.getStageService().registerActor(this);
        if (location != null)
            this.send(self, self, -1, "migrate", "exitValue", Message.NORMAL_TYPE,
                new Object[] { location }, new int[] {}, null);

    }

//    private void setIdentifier(String identifier) {
//        this.identifier = identifier;
//        // Need to test if it is UAN or not
//        if (identifier.startsWith(UAN.PREFIX)) {
//            // Register
//            try {
//                uan = new UAN(identifier);
//            } catch (MalformedUANException e) {
//            }
//        }
//        if (uan != null) {
//            ServiceFactory.getNamingService().put(uan,
//                    ServiceFactory.getReceptionService().getLocation());
//        }
//        self = new ActorRef();
//        self.identifier = this.identifier;
//        self.uan = uan;
//    }
    
    public void putMessage(Message m) {
        synchronized(mailbox) {
            this.mailbox.add(m);
        }
    }
    
    private Message getMessage() {
        synchronized(mailbox) {
            if (mailbox.size() > 0)
                return mailbox.remove(0);
            else
                return null;
        }
    }
    
    public int getUnprocessedMsgNum() {
        synchronized(mailbox) {
            return mailbox.size();
        }
    }
    
    public synchronized boolean isIdle() {
        return status == ACTOR_IDLE;
    }

    public synchronized boolean isExecuting() {
        return status == ACTOR_EXECUTING;
    }
    
    public synchronized boolean isMigrating() {
        return status == ACTOR_MIGRATING;
    }   
 
    public synchronized boolean isMigrated() {
        return status == ACTOR_MIGRATED;
    }   
 
    public synchronized void setIdle() {
        status = ACTOR_IDLE;
    }

    public synchronized void setExecuting() {
        status = ACTOR_EXECUTING;
    }
    
    public synchronized void setMigrating() {
        status = ACTOR_MIGRATING;
    }

    public synchronized void setMigrated() {
        status = ACTOR_MIGRATED;
    }
     
   public abstract void invokeByName(String msgName, Object[] args, ActorRef src, String assignTo);
    
    public abstract void invokeById(int msgId, Object[] args, ActorRef src, String assignTo);
    
    
    public void schedule() {
        Message message = getMessage();
        if (message != null) {
            process(message);
        }
    }

    
    private void process(Message message) {
        if (message == null) {
            System.err.println("Error");
            return;
        }
        String msgName = message.getMsgName();
        int msgId = message.getMsgId();
        Object[] args = message.getArguments();
        ActorRef src = message.getSource();
        String assignTo = message.getAssignTo();
        
        if (msgId != -1) {
            invokeById(msgId, args, src, assignTo);
        } else if (message.getMsgType() == Message.ECHO_TYPE) {
            this.echo(args[0], assignTo);
        } else if (msgName.equals("joinHelper")) {
            joinHelper(src, assignTo, args);
        } else if (msgName.equals("migrate")) {
            migrate((String)args[0]);
        } else {
            invokeByName(msgName, args, src, assignTo);
        }
    }
    

    public Token send(ActorRef src, ActorRef target, int msgId, String msgName,
            String assignTo, int msgType, Object[] args, int[] tokenPos, Token conToken) {
        if (msgType == Message.ECHO_TYPE) {
            // A simple return message
            Message m = new Message(src, target, msgId, msgName, assignTo, args, 0, msgType);
            ServiceFactory.getStageService().send(m);
            return null;
        } 
        else {
            Token token = null;
            if (msgType == Message.NORMAL_TYPE) {
                assignTo = msgName + (varIndex++);        
                token = new Token(assignTo);
                tokenMap.put(assignTo, token);
            }
            
            // If we don't know the token's position
            if (tokenPos == null) {
                tokenPos = new int[args.length];
                int len = 0;
                for (int i = 0; i < args.length; i++) {
                    if (args[i] instanceof Token) 
                        tokenPos[len++] = i;
                }
                System.arraycopy(tokenPos, 0, tokenPos, 0, len);
            }            

            int waitingTokenNum = tokenPos.length + (conToken == null ? 0 : 1); 
            Message m = new Message(src, target, msgId, msgName, assignTo,
                    args, waitingTokenNum, msgType);
            if (waitingTokenNum == 0) {
                ServiceFactory.getStageService().send(m);
            } else {
                for (int i = 0; i < tokenPos.length; i++) {
                    Token t = (Token)args[tokenPos[i]];
                    t.addWaitingMessage(m, tokenPos[i]);
                }
                if (conToken != null)
                    conToken.addWaitingMessage(m, -1);
            }
            return token;
        }
    }

    
    /**
     * echo a message 
     * @param result
     * @param assignTo
     */
    public void echo(Object result, String assignTo) {
        Token token = tokenMap.remove(assignTo);
        if (token != null) {
            token.bindResult(result, this);
        }
    }
    
    /**
     * Auxiliary method for joinblock
     * @param src
     * @param assignTo
     * @param o
     */
    public void joinHelper( ActorRef src, String assignTo, Object... o) {
        send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{o}, new int[]{},null);
    }

    
    public void migrate(String location) {
        this.setMigrating();
//        if (ServiceFactory.getReceptionService().isLocal(location)) {
            
//            this.setExecuting();
//            return;
//        } else
            ServiceFactory.getTransportService().migrateActor(this, location);
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        in.defaultReadObject();
        this.status = ACTOR_IDLE;
    }
}
