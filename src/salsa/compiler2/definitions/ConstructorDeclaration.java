package salsa.compiler2.definitions;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import salsa.compiler2.SalsaNode;
import salsa.compiler2.SymbolType;

public class ConstructorDeclaration extends MethodDeclaration implements SalsaNode {
    
    public ConstructorDeclaration(String modifiers, String name,
            List<FormalParameter> parameters, Block block) {
        this.name = name;
        this.parameters = parameters;
        this.block = block;
    }

    
    @Override
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv, Map<String, SymbolType> knownTypes) {
        if (!((TypeDeclaration)parent).getName().equals(name)) {
            this.log("Invalid constructor");
        }
        return super.analyze(parent, typeEnv, knownTypes);
    }
    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();
        sb.append(identation).append("public ").append(name);
        if (!isClassDefinition())
            sb.append("State");
        sb.append("(");
        for (Iterator<FormalParameter> it = parameters.iterator(); it.hasNext();) {
            FormalParameter fp = it.next();
            sb.append(fp.toJavaCode(""));
            if (it.hasNext())
                sb.append(", ");
        }
        sb.append(")");
        
        sb.append(block.toJavaCode(identation + ""));
        return sb.toString();
    }
    
//    private int line = -1;
//    @Override
//    public void setLine(int line) {
//        this.line = line;
//    }
//    @Override
//    public int getLine() {
//        return line;
//    }
//
//    private String salsaSource = "";
//    
//    @Override
//    public void setSalsaSource(String src) {
//        salsaSource = src;
//    }
//
//    @Override
//    public String getSalsaSource() {
//        return salsaSource;
//    }
    
}
