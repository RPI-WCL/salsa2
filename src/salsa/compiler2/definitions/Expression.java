package salsa.compiler2.definitions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import salsa.compiler2.CompilerHelper;
import salsa.compiler2.SalsaNode;
import salsa.compiler2.SalsaSource;
import salsa.compiler2.SymbolType;

public class Expression extends SalsaSource implements SalsaNode {
    
    List<Expression> expressions = new ArrayList<Expression>();
    List<String> operators = new ArrayList<String>();

    protected boolean isSendMessage = false;
    
    protected boolean isReturnStatement = false;
    
    protected boolean afterContinuation = false;
    
    protected String assignTo;
    
    public Expression() {
        this.assignTo = "";
    }
    
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
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv, Map<String, SymbolType> knownTypes) {
        for (Expression e : expressions)
            e.analyze(this, typeEnv, knownTypes);
        return true;
    }


    public void addOperator(String operator) {
        operators.add(operator);
    }


    public void addExpression(Expression e) {
        expressions.add(e);
    }


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
    

    public boolean isReturnStatement() {
        return isReturnStatement;
    }

    public void setReturnStatement(boolean isReturnStatement) {
        this.isReturnStatement = isReturnStatement;
        for (Expression e : expressions)
            e.setReturnStatement(true);
    }

    public boolean isAfterContinuation() {
        return afterContinuation;
    }

    public void setAfterContinuation(boolean afterContinuation) {
        this.afterContinuation = afterContinuation;
        for (Expression e : expressions)
            e.setAfterContinuation(afterContinuation);
    }        
    
}
