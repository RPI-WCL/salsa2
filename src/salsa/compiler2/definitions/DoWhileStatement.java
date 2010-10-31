package salsa.compiler2.definitions;

import java.util.Map;

import salsa.compiler2.SalsaNode;
import salsa.compiler2.SymbolType;

public class DoWhileStatement extends Statement {
    private Expression expression;
    private Statement statement;
    
    public DoWhileStatement(Statement statement, Expression expression) {
        this.expression = expression;
        this.statement = statement;
    }

    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();
        sb.append(identation).append("do \n");
        sb.append(statement.toJavaCode(identation));
        sb.append("while (").append(expression.toJavaCode("")).append(")");
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
        if (!expression.getType().getCanonicalName().equalsIgnoreCase("boolean")) 
            this.log(expression.getSalsaSource() + " needs to be a boolean type");
        return super.analyze(parent, typeEnv, knownTypes);
    }
}
