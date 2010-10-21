package salsa.compiler2.definitions;

import salsa.compiler2.CompilerHelper;
import salsa.compiler2.SymbolType;


public class MultExpression extends Expression {

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

//    @Override
//    public void analyze(SalsaNode parent) {
//        // TODO Auto-generated method stub
//
//    }

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

//    private String getDominatingType(String type1, String type2) {
//        if (type1.equalsIgnoreCase("double") || type2.equalsIgnoreCase("double")) {
//            return "double";
//        }
//        else if (type1.equalsIgnoreCase("float") || type2.equalsIgnoreCase("float")) {
//            return "float";
//        }
//        else if (type1.equalsIgnoreCase("long") || type2.equalsIgnoreCase("long")) {
//            return "long";
//        }
//        else if (type1.equalsIgnoreCase("int") || type2.equalsIgnoreCase("int")) {
//            return "int";
//        }
//        else if (type1.equalsIgnoreCase("short") || type2.equalsIgnoreCase("short")) {
//            return "short";
//        }
//        //TODO byte and char?
//        else return "byte";
//    }

}
