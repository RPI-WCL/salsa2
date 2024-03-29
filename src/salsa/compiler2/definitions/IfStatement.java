package salsa.compiler2.definitions;

import java.util.Map;

import salsa.compiler2.SalsaNode;
import salsa.compiler2.SymbolType;

public class IfStatement extends Statement implements SalsaNode {

    Expression e;

    Statement ifStatement, elseStatement;

    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();

        sb.append(identation).append("if(").append(e.toJavaCode(identation))
                .append(")");

        sb.append(ifStatement.toJavaCode(identation));

        if (elseStatement != null) {
            sb.append("\n" + identation + "else").append(
                    elseStatement.toJavaCode(identation));
        }

        return sb.toString();
    }

    @Override
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv, Map<String, SymbolType> knownTypes) {
        super.analyze(parent, typeEnv, knownTypes);
        e.analyze(this, typeEnv, knownTypes);
        ifStatement.analyze(this, typeEnv, knownTypes);
        if (elseStatement != null)
            elseStatement.analyze(this, typeEnv, knownTypes);
        if (!e.getType().getCanonicalName().equalsIgnoreCase("boolean")) {
            this.log(e.getSalsaSource() + " needs to be a boolean type");
        }
        return true;
    }

    public void setExpression(Expression e) {
        this.e = e;
    }

    public void setIfStatement(Statement statement) {
        ifStatement = statement;
    }

    public void setElseStatement(Statement s) {
        this.elseStatement = s;
    }

    @Override
    public void setInJoinBlock(boolean isInJoinBlock) {
        super.setInJoinBlock(isInJoinBlock);
    }

    

//    private int line = -1;
//    @Override
//    public void setLine(int line) {
//        this.line = line;
//    }
//    @Override
//    public int getLine() {
//        return line;
//    }
//    
//    private String salsaSource = "";
//    
//    @Override
//    public void setSalsaSource(String src) {
//        salsaSource = src;
//    }
//
//    @Override
//    public String getSalsaSource() {
//        return salsaSource;
//    }
    
}
