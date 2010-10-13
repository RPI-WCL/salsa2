/**
 * 
 */
package salsa.lang;

import java.io.Serializable;
import java.util.List;

import salsa.lang.exceptions.ConstructorNotFoundException;
import salsa.lang.exceptions.ContinuationPassException;
import salsa.lang.exceptions.MessageHandlerNotFoundException;
import salsa.lang.exceptions.TokenPassException;

/**
 * @author Wei Huang
 * @date Apr 7, 2010
 */
public class ActorRef implements Serializable {
    
    private int hashCode;
    
    private String identifier;
    
    protected ActorState actorState;
    
    public ActorRef() {
    }
    
    public ActorRef(ActorState actorState) {
        this.actorState = actorState;
    }
    
	public int getHashcode() {
	    return hashCode;
	}

	public String getIdentifier() {
	    return identifier;
	}
	
	public ActorState getActorState() {
	    return actorState;
	}
	
    public boolean putDirectly(Message m) {
        if (actorState == null)
            return false;
        return actorState.putDirectly(m);
    }
//
//    public boolean invokeDirectly() {
//        if (actorState == null)
//            return false;
//        return actorState.invokeDirectly();
//    }
}

///**
//* Actors that are waiting for its bound
//*/
//private List<ActorRef> waitees; 

//public Object invokeMessage(int messageId, Object[] arguments)
//      throws MessageHandlerNotFoundException, ContinuationPassException, TokenPassException {
//  if (actorState == null)
//      throw new MessageHandlerNotFoundException(messageId, arguments);
//  else
//      return actorState.invokeMessage(messageId, arguments);
//}

//public Object invokeMessage(String messageName, Object[] arguments)
//        throws ContinuationPassException, TokenPassException,
//        MessageHandlerNotFoundException {
//    if (actorState == null)
//        throw new MessageHandlerNotFoundException(messageName, arguments);
//    else
//        return actorState.invokeMessage(messageName, arguments);
//}


//public void invokeConstructor(int constructorId, Object[] arguments)
//      throws ConstructorNotFoundException {
//  if (actorState == null) {
//      throw new ConstructorNotFoundException(constructorId, arguments);
//  }
//  else 
//      actorState.invokeConstructor(constructorId, arguments);
//}

