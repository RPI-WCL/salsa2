package salsa.compiler2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import salsa.wwc.lang.SalsaMsg;

public class SymbolType {

    private List<SymbolField> fields;

    private List<SymbolMethod> methods;

    private boolean isActor = false;

    private boolean isPrimitive = true;

    private boolean isImmutable = false;
    
    private String canonicalName;

    private String simpleName;
    
    private SymbolType superType;
    
    private List<SymbolType> interfaces = new LinkedList<SymbolType>();
    
    public static int ACTOR_TYPE = 1;
    
    public static int OBJECT_TYPE = 2;
    
    public static int LIBRARY_TYPE = 3;
    
    private int type;
    
    private SymbolType rawType; // The raw type of an array
    
    private static Map<String, String> primitiveTypes = new HashMap<String, String>();

    static {
        primitiveTypes.put("boolean", "");
        primitiveTypes.put("char", "");
        primitiveTypes.put("byte", "");
        primitiveTypes.put("short", "");
        primitiveTypes.put("int", "");
        primitiveTypes.put("long", "");
        primitiveTypes.put("float", "");
        primitiveTypes.put("double", "");
        primitiveTypes.put("void", "");
        primitiveTypes.put("Token", "");
//        primitiveTypes.put("java.lang.String", "");
    }
    
        
    public SymbolType(String canonicalName, int type) {
        this.type = type;
        this.canonicalName = canonicalName;
        fields = new ArrayList<SymbolField>();
        methods = new ArrayList<SymbolMethod>();
        int i = canonicalName.lastIndexOf('.');
        if (i > 0)
            simpleName = canonicalName.substring(i + 1);
        else
            simpleName = canonicalName;
        
        if (type == ACTOR_TYPE) {
            this.isActor = true;
        } else
            this.isActor = false;
        
        if (primitiveTypes.get(canonicalName) != null) {
            isPrimitive = true;
        } else {
            isPrimitive = false;
        }
        if (!isPrimitive && type == LIBRARY_TYPE) {
            try {
                if (canonicalName.equals("salsa.wwc.lang.ActorRef")) {
                    isActor = true;
                    canonicalName = "salsa.wwc.lang.ActorState";
                }
                Class c = Class.forName(canonicalName);
                /**
                 * Check if it is of actor type.
                 */
                Class superClass = c.getSuperclass();
                if (superClass != null) {
                    String superTypeName = superClass.getCanonicalName();
                    superType = CompilerHelper.getSymbolTypeByName(superTypeName);
                }
                while (superClass != null) {
                    if (superClass.getCanonicalName().contains("ActorRef")) {
                        isActor = true;
                        // If it is an actor from library, need to have NameState file
                        c = Class.forName(canonicalName+"State");
                        break;
                    }
                    superClass = superClass.getSuperclass();
                }
                
                Class[] ins = c.getInterfaces();
                for (Class in : ins) {
                    interfaces.add(CompilerHelper.getSymbolTypeByName(in.getCanonicalName()));
                }
                
                Field[] fields = c.getFields();
                for (Field field : fields) {
                    if (Modifier.isPublic(field.getModifiers())) {
                        String typeName = field.getType().getCanonicalName();
//                        typeName = CompilerHelper.convertoObjectType(typeName);
                        SymbolField sf = new SymbolField(field.getName(),
                                typeName);
                        this.addField(sf);
                    }
                }

                // If it is from actor library, need to remove the first N parameters.
                final int auxiliaryArgNum = 2;
                Method[] methods = c.getMethods();
                for (Method method : methods) {
                    if (Modifier.isPublic(method.getModifiers())) {
                        boolean isSalsaMsg = false;
                        if (method.isAnnotationPresent(SalsaMsg.class)) 
                            isSalsaMsg = true;
                        String name = method.getName();
                        String returnTypeName = method.getReturnType()
                                .getCanonicalName();
                        List<String> parameters = new ArrayList<String>();
                        int j = 0;
                        for (Class pt : method.getParameterTypes()) {
                            String paraTypeName = pt.getCanonicalName();
//                            if (isSalsaMsg && paraTypeName.contains("[")) {
//                                paraTypeName = CompilerHelper.convertoObjectType(paraTypeName);
//                            }
                            // CompilerHelper.convertoObjectType(pt.getCanonicalName())
                            if (!isSalsaMsg || j >= auxiliaryArgNum)
                                parameters.add(paraTypeName);
                            j++;
                        }
                        SymbolMethod sm = new SymbolMethod(name, returnTypeName,
                                parameters.toArray(new String[0]));
                        sm.setMessage(isSalsaMsg);
                        this.addMethod(sm);
                    }
                }
            } catch (ClassNotFoundException e) {
                System.err.println("Cannot find " + canonicalName + ": "
                        + e.getMessage());
            }
        }
        this.isImmutable = isActor || isPrimitive ? true : false;
    }
    
