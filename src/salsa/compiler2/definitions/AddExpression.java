package salsa.compiler2.definitions;

import salsa.compiler2.CompilerHelper;
import salsa.compiler2.SymbolType;


public class AddExpression extends Expression {

//    List<Expression> expressions = new ArrayList<Expression>();
//    List<String> operators = new ArrayList<String>();

    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(expressions.get(0).toJavaCode(identation));
        
        for (int i = 0; i < operators.size(); i++) {
            sb.append(operators.get(i));
            sb.append(expressions.get(i+1).toJavaCode(identation));
        }
        
        return sb.toString();
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
                type = CompilerHelper.getSumDominatingType(type, expressions.get(i).getType());
            return type;
        }
    }

}
