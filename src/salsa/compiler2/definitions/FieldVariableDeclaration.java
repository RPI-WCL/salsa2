package salsa.compiler2.definitions;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import salsa.compiler2.SalsaNode;
import salsa.compiler2.SalsaSource;
import salsa.compiler2.SymbolType;

public class FieldVariableDeclaration extends SalsaSource implements SalsaNode {
  
    public List<VariableDeclaration> variableDeclarations = new Vector<VariableDeclaration>();
    
    public void addVariableDeclaration(VariableDeclaration vd) {
        variableDeclarations.add(vd);
    }
    
    public List<VariableDeclaration> getVariableDeclarations() {
        return variableDeclarations;
    }

    @Override
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv, Map<String, SymbolType> knownTypes) {
        for (VariableDeclaration vd : variableDeclarations) 
            vd.analyze(parent, typeEnv, knownTypes);
        return true;
    }

    @Override
    public String toJavaCode(String identation) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
