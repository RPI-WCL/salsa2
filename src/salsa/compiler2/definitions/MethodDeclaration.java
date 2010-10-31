package salsa.compiler2.definitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import salsa.compiler2.CompilerHelper;
import salsa.compiler2.SalsaNode;
import salsa.compiler2.SalsaSource;
import salsa.compiler2.SymbolMethod;
import salsa.compiler2.SymbolType;

public abstract class MethodDeclaration extends SalsaSource implements SalsaNode {

    protected String name;
    protected List<FormalParameter> parameters;
    protected Block block;
    protected String signature = null;    
    protected String modifiers = "";
    protected String returnType = "";
    private boolean isClassDef = false;
    private SymbolMethod symbolMethod;
    
    
 
    public SymbolMethod getSymbolMethod() {
        return symbolMethod;
    }

    public void setSymbolMethod(SymbolMethod symbolMethod) {
        this.symbolMethod = symbolMethod;
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

    public SymbolMethod getSymbolMethod(Map<String, SymbolType> knownTypes) {
       List<String> typeList = new ArrayList<String>();
       for (FormalParameter fp : parameters) {
            String type =  fp.getType();
            SymbolType st = CompilerHelper.getSymbolTypeByName(type);
            if (st != null) {
//                if (!isClassDefinition() && type.contains("[")
//                        && st.getRawType().isPrimitive()) {
//                    fp.log("Array arguments of a message should be of wrapper type, you may want to change "
//                            + type
//                            + " to "
//                            + CompilerHelper.convertoObjectType(type));
//                }
              fp.setType(st.getCanonicalName());
            }
            else 
                fp.log("Unknown type " + type);
            typeList.add(fp.getType());
        }
        if (!isClassDefinition() && !returnType.equals(name)
                && !returnType.equals("void")
                && !returnType.startsWith(CompilerHelper.TOKEN)) {
            returnType = CompilerHelper.TOKEN + " " + returnType;
        }
        SymbolType returnSt = CompilerHelper.getSymbolTypeByName(returnType);
        if (returnSt != null)
            returnType = returnSt.getCanonicalName();
        else 
            log("Unknown type " + returnType);

        symbolMethod = new SymbolMethod(name, returnType, typeList.toArray(new String[0])); 
        if (!isClassDefinition()) {
            symbolMethod.setMessage(true);
        }
        return symbolMethod;
    }

}
