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
//    THIS                    = 'this'            ;
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
package salsa.compiler2;
import salsa.compiler2.definitions.*;
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

    
    public static int getLine(IntStream input) {
        Token token;    
        int line = -1;
        if ( input instanceof TokenStream ) {
            token = ((TokenStream)input).LT(1);
            line = token.getLine();
        }
        else if ( input instanceof CharStream ) {
            line = ((CharStream)input).getLine();
        }
        return line;
    }
    
    private String getOutputPrefix(IntStream input) {
        return "line " + getLine(input) + ": ";
    }
    
    
//    Map<String, String> staticTypes = new HashMap<String, String>();





	Stack<String> paraphrases = new Stack<String>();
	public String getErrorMessage(RecognitionException e, String[] tokenNames) {
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
        }
        super.emitErrorMessage(pMessage);
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
package salsa.compiler2;
import salsa.compiler2.definitions.*;
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
@init{
    enableErrorMessageCollection(true);
    $cu = new CompilationUnit();
}
    :   (moduleDeclaration {$cu.setModuleName($moduleDeclaration.value); moduleName = $moduleDeclaration.value;})?
        (importDeclaration {$cu.addImport($importDeclaration.value);})* 
        (typeDeclaration {$cu.addTypeDeclaration($typeDeclaration.td);})+
    ;

moduleDeclaration returns [String value]
    :   'module' qualifiedName ';' {$value = $qualifiedName.text;}
    ;

importDeclaration returns [String value]
    :   'import' qualifiedName {$value = $qualifiedName.text;}
        ('.*' {$value += ".*";})? ';'
    ;

   
qualifiedNameList 
    :   qualifiedName
        (',' qualifiedName
        )*
    ;    

qualifiedName 
    :   IDENT
        ('.' IDENT)* 
    ;
    
modifiers  
    :
    (   'public'
    |   'protected'
    |   'private'
    |   'static'
    |   'abstract'
    |   'final'
    |   'native'
    |   'synchronized'
    |   'transient'
    |   'volatile'
    |   'strictfp'
    )*
    ;

variableModifiers 
    :   (   'final'
        )*
    ;    

typeList 
    :   type
        (',' type
        )*
    ;
    
type
    :   ('Token')?
        (
            primitiveType
        |   qualifiedName
        )    
        ('[' ']')*
    ;        

primitiveType  
    :   'boolean'
    |   'char'
    |   'byte'
    |   'short'
    |   'int'
    |   'long'
    |   'float'
    |   'double'
    |   'void'
    ;
    
typeDeclaration returns [TypeDeclaration td]
scope{ SymbolType currentType;}
@after { $td.setModuleName(moduleName);}
    :   behaviorDeclaration {$td = $behaviorDeclaration.bd;}
    |   classDeclaration {$td = $classDeclaration.cd;}
    |   interfaceDeclaration {$td = $interfaceDeclaration.in;}
    ;   
    
interfaceDeclaration returns [InterfaceDeclaration in]
@init{ $in = new InterfaceDeclaration(); } 
    :   modifiers 'interface' IDENT
        ('extends' typeList)?
        '{'
            (   fieldVariableDeclaration {$in.addFieldVariableDeclaration($fieldVariableDeclaration.sd);}
            |   intefaceMethodDeclaration {$in.addMethodDeclaration($intefaceMethodDeclaration.m);}
            )*
        '}'
    ;              
    
classDeclaration returns [ClassDeclaration cd] 
@init{ $cd = new ClassDeclaration(); }
    :   modifiers 'class' IDENT
        ('extends' type)?
        ('implements' typeList)?
        {   $cd.setName($IDENT.text); 
            String canonicalName = moduleName + "." + $IDENT.text;
            $typeDeclaration::currentType = new SymbolType(canonicalName, SymbolType.OBJECT_TYPE);
            CompilerHelper.addInitKnownType($typeDeclaration::currentType);
            $cd.setSymbolType($typeDeclaration::currentType);        
        }
        '{'
            (   fieldVariableDeclaration {$cd.addFieldVariableDeclaration($fieldVariableDeclaration.sd);}
            |   constructorDeclaration {$cd.addMethodDeclaration($constructorDeclaration.cd);}
            |   classMethodDeclaration {$cd.addMethodDeclaration($classMethodDeclaration.cd);}
            )*
        '}'
    ;    
    
