package salsa.compiler.definitions;

import salsa.compiler.SalsaNode;

public class ReturnStatement extends Statement {

    private Expression expression;
    
    public ReturnStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();
        
        if (!isClassDef()) { 
            sb.append(identation).append("{\n");
            if (expression.getType().startsWith("future")) {
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
