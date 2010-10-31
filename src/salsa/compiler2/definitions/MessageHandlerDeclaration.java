package salsa.compiler2.definitions;

import java.util.List;
import java.util.Map;

import salsa.compiler2.CompilerHelper;
import salsa.compiler2.SalsaNode;
import salsa.compiler2.SymbolMethod;
import salsa.compiler2.SymbolType;

public class MessageHandlerDeclaration extends MethodDeclaration implements
        SalsaNode {

    public MessageHandlerDeclaration(String modifiers, String type, String name,
            List<FormalParameter> parameters, Block block) {
        this.name = name;
        this.parameters = parameters;
        this.block = block;
        this.returnType = type;
        this.modifiers = modifiers;
    }


    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();

        sb.append(identation).append(
                "@SuppressWarnings({ \"unchecked\", \"rawtypes\" })\n");
        sb.append(identation).append(
                "@SalsaMsg\n");
        if (!isClassDefinition()) {
            sb.append(identation).append("public ")
                    .append(/* passType + */"void ").append(name + "(");

            sb.append("ActorRef src, String assignTo");
            for (FormalParameter fp : parameters) {
                sb.append(", ");
                sb.append(fp.toJavaCode(""));
            }
            sb.append(")");
            sb.append(block.toJavaCode(identation + ""));

            /**
             * A tricky fix: If a message has void return type, then we need to
             * echo something, because a continuation statement might be waiting
             * for it.
             */
            if (this.returnType.equals("void")) {
                sb.deleteCharAt(sb.length() - 1);
                sb.append(identation)
                        .append("// A tricky fix: add an echo message for void message.\n");
                sb.append(identation + "  ")
                        .append("send(self,src,-1,\"echo\",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, ");
                sb.append("new int[]{},null);\n");
                sb.append(identation).append("}");
            }
        } else {
            sb.append(identation).append("public ").append(returnType).append(" ")
                    .append(name + "(");
            for (FormalParameter fp : parameters) {
                sb.append(", ");
                sb.append(fp.toJavaCode(""));
            }
            sb.append(")");
            sb.append(block.toJavaCode(identation + ""));
        }
        return sb.toString();
    }

    @Override
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv, Map<String, SymbolType> knownTypes) {
        SymbolType st = CompilerHelper.getKnownType(knownTypes, returnType);
        if (st == null) {
            log("Unknown type " + returnType);
        } else {
            this.returnType = st.getCanonicalName();
        }
        return super.analyze(parent, typeEnv, knownTypes);
    }
}
