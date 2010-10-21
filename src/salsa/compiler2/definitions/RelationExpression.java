package salsa.compiler2.definitions;

import java.util.ArrayList;
import java.util.List;

import salsa.compiler2.CompilerHelper;
import salsa.compiler2.SymbolType;

public class RelationExpression extends Expression {
    
    List<Expression> expressions = new ArrayList<Expression>();
    List<String> operators = new ArrayList<String>();

    private boolean isSendMessage = false;
    
    private String assignTo;
    
    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(expressions.get(0).toJavaCode(identation));
        
        for (int i = 0; i < operators.size(); i++) {
            sb.append(operators.get(i));
            sb.append(expressions.get(i+1).toJavaCode(identation));
        }
//        
//        if (isSendMessage)
//            System.err.println("send message");
        
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
        if (operators.size() > 0)
            return CompilerHelper.getSymbolTypeByName("boolean");
        else
            return expressions.get(0).getType();
    }

    public void setSendMessage(boolean isSendMessage) {
        this.isSendMessage = isSendMessage;
    }

    public boolean isSendMessage() {
        return isSendMessage;
    }

    public void setAssignTo(String var) {
        this.assignTo = var;
    }
    
}
