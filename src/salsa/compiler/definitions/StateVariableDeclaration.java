package salsa.compiler.definitions;

import java.util.List;
import java.util.Vector;

import salsa.compiler.SalsaNode;
import salsa.compiler.SalsaSource;

public class StateVariableDeclaration extends SalsaSource implements SalsaNode {
  
    public List<VariableDeclaration> variableDeclarations = new Vector<VariableDeclaration>();
    
    public void addVariableDeclaration(VariableDeclaration vd) {
        variableDeclarations.add(vd);
    }
    
    public List<VariableDeclaration> getVariableDeclarations() {
        return variableDeclarations;
    }

    @Override
    public boolean analyze(SalsaNode parent) {
        for (VariableDeclaration vd : variableDeclarations) 
            vd.analyze(parent);
        return true;
    }

    @Override
    public String toJavaCode(String identation) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
