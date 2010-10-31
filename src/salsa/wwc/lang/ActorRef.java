/**
 * 
 */
package salsa.wwc.lang;

import java.io.IOException;
import java.io.Serializable;

import salsa.lib.UAL;
import salsa.lib.UAN;
import salsa.wwc.lang.services.ServiceFactory;

/**
 * @author Wei Huang
 * @date Apr 7, 2010
 */
public class ActorRef implements Serializable {
    
    private int hashCode;
    
    protected String identifier;
    
    protected UAN uan;
    
    protected UAL ual;
    
    public ActorRef() {
    }
  
    public ActorRef(ActorState actorState) {
        this(actorState, null, null);
    }
    
    public ActorRef(ActorState actorState, String uan, String location) {
        actorState.initialize(uan, location);
        this.identifier = actorState.getIdentifier();
        this.uan = actorState.getUAN();
        this.ual = actorState.getUAL();
    }
   
	public int getHashcode() {
	    return identifier.hashCode();
	}

	public String getIdentifier() {
	    return identifier;
	}
	
	
	public UAN getUAN() {
        return uan;
    }
	
	public UAL getUAL() {
	    return ual;
	}

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ActorRef) {
            ActorRef ar = (ActorRef)obj;
            return identifier.equals(ar.getIdentifier());
        }
        return false;
    }

	

}