behaviorDeclaration returns [BehaviorDeclaration bd] 
@init{ $bd = new BehaviorDeclaration();}
    :   modifiers 'behavior' IDENT 
        ('extends' type)?
        ('implements' typeList)?
        {   $bd.setName($IDENT.text); 
            String canonicalName = moduleName + "." + $IDENT.text;
            $typeDeclaration::currentType = new SymbolType(canonicalName, SymbolType.ACTOR_TYPE);
            CompilerHelper.addInitKnownType($typeDeclaration::currentType);
            $bd.setSymbolType($typeDeclaration::currentType);
        }
        '{'
	        (   fieldVariableDeclaration {$bd.addFieldVariableDeclaration($fieldVariableDeclaration.sd);}
	        |   constructorDeclaration {$bd.addMethodDeclaration($constructorDeclaration.cd);}
	        |   messageHandlerDeclaration{$bd.addMethodDeclaration($messageHandlerDeclaration.md);}
	        )*     
        '}'
    ;    
    
intefaceMethodDeclaration returns [InterfaceMethodDeclaration m] 
    :    modifiers type IDENT formalParameters ('throws' qualifiedNameList )? ';'
        {
            $m = new InterfaceMethodDeclaration();
//            List<FormalParameter> list = $formalParameters.list;
//            List<String> typeList = new ArrayList<String>();
//            for (FormalParameter fp : list) {
//                typeList.add(fp.getType());
//            }
//            SymbolMethod sm = new SymbolMethod($IDENT.text, "", typeList.toArray(new String[0]));
//            $m.setSymbolMethod(sm);
//            $typeDeclaration::currentType.addMethod(sm);
        }                
    ;        

classMethodDeclaration returns [ClassMethodDeclaration cd]
    :   modifiers type IDENT formalParameters ('throws' qualifiedNameList)?
        block
        {
            $cd = new ClassMethodDeclaration($modifiers.text, $type.text, $IDENT.text, $formalParameters.list, $block.b);
//            List<FormalParameter> list = $formalParameters.list;
//            List<String> typeList = new ArrayList<String>();
//            for (FormalParameter fp : list) {   
//                typeList.add(fp.getType());
//            }
//            SymbolMethod sm = new SymbolMethod($IDENT.text, $type.text, typeList.toArray(new String[0]));
//            $cd.setSymbolMethod(sm);
//            $typeDeclaration::currentType.addMethod(sm);
        }
    ;
    
constructorDeclaration returns [ConstructorDeclaration cd]  
    :   modifiers IDENT {int ln = getLine(input);} formalParameters block
        {   $cd = new ConstructorDeclaration($modifiers.text, $IDENT.text, $formalParameters.list, $block.b);
            $cd.setLine(ln);
//            List<FormalParameter> list = $formalParameters.list;
//            List<String> typeList = new ArrayList<String>();
//            for (FormalParameter fp : list) {
//                typeList.add(fp.getType());
//            }
//            SymbolMethod sm = new SymbolMethod($IDENT.text, "", typeList.toArray(new String[0]));
//            $cd.setSymbolMethod(sm);
//            $typeDeclaration::currentType.addMethod(sm);            
        }
    ;

messageHandlerDeclaration returns [MessageHandlerDeclaration md]
    :   modifiers type IDENT formalParameters 
        block
        {
            $md = new MessageHandlerDeclaration($modifiers.text, $type.text, $IDENT.text, $formalParameters.list, $block.b);
//            String returnType = CompilerHelper.TOKEN + " " + $type.text;
//            List<FormalParameter> list = $formalParameters.list;
//            List<String> typeList = new ArrayList<String>();
//            for (FormalParameter fp : list) {   
//                typeList.add(fp.getType());
//            }
//            SymbolMethod sm = new SymbolMethod($IDENT.text, returnType, typeList.toArray(new String[0]));
//            $md.setSymbolMethod(sm);
//            $typeDeclaration::currentType.addMethod(sm);
        }
    ;


