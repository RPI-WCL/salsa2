package salsa.compiler2.definitions;

import java.util.Iterator;
import java.util.Map;

import salsa.compiler2.SalsaNode;
import salsa.compiler2.SymbolType;

public class NegationExpression extends Expression {

//    List<String> operators = new ArrayList<String>();
    
    Term term;
    

    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();
        
        for (Iterator<String> it = operators.iterator(); it.hasNext();) {
            sb.append(it.next());
        }
        
        sb.append(term.toJavaCode(identation));
//        sb.append(expressions.get(0).toJavaCode(identation));        
        return sb.toString();
    }

    @Override
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv, Map<String, SymbolType> knownTypes) {
        // TODO Auto-generated method stub
        term.analyze(this, typeEnv, knownTypes);
        return true;
    }

    @Override
    public void addOperator(String operator) {
        operators.add(operator);
    }

    @Override
    public void addExpression(Expression e) {
    }

    public void setTerm(Term term) {
        this.term = term;
        term.setParentExpression(this);
    }

    @Override
    public SymbolType getType() {
        return term.getType();
    }
}
