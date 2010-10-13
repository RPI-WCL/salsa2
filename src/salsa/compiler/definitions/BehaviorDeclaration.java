/*
	Code generation for the following grammar segment:
	
	BehaviorDeclaration := "behavior" <IDENTIFIER> ["extends" Name()] ["implements" Name() ("," Name())*] BehaviorBody()
 */

package salsa.compiler.definitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import salsa.compiler.SalsaNode;
import salsa.compiler.SymbolTable;

public class BehaviorDeclaration extends TypeDeclaration implements SalsaNode {


    public String toJavaRefCode(String identation) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(identation).append(attributes + "class ")
                .append(name + " extends ActorRef {\n");
        sb.append(identation + "  ").append("public ").append(name).append("(")
                .append(name).append("State actorState) {\n");
        sb.append(identation + "    ").append("super(actorState);\n");
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
        
        sb.append(identation).append(attributes 
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
            sb.append(identation+ "  ").append("public ").append(name).append("State() {}\n");
        }
        
        /**
         * Message Handlers
         */
        
        for (Iterator<MessageHandlerDeclaration> it = messageHandlers.values()
                .iterator(); it.hasNext();) {
            MessageHandlerDeclaration mh = it.next();
            sb.append(identation).append(mh.toJavaCode(identation + "  "))
                    .append("\n\n");
        }        

        
        /**
         * Invoke Message by name
         */        
        sb.append(identation + "  ").append("public void invokeByName(String msgName, Object[] args, ActorRef src, String assignTo) {\n");
        for (Iterator<MessageHandlerDeclaration> it = messageHandlers.values()
                .iterator(); it.hasNext();) {
            MessageHandlerDeclaration mh = it.next();
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
        for (Iterator<MessageHandlerDeclaration> it = messageHandlers.values()
                .iterator(); it.hasNext();) {
            MessageHandlerDeclaration mh = it.next();
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

//    PRIVATE INT LINE = -1;
//    @OVERRIDE
//    PUBLIC VOID SETLINE(INT LINE) {
//        THIS.LINE = LINE;
//    }
//    @OVERRIDE
//    PUBLIC INT GETLINE() {
//        RETURN LINE;
//    }
//    
//    PRIVATE STRING SALSASOURCE = "";
//    
//    @OVERRIDE
//    PUBLIC VOID SETSALSASOURCE(STRING SRC) {
//        SALSASOURCE = SRC;
//    }
//
//    @OVERRIDE
//    PUBLIC STRING GETSALSASOURCE() {
//        RETURN SALSASOURCE;
//    }
    

}
