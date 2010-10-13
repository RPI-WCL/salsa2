package salsa.compiler.definitions;

import java.util.Iterator;
import java.util.List;

import salsa.compiler.SalsaNode;
import salsa.compiler.SalsaSource;

public abstract class MethodDeclaration extends SalsaSource implements SalsaNode {

    public String name;
    public List<FormalParameter> parameters;
    public Block block;
    public String signature = null;    
    
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
    

    public void setClassDef(boolean isClassDef) {
        this.isClassDef = isClassDef;
    }

    public boolean isClassDef() {
        return isClassDef;
    }    
}
