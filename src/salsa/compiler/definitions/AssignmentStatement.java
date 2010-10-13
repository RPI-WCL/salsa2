package salsa.compiler.definitions;

import salsa.compiler.SalsaNode;
import salsa.compiler.SymbolType;

public class AssignmentStatement extends Statement {

    private Expression expression1;

    private Expression expression2;

    public AssignmentStatement(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
        this.setSendMessage(expression2.isSendMessage());
    }

    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();

        sb.append(identation).append(expression1.toJavaCode("")).append("=")
                .append(expression2.toJavaCode(identation)).append(";");

        if (isContinuation() && isSendMessage()) {
            sb.append("\n").append(identation).append("token = ")
                    .append(expression1.toJavaCode("")).append(";");
        }
        return sb.toString();
    }

    @Override
    public boolean analyze(SalsaNode parent) {
        super.analyze(parent);
        expression1.analyze(this);
        expression2.analyze(this);
        if (!expression1.getType().equals(expression2.getType())) {
            this.log("Incompatible type (" + expression1.getType() + " != "
                    + expression2.getType() + ")");
        }
        return true;
    }
}
