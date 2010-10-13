/**
 * 
 */
package salsa.lang;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import salsa.lang.services.ServiceFactory;

/**
 * @author Wei Huang
 * @date Apr 8, 2010
 */
public abstract class ActorState implements Serializable {

//    private static final long serialVersionUID = 1L;

    /**
     * Self reference
     */
    protected ActorRef self;    
    
    /**
     * Used to generate <code>assignTo</code>
     */
    private long varIndex = 0;
    
    /**
     * Maps from assignTo to token
     */
    private Map<String, Token> tokenMap = new HashMap<String, Token>();
    
    private List<Message> mailbox = new LinkedList<Message>();
    
    /**
     * For continuation
     */
    protected Token token;
    protected Object echoObject = new Object();

    public ActorState() {
        self = new ActorRef(this);
    }

    public ActorRef getSelfRef() {
        return self;
    }

    public int getHashcode() {
        return 0;
    }

    public String getUniqueId() {
        return null;
    }
    

//    public void invokeConstructor(int messageId, Object[] arguments)
//            throws ConstructorNotFoundException {
//    }
//
//    public Object invokeMessage(int messageId, Object[] arguments)
//            throws ContinuationPassException, TokenPassException,
//            MessageHandlerNotFoundException {
//        Integer i = null;
//        Double d = null;
//        d = i + d;
//        return null;
//    }

    public abstract void invokeByName(String msgName, Object[] args, ActorRef src, String assignTo);
    
    public abstract void invokeById(int msgId, Object[] args, ActorRef src, String assignTo);
    
    public void process() {
        Message message = get();
        if (message == null) {
            System.err.println("Error");
            return;
        }
        String msgName = message.getMsgName();
        int msgId = message.getMsgId();
        Object[] args = message.getArguments();
        ActorRef src = message.getSource();
        String assignTo = message.getAssignTo();
        
        if (msgId >= 0) {
            invokeById(msgId, args, src, assignTo);
        } else if (msgName.equals("echo")) {
            this.echo(args[0], assignTo);
        } else if (msgName.equals("joinHelper")) {
            joinHelper(src, assignTo, args);
        } else {
            invokeByName(msgName, args, src, assignTo);
        }
    }
    

    public Token send(ActorRef src, ActorRef target, int msgId, String msgName,
            String assignTo, int msgType, Object[] args, int[] tokenPos, Token conToken) {
        if (msgType == Message.ECHO_TYPE) {
            // A simple return message
            Message m = new Message(src, target, msgId, msgName, assignTo, args, 0);
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
                    args, waitingTokenNum);
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
    
    public void echo(Object result, String assignTo) {
        Token token = tokenMap.remove(assignTo);
        if (token != null) {
            token.bindResult(result, this);
        }
    }
    
    public void joinHelper( ActorRef src, String assignTo, Object... o) {
        send(self,src,-1,"echo",assignTo,Message.ECHO_TYPE,new Object[]{o}, new int[]{},null);
    }

    private Message get() {
        if (mailbox.size() > 0)
            return mailbox.remove(0);
        else
            return null;
    }
    
    public void put(Message m) {
        this.mailbox.add(m);
    }
    
    public boolean putDirectly(Message m) {
        if (!this.isRegister()) {
            this.put(m);
            return true;
        }
        else 
            return false;
    }
    
    
    public static final int NO_MORE_MESSAGE = 1;
    public static final int ACTOR_EXECUTING = 2;
    public static final int SUCCEEDED = 3;
    
    private boolean isExecuting = false;
    
    public synchronized int invokeDirectly() {
        if (mailbox.size() == 0)
            return NO_MORE_MESSAGE;
        if (isExecuting) 
            return ACTOR_EXECUTING;
        try {
            isExecuting = true;
            process();
        } finally {
            isExecuting = false;
        }
        return SUCCEEDED;
    }
    
    private boolean isRegister() {
        return false;
    }
    
    
//  protected static Map<String, Method> methodTable = new HashMap<String, Method>();    
//  /**
//  * If at least one of the arguments is unbound, process this message later.
//  * 
//  * @param messageName
//  * @param arguments
//  * @return
//  * @throws ContinuationPassException
//  * @throws TokenPassException
//  * @throws MessageHandlerNotFoundException
//  */
// public Object invokeMessage(String messageName, Object[] arguments)
//         throws ContinuationPassException, TokenPassException,
//         MessageHandlerNotFoundException {
//     Method method = null;
//     synchronized (methodTable) {
//         method = methodTable.get(messageName);
//     }
//     if (method == null) {
//         Class<?>[] parameterClasses = null;
//         if (arguments != null) {
//             parameterClasses = new Class<?>[arguments.length];
//             for (int i = 0; i < arguments.length; i++) {
//                 if (arguments[i] == null) {
//                     parameterClasses[i] = null;
//                 } else {
//                     parameterClasses[i] = arguments[i].getClass();
//                 }
//             }
//         }
//         try {
//             method = this.getClass().getDeclaredMethod(messageName,
//                     parameterClasses);
//             synchronized (methodTable) {
//                 methodTable.put(messageName, method);
//             }
//         } catch (SecurityException e) {
//             // TODO
//             e.printStackTrace();
//         } catch (NoSuchMethodException e) {
//             // TODO
//             e.printStackTrace();
//         }
//     }
//     if (method != null) {
//         try {
//             return method.invoke(this, arguments);
//         } catch (IllegalArgumentException e) {
//             // TODO Auto-generated catch block
//             e.printStackTrace();
//         } catch (IllegalAccessException e) {
//             // TODO Auto-generated catch block
//             e.printStackTrace();
//         } catch (InvocationTargetException e) {
//             Throwable cause = e.getCause();
//             if (cause instanceof TokenPassException) {
//                 throw (TokenPassException) cause;
//             }
//         }
//     }
//     return null;
// }

}