block returns [Block b]
@init{ 
    $b = new Block();
    boolean isPreviousLineContinuation = false;   
}
    :   '{' (statement  
        {
            if ($statement.stat != null) {
                $b.addStatement($statement.stat);
                $statement.stat.setAfterContinuation(isPreviousLineContinuation);
                isPreviousLineContinuation = $statement.stat.isInContinuation();
            }
            } 
        )* 
        '}'
    ;        
    
    
statement returns [Statement stat]
scope{boolean isSendMessage;}
@init{boolean isContinuation = false; $statement::isSendMessage = false;}
@after{ 
    $stat.setInContinuation(isContinuation);
    $stat.setSendMessage($statement::isSendMessage);
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
    |   whileStatement {$stat = $whileStatement.s; }
    |   doWhileStatement ';' {$stat = $doWhileStatement.s; }
    |   breakStatement ';' {$stat = $breakStatement.s; }
    |   continueStatement ';' {$stat = $continueStatement.s; }
    |   tryStatement {$stat = $tryStatement.s; }
    |   throwStatement ';' {$stat = $throwStatement.s; }
    |   switchStatement {$stat = $switchStatement.s; }
    )
    {$stat.setLine(ln);}
    {$stat.setSalsaSource($statement.text);}
    ;
    
doWhileStatement returns [DoWhileStatement s]
    :   'do' st = statement 'while' '(' e = expression ')'
        {$s = new DoWhileStatement($st.stat, $e.e);}
    ;    
    
whileStatement returns [WhileStatement s] 
    :   'while' '(' e = expression ')' st = statement
        {$s = new WhileStatement($e.e, $st.stat);}
    ;

throwStatement returns [ThrowStatement s]    
    :   'throw' e = expression
        {$s = new ThrowStatement($e.e);}
    ;
    
breakStatement returns [BreakStatement s]
@init {$s = new BreakStatement();}
    :   'break'
    ;
   
    
continueStatement returns [ContinueStatement s]
@init {$s = new ContinueStatement();}
    :   'continue'
    ;
    
tryStatement returns [TryStatement s]
@init {$s = new TryStatement(); }
    :   'try'   b1 = block {$s.setTryBlock($b1.b);}
        (   'catch' '(' fp = formalParameter ')' b2 = block
            {$s.addCatchBlock($b2.b); $s.addCatchFP($fp.fp);}
        )*
        (   'finally' b3 = block 
            {$s.setFinallyBlock($b3.b);}
        )?
    ;        
    
switchStatement returns [SwitchStatement s]
    :   'switch' '(' expression ')'
        '{'
            (switchBlockStatementGroup)*
        '}'    
    ;        

switchBlockStatementGroup 
    :
        switchLabel
        (blockStatement
        )*
    ;

switchLabel 
    :   'case' expression ':'
    |   'default' ':'
    ;


forStatement returns [ForStatement s] 
    :   'for' 
        '(' 
            (localVariableDeclaration)? 
            ';' 
            (e1 = expression)? ';' 
            (e2 = expression)? 
        ')'
        st = statement
        {
            $s = new ForStatement($localVariableDeclaration.ld, $e1.e, $e2.e, $st.stat);
        }    
    ;     

returnStatement returns [ReturnStatement s]
    :   'return' (expression)? 
        { $s = new ReturnStatement($expression.e); }
    ;

ifStatement returns [IfStatement s]
@init{$s = new IfStatement();}
    :   'if' '(' expression ')' s1 = statement {$s.setExpression($expression.e); $s.setIfStatement($s1.stat);}
        ('else' s2 = statement {$s.setElseStatement($s2.stat);})?
    ;
    
joinBlockStatement returns [JoinBlockStatement s]
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
@after { $fp.setSalsaSource($formalParameter.text); $fp.setLine(getLine(input));}
    :   type
        IDENT { $fp = new FormalParameter($type.text, $IDENT.text);}
    ;
    
    
localVariableDeclaration returns [LocalVariableDeclaration ld, String canonicalType]
@init{ $ld = new LocalVariableDeclaration(); String rawType; SymbolType st;}
    :   type 
        v1 = variableDeclaration[$type.text]
        { 
            $v1.vd.setType($type.text);       
            $ld.addVariableDeclaration($v1.vd);
        }
        (',' v2 = variableDeclaration[$type.text] 
            { $v2.vd.setType($type.text);
              $ld.addVariableDeclaration($v2.vd);}
        )*
    ;     
    
