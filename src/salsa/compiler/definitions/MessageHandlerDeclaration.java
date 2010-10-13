package salsa.compiler.definitions;

import java.util.Iterator;
import java.util.List;

import salsa.compiler.SalsaNode;
import salsa.compiler.SalsaParser;
import salsa.compiler.SymbolMethod;
import salsa.compiler.SymbolType;

public class MessageHandlerDeclaration extends MethodDeclaration implements
        SalsaNode {

    public MessageHandlerDeclaration(String type, String name,
            List<FormalParameter> parameters, Block block) {
        this.name = name;
        this.parameters = parameters;
        this.block = block;
        this.type = type;
    }

    private SymbolMethod symbolMethod;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String passType) {
        this.type = passType;
    }

    public SymbolMethod getSymbolMethod() {
        return symbolMethod;
    }

    public void setSymbolMethod(SymbolMethod symbolMethod) {
        this.symbolMethod = symbolMethod;
    }

    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();

        sb.append(identation).append(
                "@SuppressWarnings({ \"unchecked\", \"rawtypes\" })\n");

        if (!isClassDef()) {
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
            if (this.type.equals("void")) {
                sb.deleteCharAt(sb.length() - 1);
                sb.append(identation)
                        .append("// A tricky fix: add an echo message for void message.\n");
                sb.append(identation + "  ")
                        .append("send(self,src,-1,\"echo\",assignTo,Message.ECHO_TYPE,new Object[]{echoObject}, ");
                sb.append("new int[]{},null);\n");
                sb.append(identation).append("}");
            }
        } else {
            sb.append(identation).append("public ").append(type).append(" ")
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
    public boolean analyze(SalsaNode parent) {
//        for (FormalParameter fp : parameters) {
//            fp.analyze(this);
//        }
        SymbolType st = SalsaParser.getKnownType(type);
        if (st == null) {
            log("Unknown type " + type);
        } else {
            this.type = st.getCanonicalName();
        }
        block.analyze(this);
        return true;
    }
}
