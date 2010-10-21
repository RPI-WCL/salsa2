package salsa.compiler2.definitions;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import salsa.compiler2.CompilerHelper;
import salsa.compiler2.SalsaNode;
import salsa.compiler2.SalsaSource;
import salsa.compiler2.SymbolType;

public abstract class MethodDeclaration extends SalsaSource implements SalsaNode {

    protected String name;
    protected List<FormalParameter> parameters;
    protected Block block;
    protected String signature = null;    
    protected String modifiers = "";
    protected String returnType = "";
    private boolean isClassDef = false;
    
    /**
     * Signature is not related to pass type.
     * @return
     */
    public String getSignature() {
        if (signature == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(name).append("(");
            for (Iterator<FormalParameter> it = parameters.iterator(); it.hasNext();) {
                FormalParameter fp = it.next();
                sb.append(fp.getType());
                if (it.hasNext())
                    sb.append(",");
            }
            signature = sb.toString();
        }
        return signature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FormalParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<FormalParameter> parameters) {
        this.parameters = parameters;
    }
    
    public String getModifiers() {
        return modifiers;
    }

    public void setModifiers(String modifiers) {
        this.modifiers = modifiers;
    }

    public void setClassDefinition(boolean isClassDef) {
        this.isClassDef = isClassDef;
    }

    public boolean isClassDefinition() {
        return isClassDef;
    }

    @Override
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv, Map<String, SymbolType> knownTypes) {
        for (FormalParameter fp : parameters) {
            fp.analyze(this, typeEnv, knownTypes);
        }
        block.analyze(this, typeEnv, knownTypes);
        return true;
    }
    
    
}