fieldVariableDeclaration returns [FieldVariableDeclaration sd, String canonicalType]
@init{ $sd = new FieldVariableDeclaration(); String rawType; SymbolType st;}
    :   modifiers type
        v1 = variableDeclaration[$type.text] 
        {
            $v1.vd.setType($type.text); 
            $v1.vd.setModifiers($modifiers.text);         
            $sd.addVariableDeclaration($v1.vd);
            SymbolField sf = new SymbolField($v1.vd.getName(), $type.text);
            $typeDeclaration::currentType.addField(sf);
        }
        (',' v2 = variableDeclaration[$type.text] 
        {
            $v2.vd.setType($type.text); 
            $v2.vd.setModifiers($modifiers.text);         
	        $sd.addVariableDeclaration($v2.vd);
            sf = new SymbolField($v2.vd.getName(), $type.text);
            $typeDeclaration::currentType.addField(sf);
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


term returns [Term t]
@init{ $t = new Term(); int arrayDims = 0; String type = null;}
@after{ $t.setSalsaSource($term.text);}
    :   {$t.setLine(getLine(input));}
        ('(' type ')' {$t.setCastType($type.text);})?     //cast
        (
            literal {$t.setLiteral($literal.literal);}
	    |   '(' e1 = expression ')'{$t.setExpression($e1.e);}
	    |   v1 = IDENT ('[' index = expression ']' {$t.addIndexExpression($index.e); arrayDims++;})*
	        { $t.setVarName($v1.text); }
	    |   allocation {$t.setAllocation($allocation.a);}
	    )
//	    (
//            '.' v2 = IDENT {$t.setSelector($v2.text);} 
//                (p1 = actualParameters {$t.setActualArguments($p1.list);})?
//        )*
//        (   ('<-' | '!') v3 = IDENT {$t.setMessageName($v3.text);} 
//                p2 = actualParameters 
//                {   $t.setActualArguments($p2.list); 
//                    $statement::isSendMessage = true;
//                 }
//        )?
             
        (
            '.' v2 = qualifiedName {$t.setSelector($v2.text);} 
                (p1 = actualParameters {$t.setActualArguments($p1.list);})?
                
        |   
            ('<-' | '!') v3 = IDENT {$t.setMessageName($v3.text);} 
                p2 = actualParameters 
                {   $t.setActualArguments($p2.list); 
                    $statement::isSendMessage = true;
                }
        )? 
    ;

allocation returns [Allocation a]
@init{ $a = new Allocation(); String temp = null;}
@after{ $a.setSalsaSource($allocation.text); $a.setLine(getLine(input));}
    :   
        // Normal Object
		'new' type  actualParameters 
		{$a.setType($type.text); $a.setActualArguments($actualParameters.list);}  
		('at' 
		      '(' uan=expression (',' host=expression 
		          {$a.setHostExpression($host.e);})? 
		      ')'
		      {$a.setUANExpression($uan.e);}
		)?
		|
		// Array
		('new' (primitiveType {temp = $primitiveType.text;}  |  qualifiedName {temp = $qualifiedName.text;})
          {$a.setType(temp);}  
		  ('[' expression ']' {$a.addExpression($expression.e);})+
		)
    ;

actualParameters returns [List<Expression> list]
@init{ $list = new ArrayList<Expression>();}
    :   '('
            (e1 = expression {$list.add($e1.e);}
            (',' e2 = expression {$list.add($e2.e);})*)?
        ')'
    ;
    

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
            (op = '*' | op = '/' | op = '%' | op = '*=' | op = '/=') 
            e2 = unary {$e.addOperator($op.text); $e.addExpression($e2.e);}
        )*
    ;
    
add returns [AddExpression e]
@init{ $e = new AddExpression(); }
    :   e1 = mult {$e.addExpression($e1.e);} 
        (
            (op = '+' | op = '-' | op = '+=' | op = '-=') 
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
    
expression returns [Expression e]
@init{ $e = new Expression(); }
@after{ 
    $e.setSalsaSource($expression.text);
}
    :   
        {$e.setLine(getLine(input));}
        e1 = relation   {$e.addExpression($e1.e);} 
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

    