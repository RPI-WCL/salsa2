package salsa.compiler2;

import java.util.ArrayList;
import java.util.List;



public class SymbolMethod {
    private String name;
    private String returnType;
    private String[] parameterTypes;
    private SymbolType returnSymbolType;
    private List<SymbolType> parameterSymbolTypes;
    private String signature;
    private int id = -1;
    private boolean isMessage = false;
    public SymbolMethod(String name, String returnType,
            String[] parameterTypes) {
        super();
        this.name = name;
        this.returnType = returnType;
        this.parameterTypes = parameterTypes;
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("(");
        for (String type : parameterTypes) {
            sb.append(type).append(",");
        }
        if (parameterTypes.length > 0)
            sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        signature = sb.toString();
    }
    @Override
    public String toString() {
        return signature + returnType;
    }
    public String getName() {
        return name;
    }
    public String getReturnType() {
        return returnType;
    }
    public String[] getParameterTypes() {
        return parameterTypes;
    }
    public String getSignature() {
        return signature;
    }
    public int getId() {
        return signature.hashCode();
    }
    public void setId(int id) {
        this.id = id;
    }
  
    
    public boolean isMessage() {
        return isMessage;
    }
    public void setMessage(boolean isMessage) {
        this.isMessage = isMessage;
    }
    public SymbolType getReturnSymbolType() {
        if (returnSymbolType == null)
            this.formalizeTypes();
        return returnSymbolType;
    }
    public List<SymbolType> getParameterSymbolTypes() {
        if (parameterSymbolTypes == null)
            this.formalizeTypes();
        return parameterSymbolTypes;
    }
    public void formalizeTypes() {
        if (parameterSymbolTypes == null) {
            parameterSymbolTypes = new ArrayList<SymbolType>(
                    parameterTypes.length);
            for (String paraType : parameterTypes) {
                SymbolType st = CompilerHelper.getSymbolTypeByName(paraType);
                if (st == null) {
                    System.out.println("Unknown type " + paraType);
                } else {
                    parameterSymbolTypes.add(st);
                }
            }
            SymbolType st = CompilerHelper.getSymbolTypeByName(returnType);
            returnSymbolType = st;
        }
    }
    
//    @Override
//    public String toJavaCode(String identation) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//    @Override
//    public void analyze(SalsaNode parent) {
//        SymbolType st = CompilerHelper.getKnownType(returnType);
//        if (st == null) {
//            System.err.println("Unknown type " + returnType);
//        } else {
//            this.returnType = st.getCanonicalName();
//        }
//        for (int i = 0; i < parameterTypes.length; i++) {
//            String paraType = parameterTypes[i];
//            st = CompilerHelper.getKnownType(paraType);
//            if (st == null) {
//                System.err.println("Unknown type " + paraType);
//            } else {
//                parameterTypes[i]= st.getCanonicalName();
//            }
//        }
//    }
    
}
