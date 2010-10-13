package salsa.compiler.definitions;

import salsa.compiler.SalsaNode;

public class ForStatement extends Statement implements SalsaNode {

    private LocalVariableDeclaration ld;
    
    private Expression conditionExpression;
    
    private Expression incrementExpression;
    
    private Block block;

    public ForStatement(LocalVariableDeclaration ld,
            Expression conditionExpression, Expression incrementExpression,
            Block block) {
        super();
        this.ld = ld;
        this.conditionExpression = conditionExpression;
        this.incrementExpression = incrementExpression;
        this.block = block;
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
        
        sb.append(block.toJavaCode(identation));
        
        return sb.toString();
    }

    @Override
    public boolean analyze(SalsaNode parent) {
        super.analyze(parent);
        if (ld != null)
            ld.analyze(this);
        if (conditionExpression != null) {
            conditionExpression.analyze(this);
            if (!conditionExpression.getType().equalsIgnoreCase("boolean"))
                this.log(conditionExpression.getSalsaSource() + " needs to be a boolean type");
        }
        if (incrementExpression != null)
            incrementExpression.analyze(this);
        if (block != null)
            block.analyze(this); 
        return true;
        
    }

}
