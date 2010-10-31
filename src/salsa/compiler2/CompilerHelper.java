package salsa.compiler2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarFile;

public class CompilerHelper {

    
    public static Map<String, SymbolType> initKnownTypes = new HashMap<String, SymbolType>();
    
    public final static String TOKEN = "Token";
    
    public static List<String> classPrefixes = new ArrayList<String>();
    
    private static SymbolType objectSymbolType, arraySymbolType;
    
    static Map<String, String> objectTypes = new HashMap<String, String>();
    
    static {
        objectTypes.put("boolean", "java.lang.Boolean");
        objectTypes.put("char", "java.lang.Character");
        objectTypes.put("byte", "java.lang.Byte");
        objectTypes.put("short", "java.lang.Short");
        objectTypes.put("int", "java.lang.Integer");
        objectTypes.put("long", "java.lang.Long");
        objectTypes.put("float", "java.lang.Float");
        objectTypes.put("double", "java.lang.Double");
    }
    static {

        classPrefixes.add("java.lang");
        classPrefixes.add("salsa.lib");
        
       
        objectSymbolType = new SymbolType("java.lang.Object",
                SymbolType.LIBRARY_TYPE);
        arraySymbolType = new SymbolType(objectSymbolType);
        arraySymbolType.addField(new SymbolField("length", "int"));
        
        addKnownType(initKnownTypes, new SymbolType("char", SymbolType.OBJECT_TYPE));
        addKnownType(initKnownTypes, new SymbolType("boolean", SymbolType.OBJECT_TYPE));
        addKnownType(initKnownTypes, new SymbolType("byte", SymbolType.OBJECT_TYPE));
        addKnownType(initKnownTypes, new SymbolType("short", SymbolType.OBJECT_TYPE));
        addKnownType(initKnownTypes, new SymbolType("int", SymbolType.OBJECT_TYPE));
        addKnownType(initKnownTypes, new SymbolType("long", SymbolType.OBJECT_TYPE));
        addKnownType(initKnownTypes, new SymbolType("float", SymbolType.OBJECT_TYPE));
        addKnownType(initKnownTypes, new SymbolType("double", SymbolType.OBJECT_TYPE));
        addKnownType(initKnownTypes, new SymbolType("void", SymbolType.OBJECT_TYPE));
        addKnownType(initKnownTypes, new SymbolType("null", SymbolType.OBJECT_TYPE));
        addKnownType(initKnownTypes, new SymbolType("java.lang.String", SymbolType.LIBRARY_TYPE));
    }
    
    public static boolean isPrimitiveType(String type) {
        String s = convertoObjectType(type);
        return s.equals(type)? false : true;
    }

    public static String convertoObjectType(String type) {
        String s = objectTypes.get(type);
        if (s != null)
            return s;        
        else if (type.contains("[")) {
            int first = type.indexOf('[');
            int last = type.lastIndexOf(']');
            if (first > 0 && last > 0) {
                // extract the dim string like [][][]
                String dimStr = type.substring(first, last + 1);
                String rawTypeStr = type.substring(0, first);            
                s = objectTypes.get(rawTypeStr);
                if (s != null)
                    return s + dimStr;
            }
        }
        return type;
    }

    private static List<String> getPossibleClasspaths(String[] properties) {
        List<String> l = new ArrayList<String>();
        for (String property : properties) {
            String s = System.getProperty(property);
            if (s != null) {
                String[] paths = s.split(File.pathSeparator);
                for (String path : paths)
                    l.add(path);
            }
        }
        return l;
    }
    
    public static SymbolType getSymbolTypeByName(String className) {
        return getSymbolTypeByName(initKnownTypes, className);
    }
    
