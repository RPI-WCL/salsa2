grammar Salsa;

options {
  language = Java;
//  backtrack=true; 
//  memoize=true;
//  output   = AST;
//  ASTLabelType = CommonTree;
}

tokens {

    // operators and other special chars
    
    AND                     = '&'               ;
    AND_ASSIGN              = '&='              ;
    ASSIGN                  = '='               ;
    AT                      = '@'               ;
    BIT_SHIFT_RIGHT         = '>>>'             ;
    BIT_SHIFT_RIGHT_ASSIGN  = '>>>='            ;
    COLON                   = ':'               ;
    COMMA                   = ','               ;
    DEC                     = '--'              ;
    DIV                     = '/'               ;
    DIV_ASSIGN              = '/='              ;
    DOT                     = '.'               ;
    DOTSTAR                 = '.*'              ;
    ELLIPSIS                = '...'             ;
    EQUAL                   = '=='              ;
    GREATER_OR_EQUAL        = '>='              ;
    GREATER_THAN            = '>'               ;
    INC                     = '++'              ;
    LBRACK                  = '['               ;
    LCURLY                  = '{'               ;
    LESS_OR_EQUAL           = '<='              ;
    LESS_THAN               = '<'               ;
    LOGICAL_AND             = '&&'              ;
    LOGICAL_NOT             = '!'               ;
    LOGICAL_OR              = '||'              ;
    LPAREN                  = '('               ;
    MINUS                   = '-'               ;
    MINUS_ASSIGN            = '-='              ;
    MOD                     = '%'               ;
    MOD_ASSIGN              = '%='              ;
    NOT                     = '~'               ;
    NOT_EQUAL               = '!='              ;
    OR                      = '|'               ;
    OR_ASSIGN               = '|='              ;
    PLUS                    = '+'               ;
    PLUS_ASSIGN             = '+='              ;
    QUESTION                = '?'               ;
    RBRACK                  = ']'               ;
    RCURLY                  = '}'               ;
    RPAREN                  = ')'               ;
    SEMI                    = ';'               ;
    SHIFT_LEFT              = '<<'              ;
    SHIFT_LEFT_ASSIGN       = '<<='             ;
    SHIFT_RIGHT             = '>>'              ;
    SHIFT_RIGHT_ASSIGN      = '>>='             ;
    STAR                    = '*'               ;
    STAR_ASSIGN             = '*='              ;
    XOR                     = '^'               ;
    XOR_ASSIGN              = '^='              ;

    // keywords
    
    ABSTRACT                = 'abstract'        ;
    ASSERT                  = 'assert'          ;
    BOOLEAN                 = 'boolean'         ;
    BREAK                   = 'break'           ;
    BYTE                    = 'byte'            ;
    CASE                    = 'case'            ;
    CATCH                   = 'catch'           ;
    CHAR                    = 'char'            ;
    CLASS                   = 'class'           ;
    CONTINUE                = 'continue'        ;
    DEFAULT                 = 'default'         ;
    DO                      = 'do'              ;
    DOUBLE                  = 'double'          ;
    ELSE                    = 'else'            ;
    ENUM                    = 'enum'            ;
    EXTENDS                 = 'extends'         ;
    FALSE                   = 'false'           ;
    FINAL                   = 'final'           ;
    FINALLY                 = 'finally'         ;
    FLOAT                   = 'float'           ;
    FOR                     = 'for'             ;
    IF                      = 'if'              ;
    IMPLEMENTS              = 'implements'      ;
    INSTANCEOF              = 'instanceof'      ;
    INTERFACE               = 'interface'       ;
    IMPORT                  = 'import'          ;
    INT                     = 'int'             ;
    LONG                    = 'long'            ;
    NATIVE                  = 'native'          ;
    NEW                     = 'new'             ;
    NULL                    = 'null'            ;
    PACKAGE                 = 'package'         ;
    PRIVATE                 = 'private'         ;
    PROTECTED               = 'protected'       ;
    PUBLIC                  = 'public'          ;
    RETURN                  = 'return'          ;
    SHORT                   = 'short'           ;
    STATIC                  = 'static'          ;
    STRICTFP                = 'strictfp'        ;
    SUPER                   = 'super'           ;
    SWITCH                  = 'switch'          ;
    SYNCHRONIZED            = 'synchronized'    ;
    THIS                    = 'this'            ;
    THROW                   = 'throw'           ;
    THROWS                  = 'throws'          ;
    TRANSIENT               = 'transient'       ;
    TRUE                    = 'true'            ;
    TRY                     = 'try'             ;
    VOID                    = 'void'            ;
    VOLATILE                = 'volatile'        ;
    WHILE                   = 'while'           ;
    
    // tokens for imaginary nodes
    
    ANNOTATION_INIT_ARRAY_ELEMENT;
    ANNOTATION_INIT_BLOCK;
    ANNOTATION_INIT_DEFAULT_KEY;
    ANNOTATION_INIT_KEY_LIST;
    ANNOTATION_LIST;
    ANNOTATION_METHOD_DECL;
    ANNOTATION_SCOPE;
    ANNOTATION_TOP_LEVEL_SCOPE;
    ARGUMENT_LIST;
    ARRAY_DECLARATOR;
    ARRAY_DECLARATOR_LIST;
    ARRAY_ELEMENT_ACCESS;
    ARRAY_INITIALIZER;
    BLOCK_SCOPE;
    CAST_EXPR;
    CATCH_CLAUSE_LIST;
    CLASS_CONSTRUCTOR_CALL;
    CLASS_INSTANCE_INITIALIZER;
    CLASS_STATIC_INITIALIZER;
    CLASS_TOP_LEVEL_SCOPE;
    CONSTRUCTOR_DECL;
    ENUM_TOP_LEVEL_SCOPE;
    EXPR;
    EXTENDS_BOUND_LIST;
    EXTENDS_CLAUSE;
    FOR_CONDITION;
    FOR_EACH;
    FOR_INIT;
    FOR_UPDATE;
    FORMAL_PARAM_LIST;
    FORMAL_PARAM_STD_DECL;
    FORMAL_PARAM_VARARG_DECL;
    FUNCTION_METHOD_DECL;
    GENERIC_TYPE_ARG_LIST;
    GENERIC_TYPE_PARAM_LIST;
    INTERFACE_TOP_LEVEL_SCOPE;
    IMPLEMENTS_CLAUSE;
    LABELED_STATEMENT;
    LOCAL_MODIFIER_LIST;
    JAVA_SOURCE;
    METHOD_CALL;
    MODIFIER_LIST;
    PARENTESIZED_EXPR;
    POST_DEC;
    POST_INC;
    PRE_DEC;
    PRE_INC;
    QUALIFIED_TYPE_IDENT;
    STATIC_ARRAY_CREATOR;
    SUPER_CONSTRUCTOR_CALL;
    SWITCH_BLOCK_LABEL_LIST;
    THIS_CONSTRUCTOR_CALL;
    THROWS_CLAUSE;
    TYPE;
    UNARY_MINUS;
    UNARY_PLUS;
    VAR_DECLARATION;
    VAR_DECLARATOR;
    VAR_DECLARATOR_LIST;
    VOID_METHOD_DECL;
}


