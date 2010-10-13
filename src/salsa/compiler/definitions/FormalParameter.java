package salsa.compiler.definitions;

import salsa.compiler.SalsaNode;
import salsa.compiler.SalsaParser;
import salsa.compiler.SalsaSource;
import salsa.compiler.SymbolType;

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
    public boolean analyze(SalsaNode parent) {
        SymbolType st = SalsaParser.getKnownType(type);
        if (st == null) {
            log("Unknown type " + type);
        } else {
            this.type = st.getCanonicalName();            
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