    public static SymbolType getSymbolTypeByName(Map<String, SymbolType> knownTypes, String className) {
        if (className == null) {
            return null;
        }
        SymbolType symbolType = null;
        symbolType = knownTypes.get(className);
        if (symbolType != null)
            return symbolType;
        
        /** 
         * First try if it is of array type
         */
        int first = className.indexOf('[');
        int last = className.lastIndexOf(']');
        if (first > 0 && last > 0) {
            // extract the dim string like [][][]
            String dimStr = className.substring(first, last + 1);
            String rawTypeStr = className.substring(0, first);
            SymbolType rawType = getSymbolTypeByName(knownTypes, rawTypeStr);
            if (rawType != null) {
                SymbolType arrayType = new SymbolType(arraySymbolType);
                arrayType.setCanonicalName(rawType.getCanonicalName() + dimStr);
                arrayType.setRawType(rawType);
                addKnownType(knownTypes, arrayType);
                return arrayType;
            }
        }
        
        /**
         *  Try to load from library
         */
        // Get possible classpaths
        List<String> classpaths = getPossibleClasspaths(new String[] {
                "java.class.path", "sun.boot.class.path" });
        // Get possible classNames
        List<String> classNames = new ArrayList<String>();
        classNames.add(className);
        // If it is a simple name, also try to load from the import declarations
        if (!className.contains("."))
            for (String prefix : classPrefixes)
                classNames.add(prefix + "." + className);
        
        for (String name : classNames) {
            for (String path : classpaths) {
                if (path.endsWith("jar")) {
                    String filePath = name.replaceAll("\\.", "/")
                            + ".class";
                    try {
                        JarFile jarFile = new JarFile(path);
                        if (jarFile.getJarEntry(filePath) != null) {
                            symbolType = new SymbolType(name,
                                    SymbolType.LIBRARY_TYPE);
                            addKnownType(knownTypes, symbolType);
                            break;
                        }
                    } catch (IOException e) {
//                        System.err.println("WARNNING: " + e.getMessage() + " " + path);
                    }
                } else {
                    String filePath = path + File.separator
                            + name.replaceAll("\\.", File.separator)
                            + ".class";
                    if (new File(filePath).exists()) {
                        symbolType = new SymbolType(name,
                                SymbolType.LIBRARY_TYPE);
                        addKnownType(knownTypes, symbolType);
                        break;
                    }
                }
            }
            if (symbolType != null)
                break;
        }
        if (symbolType == null) {
            System.err.print("");
        }
        return symbolType;
    }
    
    public static SymbolType getKnownType(Map<String, SymbolType> knownTypes, String className) {
        return getSymbolTypeByName(knownTypes, className);
//    
//        SymbolType st = initKnownTypes.get(className);
//        
//        if (st != null)
//            return st;  
//    
//        if (className == null)
//            System.out.println();
//        
//        boolean isFuture = false;
//        if (className.startsWith("Token")) {
//            isFuture = true;
//            className = className.substring("Token".length() + 1).trim();
//        }
//        SymbolType returnType = null;
//        int i;
//        if ((i = className.indexOf("[")) > 0) {
//            String rawStr = className.substring(0, i);
//            String dimStr = className.substring(i);
//            SymbolType rawType = initKnownTypes.get(rawStr); 
//            if (rawType == null)
//                return null;
//            // array type
//            SymbolType objectType = getKnownType(knownTypes, "Object");
////            SymbolType newType = new SymbolType(objectType);
////            newType.addField(new SymbolField("length", "int"));
////            newType.setCanonicalName(rawType.getCanonicalName() + dimStr);
////            returnType = newType;
//        } else 
//            returnType = initKnownTypes.get(className);
//        if (isFuture && returnType != null) {
////            SymbolType objectType = getKnownType("Object");
////            SymbolType newType = new SymbolType(objectType);
////            newType.setCanonicalName("Token " + returnType.getCanonicalName());
////            knownTypes.put("Token " + returnType.getSimpleName(), newType);
////            knownTypes.put("Token " + returnType.getCanonicalName(), newType);
////            return newType;
//        }
//        return returnType;                          
    }
    
    public static void addInitKnownType(SymbolType st) {
        addKnownType(initKnownTypes, st);
    }
    
