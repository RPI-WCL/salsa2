package salsa.compiler2.definitions;

import java.util.Map;

import salsa.compiler2.SalsaNode;
import salsa.compiler2.SymbolType;

public class ForStatement extends Statement implements SalsaNode {

    private LocalVariableDeclaration ld;
    
    private Expression conditionExpression;
    
    private Expression incrementExpression;
    
    private Statement statement;

    public ForStatement(LocalVariableDeclaration ld,
            Expression conditionExpression, Expression incrementExpression,
            Statement block) {
        super();
        this.ld = ld;
        this.conditionExpression = conditionExpression;
        this.incrementExpression = incrementExpression;
        this.statement = block;
    }
    
    
    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();

        sb.append(identation).append("for (");
        if (ld != null)
            sb.append(ld.toJavaCode(""));
        else
            sb.append(";");
        
        if (conditionExpression != null)
            sb.append(conditionExpression.toJavaCode(""));
        sb.append(";");
        
        if (incrementExpression != null)
            sb.append(incrementExpression.toJavaCode(""));
        sb.append(")");
        
        sb.append(statement.toJavaCode(identation));
        
        return sb.toString();
    }

    @Override
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv, Map<String, SymbolType> knownTypes) {
        super.analyze(parent, typeEnv, knownTypes);
        if (ld != null)
            ld.analyze(this, typeEnv, knownTypes);
        if (conditionExpression != null) {
            conditionExpression.analyze(this, typeEnv, knownTypes);
            if (!conditionExpression.getType().getCanonicalName().equalsIgnoreCase("boolean"))
                this.log(conditionExpression.getSalsaSource() + " needs to be a boolean type");
        }
        if (incrementExpression != null)
            incrementExpression.analyze(this, typeEnv, knownTypes);
        if (statement != null)
            statement.analyze(this, typeEnv, knownTypes); 
        return true;
        
    }


    @Override
    public void setInJoinBlock(boolean isInJoinBlock) {
        super.setInJoinBlock(isInJoinBlock);
        statement.setInJoinBlock(isInJoinBlock);
    }

}
