package salsa.compiler2.definitions;

import java.util.Map;

import salsa.compiler2.CompilerHelper;
import salsa.compiler2.SalsaNode;
import salsa.compiler2.SalsaParser;
import salsa.compiler2.SalsaSource;
import salsa.compiler2.SymbolType;

public class VariableDeclaration extends SalsaSource implements SalsaNode {

    private String type;
    
    private String modifiers = "";

    private String name = "";

    private Expression initExpresssion;

    private boolean isToken = false;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type.startsWith("Token")) {
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
    

    
    public String getModifiers() {
        return modifiers;
    }

    public void setModifiers(String modifiers) {
        this.modifiers = modifiers;
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
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv, Map<String, SymbolType> knownTypes) {
        SymbolType st = CompilerHelper.getKnownType(knownTypes, type);
        if (st == null) {
            log("Type not defined " + type);
        } else {
            this.type = st.getCanonicalName();
            typeEnv.put(name, st);
        }
        
        if (parent instanceof ClassDeclaration) {
            SymbolType st1 = CompilerHelper
                    .getKnownType(knownTypes, ((ClassDeclaration) parent).getAbsoluteName());
            SymbolType st2 = CompilerHelper.getKnownType(knownTypes, type);
            if (st1 == null || st2 == null)
                log("Type not defined " + type);
            else {
                if (st1.isImmutable() && !st2.isImmutable()) {
                    log("Non-immutable field in an immutable class");
                }
            }
        }

        if (initExpresssion != null) {
            initExpresssion.analyze(this, typeEnv, knownTypes);
            if (!st.isAssignable((initExpresssion.getType()))) {
                this.log("Incompatible type (" + type + " != "
                        + initExpresssion.getType() + ")");
            }
        }
        return true;
    }
}
