package salsa.compiler;

import java.util.HashMap;
import java.util.Map;

import org.antlr.codegen.ObjCTarget;

import salsa.compiler.definitions.BehaviorDeclaration;
import salsa.compiler.definitions.MessageHandlerDeclaration;

public class SymbolTable {

    static BehaviorDeclaration currentBehavior = null;

    static Map<String, BehaviorDeclaration> behaviorMap = new HashMap<String, BehaviorDeclaration>();
    
    static Map<String, String> objectTypes = new HashMap<String, String>();
    
    static {
        objectTypes.put("boolean", "Boolean");
        objectTypes.put("char", "Character");
        objectTypes.put("byte", "Byte");
        objectTypes.put("short", "Short");
        objectTypes.put("int", "Integer");
        objectTypes.put("long", "Long");
        objectTypes.put("float", "Float");
        objectTypes.put("double", "Double");
    }

    public static MessageHandlerDeclaration getMessageHandler(String behaviorType,
            String msgSignature) {
        BehaviorDeclaration behavior = behaviorMap.get(behaviorType);
        if (behavior != null) {
            return behavior.getMessageHandler(msgSignature);
        }
        return null;
    }

    public static BehaviorDeclaration getCurrentBehavior() {
        return currentBehavior;
    }

    public static void setCurrentBehavior(BehaviorDeclaration currentBehavior) {
        SymbolTable.currentBehavior = currentBehavior;
    }
    
    public static void addBehavior(BehaviorDeclaration behavior) {
        behaviorMap.put(behavior.getAbsoluteName(), behavior);
    }
    
    public static String convertoObjectType(String type) {
        String s = objectTypes.get(type);
        if (s == null)
            return type;
        else 
            return s;
    }
}
