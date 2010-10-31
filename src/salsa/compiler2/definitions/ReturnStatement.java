package salsa.compiler2.definitions;

import java.util.Map;

import salsa.compiler2.SalsaNode;
import salsa.compiler2.SymbolType;

public class ReturnStatement extends Statement {

    private Expression expression;
    
    public ReturnStatement(Expression expression) {
        this.expression = expression;
        expression.setReturnStatement(true);
    }

    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();
        
        if (!isClassDefinition()) { 
            sb.append(identation).append("{\n");
            if (expression.getType().getCanonicalName().startsWith("Token")) {
                sb.append(identation + "  // Delegate message\n");
                sb.append(identation + "  ").append(expression.toJavaCode(identation)).append(";\n");
            } else {
                sb.append(identation + "  // Normal return\n");
                sb.append(identation + "  ").append("send(self,src,-1,\"echo\",assignTo,Message.ECHO_TYPE,new Object[]{");
                sb.append(expression.toJavaCode(identation)).append("}, ");
                sb.append("new int[]{},null);\n");
            }
            sb.append(identation + "  ").append("return;\n");
            sb.append(identation).append("}");
        } else {
            sb.append(identation).append("return ").append(expression.toJavaCode(identation)).append(";");
        }
        return sb.toString();
    }

    @Override
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv, Map<String, SymbolType> knownTypes) {
        super.analyze(parent, typeEnv, knownTypes);
        expression.analyze(this, typeEnv, knownTypes);
        if (isInJoinBlock())
            log("Return statement is not allowed in JoinBlock");
        return true;
    }

    @Override
    public void setInJoinBlock(boolean isInJoinBlock) {
        // TODO Auto-generated method stub
        super.setInJoinBlock(isInJoinBlock);    
    }
    
}
