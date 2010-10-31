package salsa.compiler2.definitions;

import java.util.Map;

import salsa.compiler2.SalsaNode;
import salsa.compiler2.SymbolType;

public class WhileStatement extends Statement {

    private Expression expression;
    private Statement statement;
    
    public WhileStatement(Expression expression, Statement statement) {
        this.expression = expression;
        this.statement = statement;
    }

    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();
        sb.append(identation).append("while (").append(expression.toJavaCode("")).append(")");
        sb.append(statement.toJavaCode(identation));
        return sb.toString();
    }

    @Override
    public void setInJoinBlock(boolean isInJoinBlock) {
        super.setInJoinBlock(isInJoinBlock);
        statement.setInJoinBlock(isInJoinBlock);
    }

    @Override
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv,
            Map<String, SymbolType> knownTypes) {
        expression.analyze(this, typeEnv, knownTypes);
        if (!expression.getType().getCanonicalName().equalsIgnoreCase("boolean")) {
            this.log(expression.getSalsaSource() + " needs to be a boolean type");
        }
        return super.analyze(parent, typeEnv, knownTypes);
    }
}
