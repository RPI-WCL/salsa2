package salsa.compiler.definitions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import salsa.compiler.SalsaNode;
import salsa.compiler.SalsaSource;

public class Block extends SalsaSource implements SalsaNode {
    
    List<Statement> statements = new ArrayList<Statement>();

    public void addStatement(Statement statement) {
        statements.add(statement);
    }


    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n" + identation).append("{\n");
        for (Iterator<Statement> it = statements.iterator(); it.hasNext();) {
            Statement statement = it.next();
            sb.append(statement.toJavaCode(identation + "  ")).append("\n");
        }
        sb.append(identation).append("}");
        return sb.toString();
    }

    @Override
    public boolean analyze(SalsaNode parent) {
        for (Iterator<Statement> it = statements.iterator(); it.hasNext();) {
            Statement statement = it.next();
            statement.analyze(this);
        }
        return true;
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
//    
}
