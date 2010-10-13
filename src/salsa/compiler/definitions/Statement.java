package salsa.compiler.definitions;

import salsa.compiler.SalsaNode;
import salsa.compiler.SalsaSource;

public abstract class Statement extends SalsaSource implements SalsaNode {

    private boolean isContinuation;
    
    public boolean isContinuation() {
        return isContinuation;
    }
    
    public void setContinuation(boolean b) {
        isContinuation = b;
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

    public boolean isClassDef() {
        return isClassDef;
    }

    public void setClassDef(boolean isClassDef) {
        this.isClassDef = isClassDef;
    }
    
    @Override
    public boolean analyze(SalsaNode parent) {
        if (!((!isContinuation) || isSendMessage())) {
            this.log("Continuation can only be applied to a message sending");
        }
        return true;
    }

}
