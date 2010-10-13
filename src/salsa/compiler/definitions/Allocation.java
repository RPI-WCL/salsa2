package salsa.compiler.definitions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import salsa.compiler.SalsaNode;
import salsa.compiler.SalsaParser;
import salsa.compiler.SalsaSource;
import salsa.compiler.SymbolType;


public class Allocation extends SalsaSource implements SalsaNode {

    private String type, arrayType;

    private List<Expression> actualArguments;
    
    private int allocType;
    
    public static int ALLOC_OBJECT = 1;
    
    public static int ALLOC_ARRAY = 2;

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
            SymbolType symbolType = SalsaParser.getKnownType(type);
            
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
            
            if (symbolType.isActorType())        
                sb.append(")");
        } else if (allocType == ALLOC_ARRAY) {
            sb.append("new ").append(type);
            for (Expression e : actualArguments) {
                sb.append("[").append(e.toJavaCode(identation)).append("]");
            }
        }
        
        return sb.toString();
    }

    @Override
    public boolean analyze(SalsaNode parent) {
        // Type test
        SymbolType st = SalsaParser.getKnownType(type);
        if (st == null) {
            log("Unknown type " + type);
        } else {
            this.type = st.getCanonicalName();
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
}
