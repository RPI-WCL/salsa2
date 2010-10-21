package salsa.compiler2;

import java.util.Map;


public interface SalsaNode {
    
    public String toJavaCode(String identation);
    
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv, Map<String, SymbolType> knownTypes);

}
