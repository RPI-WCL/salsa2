package salsa.compiler2.definitions;

import java.util.Map;

import salsa.compiler2.SalsaNode;
import salsa.compiler2.SalsaSource;
import salsa.compiler2.SymbolType;

public class Literal extends SalsaSource implements SalsaNode {
    
    public String type = "";

    public String value = "";
    
    
    
    public Literal(String type, String value) {
        super();
        this.type = type;
        this.value = value;
    }

    public String toJavaCode(String identation) {
        return value;
    }

    @Override
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv, Map<String, SymbolType> knownTypes) {

        return true;
    }
    
}
