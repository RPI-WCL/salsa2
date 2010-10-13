package salsa.compiler.definitions;

import salsa.compiler.SalsaNode;
import salsa.compiler.SalsaSource;

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
    public boolean analyze(SalsaNode parent) {

        return true;
    }
    
}
