package salsa.compiler2.definitions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import salsa.compiler2.SalsaNode;
import salsa.compiler2.SalsaSource;
import salsa.compiler2.SymbolType;

public class Block extends SalsaSource implements SalsaNode {
    
    List<Statement> statements = new ArrayList<Statement>();
    
    private boolean isJoinBlock = false;

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
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv, Map<String, SymbolType> knownTypes) {
        for (Iterator<Statement> it = statements.iterator(); it.hasNext();) {
            Statement statement = it.next();
            statement.analyze(this, typeEnv, knownTypes);
        }
        return true;
    }


    public void setJoinBlock(boolean b) {
        isJoinBlock = true;
        for (Statement stat : statements) {
            stat.setInJoinBlock(isJoinBlock);
        }
    }
}
