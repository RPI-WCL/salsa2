package salsa.compiler2.definitions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import salsa.compiler2.CompilerHelper;
import salsa.compiler2.SalsaNode;
import salsa.compiler2.SalsaSource;
import salsa.compiler2.SymbolType;


public class Allocation extends SalsaSource implements SalsaNode {

    private String type, arrayType;

    private List<Expression> actualArguments;
    
    private int allocType;
    
    public static int ALLOC_OBJECT = 1;
    
    public static int ALLOC_ARRAY = 2;
    
    private SymbolType symbolType;
    
    private Expression uanExpression;
    
    private Expression hostExpression;
    
    private Expression portExpression;

    public void setType(String type) {
        this.type = type;
        this.arrayType = "";
    }

    public String getType() {
        if (allocType == ALLOC_OBJECT)
            return type;
        else 
            return type + arrayType;
    }

    public List<Expression> getActuarrayTypealArguments() {
        return actualArguments;
    }

    public void setActualArguments(List<Expression> actualArguments) {
        this.actualArguments = actualArguments;
        this.allocType = ALLOC_OBJECT;
    }

    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();

        if (allocType == ALLOC_OBJECT) {
//            SymbolType symbolType = CompilerHelper.getKnownType(knownTypes, type);
            
            if (symbolType.isActorType()) {        
                sb.append("new ").append(type).append("(");
                sb.append("new ").append(type + "State").append("(");
            }
            else 
                sb.append("new ").append(type).append("(");
    
            for (Iterator<Expression> it = actualArguments.iterator(); it.hasNext();) {
                sb.append(it.next().toJavaCode(null));
                if (it.hasNext())
                    sb.append(", ");
            }
            sb.append(")");
            
            if (symbolType.isActorType()) {
                if (uanExpression != null) {
                    sb.append(", ").append(uanExpression.toJavaCode(""));
                }
                if (hostExpression != null) {
                    sb.append(", ").append(hostExpression.toJavaCode(""));
                }
                sb.append(")");
            }
        } else if (allocType == ALLOC_ARRAY) {
            sb.append("new ").append(type);
            for (Expression e : actualArguments) {
                sb.append("[").append(e.toJavaCode(identation)).append("]");
            }
        }
        
        return sb.toString();
    }

    @Override
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv,
            Map<String, SymbolType> knownTypes) {
        // Type test
        SymbolType st = CompilerHelper.getKnownType(knownTypes, type);
        if (st == null) {
            log("Unknown type " + type);
        } else {
            this.type = st.getCanonicalName();
            symbolType = st;
        }
        
        // TODO
        if (!symbolType.isActorType()
                && (uanExpression != null || hostExpression != null || portExpression != null)) {
            log("Only actors can have UAN or UAL");
        }
        if (uanExpression != null
                && uanExpression.analyze(parent, typeEnv, knownTypes)
                && !uanExpression.getType().getSimpleName().equals("String")) {
            log("UAN should be of String type");
        }
        return true;
    }

    public void addExpression(Expression expression) {
        if (actualArguments == null)
            actualArguments = new ArrayList<Expression>();
        actualArguments.add(expression);
        arrayType += "[]";
        this.allocType = ALLOC_ARRAY;
    }

    public void setUANExpression(Expression expression) {
        this.uanExpression = expression;
    }

    public void setHostExpression(Expression expression) {
        this.hostExpression = expression;
    }

    public void setPortExpression(Expression expression) {
        this.portExpression = expression;
    }
}