@header {
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
}

@members {

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
          if (fpe.predicateText.equals("{getKnownType(moduleName + \".\" + \$IDENT.text) != null}?")) {
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
}


@lexer::header {
package salsa.compiler;
import salsa.compiler.definitions.*;
}

@lexer::members {
/** 
 *  Determines if whitespaces and comments should be preserved or thrown away.
 *
 *  If <code>true</code> whitespaces and comments will be preserved within the
 *  hidden channel, otherwise the appropriate tokens will be skiped. This is
 *  a 'little bit' expensive, of course. If only one of the two behaviours is
 *  needed forever the lexer part of the grammar should be changed by replacing 
 *  the 'if-else' stuff within the approprate lexer grammar actions.
 */
public boolean preserveWhitespacesAndComments = false;
}


// Parser begins

compilationUnit returns [CompilationUnit cu]
//scope{ boolean isClassDef; }
@init{
    $cu = new CompilationUnit();
//    SymbolType st = new SymbolType("primitive");
}
//@after{ $cu.setKnownTypes(knownTypes);}
    :   (moduleDeclaration {$cu.setModuleName($moduleDeclaration.value); moduleName = $moduleDeclaration.value;})?
        (importDeclaration {$cu.addImport($importDeclaration.value);} {addImportType($importDeclaration.value)}? )*
        (typeDeclaration {$cu.addTypeDeclaration($typeDeclaration.td); $typeDeclaration.td.setModuleName(moduleName);})+
    ;

moduleDeclaration returns [String value]
    :   'module' name ';' {$value = $name.value;}
    ;

importDeclaration returns [String value]
    :   'import' name {$value = $name.value;}
        ('.*' {$value += ".*";})? ';'
    ;

name returns [String value]
    :   t1 = IDENT {$value = $t1.text;}
        ('.' t2 = IDENT {$value += "." + $t2.text;})* 
    ;
    
typeDeclaration returns [TypeDeclaration td]
scope { Map<String, String> fieldTypes; SymbolType currentType;} 
@init {
    $typeDeclaration::fieldTypes = new HashMap<String, String>();
}
    :   behaviorDeclaration {$td = $behaviorDeclaration.bd;}
    |   classDeclaration {$td = $classDeclaration.cd;}
    ;   
    
classDeclaration returns [ClassDeclaration cd] 
@init{ $cd = new ClassDeclaration(); }
    :   (im = 'immutable')?
        'class' IDENT 
        {   $cd.setName($IDENT.text); 
            $typeDeclaration::currentType = new SymbolType(moduleName + "." + $IDENT.text);
            if ($im != null) $typeDeclaration::currentType.setImmutable(true); 
            if (getKnownType(moduleName + "." + $IDENT.text) != null) {
                System.err.println("line " + getLine(input) + ": Duplicated type definition\n\t" + $classDeclaration.text);
                mHasErrors = true;
            }
        }
        {            
            knownTypes.put(moduleName + "." + $IDENT.text, $typeDeclaration::currentType);  
            knownTypes.put($IDENT.text, $typeDeclaration::currentType);  
            $typeDeclaration::fieldTypes.put("this", $IDENT.text);
       }
        '{'
            (   stateVariableDeclaration {$cd.addStateVariableDeclaration($stateVariableDeclaration.sd);}
            |   methodDeclaration {$cd.addMethodDeclaration($methodDeclaration.m);}
            )*
        '}'
    ;    
    
behaviorDeclaration returns [BehaviorDeclaration bd] 
@init{ $bd = new BehaviorDeclaration();}
    :   'behavior' IDENT 
        {   $bd.setName($IDENT.text); 
            $typeDeclaration::currentType = new SymbolType(moduleName + "." + $IDENT.text, true);
            if (getKnownType(moduleName + "." + $IDENT.text) != null) {
                System.err.println("line " + getLine(input) + ": Duplicated type definition\n\t" + $behaviorDeclaration.text);
                mHasErrors = true;
            }
        }
        {
            knownTypes.put(moduleName + "." + $IDENT.text, $typeDeclaration::currentType);  
            knownTypes.put($IDENT.text, $typeDeclaration::currentType);  
            $typeDeclaration::fieldTypes.put("self", $IDENT.text);
            $typeDeclaration::fieldTypes.put("token", "Token");
            $bd.setLine(getLine(input));
        }
        '{'
	        (   stateVariableDeclaration {$bd.addStateVariableDeclaration($stateVariableDeclaration.sd);}
	        |   methodDeclaration{$bd.addMethodDeclaration($methodDeclaration.m);}
	        )*     
        '}'
    ;    

methodDeclaration returns [MethodDeclaration m]
scope{Map<String, String> localTypes;}
@init{ $methodDeclaration::localTypes = new HashMap<String, String>(); }
    :   (constructorDeclaration {$m = $constructorDeclaration.cd;}
    |   messageHandlerDeclaration {$m = $messageHandlerDeclaration.md;})
        {$m.setClassDef(!$typeDeclaration::currentType.isActorType());}
    ;

constructorDeclaration returns [ConstructorDeclaration cd]  
    :   IDENT {int ln = getLine(input);} formalParameters block
        {   $cd = new ConstructorDeclaration($IDENT.text, $formalParameters.list, $block.b);
            $cd.setLine(ln);
        }
//        {$typeDeclaration::currentType.getSimpleName().equals($IDENT.text)}?
    ;

messageHandlerDeclaration returns [MessageHandlerDeclaration md]
    :   type IDENT formalParameters block
        {
            $md = new MessageHandlerDeclaration($type.value, $IDENT.text, $formalParameters.list, $block.b);
            List<FormalParameter> list = $formalParameters.list;
            List<String> typeList = new ArrayList<String>();
            for (FormalParameter fp : list) {
                typeList.add(fp.getType());
            }
            SymbolMethod sm = new SymbolMethod($IDENT.text, $type.value, typeList.toArray(new String[0]));
            $md.setSymbolMethod(sm);
            $typeDeclaration::currentType.addMethod(sm);
        }
    ;


block returns [Block b]
scope{ boolean afterContinuation;}
@init{ $b = new Block(); $block::afterContinuation = false;}
    :   '{' (statement  {$b.addStatement($statement.stat); } )* '}'
    ;        
    
    
statement returns [Statement stat]
@init{boolean isContinuation = false; }
@after{ 
    $block::afterContinuation = isContinuation; 
    $stat.setContinuation(isContinuation);
    $stat.setClassDef(!$typeDeclaration::currentType.isActorType());
    try{$stat.setInJoinBlock($joinBlockStatement::isInJoinBlock);}catch(Exception e){}
}
    : {int ln = getLine(input);}
    (
        localVariableDeclaration (';' | '@'{isContinuation=true;}) {$stat = $localVariableDeclaration.ld;}
    |   e1 = expression ('=' e2 = expression)? 
        {   if(e2 == null) 
                $stat = new ExpressionStatement($e1.e); 
            else {
                $stat = new AssignmentStatement($e1.e, $e2.e);
             }
        }
        (';' | '@'{isContinuation=true;}) 
    |   joinBlockStatement ('@')  { $stat = $joinBlockStatement.s; isContinuation=true;}
    |   blockStatement  {$stat = $blockStatement.s;}
    |   ifStatement {$stat = $ifStatement.s;}
    |   returnStatement ';' {$stat = $returnStatement.s; }
    |   forStatement {$stat = $forStatement.s; }
    )
    {$stat.setLine(ln);}
    {$stat.setSalsaSource($statement.text);}
    ;   
    
forStatement returns [ForStatement s] 
    :   'for' 
        '(' 
            localVariableDeclaration 
            ';' 
            e1 = expression ';' 
            e2 = expression 
        ')'
        block
        {
            $s = new ForStatement($localVariableDeclaration.ld, $e1.e, $e2.e, $block.b);
        }    
    ;     

returnStatement returns [ReturnStatement s]
    :   'return' (expression)? 
        {   $expression.e.setReturnStatement(true);
            $s = new ReturnStatement($expression.e); }
    ;

//assignmentStatement returns [AssignmentStatement s]
//@init {$s = new AssignmentStatement();}
//    :   
//        IDENT 
//        ('['  e1=expression ']' {$s.addIndex($e1.e);})*
//        '='
//        e2 = expression {
//            $s.setVariable($IDENT.text);
//            $s.setExpression($e2.e);;
//        }
//    ;

ifStatement returns [IfStatement s]
@init{$s = new IfStatement();}
    :   'if' '(' expression ')' block {$s.setExpression($expression.e); $s.setBlock($block.b);}
        ('else' statement {$s.setElseStatement($statement.stat);})?
    ;
    
joinBlockStatement returns [JoinBlockStatement s]
scope { boolean isInJoinBlock;}
@init{ $joinBlockStatement::isInJoinBlock = true;}
@after { $joinBlockStatement::isInJoinBlock = false;} 
    :   'join' block {$s = new JoinBlockStatement($block.b);}
    ;    

blockStatement returns [BlockStatement s]         
    :   block {$s = new BlockStatement($block.b);}
    ;

expressionStatement returns [ExpressionStatement s]
    :   expression 
        {$s = new ExpressionStatement($expression.e);}
    ;
    
formalParameters returns [List<FormalParameter> list]
@init{ $list = new ArrayList<FormalParameter>(); }
    :   '('
        (
            f1 = formalParameter { $list.add($f1.fp); }
            (',' f2 = formalParameter {$list.add($f2.fp);} )*
        )?
        ')'
    ;


formalParameter returns [FormalParameter fp]
@init {SymbolType st;}
@after { $fp.setSalsaSource($formalParameter.text); $fp.setLine(getLine(input));$fp.analyze(null); }
    :   type
        IDENT { $fp = new FormalParameter($type.value, $IDENT.text);}
        {$methodDeclaration::localTypes.put($IDENT.text, $type.value);}
        
    ;
    
    
localVariableDeclaration returns [LocalVariableDeclaration ld, String canonicalType]
@init{ $ld = new LocalVariableDeclaration(); String rawType; SymbolType st;}
    :   type 
//        {
//            rawType = $type.value;
//            st = getKnownType(rawType);
//        }  
//        {if (!(st != null)) { System.err.println(getOutputPrefix(input) + "Unknown type " + $type.value);}}  
//        {   $canonicalType = st.getCanonicalName();
//            if (rawType.startsWith("future"))
//                $canonicalType = "future " + $canonicalType;
//        }

        {$canonicalType = $type.value;}
        v1 = variableDeclaration[$canonicalType]
        { $ld.addVariableDeclaration($v1.vd); $methodDeclaration::localTypes.put($v1.value, $canonicalType);}
        (',' v2 = variableDeclaration[$canonicalType] 
        { $ld.addVariableDeclaration($v2.vd); $methodDeclaration::localTypes.put($v2.value, $canonicalType);})*        
    ;     
    
stateVariableDeclaration returns [StateVariableDeclaration sd, String canonicalType]
@init{ $sd = new StateVariableDeclaration(); String rawType; SymbolType st;}
    :   type
//        {!$type.value.startsWith("future")}?
        {if (!(!$type.value.startsWith("future")))
        { System.err.println(getOutputPrefix(input) + "future type is not allowed in the field");}
        }          
        {
            rawType = $type.value;
            st = getKnownType(rawType);
        }
//        { st != null}?
//        {if (!(st != null)) { System.err.println(getOutputPrefix(input) + "Unknown type " + $type.value);}}  
//        {!$typeDeclaration::currentType.isImmutable() || st.isImmutable()}?
        {$canonicalType = $type.value;} 
        v1 = variableDeclaration[$canonicalType] 
        { 
            $sd.addVariableDeclaration($v1.vd); 
            $typeDeclaration::fieldTypes.put($v1.value, $canonicalType);
            $typeDeclaration::currentType.addField(new SymbolField($v1.value, $canonicalType));
        }
        (',' v2 = variableDeclaration[$canonicalType] 
        { 
	        $sd.addVariableDeclaration($v2.vd); 
	        $typeDeclaration::fieldTypes.put($v2.value, $canonicalType);
	        $typeDeclaration::currentType.addField(new SymbolField($v2.value, $canonicalType));	        
        }
        )*
        ';'
    ;

variableDeclaration[String type] returns [VariableDeclaration vd, String value]
@init{ $vd = new VariableDeclaration(); $vd.setType(type); }  
    :   IDENT {$vd.setName($IDENT.text); $value=$IDENT.text; $vd.setLine(getLine(input));}     
        ('=' expression {   
	        $vd.setInitExpresssion($expression.e);}
        )?
        {$vd.setSalsaSource($variableDeclaration.text);}
    ;


term returns [Term t, String type]
@init{ $t = new Term(); int arrayDims = 0; String type = null;}
@after{ $t.setSalsaSource($term.text);}
    :   {$t.setLine(getLine(input));}
        ('(' type ')' {$t.setCastType($type.value);})?     //cast
        (
            literal {$t.setLiteral($literal.literal);}
	    |   '(' e1 = expression ')'{$t.setExpression($e1.e);}
	    |  ('this') 
	       {$t.setVarName("this"); $t.setVarType($typeDeclaration::currentType.getCanonicalName());}
	       {if ($typeDeclaration::currentType.isActorType()) 
	           {System.err.println(getOutputPrefix(input) + "\"this\' is not allowed in behavior declaration");}
           }
        |  ('self') {$t.setVarName("self"); $t.setVarType($typeDeclaration::currentType.getCanonicalName());}
            {if (!$typeDeclaration::currentType.isActorType()) 
               {System.err.println(getOutputPrefix(input) + "\"self\' is not allowed in class declaration");}
           }	    
	    |   v1 = IDENT ('[' index = expression ']' {$t.addIndexExpression($index.e); arrayDims++;})*
	        {
	           $t.setVarName($v1.text);
	           type = $methodDeclaration::localTypes.get($v1.text);
	           if (type == null)
	               type = $typeDeclaration::fieldTypes.get($v1.text);
               if (type == null) {
                   // Check if it is a static type
                   SymbolType st = getKnownType($v1.text);
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
                        $t.setVarType(type);
//                        $t.setVarType(getKnownType(type).getCanonicalName());
//                    else
//                        $t.setVarType("future " + type);                                           
//                        $t.setVarType("future " + getKnownType(type).getCanonicalName());	                   	                   
               }
               else {
                    System.err.println("Unable to resolve the type");
               }
	        }
	    |   allocation {$t.setAllocation($allocation.a);}
	    )
        (
            '.' v2 = name {$t.setSelector($v2.text);} 
                (p1 = actualParameters {$t.setActualArguments($p1.list);})?
                
        |   
            ('<-' | '!') v3 = IDENT {$t.setMessageName($v3.text);} 
                p2 = actualParameters 
                {   $t.setActualArguments($p2.list); 
                    $expression::isSendMsg = true;
                }
        )?	       
    ;

allocation returns [Allocation a]
@init{ $a = new Allocation(); String temp = null; SymbolType st;}
@after{ $a.setSalsaSource($allocation.text); $a.setLine(getLine(input));}
    :   
		('new' type 
//	       {st = getKnownType($type.value);}
//	       {st != null}?
		   actualParameters 
//		   {$a.setType(st.getCanonicalName()); $a.setActualArguments($actualParameters.list);}
           {$a.setType($type.value); $a.setActualArguments($actualParameters.list);} 
//		   {getKnownType($type.value) != null}?
		)
		|
		('new'
		  (primitiveType {temp = $primitiveType.value;}  |  name {temp = $name.value;})
//		  {st = getKnownType(temp);}
//		  {st != null}? 
//		  {$a.setType(st.getCanonicalName());}
          {$a.setType(temp);}  
		  ('[' expression ']' {$a.addExpression($expression.e);} )+
		)
    ;

actualParameters returns [List<Expression> list]
@init{ $list = new ArrayList<Expression>();}
    :   '('
            (e1 = expression {$list.add($e1.e);}
            (',' e2 = expression {$list.add($e2.e);})*)?
        ')'
    ;
    
//dot returns [DotExpression e, String type]
//@init{ $e = new DotExpression();}
//@after{ $type = $e.getType(); }
//    :   t1 = term {$e.addTerm($t1.term);} 
//        (
//            (op = '.')
//            t2 = term {$e.addTerm($t2.term);} 
//        )*
//    ;    

negation returns [NegationExpression e]
@init{ $e = new NegationExpression();}
    :   ('~' {$e.addOperator("~");})* term {$e.setTerm($term.t);}
    ;
    
unary returns [UnaryExpression e]
@init { $e = new UnaryExpression();}
    :   ((op = '+' | op = '-' | op = '!' | op = '++' | op = '--') {$e.addOperator($op.text);})* 
        negation {$e.addExpression($negation.e);}
        ((op2 = '++' | op2 = '--') {$e.setSuffix($op2.text);})?
        {op == null || op2 == null}?
    ;


mult returns [MultExpression e]
@init{ $e = new MultExpression();}
    :   e1 = unary {$e.addExpression($e1.e);} 
        (
            (op = '*' | op = '/' | op = '%') 
            e2 = unary {$e.addOperator($op.text); $e.addExpression($e2.e);}
        )*
    ;
    
add returns [AddExpression e]
@init{ $e = new AddExpression(); }
    :   e1 = mult {$e.addExpression($e1.e);} 
        (
            (op = '+' | op = '-') 
            e2 = mult {$e.addOperator($op.text); $e.addExpression($e2.e);}
        )*
    ;

relation returns [Expression e]
@init{ $e = new Expression();}
    :   e1 = add  {$e.addExpression($e1.e);} 
        (
            (op = '==' | op = '!=' | op = '<' | op = '<=' | op = '>=' | op = '>') 
            e2 = add {$e.addOperator($op.text); $e.addExpression($e2.e);}
        )*
    ;
    
expression returns [Expression e, boolean sendMessage]
scope{ boolean isSendMsg;}
@init{ $e = new Expression(); $expression::isSendMsg = false; }
@after{ 
    $e.setSalsaSource($expression.text);
    $sendMessage = $expression::isSendMsg; 
    $e.setSendMessage($expression::isSendMsg);
    try {$e.setAfterContinuation($block::afterContinuation);} catch (Exception e){}
}
    :   e1 = relation   {$e.addExpression($e1.e);} 
        (
            (op = '&&' | op = '||' | op = 'instanceof') e2 = relation 
            {$e.addOperator($op.text); $e.addExpression($e2.e);}
            
        )*
    ;


literal returns [Literal literal]
    :   HEX_LITERAL {$literal = new Literal("int", $HEX_LITERAL.text);}
    |   DECIMAL_LITERAL {$literal = new Literal("int", $DECIMAL_LITERAL.text);}
    |   OCTAL_LITERAL {$literal = new Literal("int", $OCTAL_LITERAL.text);}
    |   CHARACTER_LITERAL   {$literal = new Literal("char", $CHARACTER_LITERAL.text);}
    |   STRING_LITERAL  {$literal = new Literal("java.lang.String", $STRING_LITERAL.text);}
    |   FLOATING_POINT_LITERAL  {$literal = new Literal("double", $FLOATING_POINT_LITERAL.text);}
    |   (t = 'true' | t = 'false') {$literal = new Literal("boolean", $t.text);}
    |   'null'    {$literal = new Literal("null", "null");}
    ;

type returns [String value]
@init {$value = "";} 
    :   ('future' {$value += "future ";})?
        (
            primitiveType { $value += $primitiveType.value; }
        |   name {$value += $name.value; }
        )    
        ('[' ']' {$value += "[]";})*
    ;        

primitiveType returns [String value]
    :     'boolean'     { $value = "boolean"; }
        | 'char'        { $value = "char"; }
        | 'byte'        { $value = "byte"; }
        | 'short'       { $value = "short"; }
        | 'int'         { $value = "int"; }
        | 'long'        { $value = "long"; }
        | 'float'       { $value = "float"; }
        | 'double'      { $value = "double"; }
//        | 'String'      { $value = "String"; }
        | 'void'        { $value = "void"; }
    ;

// LEXER

HEX_LITERAL : '0' ('x'|'X') HEX_DIGIT+ INTEGER_TYPE_SUFFIX? ;

DECIMAL_LITERAL : ('0' | '1'..'9' '0'..'9'*) INTEGER_TYPE_SUFFIX? ;

OCTAL_LITERAL : '0' ('0'..'7')+ INTEGER_TYPE_SUFFIX? ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
INTEGER_TYPE_SUFFIX : ('l'|'L') ;

FLOATING_POINT_LITERAL
    :   ('0'..'9')+ 
        (
            DOT ('0'..'9')* EXPONENT? FLOAT_TYPE_SUFFIX?
        |   EXPONENT FLOAT_TYPE_SUFFIX?
        |   FLOAT_TYPE_SUFFIX
        )
    |   DOT ('0'..'9')+ EXPONENT? FLOAT_TYPE_SUFFIX?
    ;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
FLOAT_TYPE_SUFFIX : ('f'|'F'|'d'|'D') ;

CHARACTER_LITERAL
    :   '\'' ( ESCAPE_SEQUENCE | ~('\''|'\\') ) '\''
    ;

STRING_LITERAL
    :  '"' ( ESCAPE_SEQUENCE | ~('\\'|'"') )* '"'
    ;

fragment
ESCAPE_SEQUENCE
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESCAPE
    |   OCTAL_ESCAPE
    ;

fragment
OCTAL_ESCAPE
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESCAPE
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;

//BOOLEAN_LITERAL :   'true' | 'false';


IDENT 
    :   Letter (Letter|JavaIDDigit)*
    ;

/**I found this char range in JavaCC's grammar, but Letter and Digit overlap.
   Still works, but...
 */
fragment
Letter
    :  '\u0024' |
       '\u0041'..'\u005a' |
       '\u005f' |
       '\u0061'..'\u007a' |
       '\u00c0'..'\u00d6' |
       '\u00d8'..'\u00f6' |
       '\u00f8'..'\u00ff' |
       '\u0100'..'\u1fff' |
       '\u3040'..'\u318f' |
       '\u3300'..'\u337f' |
       '\u3400'..'\u3d2d' |
       '\u4e00'..'\u9fff' |
       '\uf900'..'\ufaff'
    ;

fragment
JavaIDDigit
    :  '\u0030'..'\u0039' |
       '\u0660'..'\u0669' |
       '\u06f0'..'\u06f9' |
       '\u0966'..'\u096f' |
       '\u09e6'..'\u09ef' |
       '\u0a66'..'\u0a6f' |
       '\u0ae6'..'\u0aef' |
       '\u0b66'..'\u0b6f' |
       '\u0be7'..'\u0bef' |
       '\u0c66'..'\u0c6f' |
       '\u0ce6'..'\u0cef' |
       '\u0d66'..'\u0d6f' |
       '\u0e50'..'\u0e59' |
       '\u0ed0'..'\u0ed9' |
       '\u1040'..'\u1049'
   ;

    
WS  :  (' '|'\r'|'\t'|'\u000C'|'\n') {$channel=HIDDEN;}
    ;    

COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/'
    {   
        if (!preserveWhitespacesAndComments) {
            skip();
        } else {
            $channel = HIDDEN;
        }
    }
    ;

LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n'
    {   
        if (!preserveWhitespacesAndComments) {
            skip();
        } else {
            $channel = HIDDEN;
        }
    }
    ;
