package salsa.compiler2.definitions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import salsa.compiler2.CompilerHelper;
import salsa.compiler2.SalsaNode;
import salsa.compiler2.SalsaSource;
import salsa.compiler2.SymbolMethod;
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
        
        if (type.contains("UAL")) {
            System.out.print("");
        }      
        
        for (Expression e : actualArguments) {
            e.analyze(parent, typeEnv, knownTypes);
        }
        
        // Type test
        SymbolType st = CompilerHelper.getKnownType(knownTypes, type);
        if (st == null) {
            log("Unknown type " + type);
            return false;
        } else {
            this.type = st.getCanonicalName();
            symbolType = st;
        }
        
        // Check if the constructor exist 
        StringBuilder sbInput = null; 
        StringBuilder sbRequired = null;
        List<SymbolMethod> methods = st.getMethods();
        boolean found = true;
        for (SymbolMethod sm : methods) {
                if (type.equals(sm.getName())
                        && actualArguments.size() == sm.getParameterTypes().length) {
                    sbInput = new StringBuilder();
                    sbRequired = new StringBuilder();
                    sbInput.append(type).append("(");
                    found = true;
                    sbRequired.append(type).append("(");
                    for (int i = 0; i < actualArguments.size(); i++) {
                        SymbolType eType = actualArguments.get(i).getType();
                        SymbolType rType = sm.getParameterSymbolTypes().get(i);
                        if (eType == null) {
                            this.log("Cannot determine the type of "
                                    + actualArguments.get(i).toJavaCode(""));
                            break;
                        } else if (!rType.isAssignable(eType)) {
                            found = false;
                            // break;
                        }
                        sbInput.append(eType.getCanonicalName());
                        sbRequired.append(rType.getCanonicalName());
                        if (i < actualArguments.size() - 1) {
                            sbInput.append(", ");
                            sbRequired.append(", ");
                        }

                    }
                    sbInput.append(")");
                    sbRequired.append(")");
                    if (found) {
                        break;
                    }
                }
            }
        if (!found)
            this.log("Cannot find method "
                    + (sbInput == null ? type : sbInput.toString())
                    + " in "
                    + type
                    + (sbRequired == null ? "." : ". Do you mean "
                            + sbRequired.toString() + "?"));
        
        // TODO
        if (!symbolType.isActorType()
                && (uanExpression != null || hostExpression != null )) {
            log("Only actors can have UAN or UAL");
        }
        if (uanExpression != null
                && uanExpression.analyze(parent, typeEnv, knownTypes)
                && !uanExpression.getType().getSimpleName().equals("String")) {
            log("UAN should be of String type");
        }
        if (hostExpression != null            
                 && hostExpression.analyze(parent, typeEnv, knownTypes)
                && !hostExpression.getType().getSimpleName().equals("String")) {
            log("Location should be of String type in the form of host:port");
               
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

}
