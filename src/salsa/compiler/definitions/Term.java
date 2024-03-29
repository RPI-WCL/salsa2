package salsa.compiler.definitions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import salsa.compiler.SalsaNode;
import salsa.compiler.SalsaParser;
import salsa.compiler.SalsaSource;
import salsa.compiler.SymbolField;
import salsa.compiler.SymbolMethod;
import salsa.compiler.SymbolType;

public class Term extends SalsaSource implements SalsaNode {

    /**
     * Type of this term
     */
    private String type = null; 
    
    private String varName;
    
    private String varType;
    
    private String castType;
    
    private Literal literal;
    
    private Expression expression;
    
    private Allocation allocation;
    
    private String selector;
    
    private String messageName;
    
    private int messageId = -1;
    
    private List<Expression> actualArguments;
    
    private Expression parentExpression = null;
    
    private int termType = 0;
    
    public static final int LITERAL = 1;
    
    public static final int EXPRESSION = 2;
    
    public static final int VARIABLE = 3;
    
    public static final int ALLOCATION = 4;
    
    
    private int operatorType = 0;

    
    public static final int SELECT_FIELD = 1;
    
    public static final int INVOKE_METHOD = 2;
    
    public static final int SEND_MESSAGE = 3;
    
    
//    private boolean isInReturnStatement = false;
    
