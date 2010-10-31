/*
	Code generation for the following grammar segment:
	
	BehaviorDeclaration := "behavior" <IDENTIFIER> ["extends" Name()] ["implements" Name() ("," Name())*] BehaviorBody()
 */

package salsa.compiler2.definitions;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import salsa.compiler2.CompilerHelper;
import salsa.compiler2.SalsaNode;
import salsa.compiler2.SymbolTable;
import salsa.compiler2.SymbolType;


public class BehaviorDeclaration extends TypeDeclaration implements SalsaNode {


    public String toJavaRefCode(String identation) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(identation).append("public " + modifiers + "class ")
                .append(name + " extends ActorRef {\n");
        
        sb.append(identation + "  ").append("public ").append(name).append("() {}\n");

        
        sb.append(identation + "  ").append("public ").append(name).append("(")
                .append(name).append("State actorState) {\n");
        sb.append(identation + "    ").append("super(actorState);\n");
        sb.append(identation + "    ").append("actorState.self = new " + name + "();\n")  ;
        sb.append(identation + "    ").append("actorState.self.identifier = this.identifier;\n")  ;
        sb.append(identation + "    ").append("actorState.self.uan = this.uan;\n")  ;
        sb.append(identation + "    ").append("actorState.self.ual = this.ual;\n")  ;
        sb.append(identation + "  }\n");
        
        sb.append(identation + "  ").append("public ").append(name).append("(")
                .append(name).append("State actorState, String uan, String location) {\n");
        sb.append(identation + "    ").append("super(actorState, uan, location);\n"); 
        sb.append(identation + "    ").append("actorState.self = new " + name + "();\n")  ;
        sb.append(identation + "    ").append("actorState.self.identifier = this.identifier;\n")  ;
        sb.append(identation + "    ").append("actorState.self.uan = this.uan;\n")  ;
        sb.append(identation + "    ").append("actorState.self.ual = this.ual;\n")  ;
       
        sb.append(identation + "  }\n");
//        sb.append(identation + "    ").append("if (uanStr != null && location != null) {\n");
//        sb.append(identation + "      ").append("actorState.setIdentifier(uanStr);\n");
//        sb.append(identation + "      ").append("actorState.send(this, actorState.getSelfRef(),-1,\"migrate\",\"exitValue\",Message.NORMAL_TYPE,new Object[]{location},new int[]{},null);\n");
//        sb.append(identation + "    }\n");
//        sb.append(identation + "    ").append("else if (location != null) {\n");
//        sb.append(identation + "      " +
//                "actorState.setIdentifier(\"ual://\" + location + \"/\" + actorState.hashCode());\n");
//        sb.append(identation + "    }\n");
//        sb.append(identation + "    else {\n");
//        sb.append(identation + "    ").append("this.identifier = actorState.getIdentifier();\n");
//        sb.append(identation + "    ").append("this.uan = actorState.getUAN();\n");
//        sb.append(identation + "    ").append("if (uanStr == null && location == null) this.actorState = actorState;\n");

        sb.append(identation+ "  ").append("public void go(ActorState actorState, String[] args) {\n");
        sb.append(identation + "    ").append("actorState.send(this, actorState.getSelfRef(),-1,\"act1\",\"exitValue\",Message.NORMAL_TYPE,new Object[]{args},new int[]{},null);").append("\n");
        sb.append(identation + "  }").append("\n");
        
        // Main method
        sb.append(identation+ "  ").append("public static void main(String[] args) {\n");
        sb.append(identation + "    ").append(name).append("State as = new ").append(name).append("State();\n");
        sb.append(identation + "    ").append(name + " ref=").append("new ").append(name)
            .append("(as);\n");
        sb.append(identation + "    ref.go(as, args);\n");
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
        
        sb.append(identation).append("  ").append(name + " self;\n");
        
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
                String type = fp.getType();
                if (type.indexOf('[') != -1) {
                    if (!CompilerHelper.isPrimitiveType(type))
                        sb.append("Arrays.copyOf(((Object[])args[")
                                .append(i)
                                .append("]), ((Object[])args[")
                                .append(i)
                                .append("]).length, ")
                                .append(CompilerHelper.convertoObjectType(type))
                                .append(".class)");
                    else
                        sb.append("(" + type + ")").append("args[").append(i)
                                .append("]");
                } else
                    sb.append(
                            "(" + CompilerHelper.convertoObjectType(type) + ")")
                            .append("args[").append(i).append("]");

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
        for (Iterator<MethodDeclaration> it = methodDeclaration.iterator(); it
                .hasNext();) {
            MessageHandlerDeclaration mh = (MessageHandlerDeclaration) it
                    .next();
            sb.append(identation + "    ").append("if (msgId == ")
                    .append(mh.getSymbolMethod().getId()).append(") {\n");
            sb.append(identation + "      ").append(mh.getName()).append("(");
            sb.append("src,assignTo");

            List<FormalParameter> parameters = mh.getParameters();
            for (int i = 0; i < parameters.size(); i++) {
                FormalParameter fp = parameters.get(i);
                sb.append(",");
                String type = fp.getType();
                if (type.indexOf('[') != -1) {
                    if (!CompilerHelper.isPrimitiveType(type))
                        sb.append("Arrays.copyOf(((Object[])args[")
                                .append(i)
                                .append("]), ((Object[])args[")
                                .append(i)
                                .append("]).length, ")
                                .append(CompilerHelper.convertoObjectType(type))
                                .append(".class)");
                    else
                        sb.append("(" + type + ")").append("args[").append(i)
                                .append("]");
                } else
                    sb.append(
                            "(" + CompilerHelper.convertoObjectType(type) + ")")
                            .append("args[").append(i).append("]");
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
