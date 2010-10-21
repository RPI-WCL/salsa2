package salsa.compiler2.definitions;

import java.util.Map;

import salsa.compiler2.SalsaNode;
import salsa.compiler2.SalsaSource;
import salsa.compiler2.SymbolType;

public abstract class Statement extends SalsaSource implements SalsaNode {

    private boolean isInContinuation;
    
    public boolean isInContinuation() {
        return isInContinuation;
    }
    
    public void setInContinuation(boolean isInContinuation) {
        this.isInContinuation = isInContinuation;
    }


    private boolean isAfterContinuation; 
    

    public boolean isAfterContinuation() {
        return isAfterContinuation;
    }

    public void setAfterContinuation(boolean isAfterContinuation) {
        this.isAfterContinuation = isAfterContinuation;
    }

    private boolean isSendMessage = false;

    public boolean isSendMessage() {
        return isSendMessage;
    }

    public void setSendMessage(boolean isSendMessage) {
        this.isSendMessage = isSendMessage;
    }
    
    private boolean isInJoinBlock = false;

    public boolean isInJoinBlock() {
        return isInJoinBlock;
    }

    public void setInJoinBlock(boolean isInJoinBlock) {
        this.isInJoinBlock = isInJoinBlock;
    }
    
    private boolean isAfterJoinBlock = false;

    public boolean isAfterJoinBlock() {
        return isAfterJoinBlock;
    }

    public void setAfterJoinBlock(boolean isAfterJoinBlock) {
        this.isAfterJoinBlock = isAfterJoinBlock;
    }

    private boolean isClassDef = false;

    public boolean isClassDefinition() {
        return isClassDef;
    }

    public void setClassDefinition(boolean isClassDef) {
        this.isClassDef = isClassDef;
    }
    
    @Override
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv, Map<String, SymbolType> knownTypes) {
        if (isInContinuation && !isSendMessage()) {
            this.log("Continuation can only be applied to a message sending");
        }
        return true;
    }
}
