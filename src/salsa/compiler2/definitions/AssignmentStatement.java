package salsa.compiler2.definitions;

import java.util.Map;

import salsa.compiler2.SalsaNode;
import salsa.compiler2.SymbolType;

public class AssignmentStatement extends Statement {

    private Expression expression1;

    private Expression expression2;

    public AssignmentStatement(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
        this.setSendMessage(expression2.isSendMessage());
    }
    
    
    @Override
    public void setSendMessage(boolean isSendMessage) {
        super.setSendMessage(isSendMessage);
        expression1.setSendMessage(isSendMessage);
        expression2.setSendMessage(isSendMessage);
    }

    @Override
    public void setAfterContinuation(boolean isAfterContinuation) {
        super.setAfterContinuation(isAfterContinuation);
        expression1.setAfterContinuation(isAfterContinuation);
        expression2.setAfterContinuation(isAfterContinuation);
    }



    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();

        sb.append(identation).append(expression1.toJavaCode("")).append("=")
                .append(expression2.toJavaCode(identation)).append(";");

        if (isInContinuation() && isSendMessage()) {
            sb.append("\n").append(identation).append("token = ")
                    .append(expression1.toJavaCode("")).append(";\n");
        } else if (!isInContinuation() && isSendMessage() && isInJoinBlock()) {
            sb.append(identation).append("token = ")
                    .append(expression1.toJavaCode(identation) + ";\n");
            sb.append(identation).append("_tokenList.add(token);");
        }
        return sb.toString();
    }

    @Override
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv, Map<String, SymbolType> knownTypes) {
        super.analyze(parent, typeEnv, knownTypes);
        expression1.analyze(this, typeEnv, knownTypes);
        expression2.analyze(this, typeEnv, knownTypes);
        SymbolType t1 = expression1.getType();
        SymbolType t2 = expression2.getType();
        if (t1 == null || t2 == null)
            return false;
        if (!expression1.getType().isAssignable((expression2.getType()))) {
            this.log("Incompatible type (" + expression1.getType() + " != "
                    + expression2.getType() + ")");
        }
        if (isInJoinBlock() && isSendMessage() && !isInContinuation()) {
            this.setMsgReturnType(expression2.getType());
        }
        return true;
    }


    @Override
    public void setInJoinBlock(boolean isInJoinBlock) {
        super.setInJoinBlock(isInJoinBlock);
    }
}