    public static void addKnownType(Map<String, SymbolType> knownTypes,
            SymbolType st) {
        knownTypes.put(st.getSimpleName(), st);
        knownTypes.put(st.getCanonicalName(), st);
        SymbolType tokenType = new SymbolType(objectSymbolType);
        tokenType.setCanonicalName(TOKEN + " " + st.getCanonicalName());
        knownTypes.put(tokenType.getCanonicalName(), tokenType);
        knownTypes.put(tokenType.getSimpleName(), tokenType);
    }
    
    public static void addStaticTypeEnv(Map<String, SymbolType> typeEnv, SymbolType st) {
        typeEnv.put(st.getSimpleName(), st);
        typeEnv.put(st.getCanonicalName(), st);
    }
    
    public static SymbolType removeKnownType(String type) {
        return initKnownTypes.remove(type);
    }
    
    public static SymbolType getSumDominatingType(SymbolType type1, SymbolType type2) {
        String type = "";
        if (type1.getSimpleName().equalsIgnoreCase("String") || type2.getSimpleName().equalsIgnoreCase("String")) {
            type = "String";
        } else if (type1.getSimpleName().equalsIgnoreCase("double") || type2.getSimpleName().equalsIgnoreCase("double")) {
            type = "double";
        }
        else if (type1.getSimpleName().equalsIgnoreCase("float") || type2.getSimpleName().equalsIgnoreCase("float")) {
            type = "float";
        }
        else if (type1.getSimpleName().equalsIgnoreCase("long") || type2.getSimpleName().equalsIgnoreCase("long")) {
            type = "long";
        }
        else if (type1.getSimpleName().equalsIgnoreCase("int") || type2.getSimpleName().equalsIgnoreCase("int")) {
            type = "int";
        }
        else if (type1.getSimpleName().equalsIgnoreCase("short") || type2.getSimpleName().equalsIgnoreCase("short")) {
            type = "short";
        }
        //TODO byte and char?
        if (type.length() > 0)
            return CompilerHelper.getSymbolTypeByName(type);
        else 
            return type1;
    }
    

//    
//    /**
//    *  Add import types
//    */
//    public static boolean addImportType(String importName) {
//        if (getKnownType(knownTypes, importName) != null)
//            return true;
////        System.err.println("adding " + importName);
//        if (importName.endsWith("*")) {
//            return addMultipleImportType(importName.substring(0, importName.length() - 2));
//        } else
//            return addSingleImportType(importName);
//
//    }
//    
//        // TODO Need improvement
//    private static boolean addSingleImportType(String importName) {
//        boolean bFound = false;
//        String s = System.getProperty("java.class.path");
//        if (s == null)
//            s = ".";
//        String[] pathes = s.split(File.pathSeparator);
//        
//        String s2 = System.getProperty("sun.boot.class.path");
//        String[] pathes2 = s2.split(File.pathSeparator);
//        
//        String[] classpathes = new String[pathes.length + pathes2.length];
//        System.arraycopy(pathes, 0, classpathes, 0, pathes.length);
//        System.arraycopy(pathes2, 0, classpathes, pathes.length, pathes2.length);
//        for (String path : classpathes) {
//            if (path.endsWith("jar")) {
//                String filePath = importName.replaceAll("\\.", "/") + ".class";
//                try {
//                    JarFile jarFile = new JarFile(path);
//                    if (jarFile.getJarEntry(filePath) != null) {
//                        String simpleName = importName.substring(importName
//                                .lastIndexOf('.') + 1);
//                        SymbolType symbolType = new SymbolType(importName, SymbolType.LIBRARY_TYPE);
//                        addKnownType(symbolType);
////                        knownTypes.put(importName, symbolType);
////                        knownTypes.put(simpleName, symbolType);
//                        bFound = true;
//                        break;
//                    }
//                } catch (IOException e) {
//                   System.err.println(e.getMessage());
////                  e.printStackTrace();
//                    break;
//                }
//            } else {
//                String filePath = path + File.separator
//                        + importName.replaceAll("\\.", File.separator)
//                        + ".class";
//                if (new File(filePath).exists()) {
//                    String simpleName = importName.substring(importName
//                            .lastIndexOf('.') + 1);
//                    SymbolType symbolType = new SymbolType(importName, SymbolType.LIBRARY_TYPE);
//                    addKnownType(symbolType);
////                    knownTypes.put(importName, symbolType);
////                    knownTypes.put(simpleName, symbolType);
//                    bFound = true;
//                    break;
//                }
//            }
//        }
//        return bFound;
//    }
//
//    private static  boolean addMultipleImportType(String importDir) {
//        boolean bFound = false;
//        String s = System.getProperty("java.class.path");
//        if (s == null)
//            s = ".";
//        String[] pathes = s.split(File.pathSeparator);
//        
//        String s2 = System.getProperty("sun.boot.class.path");
//        String[] pathes2 = s2.split(File.pathSeparator);
//        
//        String[] classpathes = new String[pathes.length + pathes2.length];
//        System.arraycopy(pathes, 0, classpathes, 0, pathes.length);
//        System.arraycopy(pathes2, 0, classpathes, pathes.length, pathes2.length);
//        int subLen = ".class".length();
//        Pattern p = Pattern.compile("^" + importDir + "\\.[a-zA-Z_0-9]+\\.class$");
//        for (String path : classpathes) {
//            if (path.endsWith("jar")) {
//                try {
//                    JarInputStream jarFile = new JarInputStream(
//                            new FileInputStream(path));
//                    JarEntry jarEntry;
//                    while (true) {
//                        jarEntry = jarFile.getNextJarEntry();
//                        if (jarEntry == null) {
//                            break;
//                        }
//                        String className = jarEntry.getName().replaceAll("/", "\\.");
//                        if (p.matcher(className).matches()) {
//                            className = className.substring(0,
//                                    className.length() - subLen);
//                            String simpleName = className.substring(className
//                                    .lastIndexOf('.') + 1);
//                            SymbolType symbolType = new SymbolType(className, SymbolType.LIBRARY_TYPE);
//                            addKnownType(symbolType);
////                            knownTypes.put(className, symbolType);
////                            knownTypes.put(simpleName, symbolType);
//                            bFound = true;
//                        }
//                    }
//                } catch (Exception e) {
//                    System.err.println(e.getMessage());
////                    e.printStackTrace();
//                }
//            } else {
//                File folder = new File(path + File.separator
//                        + importDir.replaceAll("\\.", File.separator));
//                if (folder.exists()) {                        
//                    File[] files = folder.listFiles();
//                    for (File file : files) {
//                        String className = file.getName();
//                        if (className.endsWith(".class")) {
//                            className = importDir
//                                    + "."
//                                    + className.substring(0, className.length()
//                                            - subLen);
//                            String simpleName = className.substring(className
//                                    .lastIndexOf('.') + 1);
//                            SymbolType symbolType = new SymbolType(className, SymbolType.LIBRARY_TYPE);
//                            addKnownType(symbolType);
////                            knownTypes.put(className, symbolType);
////                            knownTypes.put(simpleName, symbolType);
//                            bFound = true;
//                        }
//                }
//                }
//            }
//        }
//        return bFound;
//    }
//    
//    /**
//     * Check if t1 can be assigned by t2
//     */
//     public static boolean typeAssignable(String t1, String t2) {
//         if (t1.equals(t2))
//             return true;
//         else {
//             if (t1.equals("unknown") || t2.equals("unknown")) {
//                 return true;
//             }
//             SymbolType st1 = getKnownType(knownTypes, t1); 
//             SymbolType st2 = getKnownType(knownTypes, t2);
//             if (st1.isPrimitive() || st2.isPrimitive())
//                 return false;
//             else if (st1.getCanonicalName().equals(st2.getCanonicalName()))
//                 return true;
//             else
//                 return st1.isSuperType(st2);
//         }
//     }




}