    private List<Expression> arrayIndexes = new ArrayList<Expression>();

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
        this.termType = VARIABLE;
    }
    
    
    public String getVarType() {
        return varType;
    }

    public void setVarType(String varType) {
        this.varType = varType;
    }

    public String getCastType() {
        return castType;
    }
    public void setCastType(String castType) {
        this.castType = castType;
    }

    public Literal getLiteral() {
        return literal;
    }

    public void setLiteral(Literal literal) {
        this.literal = literal;
        this.termType = LITERAL;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
        this.termType = EXPRESSION;
    }

    public Allocation getAllocation() {
        return allocation;
    }

    public void setAllocation(Allocation allocation) {
        this.allocation = allocation;
        this.termType = ALLOCATION;
    }

    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
        operatorType = Term.SELECT_FIELD;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
        operatorType = Term.SEND_MESSAGE;
    }

    public List<Expression> getActualArguments() {
        return actualArguments;
    }

    public void setActualArguments(List<Expression> actualArguments) {
        this.actualArguments = actualArguments;
        if (operatorType == Term.SELECT_FIELD)
            operatorType = Term.INVOKE_METHOD;
    }

    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();
        
        if (castType != null)
            sb.append("(").append(castType).append(")");

        
        switch (termType) {
        case Term.LITERAL:
            sb.append(literal.value);
            break;
        case Term.EXPRESSION:
            sb.append(expression.toJavaCode(identation));
            break;
        case Term.VARIABLE:
            if (operatorType != Term.SEND_MESSAGE)
                sb.append(varName);
            break;
        case Term.ALLOCATION:
            if (operatorType != Term.SEND_MESSAGE)
                sb.append(allocation.toJavaCode(identation));
            break;
        }
        
        switch(operatorType) {
        case Term.SELECT_FIELD:
            sb.append(".").append(selector);
            break;
        case Term.INVOKE_METHOD:
            sb.append(".").append(selector).append("(");
            for (Iterator<Expression> it = actualArguments.iterator();
                    it.hasNext();) {
                sb.append(it.next().toJavaCode(identation));
                if (it.hasNext())
                    sb.append(",");
            }
            sb.append(")");
            break;
        case Term.SEND_MESSAGE:
            StringBuilder tokenPos = new StringBuilder(); // Store token's position
            tokenPos.append("new int[]{ "); 
//            sb.append("assert " + varName + " != null;");
            sb.append("send(");
            if (parentExpression.isReturnStatement())
                sb.append("src");
            else  
                sb.append("self");
            sb.append("/*replyTo*/,");
            sb.append(varName).append("/*dest*/,");
            sb.append(messageId).append("/*msgId*/,");
            sb.append("\"").append(messageName).append(actualArguments.size() + "\" /*msgName*/,");
            if (parentExpression.isReturnStatement())
                sb.append("assignTo,Message.DELEGATE_TYPE");
            else
                sb.append("\"" + /*parentExpression.getAssignTo() + */"\",Message.NORMAL_TYPE");
            sb.append(",new Object[]{");
            int i = 0;
            for (Iterator<Expression> it = actualArguments.iterator(); it
                    .hasNext();) {
                Expression arg = (Expression)it.next();
                String argType = arg.getType(); 
                if (argType.startsWith("future") || argType.equals("Token")) {
                    tokenPos.append(i + ",");
                }
                SymbolType symbolType = SalsaParser.getKnownType(argType);
                if (symbolType != null && symbolType.isImmutable() || varName.equals("self")) {
                    sb.append(arg.toJavaCode(identation));
                } else {
                    sb.append("DeepCopy.copy(" + arg.toJavaCode(identation) + ")");
                }
                if (it.hasNext())
                    sb.append(",");
                i++;
            }
            sb.append("}");
            tokenPos.deleteCharAt(tokenPos.length() - 1).append("}");
            sb.append(",").append(tokenPos);
            if (parentExpression.isAfterContinuation())
                sb.append(",token");
            else
                sb.append(",null");
            sb.append(")");
            break;
        }
        
        return sb.toString();
    }

    @Override
    public boolean analyze(SalsaNode parent) {
        if (actualArguments != null)
            for (Expression e : actualArguments)
                e.analyze(this);
        if (arrayIndexes != null)
            for (Expression e: arrayIndexes)
                e.analyze(this);

        switch (termType) {
        case Term.LITERAL:
            literal.analyze(this);
            type = literal.type;
            break;
        case Term.EXPRESSION:
            expression.analyze(this);
            type = expression.getType();
            break;
        case Term.VARIABLE:
            SymbolType st = SalsaParser.getKnownType(varType);
            if (st == null) {
                this.log("Unknown type " + varType);
            } else {
                varType = type = st.getCanonicalName();
            }
            break;
        case Term.ALLOCATION:
            allocation.analyze(this);
            type = allocation.getType();
            break;
        }
        
        // If it is type cast
        if (castType != null) {
            SymbolType st = SalsaParser.getKnownType(castType);
            if (st == null) {
                this.log("Unknown type " + castType);
            } else {
                type = castType = st.getCanonicalName();
            }
        }
        
        // If it is an array access, determine the variable name and type
        for (Iterator<Expression> it = arrayIndexes.iterator(); it.hasNext();) {
            varName += "[" + it.next().toJavaCode("") + "]";
            type  = varType.substring(0, varType.length() - 2);
        }
        
        // If it is a field selection, method invocation, or message passing
        SymbolType varSt;
        switch (operatorType) {
        case Term.SELECT_FIELD:
        case Term.INVOKE_METHOD:
            varSt = SalsaParser.getKnownType(varType);
            SymbolType tempSt =  varSt;
            if (varSt != null) {
                String[] selectors = selector.split("\\.");  
                int len = selectors.length, i = 0;
                while (len > 0) {
                    if (len == 1) {
                        tempSt = getSelectType(tempSt, selectors[i], actualArguments);
                    } else {
                        tempSt = getSelectType(tempSt, selectors[i], null);
                    }
                    if (tempSt == null)
                        break;
                    len--;
                    i++;
                }
            }
            if (tempSt != null) {
                if (!varSt.isActorType())
                    type = tempSt.getCanonicalName();
                else if (varName.equals("this") || varName.equals("self")) {
                    type = tempSt.getCanonicalName();
                    varName = "this";
                } else
                    this.log("Cannot select filed or invoke method on an actor");
            } else {
//                this.log("Cannot resovle the type");
            }
            break;
        case Term.SEND_MESSAGE:
            varSt = SalsaParser.getKnownType(varType);
            if (varSt != null) {
                if (varSt.isActorType()) {
                    varSt = getSelectType(varSt, messageName, actualArguments);
                    if (varSt == null) {
//                        this.log("Cannot resovle the type");
                    } else {
                        this.type = "future " + varSt.getCanonicalName();
                    }
                } else
                    this.log("Can only send message to an actor");
            }
            break;
        }
        return true;
    }
    
    private SymbolType getSelectType(SymbolType parentType, String selector,
            List<Expression> paras) {
        String returnStr = "";
        if (paras != null) {
            // Method invocation
            StringBuilder sb = new StringBuilder();
            StringBuilder sbShow = new StringBuilder();
            sb.append(selector).append("\\(");
            sbShow.append(selector).append("(");
            for (Expression e : paras) {
                String eStr = e.toJavaCode(""); 
                if (eStr.equals("token") || eStr.equals("null")) {
                    sb.append("[a-zA-Z_0-9\\.\\[\\]]+").append(",");
                    sbShow.append(eStr).append(",");
                } else {
                    String eType = e.getType(); 
                    if (eType.startsWith("future"))
                        eType = eType.substring("future".length() + 1).trim();
                    sb.append(eType).append(",");
                    sbShow.append(eType).append(",");
                }
            }
            if (paras.size() > 0) {
                sb.deleteCharAt(sb.length() - 1);
                sbShow.deleteCharAt(sbShow.length() - 1);
            }
            sb.append("\\)");
            sbShow.append(")");
            SymbolMethod sm = parentType.getMethodBySignatrue(sb.toString());
            if (sm != null) {
                messageId = sm.getId();
                returnStr = sm.getReturnType();
            }
            else {
                this.log("Cannot find method " + sbShow.toString()
                        + " in " + parentType.getCanonicalName());
                return null;
            }
        } else {
            // Select field
            SymbolField sf = parentType.getField(selector);
            returnStr = sf.getType();
        }
        SymbolType returnType = SalsaParser.getKnownType(returnStr);
        if (returnType == null) {
            SalsaParser.addImportType(returnStr);
            returnType = SalsaParser.getKnownType(returnStr);
        }
        return returnType;
    }

    public String getType() {
        return type;
    }

    public void setParentExpression(Expression e) {
        this.parentExpression  = e;
    }

    public void addIndexExpression(Expression e) {
        arrayIndexes.add(e);
    }
    
//    private int line = -1;
//    @Override
//    public void setLine(int line) {
//        this.line = line;
//    }
//    @Override
//    public int getLine() {
//        return line;
//    }
//    
//    private String getOutputPrefix() {
//        return ("line " + line + ": ");
//    }
//    
//    private String salsaSource = "";
//    
//    @Override
//    public void setSalsaSource(String src) {
//        salsaSource = src;
//    }
//
//    @Override
//    public String getSalsaSource() {
//        return salsaSource;
//    }
    
}
