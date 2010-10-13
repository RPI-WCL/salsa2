package salsa.compiler;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static Map<String, String> dominatingTypes;
    
    static {
        dominatingTypes = new HashMap<String, String>();
        dominatingTypes.put("String,String", "String");
        dominatingTypes.put("double,double", "double");
        dominatingTypes.put("float,float", "float");
        dominatingTypes.put("long,long", "long");
        dominatingTypes.put("long,long", "long");
    }
}
