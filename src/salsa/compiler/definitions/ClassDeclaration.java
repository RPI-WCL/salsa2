package salsa.compiler.definitions;

import java.util.Iterator;
import java.util.List;

import salsa.compiler.SalsaNode;

public class ClassDeclaration extends TypeDeclaration {

    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(identation).append("class ").append(name);
        
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
        for (Iterator<StateVariableDeclaration> it = stateVariableDeclarations.iterator();
                it.hasNext();) {
            StateVariableDeclaration svd = it.next();
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
        for (Iterator<ConstructorDeclaration> it = constructors.values()
                .iterator(); it.hasNext();) {
            ConstructorDeclaration cd = it.next();
            sb.append(identation).append(cd.toJavaCode(identation + "  "))
                    .append("\n");            
            if (cd.parameters.size() == 0)
                hasDefaultConstructor = true;
        }
        if (!hasDefaultConstructor) {
            sb.append(identation+ "  ").append("public ").append(name).append("() {}\n");
        }
        
        /**
         * Message Handlers
         */
        
        for (Iterator<MessageHandlerDeclaration> it = messageHandlers.values().iterator(); it.hasNext();) {
            MessageHandlerDeclaration mh = it.next();
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
    
}
