package salsa.compiler2.definitions;

import java.util.Map;

import salsa.compiler2.SalsaNode;
import salsa.compiler2.SymbolType;

public class ExpressionStatement extends Statement implements SalsaNode {

    private Expression expression;

    public ExpressionStatement(Expression expression) {
        this.expression = expression;
        this.setSendMessage(expression.isSendMessage());
    }
    
    

    @Override
    public void setAfterContinuation(boolean isAfterContinuation) {
        super.setAfterContinuation(isAfterContinuation);
        expression.setAfterContinuation(isAfterContinuation);
    }



    @Override
    public void setSendMessage(boolean isSendMessage) {
        super.setSendMessage(isSendMessage);
        expression.setSendMessage(isSendMessage);
    }



    @Override
    public String toJavaCode(String identation) {

        StringBuilder sb = new StringBuilder();

        if (isInContinuation() && isSendMessage()) {
            sb.append(identation).append("token = ")
                    .append(expression.toJavaCode(identation) + ";");
        } else if (!isInContinuation() && isSendMessage() && isInJoinBlock()) {
            sb.append(identation).append("token = ")
                    .append(expression.toJavaCode(identation) + ";\n");
            sb.append(identation).append("_tokenList.add(token);");
        }
        else {
            sb.append(identation).append(expression.toJavaCode(identation) + ";");
        }
        
        return sb.toString();
    }

    @Override
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv, Map<String, SymbolType> knownTypes) {
        super.analyze(parent, typeEnv, knownTypes);
        expression.analyze(this, typeEnv, knownTypes);
        if (isInJoinBlock() && isSendMessage() && !isInContinuation()) {
            this.setMsgReturnType(expression.getType());
        }

        return true;
    }



    @Override
    public void setInJoinBlock(boolean isInJoinBlock) {
        super.setInJoinBlock(isInJoinBlock);
    }    
    
}
