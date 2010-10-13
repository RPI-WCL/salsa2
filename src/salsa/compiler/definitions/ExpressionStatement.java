package salsa.compiler.definitions;

import salsa.compiler.SalsaNode;
import salsa.compiler.definitions.Expression;

public class ExpressionStatement extends Statement implements SalsaNode {

    private Expression expression;

    public ExpressionStatement(Expression expression) {
        this.expression = expression;
        this.setSendMessage(expression.isSendMessage());
    }

    @Override
    public String toJavaCode(String identation) {

        StringBuilder sb = new StringBuilder();

        if (isContinuation() && isSendMessage()) {
            sb.append(identation).append("token = ")
                    .append(expression.toJavaCode(identation) + ";");
        } else if (!isContinuation() && isSendMessage() && isInJoinBlock()) {
            sb.append(identation).append("token = ")
                    .append(expression.toJavaCode(identation) + ";\n");
            sb.append(identation).append("_tokenList.add(token);");
//            sb.append(identation).append("token = null;");
        }
        else {
            sb.append(identation).append(expression.toJavaCode(identation) + ";");
//            sb.append(identation).append("token = null;");
        }
        
        return sb.toString();
    }

    @Override
    public boolean analyze(SalsaNode parent) {
        super.analyze(parent);
        expression.analyze(this);
        return true;
    }
    
//    private int line = -1;
//    @Override
//    public void setLine(int line) {
//        this.line = line;
//    }
//    @Override
//    public int getLine() {
//        return line;
//    }
//    
//    private String salsaSource = "";
//    
//    @Override
//    public void setSalsaSource(String src) {
//        salsaSource = src;
//    }
//
//    @Override
//    public String getSalsaSource() {
//        return salsaSource;
//    }
    
}
