/*
	Code generation for the following grammar segment:
	
	BehaviorDeclaration := "behavior" <IDENTIFIER> ["extends" Name()] ["implements" Name() ("," Name())*] BehaviorBody()
 */

package salsa.compiler2.definitions;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import salsa.compiler2.SalsaNode;
import salsa.compiler2.SymbolTable;
import salsa.compiler2.SymbolType;


public class BehaviorDeclaration extends TypeDeclaration implements SalsaNode {


    public String toJavaRefCode(String identation) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(identation).append("public " + modifiers + "class ")
                .append(name + " extends ActorRef {\n");
        sb.append(identation + "  ").append("public ").append(name).append("(")
                .append(name).append("State actorState) {\n");
        sb.append(identation + "    ").append("super(actorState);\n");
        sb.append(identation + "  }\n");
        
        sb.append(identation + "  ").append("public ").append(name).append("(")
                .append(name).append("State actorState, String uanStr, String host) {\n");
        sb.append(identation + "    ").append("super(actorState);\n");
        sb.append(identation + "    ").append("if (uanStr != null) actorState.setIdentifier(uanStr);\n");
//        sb.append(identation + "    ").append("else actorState.setIdentifier(\"ual://\" + host);\n");
        sb.append(identation + "    ").append("if (host != null) {\n");
        sb.append(identation + "      " +
                "actorState.setIdentifier(\"ual://\" + host + \"/\" + actorState.hashCode());\n");
        sb.append(identation + "      " +
        		"actorState.send(this, actorState.getSelfRef(),-1,\"migrate\",\"exitValue\",Message.NORMAL_TYPE,new Object[]{host},new int[]{},null);\n");
        sb.append(identation + "    }\n");
        sb.append(identation + "  }\n");

        sb.append(identation+ "  ").append("public void go(String[] args) {\n");
        sb.append(identation + "    ").append("actorState.send(this, actorState.getSelfRef(),-1,\"act1\",\"exitValue\",Message.NORMAL_TYPE,new Object[]{args},new int[]{},null);").append("\n");
        sb.append(identation + "  }").append("\n");
        
        // Main method
        sb.append(identation+ "  ").append("public static void main(String[] args) {\n");
        sb.append(identation + "    ").append(name + " ref=").append("new ").append(name)
            .append("(new ").append(name).append("State());\n");
        sb.append(identation + "    ref.go(args);\n");
        sb.append(identation + "  }\n");
        sb.append(identation + "}\n");
        return sb.toString();
    }
    
    
    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(identation).append("public " + modifiers 
                + "class ").append(name + "State extends ActorState");
        
        
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
            sb.append(identation+ "  ").append("public ").append(name).append("State() {}\n");
        }
        
        /**
         * Message Handlers
         */
        
        for (Iterator<MethodDeclaration> it = methodDeclaration.iterator(); it.hasNext();) {
            MethodDeclaration mh = it.next();
            sb.append(identation).append(mh.toJavaCode(identation + "  "))
                    .append("\n\n");
        }        

        
        /**
         * Invoke Message by name
         */        
        sb.append(identation + "  ").append("public void invokeByName(String msgName, Object[] args, ActorRef src, String assignTo) {\n");
        for (Iterator<MethodDeclaration> it = methodDeclaration.iterator(); it.hasNext();) {
            MessageHandlerDeclaration mh = (MessageHandlerDeclaration)it.next();
            sb.append(identation + "    ").append("if (msgName.equals(\"").append(mh.getName())
                .append(mh.getParameters().size())
                .append("\")) {\n");
            sb.append(identation + "      ").append(mh.getName()).append("(");
            sb.append("src,assignTo");
            
            List<FormalParameter> parameters = mh.getParameters();
            for (int i = 0; i < parameters.size(); i++) {
                FormalParameter fp = parameters.get(i);
                sb.append(",");
                if (fp.getType().indexOf('[') != -1) {
                    sb.append("Arrays.copyOf(((Object[])args[").append(i)
                        .append("]), ((Object[])args[").append(i)
                        .append("]).length, ").append(fp.getType()).append(".class)");
                } else
                    sb.append("(" + SymbolTable.convertoObjectType(fp.getType()) + ")").append("args[").append(i).append("]");
            }
            sb.append(");\n");
            sb.append(identation + "      return;\n");
            sb.append(identation + "    }\n");
        }
        sb.append(identation + "  ").append("}\n");
        
        /**
         * Invoke Message by id
         */        
        sb.append(identation + "  ").append("public void invokeById(int msgId, Object[] args, ActorRef src, String assignTo) {\n");
        for (Iterator<MethodDeclaration> it = methodDeclaration.iterator(); it.hasNext();) {
            MessageHandlerDeclaration mh = (MessageHandlerDeclaration)it.next();
            sb.append(identation + "    ").append("if (msgId == ").append(mh.getSymbolMethod().getId())
                .append(") {\n");
            sb.append(identation + "      ").append(mh.getName()).append("(");
            sb.append("src,assignTo");
            
            List<FormalParameter> parameters = mh.getParameters();
            for (int i = 0; i < parameters.size(); i++) {
                FormalParameter fp = parameters.get(i);
                sb.append(",");
                if (fp.getType().indexOf('[') != -1) {
                    sb.append("Arrays.copyOf(((Object[])args[").append(i)
                        .append("]), ((Object[])args[").append(i)
                        .append("]).length, ").append(fp.getType()).append(".class)");
                } else
                    sb.append("(" + SymbolTable.convertoObjectType(fp.getType()) + ")").append("args[").append(i).append("]");
            }
            sb.append(");\n");
            sb.append(identation + "      return;\n");
            sb.append(identation + "    }\n");
        }
        sb.append(identation + "  ").append("}\n");
        
        
        sb.append(identation + "}\n");
        return sb.toString();
    }


    @Override
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv, Map<String, SymbolType> knownTypes) {
        typeEnv.put("self", this.symbolType);
        return super.analyze(parent, typeEnv, knownTypes);
    }
    
    

}
