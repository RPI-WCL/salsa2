// $ANTLR 3.2 Sep 23, 2009 12:02:23 /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g 2010-10-14 12:28:07

package salsa.compiler;
import salsa.compiler.definitions.*;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
import java.util.regex.Pattern;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SalsaParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "AND_ASSIGN", "ASSIGN", "AT", "BIT_SHIFT_RIGHT", "BIT_SHIFT_RIGHT_ASSIGN", "COLON", "COMMA", "DEC", "DIV", "DIV_ASSIGN", "DOT", "DOTSTAR", "ELLIPSIS", "EQUAL", "GREATER_OR_EQUAL", "GREATER_THAN", "INC", "LBRACK", "LCURLY", "LESS_OR_EQUAL", "LESS_THAN", "LOGICAL_AND", "LOGICAL_NOT", "LOGICAL_OR", "LPAREN", "MINUS", "MINUS_ASSIGN", "MOD", "MOD_ASSIGN", "NOT", "NOT_EQUAL", "OR", "OR_ASSIGN", "PLUS", "PLUS_ASSIGN", "QUESTION", "RBRACK", "RCURLY", "RPAREN", "SEMI", "SHIFT_LEFT", "SHIFT_LEFT_ASSIGN", "SHIFT_RIGHT", "SHIFT_RIGHT_ASSIGN", "STAR", "STAR_ASSIGN", "XOR", "XOR_ASSIGN", "ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE", "CASE", "CATCH", "CHAR", "CLASS", "CONTINUE", "DEFAULT", "DO", "DOUBLE", "ELSE", "ENUM", "EXTENDS", "FALSE", "FINAL", "FINALLY", "FLOAT", "FOR", "IF", "IMPLEMENTS", "INSTANCEOF", "INTERFACE", "IMPORT", "INT", "LONG", "NATIVE", "NEW", "NULL", "PACKAGE", "PRIVATE", "PROTECTED", "PUBLIC", "RETURN", "SHORT", "STATIC", "STRICTFP", "SUPER", "SWITCH", "SYNCHRONIZED", "THIS", "THROW", "THROWS", "TRANSIENT", "TRUE", "TRY", "VOID", "VOLATILE", "WHILE", "ANNOTATION_INIT_ARRAY_ELEMENT", "ANNOTATION_INIT_BLOCK", "ANNOTATION_INIT_DEFAULT_KEY", "ANNOTATION_INIT_KEY_LIST", "ANNOTATION_LIST", "ANNOTATION_METHOD_DECL", "ANNOTATION_SCOPE", "ANNOTATION_TOP_LEVEL_SCOPE", "ARGUMENT_LIST", "ARRAY_DECLARATOR", "ARRAY_DECLARATOR_LIST", "ARRAY_ELEMENT_ACCESS", "ARRAY_INITIALIZER", "BLOCK_SCOPE", "CAST_EXPR", "CATCH_CLAUSE_LIST", "CLASS_CONSTRUCTOR_CALL", "CLASS_INSTANCE_INITIALIZER", "CLASS_STATIC_INITIALIZER", "CLASS_TOP_LEVEL_SCOPE", "CONSTRUCTOR_DECL", "ENUM_TOP_LEVEL_SCOPE", "EXPR", "EXTENDS_BOUND_LIST", "EXTENDS_CLAUSE", "FOR_CONDITION", "FOR_EACH", "FOR_INIT", "FOR_UPDATE", "FORMAL_PARAM_LIST", "FORMAL_PARAM_STD_DECL", "FORMAL_PARAM_VARARG_DECL", "FUNCTION_METHOD_DECL", "GENERIC_TYPE_ARG_LIST", "GENERIC_TYPE_PARAM_LIST", "INTERFACE_TOP_LEVEL_SCOPE", "IMPLEMENTS_CLAUSE", "LABELED_STATEMENT", "LOCAL_MODIFIER_LIST", "JAVA_SOURCE", "METHOD_CALL", "MODIFIER_LIST", "PARENTESIZED_EXPR", "POST_DEC", "POST_INC", "PRE_DEC", "PRE_INC", "QUALIFIED_TYPE_IDENT", "STATIC_ARRAY_CREATOR", "SUPER_CONSTRUCTOR_CALL", "SWITCH_BLOCK_LABEL_LIST", "THIS_CONSTRUCTOR_CALL", "THROWS_CLAUSE", "TYPE", "UNARY_MINUS", "UNARY_PLUS", "VAR_DECLARATION", "VAR_DECLARATOR", "VAR_DECLARATOR_LIST", "VOID_METHOD_DECL", "IDENT", "HEX_LITERAL", "DECIMAL_LITERAL", "OCTAL_LITERAL", "CHARACTER_LITERAL", "STRING_LITERAL", "FLOATING_POINT_LITERAL", "HEX_DIGIT", "INTEGER_TYPE_SUFFIX", "EXPONENT", "FLOAT_TYPE_SUFFIX", "ESCAPE_SEQUENCE", "UNICODE_ESCAPE", "OCTAL_ESCAPE", "Letter", "JavaIDDigit", "WS", "COMMENT", "LINE_COMMENT", "'module'", "'immutable'", "'behavior'", "'join'", "'self'", "'<-'", "'future'"
    };
    public static final int PACKAGE=84;
    public static final int STAR=49;
    public static final int MOD=32;
    public static final int DO=64;
    public static final int GENERIC_TYPE_PARAM_LIST=138;
    public static final int NOT=34;
    public static final int EOF=-1;
    public static final int ANNOTATION_METHOD_DECL=109;
    public static final int BIT_SHIFT_RIGHT_ASSIGN=9;
    public static final int UNARY_PLUS=159;
    public static final int TYPE=157;
    public static final int FINAL=70;
    public static final int RPAREN=43;
    public static final int INC=21;
    public static final int IMPORT=78;
    public static final int STRING_LITERAL=169;
    public static final int CAST_EXPR=118;
    public static final int NOT_EQUAL=35;
    public static final int RETURN=88;
    public static final int THIS=95;
    public static final int ENUM_TOP_LEVEL_SCOPE=125;
    public static final int ANNOTATION_INIT_KEY_LIST=107;
    public static final int RBRACK=41;
    public static final int PRE_DEC=149;
    public static final int SWITCH_BLOCK_LABEL_LIST=154;
    public static final int STATIC=90;
    public static final int ELSE=66;
    public static final int MINUS_ASSIGN=31;
    public static final int STRICTFP=91;
    public static final int NATIVE=81;
    public static final int ELLIPSIS=17;
    public static final int PRE_INC=150;
    public static final int CHARACTER_LITERAL=168;
    public static final int LCURLY=23;
    public static final int UNARY_MINUS=158;
    public static final int OCTAL_ESCAPE=177;
    public static final int INT=79;
    public static final int FORMAL_PARAM_VARARG_DECL=135;
    public static final int INTERFACE_TOP_LEVEL_SCOPE=139;
    public static final int WS=180;
    public static final int LOCAL_MODIFIER_LIST=142;
    public static final int LESS_THAN=25;
    public static final int EXTENDS_BOUND_LIST=127;
    public static final int JavaIDDigit=179;
    public static final int DECIMAL_LITERAL=166;
    public static final int FOR_INIT=131;
    public static final int PROTECTED=86;
    public static final int LBRACK=22;
    public static final int THIS_CONSTRUCTOR_CALL=155;
    public static final int FLOAT=72;
    public static final int POST_DEC=147;
    public static final int ANNOTATION_SCOPE=110;
    public static final int STATIC_ARRAY_CREATOR=152;
    public static final int LPAREN=29;
    public static final int AT=7;
    public static final int IMPLEMENTS=75;
    public static final int XOR_ASSIGN=52;
    public static final int LOGICAL_OR=28;
    public static final int IDENT=164;
    public static final int PLUS=38;
    public static final int ANNOTATION_INIT_BLOCK=105;
    public static final int GENERIC_TYPE_ARG_LIST=137;
    public static final int GREATER_THAN=20;
    public static final int LESS_OR_EQUAL=24;
    public static final int CLASS_STATIC_INITIALIZER=122;
    public static final int HEX_DIGIT=171;
    public static final int SHORT=89;
    public static final int INSTANCEOF=76;
    public static final int MINUS=30;
    public static final int SEMI=44;
    public static final int STAR_ASSIGN=50;
    public static final int VAR_DECLARATOR_LIST=162;
    public static final int COLON=10;
    public static final int OR_ASSIGN=37;
    public static final int ENUM=67;
    public static final int RCURLY=42;
    public static final int PLUS_ASSIGN=39;
    public static final int FUNCTION_METHOD_DECL=136;
    public static final int INTERFACE=77;
    public static final int DIV=13;
    public static final int POST_INC=148;
    public static final int LONG=80;
    public static final int CLASS_CONSTRUCTOR_CALL=120;
    public static final int PUBLIC=87;
    public static final int ARRAY_INITIALIZER=116;
    public static final int CATCH_CLAUSE_LIST=119;
    public static final int SUPER_CONSTRUCTOR_CALL=153;
    public static final int EXPONENT=173;
    public static final int WHILE=103;
    public static final int MOD_ASSIGN=33;
    public static final int CASE=58;
    public static final int NEW=82;
    public static final int CHAR=60;
    public static final int CLASS_INSTANCE_INITIALIZER=121;
    public static final int ARRAY_ELEMENT_ACCESS=115;
    public static final int FOR_CONDITION=129;
    public static final int VAR_DECLARATION=160;
    public static final int DIV_ASSIGN=14;
    public static final int BREAK=56;
    public static final int LOGICAL_AND=26;
    public static final int FOR_UPDATE=132;
    public static final int FLOATING_POINT_LITERAL=170;
    public static final int VOID_METHOD_DECL=163;
    public static final int DOUBLE=65;
    public static final int VOID=101;
    public static final int SUPER=92;
    public static final int COMMENT=181;
    public static final int FLOAT_TYPE_SUFFIX=174;
    public static final int IMPLEMENTS_CLAUSE=140;
    public static final int LINE_COMMENT=182;
    public static final int PRIVATE=85;
    public static final int BLOCK_SCOPE=117;
    public static final int SWITCH=93;
    public static final int ANNOTATION_INIT_DEFAULT_KEY=106;
    public static final int NULL=83;
    public static final int VAR_DECLARATOR=161;
    public static final int ANNOTATION_LIST=108;
    public static final int THROWS=97;
    public static final int ASSERT=54;
    public static final int METHOD_CALL=144;
    public static final int TRY=100;
    public static final int SHIFT_LEFT=45;
    public static final int SHIFT_RIGHT=47;
    public static final int FORMAL_PARAM_STD_DECL=134;
    public static final int OR=36;
    public static final int SHIFT_RIGHT_ASSIGN=48;
    public static final int JAVA_SOURCE=143;
    public static final int CATCH=59;
    public static final int FALSE=69;
    public static final int INTEGER_TYPE_SUFFIX=172;
    public static final int Letter=178;
    public static final int THROW=96;
    public static final int DEC=12;
    public static final int CLASS=61;
    public static final int BIT_SHIFT_RIGHT=8;
    public static final int THROWS_CLAUSE=156;
    public static final int GREATER_OR_EQUAL=19;
    public static final int FOR=73;
    public static final int LOGICAL_NOT=27;
    public static final int ABSTRACT=53;
    public static final int AND=4;
    public static final int AND_ASSIGN=5;
    public static final int MODIFIER_LIST=145;
    public static final int IF=74;
    public static final int CONSTRUCTOR_DECL=124;
    public static final int ESCAPE_SEQUENCE=175;
    public static final int LABELED_STATEMENT=141;
    public static final int UNICODE_ESCAPE=176;
    public static final int BOOLEAN=55;
    public static final int SYNCHRONIZED=94;
    public static final int EXPR=126;
    public static final int CLASS_TOP_LEVEL_SCOPE=123;
    public static final int CONTINUE=62;
    public static final int COMMA=11;
    public static final int TRANSIENT=98;
    public static final int EQUAL=18;
    public static final int ARGUMENT_LIST=112;
    public static final int QUALIFIED_TYPE_IDENT=151;
    public static final int HEX_LITERAL=165;
    public static final int DOT=15;
    public static final int SHIFT_LEFT_ASSIGN=46;
    public static final int FORMAL_PARAM_LIST=133;
    public static final int DOTSTAR=16;
    public static final int ANNOTATION_TOP_LEVEL_SCOPE=111;
    public static final int T__184=184;
    public static final int T__183=183;
    public static final int BYTE=57;
    public static final int T__186=186;
    public static final int T__185=185;
    public static final int XOR=51;
    public static final int T__188=188;
    public static final int T__187=187;
    public static final int T__189=189;
    public static final int VOLATILE=102;
    public static final int PARENTESIZED_EXPR=146;
    public static final int ARRAY_DECLARATOR_LIST=114;
    public static final int DEFAULT=63;
    public static final int OCTAL_LITERAL=167;
    public static final int TRUE=99;
    public static final int EXTENDS_CLAUSE=128;
    public static final int ARRAY_DECLARATOR=113;
    public static final int QUESTION=40;
    public static final int FINALLY=71;
    public static final int ASSIGN=6;
    public static final int ANNOTATION_INIT_ARRAY_ELEMENT=104;
    public static final int EXTENDS=68;
    public static final int FOR_EACH=130;

    // delegates
    // delegators


        public SalsaParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public SalsaParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return SalsaParser.tokenNames; }
    public String getGrammarFileName() { return "/media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g"; }



        /**
        * Auxillary attributes
        */

        String moduleName = "";
            
        boolean isReturnStatement = false;

        private static Map<String, SymbolType> knownTypes = new HashMap<String, SymbolType>();
        
        static {
            knownTypes.put("boolean", new SymbolType("boolean"));
    	    knownTypes.put("char", new SymbolType("char"));
    	    knownTypes.put("byte", new SymbolType("byte"));
    	    knownTypes.put("short", new SymbolType("short"));
    	    knownTypes.put("int", new SymbolType("int"));
    	    knownTypes.put("long", new SymbolType("long"));
    	    knownTypes.put("float", new SymbolType("float"));
    	    knownTypes.put("double", new SymbolType("double"));
    	    knownTypes.put("void", new SymbolType("void"));
    	    knownTypes.put("Token", new SymbolType("Token"));
    	    addImportType("java.lang.String");
    	    addImportType("java.lang.Object");
    //	    addImportType("salsa.lib.*");
        }
        public static SymbolType getKnownType(String type) {
        
            SymbolType st = knownTypes.get(type);
            
            if (st != null)
                return st;  
        
            boolean isFuture = false;
            if (type.startsWith("future")) {
                isFuture = true;
                type = type.substring("future".length() + 1).trim();
            }
            SymbolType returnType = null;
            int i;
            if ((i = type.indexOf("[")) > 0) {
                String rawStr = type.substring(0, i);
                String dimStr = type.substring(i);
                SymbolType rawType = knownTypes.get(rawStr); 
                if (rawType == null)
                    return null;
                // array type
                SymbolType objectType = getKnownType("Object");
                SymbolType newType = new SymbolType(objectType);
                newType.addField(new SymbolField("length", "int"));
                newType.setCanonicalName(rawType.getCanonicalName() + dimStr);
                returnType = newType;
            } else 
                returnType = knownTypes.get(type);
            if (isFuture && returnType != null) {
                SymbolType objectType = getKnownType("Object");
                SymbolType newType = new SymbolType(objectType);
                newType.setCanonicalName("future " + returnType.getCanonicalName());
                knownTypes.put("future " + returnType.getSimpleName(), newType);
                knownTypes.put("future " + returnType.getCanonicalName(), newType);
                return newType;
            }
            return returnType;        	                
        }
        
        public static void addKnownType(SymbolType st) {
            knownTypes.put(st.getSimpleName(), st);
            knownTypes.put(st.getCanonicalName(), st);
        }
        
        public static SymbolType removeKnownType(String type) {
            return knownTypes.remove(type);
        }
        
        
        public static int getLine(IntStream input) {
            Token token;    
            int line = -1;
            if ( input instanceof TokenStream ) {
                token = ((TokenStream)input).LT(1);
                line = token.getLine();
            }
    //        if ( input instanceof TreeNodeStream ) {
    //            // TODO
    //        }
            else if ( input instanceof CharStream ) {
                line = ((CharStream)input).getLine();
            }
            return line;
        }
        
        private String getOutputPrefix(IntStream input) {
            return "line " + getLine(input) + ": ";
        }
        
        
    //    Map<String, String> staticTypes = new HashMap<String, String>();


        /**
        * Check if t1 can be assigned by t2
        */
        public static boolean typeAssignable(String t1, String t2) {
            if (t1.equals(t2))
                return true;
            else {
                if (t1.equals("unknown") || t2.equals("unknown")) {
                    return true;
                }
                SymbolType st1 = getKnownType(t1); 
                SymbolType st2 = getKnownType(t2);
                if (st1.isPrimitive() || st2.isPrimitive())
                    return false;
                else if (st1.getCanonicalName().equals(st2.getCanonicalName()))
                    return true;
                else
                    return st1.isSuperType(st2);
            }
        }

              
        /**
        *  Add import types
        */
        public static boolean addImportType(String importName) {
            if (getKnownType(importName) != null)
                return true;
    //        System.err.println("adding " + importName);
            if (importName.endsWith("*")) {
                return addMultipleImportType(importName.substring(0, importName.length() - 2));
            } else
                return addSingleImportType(importName);

        }
        
            // TODO Need improvement
    	private static boolean addSingleImportType(String importName) {
            boolean bFound = false;
            String s = System.getProperty("java.class.path");
            if (s == null)
                s = ".";
            String[] pathes = s.split(File.pathSeparator);
            
            String s2 = System.getProperty("sun.boot.class.path");
            String[] pathes2 = s2.split(File.pathSeparator);
            
            String[] classpathes = new String[pathes.length + pathes2.length];
            System.arraycopy(pathes, 0, classpathes, 0, pathes.length);
            System.arraycopy(pathes2, 0, classpathes, pathes.length, pathes2.length);
    	    for (String path : classpathes) {
    	        if (path.endsWith("jar")) {
    	            String filePath = importName.replaceAll("\\.", "/") + ".class";
    	            try {
    	                JarFile jarFile = new JarFile(path);
    	                if (jarFile.getJarEntry(filePath) != null) {
    	                    String simpleName = importName.substring(importName
    	                            .lastIndexOf('.') + 1);
    	                    SymbolType symbolType = new SymbolType(importName);
    	                    knownTypes.put(importName, symbolType);
    	                    knownTypes.put(simpleName, symbolType);
    	                    bFound = true;
    	                    break;
    	                }
    	            } catch (IOException e) {
    	               System.err.println(e.getMessage());
    //	                e.printStackTrace();
    	                break;
    	            }
    	        } else {
    	            String filePath = path + File.separator
    	                    + importName.replaceAll("\\.", File.separator)
    	                    + ".class";
    	            ;
    	            if (new File(filePath).exists()) {
    	                String simpleName = importName.substring(importName
    	                        .lastIndexOf('.') + 1);
    	                SymbolType symbolType = new SymbolType(importName);
    	                knownTypes.put(importName, symbolType);
    	                knownTypes.put(simpleName, symbolType);
    	                bFound = true;
    	                break;
    	            }
    	        }
    	    }
    	    return bFound;
    	}

        private static  boolean addMultipleImportType(String importDir) {
            boolean bFound = false;
            String s = System.getProperty("java.class.path");
            if (s == null)
                s = ".";
            String[] pathes = s.split(File.pathSeparator);
            
            String s2 = System.getProperty("sun.boot.class.path");
            String[] pathes2 = s2.split(File.pathSeparator);
            
            String[] classpathes = new String[pathes.length + pathes2.length];
            System.arraycopy(pathes, 0, classpathes, 0, pathes.length);
            System.arraycopy(pathes2, 0, classpathes, pathes.length, pathes2.length);
            int subLen = ".class".length();
            Pattern p = Pattern.compile("^" + importDir + "\\.[a-zA-Z_0-9]+\\.class$");
            for (String path : classpathes) {
                if (path.endsWith("jar")) {
                    try {
                        JarInputStream jarFile = new JarInputStream(
                                new FileInputStream(path));
                        JarEntry jarEntry;
                        while (true) {
                            jarEntry = jarFile.getNextJarEntry();
                            if (jarEntry == null) {
                                break;
                            }
                            String className = jarEntry.getName().replaceAll("/", "\\.");
                            if (p.matcher(className).matches()) {
                                className = className.substring(0,
                                        className.length() - subLen);
                                String simpleName = className.substring(className
                                        .lastIndexOf('.') + 1);
                                SymbolType symbolType = new SymbolType(className);
                                knownTypes.put(className, symbolType);
                                knownTypes.put(simpleName, symbolType);
                                bFound = true;
                            }
                        }
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
    //                    e.printStackTrace();
                    }
                } else {
                    File folder = new File(path + File.separator
                            + importDir.replaceAll("\\.", File.separator));
                    if (folder.exists()) {                        
                        File[] files = folder.listFiles();
    	                for (File file : files) {
    	                    String className = file.getName();
    	                    if (className.endsWith(".class")) {
    	                        className = importDir
    	                                + "."
    	                                + className.substring(0, className.length()
    	                                        - subLen);
    	                        String simpleName = className.substring(className
    	                                .lastIndexOf('.') + 1);
    	                        SymbolType symbolType = new SymbolType(className);
    	                        knownTypes.put(className, symbolType);
    	                        knownTypes.put(simpleName, symbolType);
    	                        bFound = true;
    	                    }
                    }
                    }
                }
            }
            return bFound;
        }

    	Stack<String> paraphrases = new Stack<String>();
    	public String getErrorMessage(RecognitionException e, String[] tokenNames) {
    		if(e instanceof FailedPredicateException){
    		  FailedPredicateException fpe = (FailedPredicateException)e;
              if (fpe.predicateText.contains("future"))
                return "Returned value of a message can only be assigned to a token";
              if (fpe.predicateText.equals("{getKnownType(moduleName + \".\" + $IDENT.text) != null}?")) {
                return "Duplicated type definition";          
                }
    		}
    		return super.getErrorMessage(e, tokenNames);
    	}
        
        private boolean mMessageCollectionEnabled = false;
        private boolean mHasErrors = false;
        private List<String> mMessages;

        /**
         *  Switches error message collection on or of.
         *
         *  The standard destination for parser error messages is <code>System.err</code>.
         *  However, if <code>true</code> gets passed to this method this default
         *  behaviour will be switched off and all error messages will be collected
         *  instead of written to anywhere.
         *
         *  The default value is <code>false</code>.
         *
         *  @param pNewState  <code>true</code> if error messages should be collected.
         */
        public void enableErrorMessageCollection(boolean pNewState) {
            mMessageCollectionEnabled = pNewState;
            if (mMessages == null && mMessageCollectionEnabled) {
                mMessages = new ArrayList<String>();
            }
        }
        
        /**
         *  Collects an error message or passes the error message to <code>
         *  super.emitErrorMessage(...)</code>.
         *
         *  The actual behaviour depends on whether collecting error messages
         *  has been enabled or not.
         *
         *  @param pMessage  The error message.
         */
         @Override
        public void emitErrorMessage(String pMessage) {
            if (mMessageCollectionEnabled) {
                mMessages.add(pMessage);
            } else {
                super.emitErrorMessage(pMessage);
            }
        }
        
        /**
         *  Returns collected error messages.
         *
         *  @return  A list holding collected error messages or <code>null</code> if
         *           collecting error messages hasn't been enabled. Of course, this
         *           list may be empty if no error message has been emited.
         */
        public List<String> getMessages() {
            return mMessages;
        }
        
        /**
         *  Tells if parsing a Java source has caused any error messages.
         *
         *  @return  <code>true</code> if parsing a Java source has caused at least one error message.
         */
        public boolean hasErrors() {
            return mHasErrors;
        }



    // $ANTLR start "compilationUnit"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:551:1: compilationUnit returns [CompilationUnit cu] : ( moduleDeclaration )? ( importDeclaration {...}?)* ( typeDeclaration )+ ;
    public final CompilationUnit compilationUnit() throws RecognitionException {
        CompilationUnit cu = null;

        String moduleDeclaration1 = null;

        String importDeclaration2 = null;

        TypeDeclaration typeDeclaration3 = null;



            cu = new CompilationUnit();
        //    SymbolType st = new SymbolType("primitive");

        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:558:5: ( ( moduleDeclaration )? ( importDeclaration {...}?)* ( typeDeclaration )+ )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:558:9: ( moduleDeclaration )? ( importDeclaration {...}?)* ( typeDeclaration )+
            {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:558:9: ( moduleDeclaration )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==183) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:558:10: moduleDeclaration
                    {
                    pushFollow(FOLLOW_moduleDeclaration_in_compilationUnit4485);
                    moduleDeclaration1=moduleDeclaration();

                    state._fsp--;

                    cu.setModuleName(moduleDeclaration1); moduleName = moduleDeclaration1;

                    }
                    break;

            }

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:559:9: ( importDeclaration {...}?)*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==IMPORT) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:559:10: importDeclaration {...}?
            	    {
            	    pushFollow(FOLLOW_importDeclaration_in_compilationUnit4500);
            	    importDeclaration2=importDeclaration();

            	    state._fsp--;

            	    cu.addImport(importDeclaration2);
            	    if ( !((addImportType(importDeclaration2))) ) {
            	        throw new FailedPredicateException(input, "compilationUnit", "addImportType($importDeclaration.value)");
            	    }

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:560:9: ( typeDeclaration )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==CLASS||(LA3_0>=184 && LA3_0<=185)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:560:10: typeDeclaration
            	    {
            	    pushFollow(FOLLOW_typeDeclaration_in_compilationUnit4518);
            	    typeDeclaration3=typeDeclaration();

            	    state._fsp--;

            	    cu.addTypeDeclaration(typeDeclaration3); typeDeclaration3.setModuleName(moduleName);

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return cu;
    }
    // $ANTLR end "compilationUnit"


    // $ANTLR start "moduleDeclaration"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:563:1: moduleDeclaration returns [String value] : 'module' name ';' ;
    public final String moduleDeclaration() throws RecognitionException {
        String value = null;

        SalsaParser.name_return name4 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:564:5: ( 'module' name ';' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:564:9: 'module' name ';'
            {
            match(input,183,FOLLOW_183_in_moduleDeclaration4545); 
            pushFollow(FOLLOW_name_in_moduleDeclaration4547);
            name4=name();

            state._fsp--;

            match(input,SEMI,FOLLOW_SEMI_in_moduleDeclaration4549); 
            value = (name4!=null?name4.value:null);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "moduleDeclaration"


    // $ANTLR start "importDeclaration"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:567:1: importDeclaration returns [String value] : 'import' name ( '.*' )? ';' ;
    public final String importDeclaration() throws RecognitionException {
        String value = null;

        SalsaParser.name_return name5 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:568:5: ( 'import' name ( '.*' )? ';' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:568:9: 'import' name ( '.*' )? ';'
            {
            match(input,IMPORT,FOLLOW_IMPORT_in_importDeclaration4574); 
            pushFollow(FOLLOW_name_in_importDeclaration4576);
            name5=name();

            state._fsp--;

            value = (name5!=null?name5.value:null);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:569:9: ( '.*' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==DOTSTAR) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:569:10: '.*'
                    {
                    match(input,DOTSTAR,FOLLOW_DOTSTAR_in_importDeclaration4589); 
                    value += ".*";

                    }
                    break;

            }

            match(input,SEMI,FOLLOW_SEMI_in_importDeclaration4595); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "importDeclaration"

    public static class name_return extends ParserRuleReturnScope {
        public String value;
    };

    // $ANTLR start "name"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:572:1: name returns [String value] : t1= IDENT ( '.' t2= IDENT )* ;
    public final SalsaParser.name_return name() throws RecognitionException {
        SalsaParser.name_return retval = new SalsaParser.name_return();
        retval.start = input.LT(1);

        Token t1=null;
        Token t2=null;

        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:573:5: (t1= IDENT ( '.' t2= IDENT )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:573:9: t1= IDENT ( '.' t2= IDENT )*
            {
            t1=(Token)match(input,IDENT,FOLLOW_IDENT_in_name4622); 
            retval.value = (t1!=null?t1.getText():null);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:574:9: ( '.' t2= IDENT )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==DOT) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:574:10: '.' t2= IDENT
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_name4635); 
            	    t2=(Token)match(input,IDENT,FOLLOW_IDENT_in_name4641); 
            	    retval.value += "." + (t2!=null?t2.getText():null);

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "name"

    protected static class typeDeclaration_scope {
        Map<String, String> fieldTypes;
        SymbolType currentType;
    }
    protected Stack typeDeclaration_stack = new Stack();


    // $ANTLR start "typeDeclaration"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:577:1: typeDeclaration returns [TypeDeclaration td] : ( behaviorDeclaration | classDeclaration );
    public final TypeDeclaration typeDeclaration() throws RecognitionException {
        typeDeclaration_stack.push(new typeDeclaration_scope());
        TypeDeclaration td = null;

        SalsaParser.behaviorDeclaration_return behaviorDeclaration6 = null;

        SalsaParser.classDeclaration_return classDeclaration7 = null;



            ((typeDeclaration_scope)typeDeclaration_stack.peek()).fieldTypes = new HashMap<String, String>();

        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:582:5: ( behaviorDeclaration | classDeclaration )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==185) ) {
                alt6=1;
            }
            else if ( (LA6_0==CLASS||LA6_0==184) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:582:9: behaviorDeclaration
                    {
                    pushFollow(FOLLOW_behaviorDeclaration_in_typeDeclaration4683);
                    behaviorDeclaration6=behaviorDeclaration();

                    state._fsp--;

                    td = (behaviorDeclaration6!=null?behaviorDeclaration6.bd:null);

                    }
                    break;
                case 2 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:583:9: classDeclaration
                    {
                    pushFollow(FOLLOW_classDeclaration_in_typeDeclaration4695);
                    classDeclaration7=classDeclaration();

                    state._fsp--;

                    td = (classDeclaration7!=null?classDeclaration7.cd:null);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            typeDeclaration_stack.pop();
        }
        return td;
    }
    // $ANTLR end "typeDeclaration"

    public static class classDeclaration_return extends ParserRuleReturnScope {
        public ClassDeclaration cd;
    };

    // $ANTLR start "classDeclaration"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:586:1: classDeclaration returns [ClassDeclaration cd] : (im= 'immutable' )? 'class' IDENT '{' ( stateVariableDeclaration | methodDeclaration )* '}' ;
    public final SalsaParser.classDeclaration_return classDeclaration() throws RecognitionException {
        SalsaParser.classDeclaration_return retval = new SalsaParser.classDeclaration_return();
        retval.start = input.LT(1);

        Token im=null;
        Token IDENT8=null;
        SalsaParser.stateVariableDeclaration_return stateVariableDeclaration9 = null;

        MethodDeclaration methodDeclaration10 = null;


         retval.cd = new ClassDeclaration(); 
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:588:5: ( (im= 'immutable' )? 'class' IDENT '{' ( stateVariableDeclaration | methodDeclaration )* '}' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:588:9: (im= 'immutable' )? 'class' IDENT '{' ( stateVariableDeclaration | methodDeclaration )* '}'
            {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:588:9: (im= 'immutable' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==184) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:588:10: im= 'immutable'
                    {
                    im=(Token)match(input,184,FOLLOW_184_in_classDeclaration4737); 

                    }
                    break;

            }

            match(input,CLASS,FOLLOW_CLASS_in_classDeclaration4749); 
            IDENT8=(Token)match(input,IDENT,FOLLOW_IDENT_in_classDeclaration4751); 
               retval.cd.setName((IDENT8!=null?IDENT8.getText():null)); 
                        ((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType = new SymbolType(moduleName + "." + (IDENT8!=null?IDENT8.getText():null));
                        if (im != null) ((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType.setImmutable(true); 
                        if (getKnownType(moduleName + "." + (IDENT8!=null?IDENT8.getText():null)) != null) {
                            System.err.println("line " + getLine(input) + ": Duplicated type definition\n\t" + input.toString(retval.start,input.LT(-1)));
                            mHasErrors = true;
                        }
                    
                        
                        knownTypes.put(moduleName + "." + (IDENT8!=null?IDENT8.getText():null), ((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType);  
                        knownTypes.put((IDENT8!=null?IDENT8.getText():null), ((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType);  
                        ((typeDeclaration_scope)typeDeclaration_stack.peek()).fieldTypes.put("this", (IDENT8!=null?IDENT8.getText():null));
                   
            match(input,LCURLY,FOLLOW_LCURLY_in_classDeclaration4782); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:604:13: ( stateVariableDeclaration | methodDeclaration )*
            loop8:
            do {
                int alt8=3;
                alt8 = dfa8.predict(input);
                switch (alt8) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:604:17: stateVariableDeclaration
            	    {
            	    pushFollow(FOLLOW_stateVariableDeclaration_in_classDeclaration4800);
            	    stateVariableDeclaration9=stateVariableDeclaration();

            	    state._fsp--;

            	    retval.cd.addStateVariableDeclaration((stateVariableDeclaration9!=null?stateVariableDeclaration9.sd:null));

            	    }
            	    break;
            	case 2 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:605:17: methodDeclaration
            	    {
            	    pushFollow(FOLLOW_methodDeclaration_in_classDeclaration4820);
            	    methodDeclaration10=methodDeclaration();

            	    state._fsp--;

            	    retval.cd.addMethodDeclaration(methodDeclaration10);

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match(input,RCURLY,FOLLOW_RCURLY_in_classDeclaration4847); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "classDeclaration"

    public static class behaviorDeclaration_return extends ParserRuleReturnScope {
        public BehaviorDeclaration bd;
    };

    // $ANTLR start "behaviorDeclaration"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:610:1: behaviorDeclaration returns [BehaviorDeclaration bd] : 'behavior' IDENT '{' ( stateVariableDeclaration | methodDeclaration )* '}' ;
    public final SalsaParser.behaviorDeclaration_return behaviorDeclaration() throws RecognitionException {
        SalsaParser.behaviorDeclaration_return retval = new SalsaParser.behaviorDeclaration_return();
        retval.start = input.LT(1);

        Token IDENT11=null;
        SalsaParser.stateVariableDeclaration_return stateVariableDeclaration12 = null;

        MethodDeclaration methodDeclaration13 = null;


         retval.bd = new BehaviorDeclaration();
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:612:5: ( 'behavior' IDENT '{' ( stateVariableDeclaration | methodDeclaration )* '}' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:612:9: 'behavior' IDENT '{' ( stateVariableDeclaration | methodDeclaration )* '}'
            {
            match(input,185,FOLLOW_185_in_behaviorDeclaration4883); 
            IDENT11=(Token)match(input,IDENT,FOLLOW_IDENT_in_behaviorDeclaration4885); 
               retval.bd.setName((IDENT11!=null?IDENT11.getText():null)); 
                        ((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType = new SymbolType(moduleName + "." + (IDENT11!=null?IDENT11.getText():null), true);
                        if (getKnownType(moduleName + "." + (IDENT11!=null?IDENT11.getText():null)) != null) {
                            System.err.println("line " + getLine(input) + ": Duplicated type definition\n\t" + input.toString(retval.start,input.LT(-1)));
                            mHasErrors = true;
                        }
                    

                        knownTypes.put(moduleName + "." + (IDENT11!=null?IDENT11.getText():null), ((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType);  
                        knownTypes.put((IDENT11!=null?IDENT11.getText():null), ((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType);  
                        ((typeDeclaration_scope)typeDeclaration_stack.peek()).fieldTypes.put("self", (IDENT11!=null?IDENT11.getText():null));
                        ((typeDeclaration_scope)typeDeclaration_stack.peek()).fieldTypes.put("token", "Token");
                        retval.bd.setLine(getLine(input));
                    
            match(input,LCURLY,FOLLOW_LCURLY_in_behaviorDeclaration4916); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:628:10: ( stateVariableDeclaration | methodDeclaration )*
            loop9:
            do {
                int alt9=3;
                alt9 = dfa9.predict(input);
                switch (alt9) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:628:14: stateVariableDeclaration
            	    {
            	    pushFollow(FOLLOW_stateVariableDeclaration_in_behaviorDeclaration4931);
            	    stateVariableDeclaration12=stateVariableDeclaration();

            	    state._fsp--;

            	    retval.bd.addStateVariableDeclaration((stateVariableDeclaration12!=null?stateVariableDeclaration12.sd:null));

            	    }
            	    break;
            	case 2 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:629:14: methodDeclaration
            	    {
            	    pushFollow(FOLLOW_methodDeclaration_in_behaviorDeclaration4948);
            	    methodDeclaration13=methodDeclaration();

            	    state._fsp--;

            	    retval.bd.addMethodDeclaration(methodDeclaration13);

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match(input,RCURLY,FOLLOW_RCURLY_in_behaviorDeclaration4976); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "behaviorDeclaration"

    protected static class methodDeclaration_scope {
        Map<String, String> localTypes;
    }
    protected Stack methodDeclaration_stack = new Stack();


    // $ANTLR start "methodDeclaration"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:634:1: methodDeclaration returns [MethodDeclaration m] : ( constructorDeclaration | messageHandlerDeclaration ) ;
    public final MethodDeclaration methodDeclaration() throws RecognitionException {
        methodDeclaration_stack.push(new methodDeclaration_scope());
        MethodDeclaration m = null;

        ConstructorDeclaration constructorDeclaration14 = null;

        MessageHandlerDeclaration messageHandlerDeclaration15 = null;


         ((methodDeclaration_scope)methodDeclaration_stack.peek()).localTypes = new HashMap<String, String>(); 
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:637:5: ( ( constructorDeclaration | messageHandlerDeclaration ) )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:637:9: ( constructorDeclaration | messageHandlerDeclaration )
            {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:637:9: ( constructorDeclaration | messageHandlerDeclaration )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==IDENT) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==DOT||LA10_1==LBRACK||LA10_1==IDENT) ) {
                    alt10=2;
                }
                else if ( (LA10_1==LPAREN) ) {
                    alt10=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA10_0==BOOLEAN||LA10_0==BYTE||LA10_0==CHAR||LA10_0==DOUBLE||LA10_0==FLOAT||(LA10_0>=INT && LA10_0<=LONG)||LA10_0==SHORT||LA10_0==VOID||LA10_0==189) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:637:10: constructorDeclaration
                    {
                    pushFollow(FOLLOW_constructorDeclaration_in_methodDeclaration5011);
                    constructorDeclaration14=constructorDeclaration();

                    state._fsp--;

                    m = constructorDeclaration14;

                    }
                    break;
                case 2 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:638:9: messageHandlerDeclaration
                    {
                    pushFollow(FOLLOW_messageHandlerDeclaration_in_methodDeclaration5023);
                    messageHandlerDeclaration15=messageHandlerDeclaration();

                    state._fsp--;

                    m = messageHandlerDeclaration15;

                    }
                    break;

            }

            m.setClassDef(!((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType.isActorType());

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            methodDeclaration_stack.pop();
        }
        return m;
    }
    // $ANTLR end "methodDeclaration"


    // $ANTLR start "constructorDeclaration"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:642:1: constructorDeclaration returns [ConstructorDeclaration cd] : IDENT formalParameters block ;
    public final ConstructorDeclaration constructorDeclaration() throws RecognitionException {
        ConstructorDeclaration cd = null;

        Token IDENT16=null;
        List<FormalParameter> formalParameters17 = null;

        Block block18 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:643:5: ( IDENT formalParameters block )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:643:9: IDENT formalParameters block
            {
            IDENT16=(Token)match(input,IDENT,FOLLOW_IDENT_in_constructorDeclaration5061); 
            int ln = getLine(input);
            pushFollow(FOLLOW_formalParameters_in_constructorDeclaration5065);
            formalParameters17=formalParameters();

            state._fsp--;

            pushFollow(FOLLOW_block_in_constructorDeclaration5067);
            block18=block();

            state._fsp--;

               cd = new ConstructorDeclaration((IDENT16!=null?IDENT16.getText():null), formalParameters17, block18);
                        cd.setLine(ln);
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return cd;
    }
    // $ANTLR end "constructorDeclaration"


    // $ANTLR start "messageHandlerDeclaration"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:650:1: messageHandlerDeclaration returns [MessageHandlerDeclaration md] : type IDENT formalParameters block ;
    public final MessageHandlerDeclaration messageHandlerDeclaration() throws RecognitionException {
        MessageHandlerDeclaration md = null;

        Token IDENT20=null;
        String type19 = null;

        List<FormalParameter> formalParameters21 = null;

        Block block22 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:651:5: ( type IDENT formalParameters block )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:651:9: type IDENT formalParameters block
            {
            pushFollow(FOLLOW_type_in_messageHandlerDeclaration5101);
            type19=type();

            state._fsp--;

            IDENT20=(Token)match(input,IDENT,FOLLOW_IDENT_in_messageHandlerDeclaration5103); 
            pushFollow(FOLLOW_formalParameters_in_messageHandlerDeclaration5105);
            formalParameters21=formalParameters();

            state._fsp--;

            pushFollow(FOLLOW_block_in_messageHandlerDeclaration5107);
            block22=block();

            state._fsp--;


                        md = new MessageHandlerDeclaration(type19, (IDENT20!=null?IDENT20.getText():null), formalParameters21, block22);
                        List<FormalParameter> list = formalParameters21;
                        List<String> typeList = new ArrayList<String>();
                        for (FormalParameter fp : list) {
                            typeList.add(fp.getType());
                        }
                        SymbolMethod sm = new SymbolMethod((IDENT20!=null?IDENT20.getText():null), type19, typeList.toArray(new String[0]));
                        md.setSymbolMethod(sm);
                        ((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType.addMethod(sm);
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return md;
    }
    // $ANTLR end "messageHandlerDeclaration"

    protected static class block_scope {
        boolean afterContinuation;
    }
    protected Stack block_stack = new Stack();


    // $ANTLR start "block"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:666:1: block returns [Block b] : '{' ( statement )* '}' ;
    public final Block block() throws RecognitionException {
        block_stack.push(new block_scope());
        Block b = null;

        SalsaParser.statement_return statement23 = null;


         b = new Block(); ((block_scope)block_stack.peek()).afterContinuation = false;
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:669:5: ( '{' ( statement )* '}' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:669:9: '{' ( statement )* '}'
            {
            match(input,LCURLY,FOLLOW_LCURLY_in_block5148); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:669:13: ( statement )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==DEC||LA11_0==INC||LA11_0==LCURLY||LA11_0==LOGICAL_NOT||(LA11_0>=LPAREN && LA11_0<=MINUS)||LA11_0==NOT||LA11_0==PLUS||LA11_0==BOOLEAN||LA11_0==BYTE||LA11_0==CHAR||LA11_0==DOUBLE||LA11_0==FALSE||(LA11_0>=FLOAT && LA11_0<=IF)||(LA11_0>=INT && LA11_0<=LONG)||(LA11_0>=NEW && LA11_0<=NULL)||(LA11_0>=RETURN && LA11_0<=SHORT)||LA11_0==THIS||LA11_0==TRUE||LA11_0==VOID||(LA11_0>=IDENT && LA11_0<=FLOATING_POINT_LITERAL)||(LA11_0>=186 && LA11_0<=187)||LA11_0==189) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:669:14: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_block5151);
            	    statement23=statement();

            	    state._fsp--;

            	    b.addStatement((statement23!=null?statement23.stat:null)); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            match(input,RCURLY,FOLLOW_RCURLY_in_block5159); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            block_stack.pop();
        }
        return b;
    }
    // $ANTLR end "block"

    public static class statement_return extends ParserRuleReturnScope {
        public Statement stat;
    };

    // $ANTLR start "statement"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:673:1: statement returns [Statement stat] : ( localVariableDeclaration ( ';' | '@' ) | e1= expression ( '=' e2= expression )? ( ';' | '@' ) | joinBlockStatement ( '@' ) | blockStatement | ifStatement | returnStatement ';' | forStatement ) ;
    public final SalsaParser.statement_return statement() throws RecognitionException {
        SalsaParser.statement_return retval = new SalsaParser.statement_return();
        retval.start = input.LT(1);

        SalsaParser.expression_return e1 = null;

        SalsaParser.expression_return e2 = null;

        SalsaParser.localVariableDeclaration_return localVariableDeclaration24 = null;

        JoinBlockStatement joinBlockStatement25 = null;

        BlockStatement blockStatement26 = null;

        IfStatement ifStatement27 = null;

        ReturnStatement returnStatement28 = null;

        ForStatement forStatement29 = null;


        boolean isContinuation = false; 
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:681:5: ( ( localVariableDeclaration ( ';' | '@' ) | e1= expression ( '=' e2= expression )? ( ';' | '@' ) | joinBlockStatement ( '@' ) | blockStatement | ifStatement | returnStatement ';' | forStatement ) )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:681:7: ( localVariableDeclaration ( ';' | '@' ) | e1= expression ( '=' e2= expression )? ( ';' | '@' ) | joinBlockStatement ( '@' ) | blockStatement | ifStatement | returnStatement ';' | forStatement )
            {
            int ln = getLine(input);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:682:5: ( localVariableDeclaration ( ';' | '@' ) | e1= expression ( '=' e2= expression )? ( ';' | '@' ) | joinBlockStatement ( '@' ) | blockStatement | ifStatement | returnStatement ';' | forStatement )
            int alt15=7;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:683:9: localVariableDeclaration ( ';' | '@' )
                    {
                    pushFollow(FOLLOW_localVariableDeclaration_in_statement5221);
                    localVariableDeclaration24=localVariableDeclaration();

                    state._fsp--;

                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:683:34: ( ';' | '@' )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==SEMI) ) {
                        alt12=1;
                    }
                    else if ( (LA12_0==AT) ) {
                        alt12=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:683:35: ';'
                            {
                            match(input,SEMI,FOLLOW_SEMI_in_statement5224); 

                            }
                            break;
                        case 2 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:683:41: '@'
                            {
                            match(input,AT,FOLLOW_AT_in_statement5228); 
                            isContinuation=true;

                            }
                            break;

                    }

                    retval.stat = (localVariableDeclaration24!=null?localVariableDeclaration24.ld:null);

                    }
                    break;
                case 2 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:684:9: e1= expression ( '=' e2= expression )? ( ';' | '@' )
                    {
                    pushFollow(FOLLOW_expression_in_statement5246);
                    e1=expression();

                    state._fsp--;

                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:684:25: ( '=' e2= expression )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==ASSIGN) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:684:26: '=' e2= expression
                            {
                            match(input,ASSIGN,FOLLOW_ASSIGN_in_statement5249); 
                            pushFollow(FOLLOW_expression_in_statement5255);
                            e2=expression();

                            state._fsp--;


                            }
                            break;

                    }

                       if(e2 == null) 
                                    retval.stat = new ExpressionStatement((e1!=null?e1.e:null)); 
                                else {
                                    retval.stat = new AssignmentStatement((e1!=null?e1.e:null), (e2!=null?e2.e:null));
                                 }
                            
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:691:9: ( ';' | '@' )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==SEMI) ) {
                        alt14=1;
                    }
                    else if ( (LA14_0==AT) ) {
                        alt14=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }
                    switch (alt14) {
                        case 1 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:691:10: ';'
                            {
                            match(input,SEMI,FOLLOW_SEMI_in_statement5279); 

                            }
                            break;
                        case 2 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:691:16: '@'
                            {
                            match(input,AT,FOLLOW_AT_in_statement5283); 
                            isContinuation=true;

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:692:9: joinBlockStatement ( '@' )
                    {
                    pushFollow(FOLLOW_joinBlockStatement_in_statement5296);
                    joinBlockStatement25=joinBlockStatement();

                    state._fsp--;

                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:692:28: ( '@' )
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:692:29: '@'
                    {
                    match(input,AT,FOLLOW_AT_in_statement5299); 

                    }

                     retval.stat = joinBlockStatement25; isContinuation=true;

                    }
                    break;
                case 4 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:693:9: blockStatement
                    {
                    pushFollow(FOLLOW_blockStatement_in_statement5313);
                    blockStatement26=blockStatement();

                    state._fsp--;

                    retval.stat = blockStatement26;

                    }
                    break;
                case 5 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:694:9: ifStatement
                    {
                    pushFollow(FOLLOW_ifStatement_in_statement5326);
                    ifStatement27=ifStatement();

                    state._fsp--;

                    retval.stat = ifStatement27;

                    }
                    break;
                case 6 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:695:9: returnStatement ';'
                    {
                    pushFollow(FOLLOW_returnStatement_in_statement5338);
                    returnStatement28=returnStatement();

                    state._fsp--;

                    match(input,SEMI,FOLLOW_SEMI_in_statement5340); 
                    retval.stat = returnStatement28; 

                    }
                    break;
                case 7 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:696:9: forStatement
                    {
                    pushFollow(FOLLOW_forStatement_in_statement5352);
                    forStatement29=forStatement();

                    state._fsp--;

                    retval.stat = forStatement29; 

                    }
                    break;

            }

            retval.stat.setLine(ln);
            retval.stat.setSalsaSource(input.toString(retval.start,input.LT(-1)));

            }

            retval.stop = input.LT(-1);

             
                ((block_scope)block_stack.peek()).afterContinuation = isContinuation; 
                retval.stat.setContinuation(isContinuation);
                retval.stat.setClassDef(!((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType.isActorType());
                try{retval.stat.setInJoinBlock(((joinBlockStatement_scope)joinBlockStatement_stack.peek()).isInJoinBlock);}catch(Exception e){}

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"


    // $ANTLR start "forStatement"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:702:1: forStatement returns [ForStatement s] : 'for' '(' localVariableDeclaration ';' e1= expression ';' e2= expression ')' block ;
    public final ForStatement forStatement() throws RecognitionException {
        ForStatement s = null;

        SalsaParser.expression_return e1 = null;

        SalsaParser.expression_return e2 = null;

        SalsaParser.localVariableDeclaration_return localVariableDeclaration30 = null;

        Block block31 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:703:5: ( 'for' '(' localVariableDeclaration ';' e1= expression ';' e2= expression ')' block )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:703:9: 'for' '(' localVariableDeclaration ';' e1= expression ';' e2= expression ')' block
            {
            match(input,FOR,FOLLOW_FOR_in_forStatement5403); 
            match(input,LPAREN,FOLLOW_LPAREN_in_forStatement5414); 
            pushFollow(FOLLOW_localVariableDeclaration_in_forStatement5429);
            localVariableDeclaration30=localVariableDeclaration();

            state._fsp--;

            match(input,SEMI,FOLLOW_SEMI_in_forStatement5444); 
            pushFollow(FOLLOW_expression_in_forStatement5463);
            e1=expression();

            state._fsp--;

            match(input,SEMI,FOLLOW_SEMI_in_forStatement5465); 
            pushFollow(FOLLOW_expression_in_forStatement5484);
            e2=expression();

            state._fsp--;

            match(input,RPAREN,FOLLOW_RPAREN_in_forStatement5495); 
            pushFollow(FOLLOW_block_in_forStatement5505);
            block31=block();

            state._fsp--;


                        s = new ForStatement((localVariableDeclaration30!=null?localVariableDeclaration30.ld:null), (e1!=null?e1.e:null), (e2!=null?e2.e:null), block31);
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "forStatement"


    // $ANTLR start "returnStatement"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:716:1: returnStatement returns [ReturnStatement s] : 'return' ( expression )? ;
    public final ReturnStatement returnStatement() throws RecognitionException {
        ReturnStatement s = null;

        SalsaParser.expression_return expression32 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:717:5: ( 'return' ( expression )? )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:717:9: 'return' ( expression )?
            {
            match(input,RETURN,FOLLOW_RETURN_in_returnStatement5547); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:717:18: ( expression )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==DEC||LA16_0==INC||LA16_0==LOGICAL_NOT||(LA16_0>=LPAREN && LA16_0<=MINUS)||LA16_0==NOT||LA16_0==PLUS||LA16_0==FALSE||(LA16_0>=NEW && LA16_0<=NULL)||LA16_0==THIS||LA16_0==TRUE||(LA16_0>=IDENT && LA16_0<=FLOATING_POINT_LITERAL)||LA16_0==187) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:717:19: expression
                    {
                    pushFollow(FOLLOW_expression_in_returnStatement5550);
                    expression32=expression();

                    state._fsp--;


                    }
                    break;

            }

               (expression32!=null?expression32.e:null).setReturnStatement(true);
                        s = new ReturnStatement((expression32!=null?expression32.e:null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "returnStatement"


    // $ANTLR start "ifStatement"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:734:1: ifStatement returns [IfStatement s] : 'if' '(' expression ')' block ( 'else' statement )? ;
    public final IfStatement ifStatement() throws RecognitionException {
        IfStatement s = null;

        SalsaParser.expression_return expression33 = null;

        Block block34 = null;

        SalsaParser.statement_return statement35 = null;


        s = new IfStatement();
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:736:5: ( 'if' '(' expression ')' block ( 'else' statement )? )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:736:9: 'if' '(' expression ')' block ( 'else' statement )?
            {
            match(input,IF,FOLLOW_IF_in_ifStatement5602); 
            match(input,LPAREN,FOLLOW_LPAREN_in_ifStatement5604); 
            pushFollow(FOLLOW_expression_in_ifStatement5606);
            expression33=expression();

            state._fsp--;

            match(input,RPAREN,FOLLOW_RPAREN_in_ifStatement5608); 
            pushFollow(FOLLOW_block_in_ifStatement5610);
            block34=block();

            state._fsp--;

            s.setExpression((expression33!=null?expression33.e:null)); s.setBlock(block34);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:737:9: ( 'else' statement )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==ELSE) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:737:10: 'else' statement
                    {
                    match(input,ELSE,FOLLOW_ELSE_in_ifStatement5623); 
                    pushFollow(FOLLOW_statement_in_ifStatement5625);
                    statement35=statement();

                    state._fsp--;

                    s.setElseStatement((statement35!=null?statement35.stat:null));

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "ifStatement"

    protected static class joinBlockStatement_scope {
        boolean isInJoinBlock;
    }
    protected Stack joinBlockStatement_stack = new Stack();


    // $ANTLR start "joinBlockStatement"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:740:1: joinBlockStatement returns [JoinBlockStatement s] : 'join' block ;
    public final JoinBlockStatement joinBlockStatement() throws RecognitionException {
        joinBlockStatement_stack.push(new joinBlockStatement_scope());
        JoinBlockStatement s = null;

        Block block36 = null;


         ((joinBlockStatement_scope)joinBlockStatement_stack.peek()).isInJoinBlock = true;
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:744:5: ( 'join' block )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:744:9: 'join' block
            {
            match(input,186,FOLLOW_186_in_joinBlockStatement5670); 
            pushFollow(FOLLOW_block_in_joinBlockStatement5672);
            block36=block();

            state._fsp--;

            s = new JoinBlockStatement(block36);

            }

             ((joinBlockStatement_scope)joinBlockStatement_stack.peek()).isInJoinBlock = false;
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            joinBlockStatement_stack.pop();
        }
        return s;
    }
    // $ANTLR end "joinBlockStatement"


    // $ANTLR start "blockStatement"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:747:1: blockStatement returns [BlockStatement s] : block ;
    public final BlockStatement blockStatement() throws RecognitionException {
        BlockStatement s = null;

        Block block37 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:748:5: ( block )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:748:9: block
            {
            pushFollow(FOLLOW_block_in_blockStatement5710);
            block37=block();

            state._fsp--;

            s = new BlockStatement(block37);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "blockStatement"


    // $ANTLR start "expressionStatement"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:751:1: expressionStatement returns [ExpressionStatement s] : expression ;
    public final ExpressionStatement expressionStatement() throws RecognitionException {
        ExpressionStatement s = null;

        SalsaParser.expression_return expression38 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:752:5: ( expression )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:752:9: expression
            {
            pushFollow(FOLLOW_expression_in_expressionStatement5735);
            expression38=expression();

            state._fsp--;

            s = new ExpressionStatement((expression38!=null?expression38.e:null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "expressionStatement"


    // $ANTLR start "formalParameters"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:756:1: formalParameters returns [List<FormalParameter> list] : '(' (f1= formalParameter ( ',' f2= formalParameter )* )? ')' ;
    public final List<FormalParameter> formalParameters() throws RecognitionException {
        List<FormalParameter> list = null;

        SalsaParser.formalParameter_return f1 = null;

        SalsaParser.formalParameter_return f2 = null;


         list = new ArrayList<FormalParameter>(); 
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:758:5: ( '(' (f1= formalParameter ( ',' f2= formalParameter )* )? ')' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:758:9: '(' (f1= formalParameter ( ',' f2= formalParameter )* )? ')'
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_formalParameters5777); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:759:9: (f1= formalParameter ( ',' f2= formalParameter )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==BOOLEAN||LA19_0==BYTE||LA19_0==CHAR||LA19_0==DOUBLE||LA19_0==FLOAT||(LA19_0>=INT && LA19_0<=LONG)||LA19_0==SHORT||LA19_0==VOID||LA19_0==IDENT||LA19_0==189) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:760:13: f1= formalParameter ( ',' f2= formalParameter )*
                    {
                    pushFollow(FOLLOW_formalParameter_in_formalParameters5805);
                    f1=formalParameter();

                    state._fsp--;

                     list.add((f1!=null?f1.fp:null)); 
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:761:13: ( ',' f2= formalParameter )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==COMMA) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:761:14: ',' f2= formalParameter
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_formalParameters5822); 
                    	    pushFollow(FOLLOW_formalParameter_in_formalParameters5828);
                    	    f2=formalParameter();

                    	    state._fsp--;

                    	    list.add((f2!=null?f2.fp:null));

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_formalParameters5854); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return list;
    }
    // $ANTLR end "formalParameters"

    public static class formalParameter_return extends ParserRuleReturnScope {
        public FormalParameter fp;
    };

    // $ANTLR start "formalParameter"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:767:1: formalParameter returns [FormalParameter fp] : type IDENT ;
    public final SalsaParser.formalParameter_return formalParameter() throws RecognitionException {
        SalsaParser.formalParameter_return retval = new SalsaParser.formalParameter_return();
        retval.start = input.LT(1);

        Token IDENT40=null;
        String type39 = null;


        SymbolType st;
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:770:5: ( type IDENT )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:770:9: type IDENT
            {
            pushFollow(FOLLOW_type_in_formalParameter5888);
            type39=type();

            state._fsp--;

            IDENT40=(Token)match(input,IDENT,FOLLOW_IDENT_in_formalParameter5898); 
             retval.fp = new FormalParameter(type39, (IDENT40!=null?IDENT40.getText():null));
            ((methodDeclaration_scope)methodDeclaration_stack.peek()).localTypes.put((IDENT40!=null?IDENT40.getText():null), type39);

            }

            retval.stop = input.LT(-1);

             retval.fp.setSalsaSource(input.toString(retval.start,input.LT(-1))); retval.fp.setLine(getLine(input));retval.fp.analyze(null); 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "formalParameter"

    public static class localVariableDeclaration_return extends ParserRuleReturnScope {
        public LocalVariableDeclaration ld;
        public String canonicalType;
    };

    // $ANTLR start "localVariableDeclaration"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:777:1: localVariableDeclaration returns [LocalVariableDeclaration ld, String canonicalType] : type v1= variableDeclaration[$canonicalType] ( ',' v2= variableDeclaration[$canonicalType] )* ;
    public final SalsaParser.localVariableDeclaration_return localVariableDeclaration() throws RecognitionException {
        SalsaParser.localVariableDeclaration_return retval = new SalsaParser.localVariableDeclaration_return();
        retval.start = input.LT(1);

        SalsaParser.variableDeclaration_return v1 = null;

        SalsaParser.variableDeclaration_return v2 = null;

        String type41 = null;


         retval.ld = new LocalVariableDeclaration(); String rawType; SymbolType st;
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:779:5: ( type v1= variableDeclaration[$canonicalType] ( ',' v2= variableDeclaration[$canonicalType] )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:779:9: type v1= variableDeclaration[$canonicalType] ( ',' v2= variableDeclaration[$canonicalType] )*
            {
            pushFollow(FOLLOW_type_in_localVariableDeclaration5955);
            type41=type();

            state._fsp--;

            retval.canonicalType = type41;
            pushFollow(FOLLOW_variableDeclaration_in_localVariableDeclaration5990);
            v1=variableDeclaration(retval.canonicalType);

            state._fsp--;

             retval.ld.addVariableDeclaration((v1!=null?v1.vd:null)); ((methodDeclaration_scope)methodDeclaration_stack.peek()).localTypes.put((v1!=null?v1.value:null), retval.canonicalType);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:793:9: ( ',' v2= variableDeclaration[$canonicalType] )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==COMMA) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:793:10: ',' v2= variableDeclaration[$canonicalType]
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_localVariableDeclaration6012); 
            	    pushFollow(FOLLOW_variableDeclaration_in_localVariableDeclaration6018);
            	    v2=variableDeclaration(retval.canonicalType);

            	    state._fsp--;

            	     retval.ld.addVariableDeclaration((v2!=null?v2.vd:null)); ((methodDeclaration_scope)methodDeclaration_stack.peek()).localTypes.put((v2!=null?v2.value:null), retval.canonicalType);

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "localVariableDeclaration"

    public static class stateVariableDeclaration_return extends ParserRuleReturnScope {
        public StateVariableDeclaration sd;
        public String canonicalType;
    };

    // $ANTLR start "stateVariableDeclaration"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:797:1: stateVariableDeclaration returns [StateVariableDeclaration sd, String canonicalType] : type v1= variableDeclaration[$canonicalType] ( ',' v2= variableDeclaration[$canonicalType] )* ';' ;
    public final SalsaParser.stateVariableDeclaration_return stateVariableDeclaration() throws RecognitionException {
        SalsaParser.stateVariableDeclaration_return retval = new SalsaParser.stateVariableDeclaration_return();
        retval.start = input.LT(1);

        SalsaParser.variableDeclaration_return v1 = null;

        SalsaParser.variableDeclaration_return v2 = null;

        String type42 = null;


         retval.sd = new StateVariableDeclaration(); String rawType; SymbolType st;
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:799:5: ( type v1= variableDeclaration[$canonicalType] ( ',' v2= variableDeclaration[$canonicalType] )* ';' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:799:9: type v1= variableDeclaration[$canonicalType] ( ',' v2= variableDeclaration[$canonicalType] )* ';'
            {
            pushFollow(FOLLOW_type_in_stateVariableDeclaration6076);
            type42=type();

            state._fsp--;

            if (!(!type42.startsWith("future")))
                    { System.err.println(getOutputPrefix(input) + "future type is not allowed in the field");}
                    

                        rawType = type42;
                        st = getKnownType(rawType);
                    
            retval.canonicalType = type42;
            pushFollow(FOLLOW_variableDeclaration_in_stateVariableDeclaration6135);
            v1=variableDeclaration(retval.canonicalType);

            state._fsp--;

             
                        retval.sd.addVariableDeclaration((v1!=null?v1.vd:null)); 
                        ((typeDeclaration_scope)typeDeclaration_stack.peek()).fieldTypes.put((v1!=null?v1.value:null), retval.canonicalType);
                        ((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType.addField(new SymbolField((v1!=null?v1.value:null), retval.canonicalType));
                    
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:818:9: ( ',' v2= variableDeclaration[$canonicalType] )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==COMMA) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:818:10: ',' v2= variableDeclaration[$canonicalType]
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_stateVariableDeclaration6158); 
            	    pushFollow(FOLLOW_variableDeclaration_in_stateVariableDeclaration6164);
            	    v2=variableDeclaration(retval.canonicalType);

            	    state._fsp--;

            	     
            	    	        retval.sd.addVariableDeclaration((v2!=null?v2.vd:null)); 
            	    	        ((typeDeclaration_scope)typeDeclaration_stack.peek()).fieldTypes.put((v2!=null?v2.value:null), retval.canonicalType);
            	    	        ((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType.addField(new SymbolField((v2!=null?v2.value:null), retval.canonicalType));	        
            	            

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            match(input,SEMI,FOLLOW_SEMI_in_stateVariableDeclaration6197); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "stateVariableDeclaration"

    public static class variableDeclaration_return extends ParserRuleReturnScope {
        public VariableDeclaration vd;
        public String value;
    };

    // $ANTLR start "variableDeclaration"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:828:1: variableDeclaration[String type] returns [VariableDeclaration vd, String value] : IDENT ( '=' expression )? ;
    public final SalsaParser.variableDeclaration_return variableDeclaration(String type) throws RecognitionException {
        SalsaParser.variableDeclaration_return retval = new SalsaParser.variableDeclaration_return();
        retval.start = input.LT(1);

        Token IDENT43=null;
        SalsaParser.expression_return expression44 = null;


         retval.vd = new VariableDeclaration(); retval.vd.setType(type); 
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:830:5: ( IDENT ( '=' expression )? )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:830:9: IDENT ( '=' expression )?
            {
            IDENT43=(Token)match(input,IDENT,FOLLOW_IDENT_in_variableDeclaration6227); 
            retval.vd.setName((IDENT43!=null?IDENT43.getText():null)); retval.value =(IDENT43!=null?IDENT43.getText():null); retval.vd.setLine(getLine(input));
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:831:9: ( '=' expression )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==ASSIGN) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:831:10: '=' expression
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_variableDeclaration6245); 
                    pushFollow(FOLLOW_expression_in_variableDeclaration6247);
                    expression44=expression();

                    state._fsp--;

                       
                    	        retval.vd.setInitExpresssion((expression44!=null?expression44.e:null));

                    }
                    break;

            }

            retval.vd.setSalsaSource(input.toString(retval.start,input.LT(-1)));

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "variableDeclaration"

    public static class term_return extends ParserRuleReturnScope {
        public Term t;
        public String type;
    };

    // $ANTLR start "term"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:838:1: term returns [Term t, String type] : ( '(' type ')' )? ( literal | '(' e1= expression ')' | ( 'this' ) | ( 'self' ) | v1= IDENT ( '[' index= expression ']' )* | allocation ) ( '.' v2= name (p1= actualParameters )? | ( '<-' | '!' ) v3= IDENT p2= actualParameters )? ;
    public final SalsaParser.term_return term() throws RecognitionException {
        SalsaParser.term_return retval = new SalsaParser.term_return();
        retval.start = input.LT(1);

        Token v1=null;
        Token v3=null;
        SalsaParser.expression_return e1 = null;

        SalsaParser.expression_return index = null;

        SalsaParser.name_return v2 = null;

        List<Expression> p1 = null;

        List<Expression> p2 = null;

        String type45 = null;

        Literal literal46 = null;

        SalsaParser.allocation_return allocation47 = null;


         retval.t = new Term(); int arrayDims = 0; String type = null;
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:841:5: ( ( '(' type ')' )? ( literal | '(' e1= expression ')' | ( 'this' ) | ( 'self' ) | v1= IDENT ( '[' index= expression ']' )* | allocation ) ( '.' v2= name (p1= actualParameters )? | ( '<-' | '!' ) v3= IDENT p2= actualParameters )? )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:841:9: ( '(' type ')' )? ( literal | '(' e1= expression ')' | ( 'this' ) | ( 'self' ) | v1= IDENT ( '[' index= expression ']' )* | allocation ) ( '.' v2= name (p1= actualParameters )? | ( '<-' | '!' ) v3= IDENT p2= actualParameters )?
            {
            retval.t.setLine(getLine(input));
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:842:9: ( '(' type ')' )?
            int alt23=2;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:842:10: '(' type ')'
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_term6313); 
                    pushFollow(FOLLOW_type_in_term6315);
                    type45=type();

                    state._fsp--;

                    match(input,RPAREN,FOLLOW_RPAREN_in_term6317); 
                    retval.t.setCastType(type45);

                    }
                    break;

            }

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:843:9: ( literal | '(' e1= expression ')' | ( 'this' ) | ( 'self' ) | v1= IDENT ( '[' index= expression ']' )* | allocation )
            int alt25=6;
            switch ( input.LA(1) ) {
            case FALSE:
            case NULL:
            case TRUE:
            case HEX_LITERAL:
            case DECIMAL_LITERAL:
            case OCTAL_LITERAL:
            case CHARACTER_LITERAL:
            case STRING_LITERAL:
            case FLOATING_POINT_LITERAL:
                {
                alt25=1;
                }
                break;
            case LPAREN:
                {
                alt25=2;
                }
                break;
            case THIS:
                {
                alt25=3;
                }
                break;
            case 187:
                {
                alt25=4;
                }
                break;
            case IDENT:
                {
                alt25=5;
                }
                break;
            case NEW:
                {
                alt25=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:844:13: literal
                    {
                    pushFollow(FOLLOW_literal_in_term6350);
                    literal46=literal();

                    state._fsp--;

                    retval.t.setLiteral(literal46);

                    }
                    break;
                case 2 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:845:10: '(' e1= expression ')'
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_term6363); 
                    pushFollow(FOLLOW_expression_in_term6369);
                    e1=expression();

                    state._fsp--;

                    match(input,RPAREN,FOLLOW_RPAREN_in_term6371); 
                    retval.t.setExpression((e1!=null?e1.e:null));

                    }
                    break;
                case 3 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:846:9: ( 'this' )
                    {
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:846:9: ( 'this' )
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:846:10: 'this'
                    {
                    match(input,THIS,FOLLOW_THIS_in_term6383); 

                    }

                    retval.t.setVarName("this"); retval.t.setVarType(((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType.getCanonicalName());
                    if (((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType.isActorType()) 
                    	           {System.err.println(getOutputPrefix(input) + "\"this\' is not allowed in behavior declaration");}
                               

                    }
                    break;
                case 4 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:851:12: ( 'self' )
                    {
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:851:12: ( 'self' )
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:851:13: 'self'
                    {
                    match(input,187,FOLLOW_187_in_term6419); 

                    }

                    retval.t.setVarName("self"); retval.t.setVarType(((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType.getCanonicalName());
                    if (!((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType.isActorType()) 
                                   {System.err.println(getOutputPrefix(input) + "\"self\' is not allowed in class declaration");}
                               

                    }
                    break;
                case 5 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:855:10: v1= IDENT ( '[' index= expression ']' )*
                    {
                    v1=(Token)match(input,IDENT,FOLLOW_IDENT_in_term6456); 
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:855:21: ( '[' index= expression ']' )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==LBRACK) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:855:22: '[' index= expression ']'
                    	    {
                    	    match(input,LBRACK,FOLLOW_LBRACK_in_term6459); 
                    	    pushFollow(FOLLOW_expression_in_term6465);
                    	    index=expression();

                    	    state._fsp--;

                    	    match(input,RBRACK,FOLLOW_RBRACK_in_term6467); 
                    	    retval.t.addIndexExpression((index!=null?index.e:null)); arrayDims++;

                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    	           retval.t.setVarName((v1!=null?v1.getText():null));
                    	           type = ((methodDeclaration_scope)methodDeclaration_stack.peek()).localTypes.get((v1!=null?v1.getText():null));
                    	           if (type == null)
                    	               type = ((typeDeclaration_scope)typeDeclaration_stack.peek()).fieldTypes.get((v1!=null?v1.getText():null));
                                   if (type == null) {
                                       // Check if it is a static type
                                       SymbolType st = getKnownType((v1!=null?v1.getText():null));
                                       if (st != null)
                                            type = st.getCanonicalName();
                                   }
                                   if (arrayDims > 0) {
                                        // Check the type
                                        String[] ss = type.split("\\[");
                                        if (ss.length != arrayDims + 1)
                                            System.err.println("Array dimensions are inconsisent.");
                                   }	               
                                   if (type != null) {
                    //                    if (!type.startsWith("future"))
                                            retval.t.setVarType(type);
                    //                        retval.t.setVarType(getKnownType(type).getCanonicalName());
                    //                    else
                    //                        retval.t.setVarType("future " + type);                                           
                    //                        retval.t.setVarType("future " + getKnownType(type).getCanonicalName());	                   	                   
                                   }
                                   else {
                                        System.err.println("Unable to resolve the type");
                                   }
                    	        

                    }
                    break;
                case 6 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:885:10: allocation
                    {
                    pushFollow(FOLLOW_allocation_in_term6493);
                    allocation47=allocation();

                    state._fsp--;

                    retval.t.setAllocation((allocation47!=null?allocation47.a:null));

                    }
                    break;

            }

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:887:9: ( '.' v2= name (p1= actualParameters )? | ( '<-' | '!' ) v3= IDENT p2= actualParameters )?
            int alt27=3;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==DOT) ) {
                alt27=1;
            }
            else if ( (LA27_0==LOGICAL_NOT||LA27_0==188) ) {
                alt27=2;
            }
            switch (alt27) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:888:13: '.' v2= name (p1= actualParameters )?
                    {
                    match(input,DOT,FOLLOW_DOT_in_term6526); 
                    pushFollow(FOLLOW_name_in_term6532);
                    v2=name();

                    state._fsp--;

                    retval.t.setSelector((v2!=null?input.toString(v2.start,v2.stop):null));
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:889:17: (p1= actualParameters )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==LPAREN) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:889:18: p1= actualParameters
                            {
                            pushFollow(FOLLOW_actualParameters_in_term6558);
                            p1=actualParameters();

                            state._fsp--;

                            retval.t.setActualArguments(p1);

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:892:13: ( '<-' | '!' ) v3= IDENT p2= actualParameters
                    {
                    if ( input.LA(1)==LOGICAL_NOT||input.LA(1)==188 ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    v3=(Token)match(input,IDENT,FOLLOW_IDENT_in_term6618); 
                    retval.t.setMessageName((v3!=null?v3.getText():null));
                    pushFollow(FOLLOW_actualParameters_in_term6643);
                    p2=actualParameters();

                    state._fsp--;

                       retval.t.setActualArguments(p2); 
                                        ((expression_scope)expression_stack.peek()).isSendMsg = true;
                                    

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

             retval.t.setSalsaSource(input.toString(retval.start,input.LT(-1)));
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "term"

    public static class allocation_return extends ParserRuleReturnScope {
        public Allocation a;
    };

    // $ANTLR start "allocation"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:900:1: allocation returns [Allocation a] : ( ( 'new' type actualParameters ) | ( 'new' ( primitiveType | name ) ( '[' expression ']' )+ ) );
    public final SalsaParser.allocation_return allocation() throws RecognitionException {
        SalsaParser.allocation_return retval = new SalsaParser.allocation_return();
        retval.start = input.LT(1);

        String type48 = null;

        List<Expression> actualParameters49 = null;

        String primitiveType50 = null;

        SalsaParser.name_return name51 = null;

        SalsaParser.expression_return expression52 = null;


         retval.a = new Allocation(); String temp = null; SymbolType st;
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:903:5: ( ( 'new' type actualParameters ) | ( 'new' ( primitiveType | name ) ( '[' expression ']' )+ ) )
            int alt30=2;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:904:3: ( 'new' type actualParameters )
                    {
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:904:3: ( 'new' type actualParameters )
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:904:4: 'new' type actualParameters
                    {
                    match(input,NEW,FOLLOW_NEW_in_allocation6716); 
                    pushFollow(FOLLOW_type_in_allocation6718);
                    type48=type();

                    state._fsp--;

                    pushFollow(FOLLOW_actualParameters_in_allocation6728);
                    actualParameters49=actualParameters();

                    state._fsp--;

                    retval.a.setType(type48); retval.a.setActualArguments(actualParameters49);

                    }


                    }
                    break;
                case 2 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:913:3: ( 'new' ( primitiveType | name ) ( '[' expression ']' )+ )
                    {
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:913:3: ( 'new' ( primitiveType | name ) ( '[' expression ']' )+ )
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:913:4: 'new' ( primitiveType | name ) ( '[' expression ']' )+
                    {
                    match(input,NEW,FOLLOW_NEW_in_allocation6758); 
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:914:5: ( primitiveType | name )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==BOOLEAN||LA28_0==BYTE||LA28_0==CHAR||LA28_0==DOUBLE||LA28_0==FLOAT||(LA28_0>=INT && LA28_0<=LONG)||LA28_0==SHORT||LA28_0==VOID) ) {
                        alt28=1;
                    }
                    else if ( (LA28_0==IDENT) ) {
                        alt28=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 0, input);

                        throw nvae;
                    }
                    switch (alt28) {
                        case 1 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:914:6: primitiveType
                            {
                            pushFollow(FOLLOW_primitiveType_in_allocation6765);
                            primitiveType50=primitiveType();

                            state._fsp--;

                            temp = primitiveType50;

                            }
                            break;
                        case 2 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:914:55: name
                            {
                            pushFollow(FOLLOW_name_in_allocation6773);
                            name51=name();

                            state._fsp--;

                            temp = (name51!=null?name51.value:null);

                            }
                            break;

                    }

                    retval.a.setType(temp);
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:919:5: ( '[' expression ']' )+
                    int cnt29=0;
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==LBRACK) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:919:6: '[' expression ']'
                    	    {
                    	    match(input,LBRACK,FOLLOW_LBRACK_in_allocation6800); 
                    	    pushFollow(FOLLOW_expression_in_allocation6802);
                    	    expression52=expression();

                    	    state._fsp--;

                    	    match(input,RBRACK,FOLLOW_RBRACK_in_allocation6804); 
                    	    retval.a.addExpression((expression52!=null?expression52.e:null));

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt29 >= 1 ) break loop29;
                                EarlyExitException eee =
                                    new EarlyExitException(29, input);
                                throw eee;
                        }
                        cnt29++;
                    } while (true);


                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

             retval.a.setSalsaSource(input.toString(retval.start,input.LT(-1))); retval.a.setLine(getLine(input));
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "allocation"


    // $ANTLR start "actualParameters"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:923:1: actualParameters returns [List<Expression> list] : '(' (e1= expression ( ',' e2= expression )* )? ')' ;
    public final List<Expression> actualParameters() throws RecognitionException {
        List<Expression> list = null;

        SalsaParser.expression_return e1 = null;

        SalsaParser.expression_return e2 = null;


         list = new ArrayList<Expression>();
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:925:5: ( '(' (e1= expression ( ',' e2= expression )* )? ')' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:925:9: '(' (e1= expression ( ',' e2= expression )* )? ')'
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_actualParameters6840); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:926:13: (e1= expression ( ',' e2= expression )* )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==DEC||LA32_0==INC||LA32_0==LOGICAL_NOT||(LA32_0>=LPAREN && LA32_0<=MINUS)||LA32_0==NOT||LA32_0==PLUS||LA32_0==FALSE||(LA32_0>=NEW && LA32_0<=NULL)||LA32_0==THIS||LA32_0==TRUE||(LA32_0>=IDENT && LA32_0<=FLOATING_POINT_LITERAL)||LA32_0==187) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:926:14: e1= expression ( ',' e2= expression )*
                    {
                    pushFollow(FOLLOW_expression_in_actualParameters6859);
                    e1=expression();

                    state._fsp--;

                    list.add((e1!=null?e1.e:null));
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:927:13: ( ',' e2= expression )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==COMMA) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:927:14: ',' e2= expression
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_actualParameters6876); 
                    	    pushFollow(FOLLOW_expression_in_actualParameters6882);
                    	    e2=expression();

                    	    state._fsp--;

                    	    list.add((e2!=null?e2.e:null));

                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_actualParameters6898); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return list;
    }
    // $ANTLR end "actualParameters"


    // $ANTLR start "negation"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:941:1: negation returns [NegationExpression e] : ( '~' )* term ;
    public final NegationExpression negation() throws RecognitionException {
        NegationExpression e = null;

        SalsaParser.term_return term53 = null;


         e = new NegationExpression();
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:943:5: ( ( '~' )* term )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:943:9: ( '~' )* term
            {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:943:9: ( '~' )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==NOT) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:943:10: '~'
            	    {
            	    match(input,NOT,FOLLOW_NOT_in_negation6940); 
            	    e.addOperator("~");

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            pushFollow(FOLLOW_term_in_negation6946);
            term53=term();

            state._fsp--;

            e.setTerm((term53!=null?term53.t:null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "negation"


    // $ANTLR start "unary"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:946:1: unary returns [UnaryExpression e] : ( (op= '+' | op= '-' | op= '!' | op= '++' | op= '--' ) )* negation ( (op2= '++' | op2= '--' ) )? {...}?;
    public final UnaryExpression unary() throws RecognitionException {
        UnaryExpression e = null;

        Token op=null;
        Token op2=null;
        NegationExpression negation54 = null;


         e = new UnaryExpression();
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:948:5: ( ( (op= '+' | op= '-' | op= '!' | op= '++' | op= '--' ) )* negation ( (op2= '++' | op2= '--' ) )? {...}?)
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:948:9: ( (op= '+' | op= '-' | op= '!' | op= '++' | op= '--' ) )* negation ( (op2= '++' | op2= '--' ) )? {...}?
            {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:948:9: ( (op= '+' | op= '-' | op= '!' | op= '++' | op= '--' ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==DEC||LA35_0==INC||LA35_0==LOGICAL_NOT||LA35_0==MINUS||LA35_0==PLUS) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:948:10: (op= '+' | op= '-' | op= '!' | op= '++' | op= '--' )
            	    {
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:948:10: (op= '+' | op= '-' | op= '!' | op= '++' | op= '--' )
            	    int alt34=5;
            	    switch ( input.LA(1) ) {
            	    case PLUS:
            	        {
            	        alt34=1;
            	        }
            	        break;
            	    case MINUS:
            	        {
            	        alt34=2;
            	        }
            	        break;
            	    case LOGICAL_NOT:
            	        {
            	        alt34=3;
            	        }
            	        break;
            	    case INC:
            	        {
            	        alt34=4;
            	        }
            	        break;
            	    case DEC:
            	        {
            	        alt34=5;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 34, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt34) {
            	        case 1 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:948:11: op= '+'
            	            {
            	            op=(Token)match(input,PLUS,FOLLOW_PLUS_in_unary6986); 

            	            }
            	            break;
            	        case 2 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:948:22: op= '-'
            	            {
            	            op=(Token)match(input,MINUS,FOLLOW_MINUS_in_unary6994); 

            	            }
            	            break;
            	        case 3 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:948:33: op= '!'
            	            {
            	            op=(Token)match(input,LOGICAL_NOT,FOLLOW_LOGICAL_NOT_in_unary7002); 

            	            }
            	            break;
            	        case 4 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:948:44: op= '++'
            	            {
            	            op=(Token)match(input,INC,FOLLOW_INC_in_unary7010); 

            	            }
            	            break;
            	        case 5 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:948:56: op= '--'
            	            {
            	            op=(Token)match(input,DEC,FOLLOW_DEC_in_unary7018); 

            	            }
            	            break;

            	    }

            	    e.addOperator((op!=null?op.getText():null));

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            pushFollow(FOLLOW_negation_in_unary7034);
            negation54=negation();

            state._fsp--;

            e.addExpression(negation54);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:950:9: ( (op2= '++' | op2= '--' ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==DEC||LA37_0==INC) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:950:10: (op2= '++' | op2= '--' )
                    {
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:950:10: (op2= '++' | op2= '--' )
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==INC) ) {
                        alt36=1;
                    }
                    else if ( (LA36_0==DEC) ) {
                        alt36=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 36, 0, input);

                        throw nvae;
                    }
                    switch (alt36) {
                        case 1 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:950:11: op2= '++'
                            {
                            op2=(Token)match(input,INC,FOLLOW_INC_in_unary7052); 

                            }
                            break;
                        case 2 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:950:24: op2= '--'
                            {
                            op2=(Token)match(input,DEC,FOLLOW_DEC_in_unary7060); 

                            }
                            break;

                    }

                    e.setSuffix((op2!=null?op2.getText():null));

                    }
                    break;

            }

            if ( !((op == null || op2 == null)) ) {
                throw new FailedPredicateException(input, "unary", "op == null || op2 == null");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "unary"


    // $ANTLR start "mult"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:955:1: mult returns [MultExpression e] : e1= unary ( (op= '*' | op= '/' | op= '%' ) e2= unary )* ;
    public final MultExpression mult() throws RecognitionException {
        MultExpression e = null;

        Token op=null;
        UnaryExpression e1 = null;

        UnaryExpression e2 = null;


         e = new MultExpression();
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:957:5: (e1= unary ( (op= '*' | op= '/' | op= '%' ) e2= unary )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:957:9: e1= unary ( (op= '*' | op= '/' | op= '%' ) e2= unary )*
            {
            pushFollow(FOLLOW_unary_in_mult7107);
            e1=unary();

            state._fsp--;

            e.addExpression(e1);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:958:9: ( (op= '*' | op= '/' | op= '%' ) e2= unary )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==DIV||LA39_0==MOD||LA39_0==STAR) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:959:13: (op= '*' | op= '/' | op= '%' ) e2= unary
            	    {
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:959:13: (op= '*' | op= '/' | op= '%' )
            	    int alt38=3;
            	    switch ( input.LA(1) ) {
            	    case STAR:
            	        {
            	        alt38=1;
            	        }
            	        break;
            	    case DIV:
            	        {
            	        alt38=2;
            	        }
            	        break;
            	    case MOD:
            	        {
            	        alt38=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 38, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt38) {
            	        case 1 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:959:14: op= '*'
            	            {
            	            op=(Token)match(input,STAR,FOLLOW_STAR_in_mult7139); 

            	            }
            	            break;
            	        case 2 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:959:25: op= '/'
            	            {
            	            op=(Token)match(input,DIV,FOLLOW_DIV_in_mult7147); 

            	            }
            	            break;
            	        case 3 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:959:36: op= '%'
            	            {
            	            op=(Token)match(input,MOD,FOLLOW_MOD_in_mult7155); 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_unary_in_mult7175);
            	    e2=unary();

            	    state._fsp--;

            	    e.addOperator((op!=null?op.getText():null)); e.addExpression(e2);

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "mult"


    // $ANTLR start "add"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:964:1: add returns [AddExpression e] : e1= mult ( (op= '+' | op= '-' ) e2= mult )* ;
    public final AddExpression add() throws RecognitionException {
        AddExpression e = null;

        Token op=null;
        MultExpression e1 = null;

        MultExpression e2 = null;


         e = new AddExpression(); 
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:966:5: (e1= mult ( (op= '+' | op= '-' ) e2= mult )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:966:9: e1= mult ( (op= '+' | op= '-' ) e2= mult )*
            {
            pushFollow(FOLLOW_mult_in_add7223);
            e1=mult();

            state._fsp--;

            e.addExpression(e1);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:967:9: ( (op= '+' | op= '-' ) e2= mult )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==MINUS||LA41_0==PLUS) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:968:13: (op= '+' | op= '-' ) e2= mult
            	    {
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:968:13: (op= '+' | op= '-' )
            	    int alt40=2;
            	    int LA40_0 = input.LA(1);

            	    if ( (LA40_0==PLUS) ) {
            	        alt40=1;
            	    }
            	    else if ( (LA40_0==MINUS) ) {
            	        alt40=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 40, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt40) {
            	        case 1 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:968:14: op= '+'
            	            {
            	            op=(Token)match(input,PLUS,FOLLOW_PLUS_in_add7255); 

            	            }
            	            break;
            	        case 2 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:968:25: op= '-'
            	            {
            	            op=(Token)match(input,MINUS,FOLLOW_MINUS_in_add7263); 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_mult_in_add7283);
            	    e2=mult();

            	    state._fsp--;

            	    e.addOperator((op!=null?op.getText():null)); e.addExpression(e2);

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "add"


    // $ANTLR start "relation"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:973:1: relation returns [Expression e] : e1= add ( (op= '==' | op= '!=' | op= '<' | op= '<=' | op= '>=' | op= '>' ) e2= add )* ;
    public final Expression relation() throws RecognitionException {
        Expression e = null;

        Token op=null;
        AddExpression e1 = null;

        AddExpression e2 = null;


         e = new Expression();
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:975:5: (e1= add ( (op= '==' | op= '!=' | op= '<' | op= '<=' | op= '>=' | op= '>' ) e2= add )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:975:9: e1= add ( (op= '==' | op= '!=' | op= '<' | op= '<=' | op= '>=' | op= '>' ) e2= add )*
            {
            pushFollow(FOLLOW_add_in_relation7327);
            e1=add();

            state._fsp--;

            e.addExpression(e1);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:976:9: ( (op= '==' | op= '!=' | op= '<' | op= '<=' | op= '>=' | op= '>' ) e2= add )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( ((LA43_0>=EQUAL && LA43_0<=GREATER_THAN)||(LA43_0>=LESS_OR_EQUAL && LA43_0<=LESS_THAN)||LA43_0==NOT_EQUAL) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:977:13: (op= '==' | op= '!=' | op= '<' | op= '<=' | op= '>=' | op= '>' ) e2= add
            	    {
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:977:13: (op= '==' | op= '!=' | op= '<' | op= '<=' | op= '>=' | op= '>' )
            	    int alt42=6;
            	    switch ( input.LA(1) ) {
            	    case EQUAL:
            	        {
            	        alt42=1;
            	        }
            	        break;
            	    case NOT_EQUAL:
            	        {
            	        alt42=2;
            	        }
            	        break;
            	    case LESS_THAN:
            	        {
            	        alt42=3;
            	        }
            	        break;
            	    case LESS_OR_EQUAL:
            	        {
            	        alt42=4;
            	        }
            	        break;
            	    case GREATER_OR_EQUAL:
            	        {
            	        alt42=5;
            	        }
            	        break;
            	    case GREATER_THAN:
            	        {
            	        alt42=6;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 42, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt42) {
            	        case 1 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:977:14: op= '=='
            	            {
            	            op=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_relation7360); 

            	            }
            	            break;
            	        case 2 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:977:26: op= '!='
            	            {
            	            op=(Token)match(input,NOT_EQUAL,FOLLOW_NOT_EQUAL_in_relation7368); 

            	            }
            	            break;
            	        case 3 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:977:38: op= '<'
            	            {
            	            op=(Token)match(input,LESS_THAN,FOLLOW_LESS_THAN_in_relation7376); 

            	            }
            	            break;
            	        case 4 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:977:49: op= '<='
            	            {
            	            op=(Token)match(input,LESS_OR_EQUAL,FOLLOW_LESS_OR_EQUAL_in_relation7384); 

            	            }
            	            break;
            	        case 5 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:977:61: op= '>='
            	            {
            	            op=(Token)match(input,GREATER_OR_EQUAL,FOLLOW_GREATER_OR_EQUAL_in_relation7392); 

            	            }
            	            break;
            	        case 6 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:977:73: op= '>'
            	            {
            	            op=(Token)match(input,GREATER_THAN,FOLLOW_GREATER_THAN_in_relation7400); 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_add_in_relation7420);
            	    e2=add();

            	    state._fsp--;

            	    e.addOperator((op!=null?op.getText():null)); e.addExpression(e2);

            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return e;
    }
    // $ANTLR end "relation"

    protected static class expression_scope {
        boolean isSendMsg;
    }
    protected Stack expression_stack = new Stack();

    public static class expression_return extends ParserRuleReturnScope {
        public Expression e;
        public boolean sendMessage;
    };

    // $ANTLR start "expression"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:982:1: expression returns [Expression e, boolean sendMessage] : e1= relation ( (op= '&&' | op= '||' | op= 'instanceof' ) e2= relation )* ;
    public final SalsaParser.expression_return expression() throws RecognitionException {
        expression_stack.push(new expression_scope());
        SalsaParser.expression_return retval = new SalsaParser.expression_return();
        retval.start = input.LT(1);

        Token op=null;
        Expression e1 = null;

        Expression e2 = null;


         retval.e = new Expression(); ((expression_scope)expression_stack.peek()).isSendMsg = false; 
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:991:5: (e1= relation ( (op= '&&' | op= '||' | op= 'instanceof' ) e2= relation )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:991:9: e1= relation ( (op= '&&' | op= '||' | op= 'instanceof' ) e2= relation )*
            {
            pushFollow(FOLLOW_relation_in_expression7475);
            e1=relation();

            state._fsp--;

            retval.e.addExpression(e1);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:992:9: ( (op= '&&' | op= '||' | op= 'instanceof' ) e2= relation )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==LOGICAL_AND||LA45_0==LOGICAL_OR||LA45_0==INSTANCEOF) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:993:13: (op= '&&' | op= '||' | op= 'instanceof' ) e2= relation
            	    {
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:993:13: (op= '&&' | op= '||' | op= 'instanceof' )
            	    int alt44=3;
            	    switch ( input.LA(1) ) {
            	    case LOGICAL_AND:
            	        {
            	        alt44=1;
            	        }
            	        break;
            	    case LOGICAL_OR:
            	        {
            	        alt44=2;
            	        }
            	        break;
            	    case INSTANCEOF:
            	        {
            	        alt44=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 44, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt44) {
            	        case 1 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:993:14: op= '&&'
            	            {
            	            op=(Token)match(input,LOGICAL_AND,FOLLOW_LOGICAL_AND_in_expression7509); 

            	            }
            	            break;
            	        case 2 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:993:26: op= '||'
            	            {
            	            op=(Token)match(input,LOGICAL_OR,FOLLOW_LOGICAL_OR_in_expression7517); 

            	            }
            	            break;
            	        case 3 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:993:38: op= 'instanceof'
            	            {
            	            op=(Token)match(input,INSTANCEOF,FOLLOW_INSTANCEOF_in_expression7525); 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_relation_in_expression7532);
            	    e2=relation();

            	    state._fsp--;

            	    retval.e.addOperator((op!=null?op.getText():null)); retval.e.addExpression(e2);

            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

             
                retval.e.setSalsaSource(input.toString(retval.start,input.LT(-1)));
                retval.sendMessage = ((expression_scope)expression_stack.peek()).isSendMsg; 
                retval.e.setSendMessage(((expression_scope)expression_stack.peek()).isSendMsg);
                try {retval.e.setAfterContinuation(((block_scope)block_stack.peek()).afterContinuation);} catch (Exception e){}

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            expression_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "expression"


    // $ANTLR start "literal"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1000:1: literal returns [Literal literal] : ( HEX_LITERAL | DECIMAL_LITERAL | OCTAL_LITERAL | CHARACTER_LITERAL | STRING_LITERAL | FLOATING_POINT_LITERAL | (t= 'true' | t= 'false' ) | 'null' );
    public final Literal literal() throws RecognitionException {
        Literal literal = null;

        Token t=null;
        Token HEX_LITERAL55=null;
        Token DECIMAL_LITERAL56=null;
        Token OCTAL_LITERAL57=null;
        Token CHARACTER_LITERAL58=null;
        Token STRING_LITERAL59=null;
        Token FLOATING_POINT_LITERAL60=null;

        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1001:5: ( HEX_LITERAL | DECIMAL_LITERAL | OCTAL_LITERAL | CHARACTER_LITERAL | STRING_LITERAL | FLOATING_POINT_LITERAL | (t= 'true' | t= 'false' ) | 'null' )
            int alt47=8;
            switch ( input.LA(1) ) {
            case HEX_LITERAL:
                {
                alt47=1;
                }
                break;
            case DECIMAL_LITERAL:
                {
                alt47=2;
                }
                break;
            case OCTAL_LITERAL:
                {
                alt47=3;
                }
                break;
            case CHARACTER_LITERAL:
                {
                alt47=4;
                }
                break;
            case STRING_LITERAL:
                {
                alt47=5;
                }
                break;
            case FLOATING_POINT_LITERAL:
                {
                alt47=6;
                }
                break;
            case FALSE:
            case TRUE:
                {
                alt47=7;
                }
                break;
            case NULL:
                {
                alt47=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1001:9: HEX_LITERAL
                    {
                    HEX_LITERAL55=(Token)match(input,HEX_LITERAL,FOLLOW_HEX_LITERAL_in_literal7595); 
                    literal = new Literal("int", (HEX_LITERAL55!=null?HEX_LITERAL55.getText():null));

                    }
                    break;
                case 2 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1002:9: DECIMAL_LITERAL
                    {
                    DECIMAL_LITERAL56=(Token)match(input,DECIMAL_LITERAL,FOLLOW_DECIMAL_LITERAL_in_literal7607); 
                    literal = new Literal("int", (DECIMAL_LITERAL56!=null?DECIMAL_LITERAL56.getText():null));

                    }
                    break;
                case 3 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1003:9: OCTAL_LITERAL
                    {
                    OCTAL_LITERAL57=(Token)match(input,OCTAL_LITERAL,FOLLOW_OCTAL_LITERAL_in_literal7619); 
                    literal = new Literal("int", (OCTAL_LITERAL57!=null?OCTAL_LITERAL57.getText():null));

                    }
                    break;
                case 4 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1004:9: CHARACTER_LITERAL
                    {
                    CHARACTER_LITERAL58=(Token)match(input,CHARACTER_LITERAL,FOLLOW_CHARACTER_LITERAL_in_literal7631); 
                    literal = new Literal("char", (CHARACTER_LITERAL58!=null?CHARACTER_LITERAL58.getText():null));

                    }
                    break;
                case 5 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1005:9: STRING_LITERAL
                    {
                    STRING_LITERAL59=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_literal7645); 
                    literal = new Literal("java.lang.String", (STRING_LITERAL59!=null?STRING_LITERAL59.getText():null));

                    }
                    break;
                case 6 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1006:9: FLOATING_POINT_LITERAL
                    {
                    FLOATING_POINT_LITERAL60=(Token)match(input,FLOATING_POINT_LITERAL,FOLLOW_FLOATING_POINT_LITERAL_in_literal7658); 
                    literal = new Literal("double", (FLOATING_POINT_LITERAL60!=null?FLOATING_POINT_LITERAL60.getText():null));

                    }
                    break;
                case 7 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1007:9: (t= 'true' | t= 'false' )
                    {
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1007:9: (t= 'true' | t= 'false' )
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==TRUE) ) {
                        alt46=1;
                    }
                    else if ( (LA46_0==FALSE) ) {
                        alt46=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 0, input);

                        throw nvae;
                    }
                    switch (alt46) {
                        case 1 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1007:10: t= 'true'
                            {
                            t=(Token)match(input,TRUE,FOLLOW_TRUE_in_literal7676); 

                            }
                            break;
                        case 2 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1007:23: t= 'false'
                            {
                            t=(Token)match(input,FALSE,FOLLOW_FALSE_in_literal7684); 

                            }
                            break;

                    }

                    literal = new Literal("boolean", (t!=null?t.getText():null));

                    }
                    break;
                case 8 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1008:9: 'null'
                    {
                    match(input,NULL,FOLLOW_NULL_in_literal7697); 
                    literal = new Literal("null", "null");

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return literal;
    }
    // $ANTLR end "literal"


    // $ANTLR start "type"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1011:1: type returns [String value] : ( 'future' )? ( primitiveType | name ) ( '[' ']' )* ;
    public final String type() throws RecognitionException {
        String value = null;

        String primitiveType61 = null;

        SalsaParser.name_return name62 = null;


        value = "";
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1013:5: ( ( 'future' )? ( primitiveType | name ) ( '[' ']' )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1013:9: ( 'future' )? ( primitiveType | name ) ( '[' ']' )*
            {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1013:9: ( 'future' )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==189) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1013:10: 'future'
                    {
                    match(input,189,FOLLOW_189_in_type7732); 
                    value += "future ";

                    }
                    break;

            }

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1014:9: ( primitiveType | name )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==BOOLEAN||LA49_0==BYTE||LA49_0==CHAR||LA49_0==DOUBLE||LA49_0==FLOAT||(LA49_0>=INT && LA49_0<=LONG)||LA49_0==SHORT||LA49_0==VOID) ) {
                alt49=1;
            }
            else if ( (LA49_0==IDENT) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1015:13: primitiveType
                    {
                    pushFollow(FOLLOW_primitiveType_in_type7760);
                    primitiveType61=primitiveType();

                    state._fsp--;

                     value += primitiveType61; 

                    }
                    break;
                case 2 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1016:13: name
                    {
                    pushFollow(FOLLOW_name_in_type7776);
                    name62=name();

                    state._fsp--;

                    value += (name62!=null?name62.value:null); 

                    }
                    break;

            }

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1018:9: ( '[' ']' )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==LBRACK) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1018:10: '[' ']'
            	    {
            	    match(input,LBRACK,FOLLOW_LBRACK_in_type7803); 
            	    match(input,RBRACK,FOLLOW_RBRACK_in_type7805); 
            	    value += "[]";

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "type"


    // $ANTLR start "primitiveType"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1021:1: primitiveType returns [String value] : ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' | 'void' );
    public final String primitiveType() throws RecognitionException {
        String value = null;

        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1022:5: ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' | 'void' )
            int alt51=9;
            switch ( input.LA(1) ) {
            case BOOLEAN:
                {
                alt51=1;
                }
                break;
            case CHAR:
                {
                alt51=2;
                }
                break;
            case BYTE:
                {
                alt51=3;
                }
                break;
            case SHORT:
                {
                alt51=4;
                }
                break;
            case INT:
                {
                alt51=5;
                }
                break;
            case LONG:
                {
                alt51=6;
                }
                break;
            case FLOAT:
                {
                alt51=7;
                }
                break;
            case DOUBLE:
                {
                alt51=8;
                }
                break;
            case VOID:
                {
                alt51=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1022:11: 'boolean'
                    {
                    match(input,BOOLEAN,FOLLOW_BOOLEAN_in_primitiveType7842); 
                     value = "boolean"; 

                    }
                    break;
                case 2 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1023:11: 'char'
                    {
                    match(input,CHAR,FOLLOW_CHAR_in_primitiveType7860); 
                     value = "char"; 

                    }
                    break;
                case 3 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1024:11: 'byte'
                    {
                    match(input,BYTE,FOLLOW_BYTE_in_primitiveType7881); 
                     value = "byte"; 

                    }
                    break;
                case 4 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1025:11: 'short'
                    {
                    match(input,SHORT,FOLLOW_SHORT_in_primitiveType7902); 
                     value = "short"; 

                    }
                    break;
                case 5 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1026:11: 'int'
                    {
                    match(input,INT,FOLLOW_INT_in_primitiveType7922); 
                     value = "int"; 

                    }
                    break;
                case 6 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1027:11: 'long'
                    {
                    match(input,LONG,FOLLOW_LONG_in_primitiveType7944); 
                     value = "long"; 

                    }
                    break;
                case 7 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1028:11: 'float'
                    {
                    match(input,FLOAT,FOLLOW_FLOAT_in_primitiveType7965); 
                     value = "float"; 

                    }
                    break;
                case 8 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1029:11: 'double'
                    {
                    match(input,DOUBLE,FOLLOW_DOUBLE_in_primitiveType7985); 
                     value = "double"; 

                    }
                    break;
                case 9 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler/Salsa.g:1031:11: 'void'
                    {
                    match(input,VOID,FOLLOW_VOID_in_primitiveType8005); 
                     value = "void"; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "primitiveType"

    // Delegated rules


    protected DFA8 dfa8 = new DFA8(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA30 dfa30 = new DFA30(this);
    static final String DFA8_eotS =
        "\25\uffff";
    static final String DFA8_eofS =
        "\25\uffff";
    static final String DFA8_minS =
        "\1\52\1\uffff\1\67\11\26\2\17\1\51\1\6\1\u00a4\1\uffff\1\26\1\uffff"+
        "\1\17";
    static final String DFA8_maxS =
        "\1\u00bd\1\uffff\14\u00a4\1\51\1\54\1\u00a4\1\uffff\1\u00a4\1\uffff"+
        "\1\u00a4";
    static final String DFA8_acceptS =
        "\1\uffff\1\3\17\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA8_specialS =
        "\25\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\1\14\uffff\1\3\1\uffff\1\5\2\uffff\1\4\4\uffff\1\12\6\uffff"+
            "\1\11\6\uffff\1\7\1\10\10\uffff\1\6\13\uffff\1\13\76\uffff\1"+
            "\14\30\uffff\1\2",
            "",
            "\1\3\1\uffff\1\5\2\uffff\1\4\4\uffff\1\12\6\uffff\1\11\6\uffff"+
            "\1\7\1\10\10\uffff\1\6\13\uffff\1\13\76\uffff\1\15",
            "\1\16\u008d\uffff\1\17",
            "\1\16\u008d\uffff\1\17",
            "\1\16\u008d\uffff\1\17",
            "\1\16\u008d\uffff\1\17",
            "\1\16\u008d\uffff\1\17",
            "\1\16\u008d\uffff\1\17",
            "\1\16\u008d\uffff\1\17",
            "\1\16\u008d\uffff\1\17",
            "\1\16\u008d\uffff\1\17",
            "\1\20\6\uffff\1\16\6\uffff\1\21\u0086\uffff\1\17",
            "\1\20\6\uffff\1\16\u008d\uffff\1\17",
            "\1\22",
            "\1\23\4\uffff\1\23\21\uffff\1\21\16\uffff\1\23",
            "\1\24",
            "",
            "\1\16\u008d\uffff\1\17",
            "",
            "\1\20\6\uffff\1\16\u008d\uffff\1\17"
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "()* loopback of 604:13: ( stateVariableDeclaration | methodDeclaration )*";
        }
    }
    static final String DFA9_eotS =
        "\25\uffff";
    static final String DFA9_eofS =
        "\25\uffff";
    static final String DFA9_minS =
        "\1\52\1\uffff\1\67\11\26\2\17\1\51\1\6\1\uffff\1\u00a4\1\26\1\uffff"+
        "\1\17";
    static final String DFA9_maxS =
        "\1\u00bd\1\uffff\14\u00a4\1\51\1\54\1\uffff\2\u00a4\1\uffff\1\u00a4";
    static final String DFA9_acceptS =
        "\1\uffff\1\3\16\uffff\1\2\2\uffff\1\1\1\uffff";
    static final String DFA9_specialS =
        "\25\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\1\14\uffff\1\3\1\uffff\1\5\2\uffff\1\4\4\uffff\1\12\6\uffff"+
            "\1\11\6\uffff\1\7\1\10\10\uffff\1\6\13\uffff\1\13\76\uffff\1"+
            "\14\30\uffff\1\2",
            "",
            "\1\3\1\uffff\1\5\2\uffff\1\4\4\uffff\1\12\6\uffff\1\11\6\uffff"+
            "\1\7\1\10\10\uffff\1\6\13\uffff\1\13\76\uffff\1\15",
            "\1\16\u008d\uffff\1\17",
            "\1\16\u008d\uffff\1\17",
            "\1\16\u008d\uffff\1\17",
            "\1\16\u008d\uffff\1\17",
            "\1\16\u008d\uffff\1\17",
            "\1\16\u008d\uffff\1\17",
            "\1\16\u008d\uffff\1\17",
            "\1\16\u008d\uffff\1\17",
            "\1\16\u008d\uffff\1\17",
            "\1\21\6\uffff\1\16\6\uffff\1\20\u0086\uffff\1\17",
            "\1\21\6\uffff\1\16\u008d\uffff\1\17",
            "\1\22",
            "\1\23\4\uffff\1\23\21\uffff\1\20\16\uffff\1\23",
            "",
            "\1\24",
            "\1\16\u008d\uffff\1\17",
            "",
            "\1\21\6\uffff\1\16\u008d\uffff\1\17"
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "()* loopback of 628:10: ( stateVariableDeclaration | methodDeclaration )*";
        }
    }
    static final String DFA15_eotS =
        "\16\uffff";
    static final String DFA15_eofS =
        "\16\uffff";
    static final String DFA15_minS =
        "\1\14\1\uffff\1\6\6\uffff\1\u00a4\1\14\1\6\1\u00a4\1\6";
    static final String DFA15_maxS =
        "\1\u00bd\1\uffff\1\u00bc\6\uffff\1\u00a4\1\u00bb\3\u00a4";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\3\1\4\1\5\1\6\1\7\5\uffff";
    static final String DFA15_specialS =
        "\16\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\3\10\uffff\1\3\1\uffff\1\5\3\uffff\1\3\1\uffff\2\3\3\uffff"+
            "\1\3\3\uffff\1\3\20\uffff\1\1\1\uffff\1\1\2\uffff\1\1\4\uffff"+
            "\1\1\3\uffff\1\3\2\uffff\1\1\1\10\1\6\4\uffff\2\1\1\uffff\2"+
            "\3\4\uffff\1\7\1\1\5\uffff\1\3\3\uffff\1\3\1\uffff\1\1\76\uffff"+
            "\1\2\6\3\17\uffff\1\4\1\3\1\uffff\1\1",
            "",
            "\2\3\4\uffff\2\3\1\uffff\1\11\2\uffff\4\3\1\12\1\uffff\5\3"+
            "\1\uffff\1\3\1\uffff\1\3\2\uffff\1\3\2\uffff\1\3\5\uffff\1\3"+
            "\4\uffff\1\3\32\uffff\1\3\127\uffff\1\1\27\uffff\1\3",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\13",
            "\1\3\10\uffff\1\3\5\uffff\1\3\1\uffff\2\3\3\uffff\1\3\3\uffff"+
            "\1\3\2\uffff\1\1\33\uffff\1\3\14\uffff\2\3\13\uffff\1\3\3\uffff"+
            "\1\3\100\uffff\7\3\20\uffff\1\3",
            "\2\3\4\uffff\2\3\1\uffff\1\14\2\uffff\4\3\1\1\1\uffff\3\3\1"+
            "\uffff\3\3\1\uffff\1\3\2\uffff\1\3\2\uffff\1\3\5\uffff\1\3\4"+
            "\uffff\1\3\32\uffff\1\3\127\uffff\1\1",
            "\1\15",
            "\2\3\4\uffff\2\3\1\uffff\1\14\2\uffff\4\3\1\1\1\uffff\3\3\1"+
            "\uffff\3\3\1\uffff\1\3\2\uffff\1\3\2\uffff\1\3\5\uffff\1\3\4"+
            "\uffff\1\3\32\uffff\1\3\127\uffff\1\1"
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "682:5: ( localVariableDeclaration ( ';' | '@' ) | e1= expression ( '=' e2= expression )? ( ';' | '@' ) | joinBlockStatement ( '@' ) | blockStatement | ifStatement | returnStatement ';' | forStatement )";
        }
    }
    static final String DFA23_eotS =
        "\13\uffff";
    static final String DFA23_eofS =
        "\7\uffff\1\2\3\uffff";
    static final String DFA23_minS =
        "\1\35\1\14\2\uffff\1\14\1\u00a4\1\14\1\6\1\14\1\u00a4\1\14";
    static final String DFA23_maxS =
        "\1\u00bb\1\u00bd\2\uffff\1\u00bc\1\u00a4\1\u00bb\1\u00bc\1\114\1"+
        "\u00a4\1\114";
    static final String DFA23_acceptS =
        "\2\uffff\1\2\1\1\7\uffff";
    static final String DFA23_specialS =
        "\13\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\1\47\uffff\1\2\14\uffff\2\2\13\uffff\1\2\3\uffff\1\2\100"+
            "\uffff\7\2\20\uffff\1\2",
            "\1\2\10\uffff\1\2\5\uffff\1\2\1\uffff\2\2\3\uffff\1\2\3\uffff"+
            "\1\2\20\uffff\1\3\1\uffff\1\3\2\uffff\1\3\4\uffff\1\3\3\uffff"+
            "\1\2\2\uffff\1\3\6\uffff\2\3\1\uffff\2\2\5\uffff\1\3\5\uffff"+
            "\1\2\3\uffff\1\2\1\uffff\1\3\76\uffff\1\4\6\2\20\uffff\1\2\1"+
            "\uffff\1\3",
            "",
            "",
            "\2\2\1\uffff\1\5\2\uffff\4\2\1\6\1\uffff\5\2\1\uffff\1\2\1"+
            "\uffff\1\2\2\uffff\1\2\2\uffff\1\2\4\uffff\1\7\5\uffff\1\2\32"+
            "\uffff\1\2\157\uffff\1\2",
            "\1\10",
            "\1\2\10\uffff\1\2\5\uffff\1\2\1\uffff\2\2\3\uffff\1\2\3\uffff"+
            "\1\2\2\uffff\1\3\33\uffff\1\2\14\uffff\2\2\13\uffff\1\2\3\uffff"+
            "\1\2\100\uffff\7\2\20\uffff\1\2",
            "\2\2\3\uffff\3\2\1\uffff\1\2\2\uffff\4\2\2\uffff\5\2\1\3\1"+
            "\2\1\uffff\1\2\2\uffff\1\2\2\uffff\1\2\2\uffff\1\2\1\uffff\2"+
            "\2\4\uffff\1\2\23\uffff\1\3\6\uffff\1\2\5\uffff\2\3\13\uffff"+
            "\1\3\3\uffff\1\3\100\uffff\7\3\20\uffff\1\3\1\2",
            "\2\2\1\uffff\1\11\2\uffff\4\2\1\3\1\uffff\3\2\1\uffff\3\2\1"+
            "\uffff\1\2\2\uffff\1\2\2\uffff\1\2\4\uffff\1\7\5\uffff\1\2\32"+
            "\uffff\1\2",
            "\1\12",
            "\2\2\1\uffff\1\11\2\uffff\4\2\1\3\1\uffff\3\2\1\uffff\3\2\1"+
            "\uffff\1\2\2\uffff\1\2\2\uffff\1\2\4\uffff\1\7\5\uffff\1\2\32"+
            "\uffff\1\2"
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "842:9: ( '(' type ')' )?";
        }
    }
    static final String DFA30_eotS =
        "\21\uffff";
    static final String DFA30_eofS =
        "\21\uffff";
    static final String DFA30_minS =
        "\1\122\1\67\11\26\1\17\1\uffff\1\14\1\u00a4\1\uffff\1\17";
    static final String DFA30_maxS =
        "\1\122\1\u00bd\12\35\1\uffff\1\u00bb\1\u00a4\1\uffff\1\35";
    static final String DFA30_acceptS =
        "\14\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String DFA30_specialS =
        "\21\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\1",
            "\1\2\1\uffff\1\4\2\uffff\1\3\4\uffff\1\11\6\uffff\1\10\6\uffff"+
            "\1\6\1\7\10\uffff\1\5\13\uffff\1\12\76\uffff\1\13\30\uffff\1"+
            "\14",
            "\1\15\6\uffff\1\14",
            "\1\15\6\uffff\1\14",
            "\1\15\6\uffff\1\14",
            "\1\15\6\uffff\1\14",
            "\1\15\6\uffff\1\14",
            "\1\15\6\uffff\1\14",
            "\1\15\6\uffff\1\14",
            "\1\15\6\uffff\1\14",
            "\1\15\6\uffff\1\14",
            "\1\16\6\uffff\1\15\6\uffff\1\14",
            "",
            "\1\17\10\uffff\1\17\5\uffff\1\17\1\uffff\2\17\3\uffff\1\17"+
            "\3\uffff\1\17\2\uffff\1\14\33\uffff\1\17\14\uffff\2\17\13\uffff"+
            "\1\17\3\uffff\1\17\100\uffff\7\17\20\uffff\1\17",
            "\1\20",
            "",
            "\1\16\6\uffff\1\15\6\uffff\1\14"
    };

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "900:1: allocation returns [Allocation a] : ( ( 'new' type actualParameters ) | ( 'new' ( primitiveType | name ) ( '[' expression ']' )+ ) );";
        }
    }
 

    public static final BitSet FOLLOW_moduleDeclaration_in_compilationUnit4485 = new BitSet(new long[]{0x2000000000000000L,0x0000000000004000L,0x0300000000000000L});
    public static final BitSet FOLLOW_importDeclaration_in_compilationUnit4500 = new BitSet(new long[]{0x2000000000000000L,0x0000000000004000L,0x0300000000000000L});
    public static final BitSet FOLLOW_typeDeclaration_in_compilationUnit4518 = new BitSet(new long[]{0x2000000000000002L,0x0000000000004000L,0x0300000000000000L});
    public static final BitSet FOLLOW_183_in_moduleDeclaration4545 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_name_in_moduleDeclaration4547 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_moduleDeclaration4549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_importDeclaration4574 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_name_in_importDeclaration4576 = new BitSet(new long[]{0x0000100000010000L});
    public static final BitSet FOLLOW_DOTSTAR_in_importDeclaration4589 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_importDeclaration4595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_name4622 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_DOT_in_name4635 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_IDENT_in_name4641 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_behaviorDeclaration_in_typeDeclaration4683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_typeDeclaration4695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_184_in_classDeclaration4737 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_CLASS_in_classDeclaration4749 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_IDENT_in_classDeclaration4751 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LCURLY_in_classDeclaration4782 = new BitSet(new long[]{0x1280040000000000L,0x0000002002018102L,0x2000001000000000L});
    public static final BitSet FOLLOW_stateVariableDeclaration_in_classDeclaration4800 = new BitSet(new long[]{0x1280040000000000L,0x0000002002018102L,0x2000001000000000L});
    public static final BitSet FOLLOW_methodDeclaration_in_classDeclaration4820 = new BitSet(new long[]{0x1280040000000000L,0x0000002002018102L,0x2000001000000000L});
    public static final BitSet FOLLOW_RCURLY_in_classDeclaration4847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_185_in_behaviorDeclaration4883 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_IDENT_in_behaviorDeclaration4885 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LCURLY_in_behaviorDeclaration4916 = new BitSet(new long[]{0x1280040000000000L,0x0000002002018102L,0x2000001000000000L});
    public static final BitSet FOLLOW_stateVariableDeclaration_in_behaviorDeclaration4931 = new BitSet(new long[]{0x1280040000000000L,0x0000002002018102L,0x2000001000000000L});
    public static final BitSet FOLLOW_methodDeclaration_in_behaviorDeclaration4948 = new BitSet(new long[]{0x1280040000000000L,0x0000002002018102L,0x2000001000000000L});
    public static final BitSet FOLLOW_RCURLY_in_behaviorDeclaration4976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constructorDeclaration_in_methodDeclaration5011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_messageHandlerDeclaration_in_methodDeclaration5023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_constructorDeclaration5061 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_formalParameters_in_constructorDeclaration5065 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_block_in_constructorDeclaration5067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_messageHandlerDeclaration5101 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_IDENT_in_messageHandlerDeclaration5103 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_formalParameters_in_messageHandlerDeclaration5105 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_block_in_messageHandlerDeclaration5107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURLY_in_block5148 = new BitSet(new long[]{0x1280044468A01000L,0x00000028830D8722L,0x2C0007F000000000L});
    public static final BitSet FOLLOW_statement_in_block5151 = new BitSet(new long[]{0x1280044468A01000L,0x00000028830D8722L,0x2C0007F000000000L});
    public static final BitSet FOLLOW_RCURLY_in_block5159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclaration_in_statement5221 = new BitSet(new long[]{0x0000100000000080L});
    public static final BitSet FOLLOW_SEMI_in_statement5224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_statement5228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement5246 = new BitSet(new long[]{0x00001000000000C0L});
    public static final BitSet FOLLOW_ASSIGN_in_statement5249 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_expression_in_statement5255 = new BitSet(new long[]{0x0000100000000080L});
    public static final BitSet FOLLOW_SEMI_in_statement5279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_statement5283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_joinBlockStatement_in_statement5296 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_AT_in_statement5299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blockStatement_in_statement5313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement5326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statement5338 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_statement5340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStatement_in_statement5352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_forStatement5403 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_LPAREN_in_forStatement5414 = new BitSet(new long[]{0x1280000000000000L,0x0000002002018102L,0x2000001000000000L});
    public static final BitSet FOLLOW_localVariableDeclaration_in_forStatement5429 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_forStatement5444 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_expression_in_forStatement5463 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_forStatement5465 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_expression_in_forStatement5484 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_forStatement5495 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_block_in_forStatement5505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_returnStatement5547 = new BitSet(new long[]{0x0000004468201002L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_expression_in_returnStatement5550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifStatement5602 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_LPAREN_in_ifStatement5604 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_expression_in_ifStatement5606 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_ifStatement5608 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_block_in_ifStatement5610 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_ELSE_in_ifStatement5623 = new BitSet(new long[]{0x1280004468A01000L,0x00000028830D8722L,0x2C0007F000000000L});
    public static final BitSet FOLLOW_statement_in_ifStatement5625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_186_in_joinBlockStatement5670 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_block_in_joinBlockStatement5672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_blockStatement5710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_expressionStatement5735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_formalParameters5777 = new BitSet(new long[]{0x1280080000000000L,0x0000002002018102L,0x2000001000000000L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameters5805 = new BitSet(new long[]{0x0000080000000800L});
    public static final BitSet FOLLOW_COMMA_in_formalParameters5822 = new BitSet(new long[]{0x1280000000000000L,0x0000002002018102L,0x2000001000000000L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameters5828 = new BitSet(new long[]{0x0000080000000800L});
    public static final BitSet FOLLOW_RPAREN_in_formalParameters5854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_formalParameter5888 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_IDENT_in_formalParameter5898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_localVariableDeclaration5955 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_variableDeclaration_in_localVariableDeclaration5990 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_COMMA_in_localVariableDeclaration6012 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_variableDeclaration_in_localVariableDeclaration6018 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_type_in_stateVariableDeclaration6076 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_variableDeclaration_in_stateVariableDeclaration6135 = new BitSet(new long[]{0x0000100000000800L});
    public static final BitSet FOLLOW_COMMA_in_stateVariableDeclaration6158 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_variableDeclaration_in_stateVariableDeclaration6164 = new BitSet(new long[]{0x0000100000000800L});
    public static final BitSet FOLLOW_SEMI_in_stateVariableDeclaration6197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_variableDeclaration6227 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_ASSIGN_in_variableDeclaration6245 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_expression_in_variableDeclaration6247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_term6313 = new BitSet(new long[]{0x1280000000000000L,0x0000002002018102L,0x2000001000000000L});
    public static final BitSet FOLLOW_type_in_term6315 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_term6317 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_literal_in_term6350 = new BitSet(new long[]{0x0000000008008002L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_term6363 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_expression_in_term6369 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_term6371 = new BitSet(new long[]{0x0000000008008002L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_THIS_in_term6383 = new BitSet(new long[]{0x0000000008008002L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_187_in_term6419 = new BitSet(new long[]{0x0000000008008002L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_IDENT_in_term6456 = new BitSet(new long[]{0x0000000008408002L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_LBRACK_in_term6459 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_expression_in_term6465 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RBRACK_in_term6467 = new BitSet(new long[]{0x0000000008408002L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_allocation_in_term6493 = new BitSet(new long[]{0x0000000008008002L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_DOT_in_term6526 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_name_in_term6532 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_actualParameters_in_term6558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_term6606 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_IDENT_in_term6618 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_actualParameters_in_term6643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_allocation6716 = new BitSet(new long[]{0x1280000000000000L,0x0000002002018102L,0x2000001000000000L});
    public static final BitSet FOLLOW_type_in_allocation6718 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_actualParameters_in_allocation6728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_allocation6758 = new BitSet(new long[]{0x1280000000000000L,0x0000002002018102L,0x0000001000000000L});
    public static final BitSet FOLLOW_primitiveType_in_allocation6765 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_name_in_allocation6773 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_LBRACK_in_allocation6800 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_expression_in_allocation6802 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RBRACK_in_allocation6804 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_LPAREN_in_actualParameters6840 = new BitSet(new long[]{0x0000084468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_expression_in_actualParameters6859 = new BitSet(new long[]{0x0000080000000800L});
    public static final BitSet FOLLOW_COMMA_in_actualParameters6876 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_expression_in_actualParameters6882 = new BitSet(new long[]{0x0000080000000800L});
    public static final BitSet FOLLOW_RPAREN_in_actualParameters6898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_negation6940 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_term_in_negation6946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_unary6986 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_MINUS_in_unary6994 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_LOGICAL_NOT_in_unary7002 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_INC_in_unary7010 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_DEC_in_unary7018 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_negation_in_unary7034 = new BitSet(new long[]{0x0000000000201002L});
    public static final BitSet FOLLOW_INC_in_unary7052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEC_in_unary7060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_in_mult7107 = new BitSet(new long[]{0x0002000100002002L});
    public static final BitSet FOLLOW_STAR_in_mult7139 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_DIV_in_mult7147 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_MOD_in_mult7155 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_unary_in_mult7175 = new BitSet(new long[]{0x0002000100002002L});
    public static final BitSet FOLLOW_mult_in_add7223 = new BitSet(new long[]{0x0000004040000002L});
    public static final BitSet FOLLOW_PLUS_in_add7255 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_MINUS_in_add7263 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_mult_in_add7283 = new BitSet(new long[]{0x0000004040000002L});
    public static final BitSet FOLLOW_add_in_relation7327 = new BitSet(new long[]{0x00000008031C0002L});
    public static final BitSet FOLLOW_EQUAL_in_relation7360 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_NOT_EQUAL_in_relation7368 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_LESS_THAN_in_relation7376 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_LESS_OR_EQUAL_in_relation7384 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_GREATER_OR_EQUAL_in_relation7392 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_GREATER_THAN_in_relation7400 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_add_in_relation7420 = new BitSet(new long[]{0x00000008031C0002L});
    public static final BitSet FOLLOW_relation_in_expression7475 = new BitSet(new long[]{0x0000000014000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_LOGICAL_AND_in_expression7509 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_LOGICAL_OR_in_expression7517 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_INSTANCEOF_in_expression7525 = new BitSet(new long[]{0x0000004468201000L,0x00000008800C0020L,0x080007F000000000L});
    public static final BitSet FOLLOW_relation_in_expression7532 = new BitSet(new long[]{0x0000000014000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_HEX_LITERAL_in_literal7595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECIMAL_LITERAL_in_literal7607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OCTAL_LITERAL_in_literal7619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARACTER_LITERAL_in_literal7631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_literal7645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOATING_POINT_LITERAL_in_literal7658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_literal7676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_literal7684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_literal7697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_189_in_type7732 = new BitSet(new long[]{0x1280000000000000L,0x0000002002018102L,0x0000001000000000L});
    public static final BitSet FOLLOW_primitiveType_in_type7760 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_name_in_type7776 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_LBRACK_in_type7803 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RBRACK_in_type7805 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_BOOLEAN_in_primitiveType7842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_in_primitiveType7860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTE_in_primitiveType7881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHORT_in_primitiveType7902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_primitiveType7922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_primitiveType7944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_primitiveType7965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_primitiveType7985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOID_in_primitiveType8005 = new BitSet(new long[]{0x0000000000000002L});

}