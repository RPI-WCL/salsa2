package salsa.compiler;



public class SymbolMethod {
    private String name;
    private String returnType;
    private String[] parameterTypes;
    private String signature;
    private int id = -1;
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
//    @Override
//    public String toJavaCode(String identation) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//    @Override
//    public void analyze(SalsaNode parent) {
//        SymbolType st = SalsaParser.getKnownType(returnType);
//        if (st == null) {
//            System.err.println("Unknown type " + returnType);
//        } else {
//            this.returnType = st.getCanonicalName();
//        }
//        for (int i = 0; i < parameterTypes.length; i++) {
//            String paraType = parameterTypes[i];
//            st = SalsaParser.getKnownType(paraType);
//            if (st == null) {
//                System.err.println("Unknown type " + paraType);
//            } else {
//                parameterTypes[i]= st.getCanonicalName();
//            }
//        }
//    }
    
}
