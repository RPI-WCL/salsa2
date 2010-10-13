package salsa.compiler;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class SymbolType {

    private List<SymbolField> fields;

    private List<SymbolMethod> methods;

    private boolean isActor = false;

    private boolean isPrimitive = true;

    private String canonicalName;

    private String simpleName;
    
    private String modifier = "";
    
    private boolean isImmutable = false;

    public static Map<String, String> primitiveTypes = new HashMap<String, String>();

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
        primitiveTypes.put("java.lang.String", "");
    }

    public SymbolType(String className, boolean isActor) {
//        this(className);
        this.canonicalName = className;
        fields = new ArrayList<SymbolField>();
        methods = new ArrayList<SymbolMethod>();
        int i = className.lastIndexOf('.');
        if (i > 0)
            simpleName = className.substring(i + 1);
        else
            simpleName = className;
        this.isActor = isActor;
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

    public SymbolType(String className) {
        this.canonicalName = className;
        fields = new ArrayList<SymbolField>();
        methods = new ArrayList<SymbolMethod>();
        int i = className.lastIndexOf('.');
        if (i > 0)
            simpleName = className.substring(i + 1);
        else
            simpleName = className;
        if (primitiveTypes.get(canonicalName) != null) {
            isPrimitive = true;
        } else {
            isPrimitive = false;
            try {
                Class c = Class.forName(className);
                Field[] fields = c.getFields();
                for (Field field : fields) {
                    if (Modifier.isPublic(field.getModifiers())) {
                        String typeName = field.getType().getCanonicalName();
                        this.addField(new SymbolField(field.getName(),
                                typeName));
                    }
                }

                Method[] methods = c.getMethods();
                for (Method method : methods) {
                    if (Modifier.isPublic(method.getModifiers())) {
                        String name = method.getName();
                        String returnType = method.getReturnType()
                                .getCanonicalName();
                        List<String> parameters = new ArrayList<String>();
                        for (Class pt : method.getParameterTypes()) {
                            parameters.add(pt.getCanonicalName());
                        }
                        this.addMethod((new SymbolMethod(name, returnType,
                                parameters.toArray((new String[0])))));
                    }
                }

                /**
                 * Check if it is of actor type.
                 */
                c = c.getSuperclass();
                while (c != null) {
                    if (c.getCanonicalName().contains("Actor")) {
                        isActor = true;
                        break;
                    }
                    c = c.getSuperclass();
                }

            } catch (ClassNotFoundException e) {
                // e.printStackTrace();
                System.err.println("Cannot find " + className + ": "
                        + e.getMessage());
            }
        }
        this.isImmutable = isActor || isPrimitive ? true : false;
    }
    
    
    
    public void setCanonicalName(String canonicalName) {
        this.canonicalName = canonicalName;
        int i = canonicalName.lastIndexOf('.');
        if (i > 0)
            simpleName = canonicalName.substring(i + 1);
        else
            simpleName = canonicalName;
    }
    
    public String getSimpleName() {
        return simpleName;
    }

    public String getCanonicalName() {
        return canonicalName;
    }
    
    

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public SymbolMethod getMethodBySignatrue(String signature) {
        Pattern p = Pattern.compile("^" + signature + "$");
        for (SymbolMethod sm : methods) {
//            if (sm.getSignature().equals(signature))
            if (p.matcher(sm.getSignature()).matches())
                return sm;
        }
        return null;
    }

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
        sm.setId(methods.size());
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
        if (st.isActorType())
            return false;
        String stName = st.getCanonicalName();
        try {
            Class c;
            c = Class.forName(stName);
            c = c.getSuperclass();
            while (c != null) {
                if (c.getCanonicalName().equals(this.canonicalName)) {
                    return true;
                }
                c = c.getSuperclass();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
