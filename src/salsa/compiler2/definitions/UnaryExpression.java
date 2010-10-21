package salsa.compiler2.definitions;

import java.util.Iterator;

import salsa.compiler2.CompilerHelper;
import salsa.compiler2.SymbolType;

public class UnaryExpression extends Expression {

    private String suffix;
    
    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();
        
        for (Iterator<String> it = operators.iterator(); it.hasNext();)
            sb.append(it.next());
        
        sb.append(expressions.get(0).toJavaCode(identation));
        
        if (suffix != null)
            sb.append(suffix);
        
        return sb.toString();
    }


    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public void addOperator(String operator) {
        operators.add(operator);
    }

    @Override
    public void addExpression(Expression e) {
        expressions.add(e);
    }

    @Override
    public SymbolType getType() {
        if (expressions.size() == 1)
            return expressions.get(0).getType();
        else {
            SymbolType type = expressions.get(0).getType();
            for (int i = 1; i < expressions.size(); i++) 
                type = CompilerHelper.getDominatingType(type, expressions.get(i).getType());
            return type;
        }
    }



}
