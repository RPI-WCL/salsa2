package salsa.compiler.definitions;

import java.util.List;

import salsa.compiler.SalsaNode;
import salsa.compiler.SalsaParser;
import salsa.compiler.SalsaSource;
import salsa.compiler.SymbolType;

public class VariableDeclaration extends SalsaSource implements SalsaNode {

    private String type;

    private String name = "";

    public List<String> attributes = null;

    // Init
    private Expression initExpresssion;

    private boolean isToken = false;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type.startsWith("future")) {
            isToken = true;
        }
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Expression getInitExpresssion() {
        return initExpresssion;
    }

    public void setInitExpresssion(Expression initExpresssion) {
        this.initExpresssion = initExpresssion;
    }

    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();

        sb.append(identation);

        if (isToken)
            sb.append("Token");
        else
            sb.append(type);
        sb.append(" " + name);

        if (initExpresssion != null)
            sb.append(" = ").append(initExpresssion.toJavaCode(identation))
                    .append("");

        return sb.toString();
    }

    @Override
    public boolean analyze(SalsaNode parent) {
        SymbolType st = SalsaParser.getKnownType(type);
        if (st == null) {
            log("Type not defined " + type);
        } else {
//            if (type.startsWith("future"))
//                this.type = "future " + st.getCanonicalName();
//            else
            this.type = st.getCanonicalName();
//            SalsaParser.addKnownType(st);
        }
        
        if (parent instanceof ClassDeclaration) {
            SymbolType st1 = SalsaParser
                    .getKnownType(((ClassDeclaration) parent).getAbsoluteName());
            SymbolType st2 = SalsaParser.getKnownType(type);
            if (st1 == null || st2 == null)
                log("Type not defined " + type);
            else {
                if (st1.isImmutable() && !st2.isImmutable()) {
                    log("Non-immutable field in an immutable class");
                }
            }
        }

        if (initExpresssion != null) {
            initExpresssion.analyze(this);
//            if (!SalsaParser.typeAssignable(type, initExpresssion.getType()))
            if (!type.equals(initExpresssion.getType())) {
                this.log("Incompatible type (" + type + " != "
                        + initExpresssion.getType() + ")");
            }
        }
        return true;
    }
    
}
