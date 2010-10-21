package salsa.compiler2.definitions;

import java.util.Map;

import salsa.compiler2.CompilerHelper;
import salsa.compiler2.SalsaNode;
import salsa.compiler2.SalsaSource;
import salsa.compiler2.SymbolType;

public class FormalParameter extends SalsaSource implements SalsaNode {

    private String type;
    private String name;
    public FormalParameter(String type, String name) {
        super();
        this.type = type;
        this.name = name;
    }
    @Override
    public String toJavaCode(String identation) {
        return type + " " + name;
    }
    @Override
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv, Map<String, SymbolType> knownTypes) {
        SymbolType st = CompilerHelper.getKnownType(knownTypes, type);
        if (st == null) {
            log("Unknown type " + type);
        } else {
            this.type = st.getCanonicalName();      
            typeEnv.put(name, st);
       }
        return true;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
}
