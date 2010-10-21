package salsa.compiler2.definitions;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import salsa.compiler2.SalsaNode;
import salsa.compiler2.SymbolType;

public class ClassDeclaration extends TypeDeclaration {

    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(identation).append("public class ").append(name);
        
        // Implementation
        if (implementNames.size() > 0) {
            sb.append(" implements ");
            for (Iterator<String> it = implementNames.iterator(); it.hasNext();){
                sb.append(it.next());
                if (it.hasNext())sb.append(", ");
            }
        }
        
        sb.append(" {\n");        
        
        
        /**
         * Field Variables
         */
        for (Iterator<FieldVariableDeclaration> it = fieldVariableDeclarations.iterator();
                it.hasNext();) {
            FieldVariableDeclaration svd = it.next();
            List<VariableDeclaration> vds = svd.getVariableDeclarations();
            for (Iterator<VariableDeclaration> it2 = vds.iterator(); it2.hasNext();) {
                VariableDeclaration vd = it2.next();
                sb.append(identation).append(vd.toJavaCode(identation + "  ")).append(";\n");
            }
        }
        
        /**
         * Constructors
         */
        boolean hasDefaultConstructor = false;
        for (Iterator<ConstructorDeclaration> it = constructors.iterator(); it.hasNext();) {
            ConstructorDeclaration cd = it.next();
            sb.append(identation).append(cd.toJavaCode(identation + "  "))
                    .append("\n");            
            if (cd.parameters.size() == 0)
                hasDefaultConstructor = true;
        }
        if (!hasDefaultConstructor) {
            sb.append(identation+ "  ").append("public ").append(name).append("() {}\n");
        }
        
        for (Iterator<MethodDeclaration> it = methodDeclaration.iterator(); it.hasNext();) {
            MethodDeclaration mh = it.next();
            sb.append(identation).append(mh.toJavaCode(identation + "  ")).append("\n");
        }

        sb.append(identation + "}\n");
        return sb.toString();
    }
    
    private int line = -1;
    @Override
    public void setLine(int line) {
        this.line = line;
    }
    @Override
    public int getLine() {
        return line;
    }
    
    private String salsaSource = "";
    
    @Override
    public void setSalsaSource(String src) {
        salsaSource = src;
    }

    @Override
    public String getSalsaSource() {
        return salsaSource;
    }
    @Override
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv, Map<String, SymbolType> knownTypes) {
        typeEnv.put("this", this.symbolType);
        return super.analyze(parent, typeEnv, knownTypes);
    }

}
