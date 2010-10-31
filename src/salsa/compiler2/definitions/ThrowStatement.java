package salsa.compiler2.definitions;

public class ThrowStatement extends Statement {

    private Expression expression;
    
    public ThrowStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toJavaCode(String identation) {
        return "throw " + expression.toJavaCode("") + ";";
    }

}