    public SymbolType(SymbolType st) {
        this.isActor = st.isActorType();
        this.isPrimitive = st.isPrimitive();
        this.canonicalName = st.getCanonicalName();
        this.simpleName = st.getSimpleName();
        fields = new ArrayList<SymbolField>();
        methods = new ArrayList<SymbolMethod>();
        fields.addAll(st.getFields());
        methods.addAll(st.getMethods());
        this.isImmutable = isActor || isPrimitive ? true : false;
    }    

    public void setCanonicalName(String canonicalName) {
        this.canonicalName = canonicalName;
        int i = canonicalName.lastIndexOf('.');
        if (i > 0) {
            simpleName = canonicalName.substring(i + 1);
            if (canonicalName.startsWith(CompilerHelper.TOKEN))
                simpleName = CompilerHelper.TOKEN + " " + simpleName;
        }
        else
            simpleName = canonicalName;
    }
    
    public String getSimpleName() {
        return simpleName;
    }

    public String getCanonicalName() {
        return canonicalName;
    }
    
    

//    public SymbolMethod getMethodBySignatrue(String signature) {
//        Pattern p = Pattern.compile("^" + signature + "$");
//        for (SymbolMethod sm : methods) {
////            if (sm.getSignature().equals(signature))
//            if (p.matcher(sm.getSignature()).matches())
//                return sm;
//        }
//        return null;
//    }

    public SymbolField getField(String fieldName) {
        for (SymbolField sf : fields) {
            if (sf.getName().equals(fieldName))
                return sf;
        }
        return null;
    }

    public List<SymbolField> getFields() {
        return fields;
    }
    
    public List<SymbolMethod> getMethods() {
        return methods;
    }

    public void addField(SymbolField sf) {
        this.fields.add(sf);
    }

    public void addMethod(SymbolMethod sm) {
        this.methods.add(sm);
    }


    public void addMethod(List<SymbolMethod> methods2) {
        this.methods.addAll(methods2);
    }
    
  
    public boolean isActorType() {
        // TODO Auto-generated method stub
        return isActor;
    }

    public boolean isPrimitive() {
        return isPrimitive;
    }

    public boolean isImmutable() {
        return isImmutable;
    }

    public void setImmutable(boolean isImmutable) {
        this.isImmutable = isImmutable;
    }

    public boolean isSuperType(SymbolType st) {
        try {
            List<SymbolType> interfaceQueue = new LinkedList<SymbolType>(); // a list of interfaces
            interfaceQueue.addAll(st.getInterfaces());
            
            // Check super class first
            SymbolType superSt = st.getSuperType();
            while (superSt != null) {
                if (superSt.getCanonicalName().equals(this.canonicalName)) {
                    return true;
                }
                // add st's interfaces
                interfaceQueue.addAll(superSt.getInterfaces());
                superSt = superSt.getSuperType();
            }
            
            // Check interfaces
            while(interfaceQueue.size() > 0) {
                SymbolType superInterface = interfaceQueue.remove(0);
                if (superInterface.getCanonicalName().equals(this.canonicalName))
                    return true;
                else {
                    superInterface = superInterface.getSuperType(); 
                    if (superInterface != null)
                        interfaceQueue.add(superInterface);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * Check if it can be assinged to type st
     * @param st
     * @return
     */
    public boolean isAssignable(SymbolType st) {
        if (st != null) {
            if (st.getSimpleName().equals("null") && !st.isPrimitive())
                return true;
            else if (this.equals(st))
                return true;
            else if (st.getCanonicalName().startsWith(CompilerHelper.TOKEN)) {
                SymbolType stNormal = CompilerHelper.getSymbolTypeByName(st
                        .getCanonicalName()
                        .substring(CompilerHelper.TOKEN.length()).trim());
                return this.isAssignable(stNormal);
            } else if (st.getCanonicalName().contains("[")
                    && this.canonicalName.contains("[")) {
                return this.getRawType().isAssignable(st.getRawType());
            } else if (this.isPrimitive
                    && st.isPrimitive()
                    && this.equals(CompilerHelper
                            .getSumDominatingType(this, st))) {
                return true;
            } else if (this.canonicalName.equals(CompilerHelper
                    .convertoObjectType(st.getCanonicalName()))) {
                return true;
            } else if (this.isSuperType(st)) {
                return true;
            } else
                return false;
        } else
            return false;
    }

    @Override
    public String toString() {
        return canonicalName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SymbolType) {
            SymbolType st = (SymbolType) obj;
            if (this.canonicalName.equals(st.getCanonicalName()))
                return true;
        }
        return false;
    }

    public void setSuperType(SymbolType superType) {
        this.superType = superType;
    }
    
    public SymbolType getSuperType() {
        return superType;
    }
    
    public void addInterfaceType(SymbolType interfaceType) {
        this.interfaces.add(interfaceType);
    }
    
    public List<SymbolType> getInterfaces() {
        return this.interfaces;
    }

    public void addField(List<SymbolField> fields2) {
        this.fields.addAll(fields2);
    }

    public void setRawType(SymbolType rawType) {
        this.rawType = rawType;
    }
    
    public SymbolType getRawType() {
        return this.rawType;
    }
}
