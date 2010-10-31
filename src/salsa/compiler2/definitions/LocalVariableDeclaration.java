package salsa.compiler2.definitions;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import salsa.compiler2.SalsaNode;
import salsa.compiler2.SymbolType;

public class LocalVariableDeclaration extends Statement implements SalsaNode {

    public List<VariableDeclaration> variableDeclarations = new Vector<VariableDeclaration>();
    
    
    
    public void addVariableDeclaration(VariableDeclaration vd) {
        variableDeclarations.add(vd);
    }

    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();
        
        for (Iterator<VariableDeclaration> it = variableDeclarations.iterator();
            it.hasNext();) {
            VariableDeclaration vd = it.next();
            sb.append(vd.toJavaCode(identation));
            if (this.isInContinuation() && this.isSendMessage()) {
                sb.append("\n");
                sb.append(identation).append("token = ").append(vd.getName());
            } else if (!isInContinuation() && isSendMessage() && isInJoinBlock()) {
                sb.append(identation).append("token = ").append(vd.getName() + ";\n");
                sb.append(identation).append("_tokenList.add(token)");
            }           
            sb.append(";");
        }        
        return sb.toString();
    }

    @Override
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv, Map<String, SymbolType> knownTypes) {
        super.analyze(parent, typeEnv, knownTypes);
        for (Iterator<VariableDeclaration> it = variableDeclarations.iterator(); it
                .hasNext();) {
            VariableDeclaration vd = it.next();
            vd.analyze(this, typeEnv, knownTypes);
        }
        return true;
    }

    @Override
    public void setInJoinBlock(boolean isInJoinBlock) {
        super.setInJoinBlock(isInJoinBlock);
    }
}
