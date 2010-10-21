// $ANTLR 3.2 Sep 23, 2009 12:02:23 /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g 2010-10-20 16:07:19

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SalsaParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "AND_ASSIGN", "ASSIGN", "AT", "BIT_SHIFT_RIGHT", "BIT_SHIFT_RIGHT_ASSIGN", "COLON", "COMMA", "DEC", "DIV", "DIV_ASSIGN", "DOT", "DOTSTAR", "ELLIPSIS", "EQUAL", "GREATER_OR_EQUAL", "GREATER_THAN", "INC", "LBRACK", "LCURLY", "LESS_OR_EQUAL", "LESS_THAN", "LOGICAL_AND", "LOGICAL_NOT", "LOGICAL_OR", "LPAREN", "MINUS", "MINUS_ASSIGN", "MOD", "MOD_ASSIGN", "NOT", "NOT_EQUAL", "OR", "OR_ASSIGN", "PLUS", "PLUS_ASSIGN", "QUESTION", "RBRACK", "RCURLY", "RPAREN", "SEMI", "SHIFT_LEFT", "SHIFT_LEFT_ASSIGN", "SHIFT_RIGHT", "SHIFT_RIGHT_ASSIGN", "STAR", "STAR_ASSIGN", "XOR", "XOR_ASSIGN", "ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE", "CASE", "CATCH", "CHAR", "CLASS", "CONTINUE", "DEFAULT", "DO", "DOUBLE", "ELSE", "ENUM", "EXTENDS", "FALSE", "FINAL", "FINALLY", "FLOAT", "FOR", "IF", "IMPLEMENTS", "INSTANCEOF", "INTERFACE", "IMPORT", "INT", "LONG", "NATIVE", "NEW", "NULL", "PACKAGE", "PRIVATE", "PROTECTED", "PUBLIC", "RETURN", "SHORT", "STATIC", "STRICTFP", "SUPER", "SWITCH", "SYNCHRONIZED", "THIS", "THROW", "THROWS", "TRANSIENT", "TRUE", "TRY", "VOID", "VOLATILE", "WHILE", "ANNOTATION_INIT_ARRAY_ELEMENT", "ANNOTATION_INIT_BLOCK", "ANNOTATION_INIT_DEFAULT_KEY", "ANNOTATION_INIT_KEY_LIST", "ANNOTATION_LIST", "ANNOTATION_METHOD_DECL", "ANNOTATION_SCOPE", "ANNOTATION_TOP_LEVEL_SCOPE", "ARGUMENT_LIST", "ARRAY_DECLARATOR", "ARRAY_DECLARATOR_LIST", "ARRAY_ELEMENT_ACCESS", "ARRAY_INITIALIZER", "BLOCK_SCOPE", "CAST_EXPR", "CATCH_CLAUSE_LIST", "CLASS_CONSTRUCTOR_CALL", "CLASS_INSTANCE_INITIALIZER", "CLASS_STATIC_INITIALIZER", "CLASS_TOP_LEVEL_SCOPE", "CONSTRUCTOR_DECL", "ENUM_TOP_LEVEL_SCOPE", "EXPR", "EXTENDS_BOUND_LIST", "EXTENDS_CLAUSE", "FOR_CONDITION", "FOR_EACH", "FOR_INIT", "FOR_UPDATE", "FORMAL_PARAM_LIST", "FORMAL_PARAM_STD_DECL", "FORMAL_PARAM_VARARG_DECL", "FUNCTION_METHOD_DECL", "GENERIC_TYPE_ARG_LIST", "GENERIC_TYPE_PARAM_LIST", "INTERFACE_TOP_LEVEL_SCOPE", "IMPLEMENTS_CLAUSE", "LABELED_STATEMENT", "LOCAL_MODIFIER_LIST", "JAVA_SOURCE", "METHOD_CALL", "MODIFIER_LIST", "PARENTESIZED_EXPR", "POST_DEC", "POST_INC", "PRE_DEC", "PRE_INC", "QUALIFIED_TYPE_IDENT", "STATIC_ARRAY_CREATOR", "SUPER_CONSTRUCTOR_CALL", "SWITCH_BLOCK_LABEL_LIST", "THIS_CONSTRUCTOR_CALL", "THROWS_CLAUSE", "TYPE", "UNARY_MINUS", "UNARY_PLUS", "VAR_DECLARATION", "VAR_DECLARATOR", "VAR_DECLARATOR_LIST", "VOID_METHOD_DECL", "IDENT", "HEX_LITERAL", "DECIMAL_LITERAL", "OCTAL_LITERAL", "CHARACTER_LITERAL", "STRING_LITERAL", "FLOATING_POINT_LITERAL", "HEX_DIGIT", "INTEGER_TYPE_SUFFIX", "EXPONENT", "FLOAT_TYPE_SUFFIX", "ESCAPE_SEQUENCE", "UNICODE_ESCAPE", "OCTAL_ESCAPE", "Letter", "JavaIDDigit", "WS", "COMMENT", "LINE_COMMENT", "'module'", "'Token'", "'behavior'", "'join'", "'<-'", "'at'"
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
    public String getGrammarFileName() { return "/media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g"; }



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
    		if(e instanceof FailedPredicateException){
    		  FailedPredicateException fpe = (FailedPredicateException)e;
              if (fpe.predicateText.contains("Token"))
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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:328:1: compilationUnit returns [CompilationUnit cu] : ( moduleDeclaration )? ( importDeclaration )* ( typeDeclaration )+ ;
    public final CompilationUnit compilationUnit() throws RecognitionException {
        CompilationUnit cu = null;

        String moduleDeclaration1 = null;

        String importDeclaration2 = null;

        TypeDeclaration typeDeclaration3 = null;



            cu = new CompilationUnit();

        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:332:5: ( ( moduleDeclaration )? ( importDeclaration )* ( typeDeclaration )+ )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:332:9: ( moduleDeclaration )? ( importDeclaration )* ( typeDeclaration )+
            {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:332:9: ( moduleDeclaration )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==183) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:332:10: moduleDeclaration
                    {
                    pushFollow(FOLLOW_moduleDeclaration_in_compilationUnit4483);
                    moduleDeclaration1=moduleDeclaration();

                    state._fsp--;

                    cu.setModuleName(moduleDeclaration1); moduleName = moduleDeclaration1;

                    }
                    break;

            }

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:333:9: ( importDeclaration )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==IMPORT) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:333:10: importDeclaration
            	    {
            	    pushFollow(FOLLOW_importDeclaration_in_compilationUnit4498);
            	    importDeclaration2=importDeclaration();

            	    state._fsp--;

            	    cu.addImport(importDeclaration2);

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:334:9: ( typeDeclaration )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==ABSTRACT||LA3_0==BOOLEAN||LA3_0==BYTE||(LA3_0>=CHAR && LA3_0<=CLASS)||LA3_0==DOUBLE||LA3_0==FINAL||LA3_0==FLOAT||LA3_0==INTERFACE||(LA3_0>=INT && LA3_0<=NATIVE)||(LA3_0>=PRIVATE && LA3_0<=PUBLIC)||(LA3_0>=SHORT && LA3_0<=STRICTFP)||LA3_0==SYNCHRONIZED||LA3_0==TRANSIENT||(LA3_0>=VOID && LA3_0<=VOLATILE)||LA3_0==IDENT||(LA3_0>=184 && LA3_0<=185)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:334:10: typeDeclaration
            	    {
            	    pushFollow(FOLLOW_typeDeclaration_in_compilationUnit4514);
            	    typeDeclaration3=typeDeclaration();

            	    state._fsp--;

            	    cu.addTypeDeclaration(typeDeclaration3);

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:337:1: moduleDeclaration returns [String value] : 'module' qualifiedName ';' ;
    public final String moduleDeclaration() throws RecognitionException {
        String value = null;

        SalsaParser.qualifiedName_return qualifiedName4 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:338:5: ( 'module' qualifiedName ';' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:338:9: 'module' qualifiedName ';'
            {
            match(input,183,FOLLOW_183_in_moduleDeclaration4541); 
            pushFollow(FOLLOW_qualifiedName_in_moduleDeclaration4543);
            qualifiedName4=qualifiedName();

            state._fsp--;

            match(input,SEMI,FOLLOW_SEMI_in_moduleDeclaration4545); 
            value = (qualifiedName4!=null?input.toString(qualifiedName4.start,qualifiedName4.stop):null);

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:341:1: importDeclaration returns [String value] : 'import' qualifiedName ( '.*' )? ';' ;
    public final String importDeclaration() throws RecognitionException {
        String value = null;

        SalsaParser.qualifiedName_return qualifiedName5 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:342:5: ( 'import' qualifiedName ( '.*' )? ';' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:342:9: 'import' qualifiedName ( '.*' )? ';'
            {
            match(input,IMPORT,FOLLOW_IMPORT_in_importDeclaration4570); 
            pushFollow(FOLLOW_qualifiedName_in_importDeclaration4572);
            qualifiedName5=qualifiedName();

            state._fsp--;

            value = (qualifiedName5!=null?input.toString(qualifiedName5.start,qualifiedName5.stop):null);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:343:9: ( '.*' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==DOTSTAR) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:343:10: '.*'
                    {
                    match(input,DOTSTAR,FOLLOW_DOTSTAR_in_importDeclaration4585); 
                    value += ".*";

                    }
                    break;

            }

            match(input,SEMI,FOLLOW_SEMI_in_importDeclaration4591); 

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


    // $ANTLR start "qualifiedNameList"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:347:1: qualifiedNameList : qualifiedName ( ',' qualifiedName )* ;
    public final void qualifiedNameList() throws RecognitionException {
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:348:5: ( qualifiedName ( ',' qualifiedName )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:348:9: qualifiedName ( ',' qualifiedName )*
            {
            pushFollow(FOLLOW_qualifiedName_in_qualifiedNameList4615);
            qualifiedName();

            state._fsp--;

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:349:9: ( ',' qualifiedName )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==COMMA) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:349:10: ',' qualifiedName
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_qualifiedNameList4626); 
            	    pushFollow(FOLLOW_qualifiedName_in_qualifiedNameList4628);
            	    qualifiedName();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
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
        return ;
    }
    // $ANTLR end "qualifiedNameList"

    public static class qualifiedName_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "qualifiedName"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:353:1: qualifiedName : IDENT ( '.' IDENT )* ;
    public final SalsaParser.qualifiedName_return qualifiedName() throws RecognitionException {
        SalsaParser.qualifiedName_return retval = new SalsaParser.qualifiedName_return();
        retval.start = input.LT(1);

        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:354:5: ( IDENT ( '.' IDENT )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:354:9: IDENT ( '.' IDENT )*
            {
            match(input,IDENT,FOLLOW_IDENT_in_qualifiedName4663); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:355:9: ( '.' IDENT )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==DOT) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:355:10: '.' IDENT
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_qualifiedName4674); 
            	    match(input,IDENT,FOLLOW_IDENT_in_qualifiedName4676); 

            	    }
            	    break;

            	default :
            	    break loop6;
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
    // $ANTLR end "qualifiedName"

    public static class modifiers_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "modifiers"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:358:1: modifiers : ( 'public' | 'protected' | 'private' | 'static' | 'abstract' | 'final' | 'native' | 'synchronized' | 'transient' | 'volatile' | 'strictfp' )* ;
    public final SalsaParser.modifiers_return modifiers() throws RecognitionException {
        SalsaParser.modifiers_return retval = new SalsaParser.modifiers_return();
        retval.start = input.LT(1);

        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:359:5: ( ( 'public' | 'protected' | 'private' | 'static' | 'abstract' | 'final' | 'native' | 'synchronized' | 'transient' | 'volatile' | 'strictfp' )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:360:5: ( 'public' | 'protected' | 'private' | 'static' | 'abstract' | 'final' | 'native' | 'synchronized' | 'transient' | 'volatile' | 'strictfp' )*
            {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:360:5: ( 'public' | 'protected' | 'private' | 'static' | 'abstract' | 'final' | 'native' | 'synchronized' | 'transient' | 'volatile' | 'strictfp' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==ABSTRACT||LA7_0==FINAL||LA7_0==NATIVE||(LA7_0>=PRIVATE && LA7_0<=PUBLIC)||(LA7_0>=STATIC && LA7_0<=STRICTFP)||LA7_0==SYNCHRONIZED||LA7_0==TRANSIENT||LA7_0==VOLATILE) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:
            	    {
            	    if ( input.LA(1)==ABSTRACT||input.LA(1)==FINAL||input.LA(1)==NATIVE||(input.LA(1)>=PRIVATE && input.LA(1)<=PUBLIC)||(input.LA(1)>=STATIC && input.LA(1)<=STRICTFP)||input.LA(1)==SYNCHRONIZED||input.LA(1)==TRANSIENT||input.LA(1)==VOLATILE ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // $ANTLR end "modifiers"


    // $ANTLR start "variableModifiers"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:374:1: variableModifiers : ( 'final' )* ;
    public final void variableModifiers() throws RecognitionException {
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:375:5: ( ( 'final' )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:375:9: ( 'final' )*
            {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:375:9: ( 'final' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==FINAL) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:375:13: 'final'
            	    {
            	    match(input,FINAL,FOLLOW_FINAL_in_variableModifiers4841); 

            	    }
            	    break;

            	default :
            	    break loop8;
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
        return ;
    }
    // $ANTLR end "variableModifiers"


    // $ANTLR start "typeList"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:379:1: typeList : type ( ',' type )* ;
    public final void typeList() throws RecognitionException {
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:380:5: ( type ( ',' type )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:380:9: type ( ',' type )*
            {
            pushFollow(FOLLOW_type_in_typeList4876);
            type();

            state._fsp--;

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:381:9: ( ',' type )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==COMMA) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:381:10: ',' type
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_typeList4887); 
            	    pushFollow(FOLLOW_type_in_typeList4889);
            	    type();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
        return ;
    }
    // $ANTLR end "typeList"

    public static class type_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "type"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:385:1: type : ( 'Token' )? ( primitiveType | qualifiedName ) ( '[' ']' )* ;
    public final SalsaParser.type_return type() throws RecognitionException {
        SalsaParser.type_return retval = new SalsaParser.type_return();
        retval.start = input.LT(1);

        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:386:5: ( ( 'Token' )? ( primitiveType | qualifiedName ) ( '[' ']' )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:386:9: ( 'Token' )? ( primitiveType | qualifiedName ) ( '[' ']' )*
            {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:386:9: ( 'Token' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==184) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:386:10: 'Token'
                    {
                    match(input,184,FOLLOW_184_in_type4924); 

                    }
                    break;

            }

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:387:9: ( primitiveType | qualifiedName )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==BOOLEAN||LA11_0==BYTE||LA11_0==CHAR||LA11_0==DOUBLE||LA11_0==FLOAT||(LA11_0>=INT && LA11_0<=LONG)||LA11_0==SHORT||LA11_0==VOID) ) {
                alt11=1;
            }
            else if ( (LA11_0==IDENT) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:388:13: primitiveType
                    {
                    pushFollow(FOLLOW_primitiveType_in_type4950);
                    primitiveType();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:389:13: qualifiedName
                    {
                    pushFollow(FOLLOW_qualifiedName_in_type4964);
                    qualifiedName();

                    state._fsp--;


                    }
                    break;

            }

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:391:9: ( '[' ']' )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==LBRACK) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:391:10: '[' ']'
            	    {
            	    match(input,LBRACK,FOLLOW_LBRACK_in_type4989); 
            	    match(input,RBRACK,FOLLOW_RBRACK_in_type4991); 

            	    }
            	    break;

            	default :
            	    break loop12;
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
    // $ANTLR end "type"

    public static class primitiveType_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "primitiveType"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:394:1: primitiveType : ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' | 'void' );
    public final SalsaParser.primitiveType_return primitiveType() throws RecognitionException {
        SalsaParser.primitiveType_return retval = new SalsaParser.primitiveType_return();
        retval.start = input.LT(1);

        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:395:5: ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' | 'void' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:
            {
            if ( input.LA(1)==BOOLEAN||input.LA(1)==BYTE||input.LA(1)==CHAR||input.LA(1)==DOUBLE||input.LA(1)==FLOAT||(input.LA(1)>=INT && input.LA(1)<=LONG)||input.LA(1)==SHORT||input.LA(1)==VOID ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


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
    // $ANTLR end "primitiveType"

    protected static class typeDeclaration_scope {
        SymbolType currentType;
    }
    protected Stack typeDeclaration_stack = new Stack();


    // $ANTLR start "typeDeclaration"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:406:1: typeDeclaration returns [TypeDeclaration td] : ( behaviorDeclaration | classDeclaration | interfaceDeclaration );
    public final TypeDeclaration typeDeclaration() throws RecognitionException {
        typeDeclaration_stack.push(new typeDeclaration_scope());
        TypeDeclaration td = null;

        BehaviorDeclaration behaviorDeclaration6 = null;

        ClassDeclaration classDeclaration7 = null;

        InterfaceDeclaration interfaceDeclaration8 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:408:5: ( behaviorDeclaration | classDeclaration | interfaceDeclaration )
            int alt13=3;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:408:9: behaviorDeclaration
                    {
                    pushFollow(FOLLOW_behaviorDeclaration_in_typeDeclaration5132);
                    behaviorDeclaration6=behaviorDeclaration();

                    state._fsp--;

                    td = behaviorDeclaration6;

                    }
                    break;
                case 2 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:409:9: classDeclaration
                    {
                    pushFollow(FOLLOW_classDeclaration_in_typeDeclaration5144);
                    classDeclaration7=classDeclaration();

                    state._fsp--;

                    td = classDeclaration7;

                    }
                    break;
                case 3 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:410:9: interfaceDeclaration
                    {
                    pushFollow(FOLLOW_interfaceDeclaration_in_typeDeclaration5156);
                    interfaceDeclaration8=interfaceDeclaration();

                    state._fsp--;

                    td = interfaceDeclaration8;

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


    // $ANTLR start "interfaceDeclaration"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:413:1: interfaceDeclaration returns [InterfaceDeclaration in] : modifiers 'interface' IDENT ( 'extends' typeList )? '{' ( fieldVariableDeclaration | intefaceMethodDeclaration )* '}' ;
    public final InterfaceDeclaration interfaceDeclaration() throws RecognitionException {
        InterfaceDeclaration in = null;

        SalsaParser.fieldVariableDeclaration_return fieldVariableDeclaration9 = null;

        InterfaceMethodDeclaration intefaceMethodDeclaration10 = null;


         in = new InterfaceDeclaration(); 
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:415:5: ( modifiers 'interface' IDENT ( 'extends' typeList )? '{' ( fieldVariableDeclaration | intefaceMethodDeclaration )* '}' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:415:9: modifiers 'interface' IDENT ( 'extends' typeList )? '{' ( fieldVariableDeclaration | intefaceMethodDeclaration )* '}'
            {
            pushFollow(FOLLOW_modifiers_in_interfaceDeclaration5193);
            modifiers();

            state._fsp--;

            match(input,INTERFACE,FOLLOW_INTERFACE_in_interfaceDeclaration5195); 
            match(input,IDENT,FOLLOW_IDENT_in_interfaceDeclaration5197); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:416:9: ( 'extends' typeList )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==EXTENDS) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:416:10: 'extends' typeList
                    {
                    match(input,EXTENDS,FOLLOW_EXTENDS_in_interfaceDeclaration5208); 
                    pushFollow(FOLLOW_typeList_in_interfaceDeclaration5210);
                    typeList();

                    state._fsp--;


                    }
                    break;

            }

            match(input,LCURLY,FOLLOW_LCURLY_in_interfaceDeclaration5222); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:418:13: ( fieldVariableDeclaration | intefaceMethodDeclaration )*
            loop15:
            do {
                int alt15=3;
                alt15 = dfa15.predict(input);
                switch (alt15) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:418:17: fieldVariableDeclaration
            	    {
            	    pushFollow(FOLLOW_fieldVariableDeclaration_in_interfaceDeclaration5240);
            	    fieldVariableDeclaration9=fieldVariableDeclaration();

            	    state._fsp--;

            	    in.addFieldVariableDeclaration((fieldVariableDeclaration9!=null?fieldVariableDeclaration9.sd:null));

            	    }
            	    break;
            	case 2 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:419:17: intefaceMethodDeclaration
            	    {
            	    pushFollow(FOLLOW_intefaceMethodDeclaration_in_interfaceDeclaration5260);
            	    intefaceMethodDeclaration10=intefaceMethodDeclaration();

            	    state._fsp--;

            	    in.addMethodDeclaration(intefaceMethodDeclaration10);

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            match(input,RCURLY,FOLLOW_RCURLY_in_interfaceDeclaration5287); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return in;
    }
    // $ANTLR end "interfaceDeclaration"


    // $ANTLR start "classDeclaration"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:424:1: classDeclaration returns [ClassDeclaration cd] : modifiers 'class' IDENT ( 'extends' type )? ( 'implements' typeList )? '{' ( fieldVariableDeclaration | constructorDeclaration | classMethodDeclaration )* '}' ;
    public final ClassDeclaration classDeclaration() throws RecognitionException {
        ClassDeclaration cd = null;

        Token IDENT11=null;
        SalsaParser.fieldVariableDeclaration_return fieldVariableDeclaration12 = null;

        ConstructorDeclaration constructorDeclaration13 = null;

        ClassMethodDeclaration classMethodDeclaration14 = null;


         cd = new ClassDeclaration(); 
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:426:5: ( modifiers 'class' IDENT ( 'extends' type )? ( 'implements' typeList )? '{' ( fieldVariableDeclaration | constructorDeclaration | classMethodDeclaration )* '}' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:426:9: modifiers 'class' IDENT ( 'extends' type )? ( 'implements' typeList )? '{' ( fieldVariableDeclaration | constructorDeclaration | classMethodDeclaration )* '}'
            {
            pushFollow(FOLLOW_modifiers_in_classDeclaration5333);
            modifiers();

            state._fsp--;

            match(input,CLASS,FOLLOW_CLASS_in_classDeclaration5335); 
            IDENT11=(Token)match(input,IDENT,FOLLOW_IDENT_in_classDeclaration5337); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:427:9: ( 'extends' type )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==EXTENDS) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:427:10: 'extends' type
                    {
                    match(input,EXTENDS,FOLLOW_EXTENDS_in_classDeclaration5348); 
                    pushFollow(FOLLOW_type_in_classDeclaration5350);
                    type();

                    state._fsp--;


                    }
                    break;

            }

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:428:9: ( 'implements' typeList )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==IMPLEMENTS) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:428:10: 'implements' typeList
                    {
                    match(input,IMPLEMENTS,FOLLOW_IMPLEMENTS_in_classDeclaration5363); 
                    pushFollow(FOLLOW_typeList_in_classDeclaration5365);
                    typeList();

                    state._fsp--;


                    }
                    break;

            }

               cd.setName((IDENT11!=null?IDENT11.getText():null)); 
                        String canonicalName = moduleName + "." + (IDENT11!=null?IDENT11.getText():null);
                        ((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType = new SymbolType(canonicalName, SymbolType.OBJECT_TYPE);
                        CompilerHelper.addInitKnownType(((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType);
                        cd.setSymbolType(((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType);        
                    
            match(input,LCURLY,FOLLOW_LCURLY_in_classDeclaration5387); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:436:13: ( fieldVariableDeclaration | constructorDeclaration | classMethodDeclaration )*
            loop18:
            do {
                int alt18=4;
                alt18 = dfa18.predict(input);
                switch (alt18) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:436:17: fieldVariableDeclaration
            	    {
            	    pushFollow(FOLLOW_fieldVariableDeclaration_in_classDeclaration5405);
            	    fieldVariableDeclaration12=fieldVariableDeclaration();

            	    state._fsp--;

            	    cd.addFieldVariableDeclaration((fieldVariableDeclaration12!=null?fieldVariableDeclaration12.sd:null));

            	    }
            	    break;
            	case 2 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:437:17: constructorDeclaration
            	    {
            	    pushFollow(FOLLOW_constructorDeclaration_in_classDeclaration5425);
            	    constructorDeclaration13=constructorDeclaration();

            	    state._fsp--;

            	    cd.addMethodDeclaration(constructorDeclaration13);

            	    }
            	    break;
            	case 3 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:438:17: classMethodDeclaration
            	    {
            	    pushFollow(FOLLOW_classMethodDeclaration_in_classDeclaration5445);
            	    classMethodDeclaration14=classMethodDeclaration();

            	    state._fsp--;

            	    cd.addMethodDeclaration(classMethodDeclaration14);

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            match(input,RCURLY,FOLLOW_RCURLY_in_classDeclaration5472); 

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
    // $ANTLR end "classDeclaration"


    // $ANTLR start "behaviorDeclaration"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:443:1: behaviorDeclaration returns [BehaviorDeclaration bd] : modifiers 'behavior' IDENT ( 'extends' type )? ( 'implements' typeList )? '{' ( fieldVariableDeclaration | constructorDeclaration | messageHandlerDeclaration )* '}' ;
    public final BehaviorDeclaration behaviorDeclaration() throws RecognitionException {
        BehaviorDeclaration bd = null;

        Token IDENT15=null;
        SalsaParser.fieldVariableDeclaration_return fieldVariableDeclaration16 = null;

        ConstructorDeclaration constructorDeclaration17 = null;

        MessageHandlerDeclaration messageHandlerDeclaration18 = null;


         bd = new BehaviorDeclaration();
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:445:5: ( modifiers 'behavior' IDENT ( 'extends' type )? ( 'implements' typeList )? '{' ( fieldVariableDeclaration | constructorDeclaration | messageHandlerDeclaration )* '}' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:445:9: modifiers 'behavior' IDENT ( 'extends' type )? ( 'implements' typeList )? '{' ( fieldVariableDeclaration | constructorDeclaration | messageHandlerDeclaration )* '}'
            {
            pushFollow(FOLLOW_modifiers_in_behaviorDeclaration5508);
            modifiers();

            state._fsp--;

            match(input,185,FOLLOW_185_in_behaviorDeclaration5510); 
            IDENT15=(Token)match(input,IDENT,FOLLOW_IDENT_in_behaviorDeclaration5512); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:446:9: ( 'extends' type )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==EXTENDS) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:446:10: 'extends' type
                    {
                    match(input,EXTENDS,FOLLOW_EXTENDS_in_behaviorDeclaration5524); 
                    pushFollow(FOLLOW_type_in_behaviorDeclaration5526);
                    type();

                    state._fsp--;


                    }
                    break;

            }

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:447:9: ( 'implements' typeList )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==IMPLEMENTS) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:447:10: 'implements' typeList
                    {
                    match(input,IMPLEMENTS,FOLLOW_IMPLEMENTS_in_behaviorDeclaration5539); 
                    pushFollow(FOLLOW_typeList_in_behaviorDeclaration5541);
                    typeList();

                    state._fsp--;


                    }
                    break;

            }

               bd.setName((IDENT15!=null?IDENT15.getText():null)); 
                        String canonicalName = moduleName + "." + (IDENT15!=null?IDENT15.getText():null);
                        ((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType = new SymbolType(canonicalName, SymbolType.ACTOR_TYPE);
                        CompilerHelper.addInitKnownType(((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType);
                        bd.setSymbolType(((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType);
                    
            match(input,LCURLY,FOLLOW_LCURLY_in_behaviorDeclaration5563); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:455:10: ( fieldVariableDeclaration | constructorDeclaration | messageHandlerDeclaration )*
            loop21:
            do {
                int alt21=4;
                alt21 = dfa21.predict(input);
                switch (alt21) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:455:14: fieldVariableDeclaration
            	    {
            	    pushFollow(FOLLOW_fieldVariableDeclaration_in_behaviorDeclaration5578);
            	    fieldVariableDeclaration16=fieldVariableDeclaration();

            	    state._fsp--;

            	    bd.addFieldVariableDeclaration((fieldVariableDeclaration16!=null?fieldVariableDeclaration16.sd:null));

            	    }
            	    break;
            	case 2 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:456:14: constructorDeclaration
            	    {
            	    pushFollow(FOLLOW_constructorDeclaration_in_behaviorDeclaration5595);
            	    constructorDeclaration17=constructorDeclaration();

            	    state._fsp--;

            	    bd.addMethodDeclaration(constructorDeclaration17);

            	    }
            	    break;
            	case 3 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:457:14: messageHandlerDeclaration
            	    {
            	    pushFollow(FOLLOW_messageHandlerDeclaration_in_behaviorDeclaration5612);
            	    messageHandlerDeclaration18=messageHandlerDeclaration();

            	    state._fsp--;

            	    bd.addMethodDeclaration(messageHandlerDeclaration18);

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            match(input,RCURLY,FOLLOW_RCURLY_in_behaviorDeclaration5640); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return bd;
    }
    // $ANTLR end "behaviorDeclaration"


    // $ANTLR start "intefaceMethodDeclaration"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:462:1: intefaceMethodDeclaration returns [InterfaceMethodDeclaration m] : modifiers type IDENT formalParameters ( 'throws' qualifiedNameList )? ';' ;
    public final InterfaceMethodDeclaration intefaceMethodDeclaration() throws RecognitionException {
        InterfaceMethodDeclaration m = null;

        Token IDENT20=null;
        List<FormalParameter> formalParameters19 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:463:5: ( modifiers type IDENT formalParameters ( 'throws' qualifiedNameList )? ';' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:463:10: modifiers type IDENT formalParameters ( 'throws' qualifiedNameList )? ';'
            {
            pushFollow(FOLLOW_modifiers_in_intefaceMethodDeclaration5673);
            modifiers();

            state._fsp--;

            pushFollow(FOLLOW_type_in_intefaceMethodDeclaration5675);
            type();

            state._fsp--;

            IDENT20=(Token)match(input,IDENT,FOLLOW_IDENT_in_intefaceMethodDeclaration5677); 
            pushFollow(FOLLOW_formalParameters_in_intefaceMethodDeclaration5679);
            formalParameters19=formalParameters();

            state._fsp--;

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:463:48: ( 'throws' qualifiedNameList )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==THROWS) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:463:49: 'throws' qualifiedNameList
                    {
                    match(input,THROWS,FOLLOW_THROWS_in_intefaceMethodDeclaration5682); 
                    pushFollow(FOLLOW_qualifiedNameList_in_intefaceMethodDeclaration5684);
                    qualifiedNameList();

                    state._fsp--;


                    }
                    break;

            }

            match(input,SEMI,FOLLOW_SEMI_in_intefaceMethodDeclaration5689); 

                        List<FormalParameter> list = formalParameters19;
                        List<String> typeList = new ArrayList<String>();
                        for (FormalParameter fp : list) {
                            typeList.add(fp.getType());
                        }
                        SymbolMethod sm = new SymbolMethod((IDENT20!=null?IDENT20.getText():null), "", typeList.toArray(new String[0]));
            //            $md.setSymbolMethod(sm);
                        ((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType.addMethod(sm);
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return m;
    }
    // $ANTLR end "intefaceMethodDeclaration"


    // $ANTLR start "classMethodDeclaration"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:476:1: classMethodDeclaration returns [ClassMethodDeclaration cd] : modifiers type IDENT formalParameters ( 'throws' qualifiedNameList )? block ;
    public final ClassMethodDeclaration classMethodDeclaration() throws RecognitionException {
        ClassMethodDeclaration cd = null;

        Token IDENT23=null;
        SalsaParser.modifiers_return modifiers21 = null;

        SalsaParser.type_return type22 = null;

        List<FormalParameter> formalParameters24 = null;

        Block block25 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:477:5: ( modifiers type IDENT formalParameters ( 'throws' qualifiedNameList )? block )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:477:9: modifiers type IDENT formalParameters ( 'throws' qualifiedNameList )? block
            {
            pushFollow(FOLLOW_modifiers_in_classMethodDeclaration5746);
            modifiers21=modifiers();

            state._fsp--;

            pushFollow(FOLLOW_type_in_classMethodDeclaration5748);
            type22=type();

            state._fsp--;

            IDENT23=(Token)match(input,IDENT,FOLLOW_IDENT_in_classMethodDeclaration5750); 
            pushFollow(FOLLOW_formalParameters_in_classMethodDeclaration5752);
            formalParameters24=formalParameters();

            state._fsp--;

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:477:47: ( 'throws' qualifiedNameList )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==THROWS) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:477:48: 'throws' qualifiedNameList
                    {
                    match(input,THROWS,FOLLOW_THROWS_in_classMethodDeclaration5755); 
                    pushFollow(FOLLOW_qualifiedNameList_in_classMethodDeclaration5757);
                    qualifiedNameList();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_block_in_classMethodDeclaration5769);
            block25=block();

            state._fsp--;


                        cd = new ClassMethodDeclaration((modifiers21!=null?input.toString(modifiers21.start,modifiers21.stop):null), (type22!=null?input.toString(type22.start,type22.stop):null), (IDENT23!=null?IDENT23.getText():null), formalParameters24, block25);
                        List<FormalParameter> list = formalParameters24;
                        List<String> typeList = new ArrayList<String>();
                        for (FormalParameter fp : list) {   
                            typeList.add(fp.getType());
                        }
                        SymbolMethod sm = new SymbolMethod((IDENT23!=null?IDENT23.getText():null), (type22!=null?input.toString(type22.start,type22.stop):null), typeList.toArray(new String[0]));
                        cd.setSymbolMethod(sm);
                        ((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType.addMethod(sm);
                    

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
    // $ANTLR end "classMethodDeclaration"


    // $ANTLR start "constructorDeclaration"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:492:1: constructorDeclaration returns [ConstructorDeclaration cd] : modifiers IDENT formalParameters block ;
    public final ConstructorDeclaration constructorDeclaration() throws RecognitionException {
        ConstructorDeclaration cd = null;

        Token IDENT27=null;
        SalsaParser.modifiers_return modifiers26 = null;

        List<FormalParameter> formalParameters28 = null;

        Block block29 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:493:5: ( modifiers IDENT formalParameters block )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:493:9: modifiers IDENT formalParameters block
            {
            pushFollow(FOLLOW_modifiers_in_constructorDeclaration5808);
            modifiers26=modifiers();

            state._fsp--;

            IDENT27=(Token)match(input,IDENT,FOLLOW_IDENT_in_constructorDeclaration5810); 
            int ln = getLine(input);
            pushFollow(FOLLOW_formalParameters_in_constructorDeclaration5814);
            formalParameters28=formalParameters();

            state._fsp--;

            pushFollow(FOLLOW_block_in_constructorDeclaration5816);
            block29=block();

            state._fsp--;

               cd = new ConstructorDeclaration((modifiers26!=null?input.toString(modifiers26.start,modifiers26.stop):null), (IDENT27!=null?IDENT27.getText():null), formalParameters28, block29);
                        cd.setLine(ln);
                        List<FormalParameter> list = formalParameters28;
                        List<String> typeList = new ArrayList<String>();
                        for (FormalParameter fp : list) {
                            typeList.add(fp.getType());
                        }
                        SymbolMethod sm = new SymbolMethod((IDENT27!=null?IDENT27.getText():null), "", typeList.toArray(new String[0]));
            //            cd.setSymbolMethod(sm);
                        ((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType.addMethod(sm);            
                    

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:507:1: messageHandlerDeclaration returns [MessageHandlerDeclaration md] : modifiers type IDENT formalParameters block ;
    public final MessageHandlerDeclaration messageHandlerDeclaration() throws RecognitionException {
        MessageHandlerDeclaration md = null;

        Token IDENT32=null;
        SalsaParser.type_return type30 = null;

        SalsaParser.modifiers_return modifiers31 = null;

        List<FormalParameter> formalParameters33 = null;

        Block block34 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:508:5: ( modifiers type IDENT formalParameters block )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:508:9: modifiers type IDENT formalParameters block
            {
            pushFollow(FOLLOW_modifiers_in_messageHandlerDeclaration5849);
            modifiers31=modifiers();

            state._fsp--;

            pushFollow(FOLLOW_type_in_messageHandlerDeclaration5851);
            type30=type();

            state._fsp--;

            IDENT32=(Token)match(input,IDENT,FOLLOW_IDENT_in_messageHandlerDeclaration5853); 
            pushFollow(FOLLOW_formalParameters_in_messageHandlerDeclaration5855);
            formalParameters33=formalParameters();

            state._fsp--;

            pushFollow(FOLLOW_block_in_messageHandlerDeclaration5866);
            block34=block();

            state._fsp--;


                        String returnType = CompilerHelper.TOKEN + " " + (type30!=null?input.toString(type30.start,type30.stop):null);
                        md = new MessageHandlerDeclaration((modifiers31!=null?input.toString(modifiers31.start,modifiers31.stop):null), (type30!=null?input.toString(type30.start,type30.stop):null), (IDENT32!=null?IDENT32.getText():null), formalParameters33, block34);
                        List<FormalParameter> list = formalParameters33;
                        List<String> typeList = new ArrayList<String>();
                        for (FormalParameter fp : list) {   
                            typeList.add(fp.getType());
                        }
                        SymbolMethod sm = new SymbolMethod((IDENT32!=null?IDENT32.getText():null), returnType, typeList.toArray(new String[0]));
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


    // $ANTLR start "block"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:525:1: block returns [Block b] : '{' ( statement )* '}' ;
    public final Block block() throws RecognitionException {
        Block b = null;

        SalsaParser.statement_return statement35 = null;


         
            b = new Block();
            boolean isPreviousLineContinuation = false;   

        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:530:5: ( '{' ( statement )* '}' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:530:9: '{' ( statement )* '}'
            {
            match(input,LCURLY,FOLLOW_LCURLY_in_block5904); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:530:13: ( statement )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==DEC||LA24_0==INC||LA24_0==LCURLY||LA24_0==LOGICAL_NOT||(LA24_0>=LPAREN && LA24_0<=MINUS)||LA24_0==NOT||LA24_0==PLUS||LA24_0==BOOLEAN||LA24_0==BYTE||LA24_0==CHAR||LA24_0==DOUBLE||LA24_0==FALSE||(LA24_0>=FLOAT && LA24_0<=IF)||(LA24_0>=INT && LA24_0<=LONG)||(LA24_0>=NEW && LA24_0<=NULL)||(LA24_0>=RETURN && LA24_0<=SHORT)||LA24_0==TRUE||LA24_0==VOID||(LA24_0>=IDENT && LA24_0<=FLOATING_POINT_LITERAL)||LA24_0==184||LA24_0==186) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:530:14: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_block5907);
            	    statement35=statement();

            	    state._fsp--;


            	                b.addStatement((statement35!=null?statement35.stat:null));
            	                (statement35!=null?statement35.stat:null).setAfterContinuation(isPreviousLineContinuation);
            	                isPreviousLineContinuation = (statement35!=null?statement35.stat:null).isInContinuation();
            	                

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            match(input,RCURLY,FOLLOW_RCURLY_in_block5942); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return b;
    }
    // $ANTLR end "block"

    protected static class statement_scope {
        boolean isSendMessage;
    }
    protected Stack statement_stack = new Stack();

    public static class statement_return extends ParserRuleReturnScope {
        public Statement stat;
    };

    // $ANTLR start "statement"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:541:1: statement returns [Statement stat] : ( localVariableDeclaration ( ';' | '@' ) | e1= expression ( '=' e2= expression )? ( ';' | '@' ) | joinBlockStatement ( '@' ) | blockStatement | ifStatement | returnStatement ';' | forStatement ) ;
    public final SalsaParser.statement_return statement() throws RecognitionException {
        statement_stack.push(new statement_scope());
        SalsaParser.statement_return retval = new SalsaParser.statement_return();
        retval.start = input.LT(1);

        SalsaParser.expression_return e1 = null;

        SalsaParser.expression_return e2 = null;

        SalsaParser.localVariableDeclaration_return localVariableDeclaration36 = null;

        JoinBlockStatement joinBlockStatement37 = null;

        BlockStatement blockStatement38 = null;

        IfStatement ifStatement39 = null;

        ReturnStatement returnStatement40 = null;

        ForStatement forStatement41 = null;


        boolean isContinuation = false; ((statement_scope)statement_stack.peek()).isSendMessage = false;
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:548:5: ( ( localVariableDeclaration ( ';' | '@' ) | e1= expression ( '=' e2= expression )? ( ';' | '@' ) | joinBlockStatement ( '@' ) | blockStatement | ifStatement | returnStatement ';' | forStatement ) )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:548:7: ( localVariableDeclaration ( ';' | '@' ) | e1= expression ( '=' e2= expression )? ( ';' | '@' ) | joinBlockStatement ( '@' ) | blockStatement | ifStatement | returnStatement ';' | forStatement )
            {
            int ln = getLine(input);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:549:5: ( localVariableDeclaration ( ';' | '@' ) | e1= expression ( '=' e2= expression )? ( ';' | '@' ) | joinBlockStatement ( '@' ) | blockStatement | ifStatement | returnStatement ';' | forStatement )
            int alt28=7;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:550:9: localVariableDeclaration ( ';' | '@' )
                    {
                    pushFollow(FOLLOW_localVariableDeclaration_in_statement6007);
                    localVariableDeclaration36=localVariableDeclaration();

                    state._fsp--;

                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:550:34: ( ';' | '@' )
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==SEMI) ) {
                        alt25=1;
                    }
                    else if ( (LA25_0==AT) ) {
                        alt25=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 0, input);

                        throw nvae;
                    }
                    switch (alt25) {
                        case 1 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:550:35: ';'
                            {
                            match(input,SEMI,FOLLOW_SEMI_in_statement6010); 

                            }
                            break;
                        case 2 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:550:41: '@'
                            {
                            match(input,AT,FOLLOW_AT_in_statement6014); 
                            isContinuation=true;

                            }
                            break;

                    }

                    retval.stat = (localVariableDeclaration36!=null?localVariableDeclaration36.ld:null);

                    }
                    break;
                case 2 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:551:9: e1= expression ( '=' e2= expression )? ( ';' | '@' )
                    {
                    pushFollow(FOLLOW_expression_in_statement6032);
                    e1=expression();

                    state._fsp--;

                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:551:25: ( '=' e2= expression )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==ASSIGN) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:551:26: '=' e2= expression
                            {
                            match(input,ASSIGN,FOLLOW_ASSIGN_in_statement6035); 
                            pushFollow(FOLLOW_expression_in_statement6041);
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
                            
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:558:9: ( ';' | '@' )
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==SEMI) ) {
                        alt27=1;
                    }
                    else if ( (LA27_0==AT) ) {
                        alt27=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 27, 0, input);

                        throw nvae;
                    }
                    switch (alt27) {
                        case 1 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:558:10: ';'
                            {
                            match(input,SEMI,FOLLOW_SEMI_in_statement6065); 

                            }
                            break;
                        case 2 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:558:16: '@'
                            {
                            match(input,AT,FOLLOW_AT_in_statement6069); 
                            isContinuation=true;

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:559:9: joinBlockStatement ( '@' )
                    {
                    pushFollow(FOLLOW_joinBlockStatement_in_statement6082);
                    joinBlockStatement37=joinBlockStatement();

                    state._fsp--;

                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:559:28: ( '@' )
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:559:29: '@'
                    {
                    match(input,AT,FOLLOW_AT_in_statement6085); 

                    }

                     retval.stat = joinBlockStatement37; isContinuation=true;

                    }
                    break;
                case 4 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:560:9: blockStatement
                    {
                    pushFollow(FOLLOW_blockStatement_in_statement6099);
                    blockStatement38=blockStatement();

                    state._fsp--;

                    retval.stat = blockStatement38;

                    }
                    break;
                case 5 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:561:9: ifStatement
                    {
                    pushFollow(FOLLOW_ifStatement_in_statement6112);
                    ifStatement39=ifStatement();

                    state._fsp--;

                    retval.stat = ifStatement39;

                    }
                    break;
                case 6 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:562:9: returnStatement ';'
                    {
                    pushFollow(FOLLOW_returnStatement_in_statement6124);
                    returnStatement40=returnStatement();

                    state._fsp--;

                    match(input,SEMI,FOLLOW_SEMI_in_statement6126); 
                    retval.stat = returnStatement40; 

                    }
                    break;
                case 7 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:563:9: forStatement
                    {
                    pushFollow(FOLLOW_forStatement_in_statement6138);
                    forStatement41=forStatement();

                    state._fsp--;

                    retval.stat = forStatement41; 

                    }
                    break;

            }

            retval.stat.setLine(ln);
            retval.stat.setSalsaSource(input.toString(retval.start,input.LT(-1)));

            }

            retval.stop = input.LT(-1);

             
                retval.stat.setInContinuation(isContinuation);
                retval.stat.setSendMessage(((statement_scope)statement_stack.peek()).isSendMessage);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            statement_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "statement"


    // $ANTLR start "forStatement"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:569:1: forStatement returns [ForStatement s] : 'for' '(' localVariableDeclaration ';' e1= expression ';' e2= expression ')' block ;
    public final ForStatement forStatement() throws RecognitionException {
        ForStatement s = null;

        SalsaParser.expression_return e1 = null;

        SalsaParser.expression_return e2 = null;

        SalsaParser.localVariableDeclaration_return localVariableDeclaration42 = null;

        Block block43 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:570:5: ( 'for' '(' localVariableDeclaration ';' e1= expression ';' e2= expression ')' block )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:570:9: 'for' '(' localVariableDeclaration ';' e1= expression ';' e2= expression ')' block
            {
            match(input,FOR,FOLLOW_FOR_in_forStatement6186); 
            match(input,LPAREN,FOLLOW_LPAREN_in_forStatement6197); 
            pushFollow(FOLLOW_localVariableDeclaration_in_forStatement6212);
            localVariableDeclaration42=localVariableDeclaration();

            state._fsp--;

            match(input,SEMI,FOLLOW_SEMI_in_forStatement6227); 
            pushFollow(FOLLOW_expression_in_forStatement6246);
            e1=expression();

            state._fsp--;

            match(input,SEMI,FOLLOW_SEMI_in_forStatement6248); 
            pushFollow(FOLLOW_expression_in_forStatement6267);
            e2=expression();

            state._fsp--;

            match(input,RPAREN,FOLLOW_RPAREN_in_forStatement6278); 
            pushFollow(FOLLOW_block_in_forStatement6288);
            block43=block();

            state._fsp--;


                        s = new ForStatement((localVariableDeclaration42!=null?localVariableDeclaration42.ld:null), (e1!=null?e1.e:null), (e2!=null?e2.e:null), block43);
                    

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:583:1: returnStatement returns [ReturnStatement s] : 'return' ( expression )? ;
    public final ReturnStatement returnStatement() throws RecognitionException {
        ReturnStatement s = null;

        SalsaParser.expression_return expression44 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:584:5: ( 'return' ( expression )? )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:584:9: 'return' ( expression )?
            {
            match(input,RETURN,FOLLOW_RETURN_in_returnStatement6330); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:584:18: ( expression )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==DEC||LA29_0==INC||LA29_0==LOGICAL_NOT||(LA29_0>=LPAREN && LA29_0<=MINUS)||LA29_0==NOT||LA29_0==PLUS||LA29_0==FALSE||(LA29_0>=NEW && LA29_0<=NULL)||LA29_0==TRUE||(LA29_0>=IDENT && LA29_0<=FLOATING_POINT_LITERAL)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:584:19: expression
                    {
                    pushFollow(FOLLOW_expression_in_returnStatement6333);
                    expression44=expression();

                    state._fsp--;


                    }
                    break;

            }

             s = new ReturnStatement((expression44!=null?expression44.e:null)); 

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:588:1: ifStatement returns [IfStatement s] : 'if' '(' expression ')' block ( 'else' statement )? ;
    public final IfStatement ifStatement() throws RecognitionException {
        IfStatement s = null;

        SalsaParser.expression_return expression45 = null;

        Block block46 = null;

        SalsaParser.statement_return statement47 = null;


        s = new IfStatement();
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:590:5: ( 'if' '(' expression ')' block ( 'else' statement )? )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:590:9: 'if' '(' expression ')' block ( 'else' statement )?
            {
            match(input,IF,FOLLOW_IF_in_ifStatement6373); 
            match(input,LPAREN,FOLLOW_LPAREN_in_ifStatement6375); 
            pushFollow(FOLLOW_expression_in_ifStatement6377);
            expression45=expression();

            state._fsp--;

            match(input,RPAREN,FOLLOW_RPAREN_in_ifStatement6379); 
            pushFollow(FOLLOW_block_in_ifStatement6381);
            block46=block();

            state._fsp--;

            s.setExpression((expression45!=null?expression45.e:null)); s.setBlock(block46);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:591:9: ( 'else' statement )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==ELSE) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:591:10: 'else' statement
                    {
                    match(input,ELSE,FOLLOW_ELSE_in_ifStatement6394); 
                    pushFollow(FOLLOW_statement_in_ifStatement6396);
                    statement47=statement();

                    state._fsp--;

                    s.setElseStatement((statement47!=null?statement47.stat:null));

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


    // $ANTLR start "joinBlockStatement"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:594:1: joinBlockStatement returns [JoinBlockStatement s] : 'join' block ;
    public final JoinBlockStatement joinBlockStatement() throws RecognitionException {
        JoinBlockStatement s = null;

        Block block48 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:595:5: ( 'join' block )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:595:9: 'join' block
            {
            match(input,186,FOLLOW_186_in_joinBlockStatement6427); 
            pushFollow(FOLLOW_block_in_joinBlockStatement6429);
            block48=block();

            state._fsp--;

            s = new JoinBlockStatement(block48);

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
    // $ANTLR end "joinBlockStatement"


    // $ANTLR start "blockStatement"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:598:1: blockStatement returns [BlockStatement s] : block ;
    public final BlockStatement blockStatement() throws RecognitionException {
        BlockStatement s = null;

        Block block49 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:599:5: ( block )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:599:9: block
            {
            pushFollow(FOLLOW_block_in_blockStatement6467);
            block49=block();

            state._fsp--;

            s = new BlockStatement(block49);

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:602:1: expressionStatement returns [ExpressionStatement s] : expression ;
    public final ExpressionStatement expressionStatement() throws RecognitionException {
        ExpressionStatement s = null;

        SalsaParser.expression_return expression50 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:603:5: ( expression )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:603:9: expression
            {
            pushFollow(FOLLOW_expression_in_expressionStatement6492);
            expression50=expression();

            state._fsp--;

            s = new ExpressionStatement((expression50!=null?expression50.e:null));

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:607:1: formalParameters returns [List<FormalParameter> list] : '(' (f1= formalParameter ( ',' f2= formalParameter )* )? ')' ;
    public final List<FormalParameter> formalParameters() throws RecognitionException {
        List<FormalParameter> list = null;

        SalsaParser.formalParameter_return f1 = null;

        SalsaParser.formalParameter_return f2 = null;


         list = new ArrayList<FormalParameter>(); 
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:609:5: ( '(' (f1= formalParameter ( ',' f2= formalParameter )* )? ')' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:609:9: '(' (f1= formalParameter ( ',' f2= formalParameter )* )? ')'
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_formalParameters6534); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:610:9: (f1= formalParameter ( ',' f2= formalParameter )* )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==BOOLEAN||LA32_0==BYTE||LA32_0==CHAR||LA32_0==DOUBLE||LA32_0==FLOAT||(LA32_0>=INT && LA32_0<=LONG)||LA32_0==SHORT||LA32_0==VOID||LA32_0==IDENT||LA32_0==184) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:611:13: f1= formalParameter ( ',' f2= formalParameter )*
                    {
                    pushFollow(FOLLOW_formalParameter_in_formalParameters6562);
                    f1=formalParameter();

                    state._fsp--;

                     list.add((f1!=null?f1.fp:null)); 
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:612:13: ( ',' f2= formalParameter )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==COMMA) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:612:14: ',' f2= formalParameter
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_formalParameters6579); 
                    	    pushFollow(FOLLOW_formalParameter_in_formalParameters6585);
                    	    f2=formalParameter();

                    	    state._fsp--;

                    	    list.add((f2!=null?f2.fp:null));

                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_formalParameters6611); 

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:618:1: formalParameter returns [FormalParameter fp] : type IDENT ;
    public final SalsaParser.formalParameter_return formalParameter() throws RecognitionException {
        SalsaParser.formalParameter_return retval = new SalsaParser.formalParameter_return();
        retval.start = input.LT(1);

        Token IDENT52=null;
        SalsaParser.type_return type51 = null;


        SymbolType st;
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:621:5: ( type IDENT )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:621:9: type IDENT
            {
            pushFollow(FOLLOW_type_in_formalParameter6645);
            type51=type();

            state._fsp--;

            IDENT52=(Token)match(input,IDENT,FOLLOW_IDENT_in_formalParameter6655); 
             retval.fp = new FormalParameter((type51!=null?input.toString(type51.start,type51.stop):null), (IDENT52!=null?IDENT52.getText():null));

            }

            retval.stop = input.LT(-1);

             retval.fp.setSalsaSource(input.toString(retval.start,input.LT(-1))); retval.fp.setLine(getLine(input));
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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:626:1: localVariableDeclaration returns [LocalVariableDeclaration ld, String canonicalType] : type v1= variableDeclaration[$type.text] ( ',' v2= variableDeclaration[$type.text] )* ;
    public final SalsaParser.localVariableDeclaration_return localVariableDeclaration() throws RecognitionException {
        SalsaParser.localVariableDeclaration_return retval = new SalsaParser.localVariableDeclaration_return();
        retval.start = input.LT(1);

        SalsaParser.variableDeclaration_return v1 = null;

        SalsaParser.variableDeclaration_return v2 = null;

        SalsaParser.type_return type53 = null;


         retval.ld = new LocalVariableDeclaration(); String rawType; SymbolType st;
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:628:5: ( type v1= variableDeclaration[$type.text] ( ',' v2= variableDeclaration[$type.text] )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:628:9: type v1= variableDeclaration[$type.text] ( ',' v2= variableDeclaration[$type.text] )*
            {
            pushFollow(FOLLOW_type_in_localVariableDeclaration6693);
            type53=type();

            state._fsp--;

            pushFollow(FOLLOW_variableDeclaration_in_localVariableDeclaration6708);
            v1=variableDeclaration((type53!=null?input.toString(type53.start,type53.stop):null));

            state._fsp--;

             
                        (v1!=null?v1.vd:null).setType((type53!=null?input.toString(type53.start,type53.stop):null));       
                        retval.ld.addVariableDeclaration((v1!=null?v1.vd:null));
                    
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:634:9: ( ',' v2= variableDeclaration[$type.text] )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==COMMA) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:634:10: ',' v2= variableDeclaration[$type.text]
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_localVariableDeclaration6730); 
            	    pushFollow(FOLLOW_variableDeclaration_in_localVariableDeclaration6736);
            	    v2=variableDeclaration((type53!=null?input.toString(type53.start,type53.stop):null));

            	    state._fsp--;

            	     (v2!=null?v2.vd:null).setType((type53!=null?input.toString(type53.start,type53.stop):null));
            	                  retval.ld.addVariableDeclaration((v2!=null?v2.vd:null));

            	    }
            	    break;

            	default :
            	    break loop33;
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

    public static class fieldVariableDeclaration_return extends ParserRuleReturnScope {
        public FieldVariableDeclaration sd;
        public String canonicalType;
    };

    // $ANTLR start "fieldVariableDeclaration"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:640:1: fieldVariableDeclaration returns [FieldVariableDeclaration sd, String canonicalType] : modifiers type v1= variableDeclaration[$type.text] ( ',' v2= variableDeclaration[$type.text] )* ';' ;
    public final SalsaParser.fieldVariableDeclaration_return fieldVariableDeclaration() throws RecognitionException {
        SalsaParser.fieldVariableDeclaration_return retval = new SalsaParser.fieldVariableDeclaration_return();
        retval.start = input.LT(1);

        SalsaParser.variableDeclaration_return v1 = null;

        SalsaParser.variableDeclaration_return v2 = null;

        SalsaParser.type_return type54 = null;

        SalsaParser.modifiers_return modifiers55 = null;


         retval.sd = new FieldVariableDeclaration(); String rawType; SymbolType st;
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:642:5: ( modifiers type v1= variableDeclaration[$type.text] ( ',' v2= variableDeclaration[$type.text] )* ';' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:642:9: modifiers type v1= variableDeclaration[$type.text] ( ',' v2= variableDeclaration[$type.text] )* ';'
            {
            pushFollow(FOLLOW_modifiers_in_fieldVariableDeclaration6799);
            modifiers55=modifiers();

            state._fsp--;

            pushFollow(FOLLOW_type_in_fieldVariableDeclaration6801);
            type54=type();

            state._fsp--;

            pushFollow(FOLLOW_variableDeclaration_in_fieldVariableDeclaration6815);
            v1=variableDeclaration((type54!=null?input.toString(type54.start,type54.stop):null));

            state._fsp--;


                        (v1!=null?v1.vd:null).setType((type54!=null?input.toString(type54.start,type54.stop):null)); 
                        (v1!=null?v1.vd:null).setModifiers((modifiers55!=null?input.toString(modifiers55.start,modifiers55.stop):null));         
                        retval.sd.addVariableDeclaration((v1!=null?v1.vd:null));
                        SymbolField sf = new SymbolField((v1!=null?v1.vd:null).getName(), (type54!=null?input.toString(type54.start,type54.stop):null));
                        ((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType.addField(sf);
                    
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:651:9: ( ',' v2= variableDeclaration[$type.text] )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==COMMA) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:651:10: ',' v2= variableDeclaration[$type.text]
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_fieldVariableDeclaration6838); 
            	    pushFollow(FOLLOW_variableDeclaration_in_fieldVariableDeclaration6844);
            	    v2=variableDeclaration((type54!=null?input.toString(type54.start,type54.stop):null));

            	    state._fsp--;


            	                (v2!=null?v2.vd:null).setType((type54!=null?input.toString(type54.start,type54.stop):null)); 
            	                (v2!=null?v2.vd:null).setModifiers((modifiers55!=null?input.toString(modifiers55.start,modifiers55.stop):null));         
            	    	        retval.sd.addVariableDeclaration((v2!=null?v2.vd:null));
            	                sf = new SymbolField((v2!=null?v2.vd:null).getName(), (type54!=null?input.toString(type54.start,type54.stop):null));
            	                ((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType.addField(sf);
            	            

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            match(input,SEMI,FOLLOW_SEMI_in_fieldVariableDeclaration6877); 

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
    // $ANTLR end "fieldVariableDeclaration"

    public static class variableDeclaration_return extends ParserRuleReturnScope {
        public VariableDeclaration vd;
        public String value;
    };

    // $ANTLR start "variableDeclaration"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:664:1: variableDeclaration[String type] returns [VariableDeclaration vd, String value] : IDENT ( '=' expression )? ;
    public final SalsaParser.variableDeclaration_return variableDeclaration(String type) throws RecognitionException {
        SalsaParser.variableDeclaration_return retval = new SalsaParser.variableDeclaration_return();
        retval.start = input.LT(1);

        Token IDENT56=null;
        SalsaParser.expression_return expression57 = null;


         retval.vd = new VariableDeclaration(); retval.vd.setType(type); 
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:666:5: ( IDENT ( '=' expression )? )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:666:9: IDENT ( '=' expression )?
            {
            IDENT56=(Token)match(input,IDENT,FOLLOW_IDENT_in_variableDeclaration6916); 
            retval.vd.setName((IDENT56!=null?IDENT56.getText():null)); retval.value =(IDENT56!=null?IDENT56.getText():null); retval.vd.setLine(getLine(input));
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:667:9: ( '=' expression )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==ASSIGN) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:667:10: '=' expression
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_variableDeclaration6934); 
                    pushFollow(FOLLOW_expression_in_variableDeclaration6936);
                    expression57=expression();

                    state._fsp--;

                       
                    	        retval.vd.setInitExpresssion((expression57!=null?expression57.e:null));

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
    };

    // $ANTLR start "term"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:674:1: term returns [Term t] : ( '(' type ')' )? ( literal | '(' e1= expression ')' | v1= IDENT ( '[' index= expression ']' )* | allocation ) ( '.' v2= qualifiedName (p1= actualParameters )? | ( '<-' | '!' ) v3= IDENT p2= actualParameters )? ;
    public final SalsaParser.term_return term() throws RecognitionException {
        SalsaParser.term_return retval = new SalsaParser.term_return();
        retval.start = input.LT(1);

        Token v1=null;
        Token v3=null;
        SalsaParser.expression_return e1 = null;

        SalsaParser.expression_return index = null;

        SalsaParser.qualifiedName_return v2 = null;

        List<Expression> p1 = null;

        List<Expression> p2 = null;

        SalsaParser.type_return type58 = null;

        Literal literal59 = null;

        SalsaParser.allocation_return allocation60 = null;


         retval.t = new Term(); int arrayDims = 0; String type = null;
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:677:5: ( ( '(' type ')' )? ( literal | '(' e1= expression ')' | v1= IDENT ( '[' index= expression ']' )* | allocation ) ( '.' v2= qualifiedName (p1= actualParameters )? | ( '<-' | '!' ) v3= IDENT p2= actualParameters )? )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:677:9: ( '(' type ')' )? ( literal | '(' e1= expression ')' | v1= IDENT ( '[' index= expression ']' )* | allocation ) ( '.' v2= qualifiedName (p1= actualParameters )? | ( '<-' | '!' ) v3= IDENT p2= actualParameters )?
            {
            retval.t.setLine(getLine(input));
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:678:9: ( '(' type ')' )?
            int alt36=2;
            alt36 = dfa36.predict(input);
            switch (alt36) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:678:10: '(' type ')'
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_term7002); 
                    pushFollow(FOLLOW_type_in_term7004);
                    type58=type();

                    state._fsp--;

                    match(input,RPAREN,FOLLOW_RPAREN_in_term7006); 
                    retval.t.setCastType((type58!=null?input.toString(type58.start,type58.stop):null));

                    }
                    break;

            }

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:679:9: ( literal | '(' e1= expression ')' | v1= IDENT ( '[' index= expression ']' )* | allocation )
            int alt38=4;
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
                alt38=1;
                }
                break;
            case LPAREN:
                {
                alt38=2;
                }
                break;
            case IDENT:
                {
                alt38=3;
                }
                break;
            case NEW:
                {
                alt38=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:680:13: literal
                    {
                    pushFollow(FOLLOW_literal_in_term7039);
                    literal59=literal();

                    state._fsp--;

                    retval.t.setLiteral(literal59);

                    }
                    break;
                case 2 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:681:10: '(' e1= expression ')'
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_term7052); 
                    pushFollow(FOLLOW_expression_in_term7058);
                    e1=expression();

                    state._fsp--;

                    match(input,RPAREN,FOLLOW_RPAREN_in_term7060); 
                    retval.t.setExpression((e1!=null?e1.e:null));

                    }
                    break;
                case 3 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:682:10: v1= IDENT ( '[' index= expression ']' )*
                    {
                    v1=(Token)match(input,IDENT,FOLLOW_IDENT_in_term7076); 
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:682:21: ( '[' index= expression ']' )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==LBRACK) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:682:22: '[' index= expression ']'
                    	    {
                    	    match(input,LBRACK,FOLLOW_LBRACK_in_term7079); 
                    	    pushFollow(FOLLOW_expression_in_term7085);
                    	    index=expression();

                    	    state._fsp--;

                    	    match(input,RBRACK,FOLLOW_RBRACK_in_term7087); 
                    	    retval.t.addIndexExpression((index!=null?index.e:null)); arrayDims++;

                    	    }
                    	    break;

                    	default :
                    	    break loop37;
                        }
                    } while (true);

                     retval.t.setVarName((v1!=null?v1.getText():null)); 

                    }
                    break;
                case 4 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:684:10: allocation
                    {
                    pushFollow(FOLLOW_allocation_in_term7113);
                    allocation60=allocation();

                    state._fsp--;

                    retval.t.setAllocation((allocation60!=null?allocation60.a:null));

                    }
                    break;

            }

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:686:9: ( '.' v2= qualifiedName (p1= actualParameters )? | ( '<-' | '!' ) v3= IDENT p2= actualParameters )?
            int alt40=3;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==DOT) ) {
                alt40=1;
            }
            else if ( (LA40_0==LOGICAL_NOT||LA40_0==187) ) {
                alt40=2;
            }
            switch (alt40) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:687:13: '.' v2= qualifiedName (p1= actualParameters )?
                    {
                    match(input,DOT,FOLLOW_DOT_in_term7146); 
                    pushFollow(FOLLOW_qualifiedName_in_term7152);
                    v2=qualifiedName();

                    state._fsp--;

                    retval.t.setSelector((v2!=null?input.toString(v2.start,v2.stop):null));
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:688:17: (p1= actualParameters )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==LPAREN) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:688:18: p1= actualParameters
                            {
                            pushFollow(FOLLOW_actualParameters_in_term7178);
                            p1=actualParameters();

                            state._fsp--;

                            retval.t.setActualArguments(p1);

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:691:13: ( '<-' | '!' ) v3= IDENT p2= actualParameters
                    {
                    if ( input.LA(1)==LOGICAL_NOT||input.LA(1)==187 ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    v3=(Token)match(input,IDENT,FOLLOW_IDENT_in_term7238); 
                    retval.t.setMessageName((v3!=null?v3.getText():null));
                    pushFollow(FOLLOW_actualParameters_in_term7263);
                    p2=actualParameters();

                    state._fsp--;

                       retval.t.setActualArguments(p2); 
                                        ((statement_scope)statement_stack.peek()).isSendMessage = true;
                                    

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:699:1: allocation returns [Allocation a] : ( 'new' type actualParameters ( 'at' '(' uan= expression ( ',' host= expression )? ')' )? | ( 'new' ( primitiveType | qualifiedName ) ( '[' expression ']' )+ ) );
    public final SalsaParser.allocation_return allocation() throws RecognitionException {
        SalsaParser.allocation_return retval = new SalsaParser.allocation_return();
        retval.start = input.LT(1);

        SalsaParser.expression_return uan = null;

        SalsaParser.expression_return host = null;

        SalsaParser.type_return type61 = null;

        List<Expression> actualParameters62 = null;

        SalsaParser.primitiveType_return primitiveType63 = null;

        SalsaParser.qualifiedName_return qualifiedName64 = null;

        SalsaParser.expression_return expression65 = null;


         retval.a = new Allocation(); String temp = null;
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:702:5: ( 'new' type actualParameters ( 'at' '(' uan= expression ( ',' host= expression )? ')' )? | ( 'new' ( primitiveType | qualifiedName ) ( '[' expression ']' )+ ) )
            int alt45=2;
            alt45 = dfa45.predict(input);
            switch (alt45) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:704:3: 'new' type actualParameters ( 'at' '(' uan= expression ( ',' host= expression )? ')' )?
                    {
                    match(input,NEW,FOLLOW_NEW_in_allocation7344); 
                    pushFollow(FOLLOW_type_in_allocation7346);
                    type61=type();

                    state._fsp--;

                    pushFollow(FOLLOW_actualParameters_in_allocation7349);
                    actualParameters62=actualParameters();

                    state._fsp--;

                    retval.a.setType((type61!=null?input.toString(type61.start,type61.stop):null)); retval.a.setActualArguments(actualParameters62);
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:706:3: ( 'at' '(' uan= expression ( ',' host= expression )? ')' )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==188) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:706:4: 'at' '(' uan= expression ( ',' host= expression )? ')'
                            {
                            match(input,188,FOLLOW_188_in_allocation7361); 
                            match(input,LPAREN,FOLLOW_LPAREN_in_allocation7372); 
                            pushFollow(FOLLOW_expression_in_allocation7376);
                            uan=expression();

                            state._fsp--;

                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:707:28: ( ',' host= expression )?
                            int alt41=2;
                            int LA41_0 = input.LA(1);

                            if ( (LA41_0==COMMA) ) {
                                alt41=1;
                            }
                            switch (alt41) {
                                case 1 :
                                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:707:29: ',' host= expression
                                    {
                                    match(input,COMMA,FOLLOW_COMMA_in_allocation7379); 
                                    pushFollow(FOLLOW_expression_in_allocation7383);
                                    host=expression();

                                    state._fsp--;

                                    retval.a.setHostExpression((host!=null?host.e:null));

                                    }
                                    break;

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_allocation7411); 
                            retval.a.setUANExpression((uan!=null?uan.e:null));

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:714:3: ( 'new' ( primitiveType | qualifiedName ) ( '[' expression ']' )+ )
                    {
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:714:3: ( 'new' ( primitiveType | qualifiedName ) ( '[' expression ']' )+ )
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:714:4: 'new' ( primitiveType | qualifiedName ) ( '[' expression ']' )+
                    {
                    match(input,NEW,FOLLOW_NEW_in_allocation7438); 
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:714:10: ( primitiveType | qualifiedName )
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==BOOLEAN||LA43_0==BYTE||LA43_0==CHAR||LA43_0==DOUBLE||LA43_0==FLOAT||(LA43_0>=INT && LA43_0<=LONG)||LA43_0==SHORT||LA43_0==VOID) ) {
                        alt43=1;
                    }
                    else if ( (LA43_0==IDENT) ) {
                        alt43=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 43, 0, input);

                        throw nvae;
                    }
                    switch (alt43) {
                        case 1 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:714:11: primitiveType
                            {
                            pushFollow(FOLLOW_primitiveType_in_allocation7441);
                            primitiveType63=primitiveType();

                            state._fsp--;

                            temp = (primitiveType63!=null?input.toString(primitiveType63.start,primitiveType63.stop):null);

                            }
                            break;
                        case 2 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:714:59: qualifiedName
                            {
                            pushFollow(FOLLOW_qualifiedName_in_allocation7449);
                            qualifiedName64=qualifiedName();

                            state._fsp--;

                            temp = (qualifiedName64!=null?input.toString(qualifiedName64.start,qualifiedName64.stop):null);

                            }
                            break;

                    }

                    retval.a.setType(temp);
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:716:5: ( '[' expression ']' )+
                    int cnt44=0;
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==LBRACK) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:716:6: '[' expression ']'
                    	    {
                    	    match(input,LBRACK,FOLLOW_LBRACK_in_allocation7473); 
                    	    pushFollow(FOLLOW_expression_in_allocation7475);
                    	    expression65=expression();

                    	    state._fsp--;

                    	    match(input,RBRACK,FOLLOW_RBRACK_in_allocation7477); 
                    	    retval.a.addExpression((expression65!=null?expression65.e:null));

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt44 >= 1 ) break loop44;
                                EarlyExitException eee =
                                    new EarlyExitException(44, input);
                                throw eee;
                        }
                        cnt44++;
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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:720:1: actualParameters returns [List<Expression> list] : '(' (e1= expression ( ',' e2= expression )* )? ')' ;
    public final List<Expression> actualParameters() throws RecognitionException {
        List<Expression> list = null;

        SalsaParser.expression_return e1 = null;

        SalsaParser.expression_return e2 = null;


         list = new ArrayList<Expression>();
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:722:5: ( '(' (e1= expression ( ',' e2= expression )* )? ')' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:722:9: '(' (e1= expression ( ',' e2= expression )* )? ')'
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_actualParameters7512); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:723:13: (e1= expression ( ',' e2= expression )* )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==DEC||LA47_0==INC||LA47_0==LOGICAL_NOT||(LA47_0>=LPAREN && LA47_0<=MINUS)||LA47_0==NOT||LA47_0==PLUS||LA47_0==FALSE||(LA47_0>=NEW && LA47_0<=NULL)||LA47_0==TRUE||(LA47_0>=IDENT && LA47_0<=FLOATING_POINT_LITERAL)) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:723:14: e1= expression ( ',' e2= expression )*
                    {
                    pushFollow(FOLLOW_expression_in_actualParameters7531);
                    e1=expression();

                    state._fsp--;

                    list.add((e1!=null?e1.e:null));
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:724:13: ( ',' e2= expression )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==COMMA) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:724:14: ',' e2= expression
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_actualParameters7548); 
                    	    pushFollow(FOLLOW_expression_in_actualParameters7554);
                    	    e2=expression();

                    	    state._fsp--;

                    	    list.add((e2!=null?e2.e:null));

                    	    }
                    	    break;

                    	default :
                    	    break loop46;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_actualParameters7570); 

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:729:1: negation returns [NegationExpression e] : ( '~' )* term ;
    public final NegationExpression negation() throws RecognitionException {
        NegationExpression e = null;

        SalsaParser.term_return term66 = null;


         e = new NegationExpression();
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:731:5: ( ( '~' )* term )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:731:9: ( '~' )* term
            {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:731:9: ( '~' )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==NOT) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:731:10: '~'
            	    {
            	    match(input,NOT,FOLLOW_NOT_in_negation7603); 
            	    e.addOperator("~");

            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

            pushFollow(FOLLOW_term_in_negation7609);
            term66=term();

            state._fsp--;

            e.setTerm((term66!=null?term66.t:null));

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:734:1: unary returns [UnaryExpression e] : ( (op= '+' | op= '-' | op= '!' | op= '++' | op= '--' ) )* negation ( (op2= '++' | op2= '--' ) )? {...}?;
    public final UnaryExpression unary() throws RecognitionException {
        UnaryExpression e = null;

        Token op=null;
        Token op2=null;
        NegationExpression negation67 = null;


         e = new UnaryExpression();
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:736:5: ( ( (op= '+' | op= '-' | op= '!' | op= '++' | op= '--' ) )* negation ( (op2= '++' | op2= '--' ) )? {...}?)
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:736:9: ( (op= '+' | op= '-' | op= '!' | op= '++' | op= '--' ) )* negation ( (op2= '++' | op2= '--' ) )? {...}?
            {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:736:9: ( (op= '+' | op= '-' | op= '!' | op= '++' | op= '--' ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==DEC||LA50_0==INC||LA50_0==LOGICAL_NOT||LA50_0==MINUS||LA50_0==PLUS) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:736:10: (op= '+' | op= '-' | op= '!' | op= '++' | op= '--' )
            	    {
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:736:10: (op= '+' | op= '-' | op= '!' | op= '++' | op= '--' )
            	    int alt49=5;
            	    switch ( input.LA(1) ) {
            	    case PLUS:
            	        {
            	        alt49=1;
            	        }
            	        break;
            	    case MINUS:
            	        {
            	        alt49=2;
            	        }
            	        break;
            	    case LOGICAL_NOT:
            	        {
            	        alt49=3;
            	        }
            	        break;
            	    case INC:
            	        {
            	        alt49=4;
            	        }
            	        break;
            	    case DEC:
            	        {
            	        alt49=5;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 49, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt49) {
            	        case 1 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:736:11: op= '+'
            	            {
            	            op=(Token)match(input,PLUS,FOLLOW_PLUS_in_unary7649); 

            	            }
            	            break;
            	        case 2 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:736:22: op= '-'
            	            {
            	            op=(Token)match(input,MINUS,FOLLOW_MINUS_in_unary7657); 

            	            }
            	            break;
            	        case 3 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:736:33: op= '!'
            	            {
            	            op=(Token)match(input,LOGICAL_NOT,FOLLOW_LOGICAL_NOT_in_unary7665); 

            	            }
            	            break;
            	        case 4 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:736:44: op= '++'
            	            {
            	            op=(Token)match(input,INC,FOLLOW_INC_in_unary7673); 

            	            }
            	            break;
            	        case 5 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:736:56: op= '--'
            	            {
            	            op=(Token)match(input,DEC,FOLLOW_DEC_in_unary7681); 

            	            }
            	            break;

            	    }

            	    e.addOperator((op!=null?op.getText():null));

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            pushFollow(FOLLOW_negation_in_unary7697);
            negation67=negation();

            state._fsp--;

            e.addExpression(negation67);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:738:9: ( (op2= '++' | op2= '--' ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==DEC||LA52_0==INC) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:738:10: (op2= '++' | op2= '--' )
                    {
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:738:10: (op2= '++' | op2= '--' )
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==INC) ) {
                        alt51=1;
                    }
                    else if ( (LA51_0==DEC) ) {
                        alt51=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 51, 0, input);

                        throw nvae;
                    }
                    switch (alt51) {
                        case 1 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:738:11: op2= '++'
                            {
                            op2=(Token)match(input,INC,FOLLOW_INC_in_unary7715); 

                            }
                            break;
                        case 2 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:738:24: op2= '--'
                            {
                            op2=(Token)match(input,DEC,FOLLOW_DEC_in_unary7723); 

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:743:1: mult returns [MultExpression e] : e1= unary ( (op= '*' | op= '/' | op= '%' ) e2= unary )* ;
    public final MultExpression mult() throws RecognitionException {
        MultExpression e = null;

        Token op=null;
        UnaryExpression e1 = null;

        UnaryExpression e2 = null;


         e = new MultExpression();
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:745:5: (e1= unary ( (op= '*' | op= '/' | op= '%' ) e2= unary )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:745:9: e1= unary ( (op= '*' | op= '/' | op= '%' ) e2= unary )*
            {
            pushFollow(FOLLOW_unary_in_mult7770);
            e1=unary();

            state._fsp--;

            e.addExpression(e1);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:746:9: ( (op= '*' | op= '/' | op= '%' ) e2= unary )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==DIV||LA54_0==MOD||LA54_0==STAR) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:747:13: (op= '*' | op= '/' | op= '%' ) e2= unary
            	    {
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:747:13: (op= '*' | op= '/' | op= '%' )
            	    int alt53=3;
            	    switch ( input.LA(1) ) {
            	    case STAR:
            	        {
            	        alt53=1;
            	        }
            	        break;
            	    case DIV:
            	        {
            	        alt53=2;
            	        }
            	        break;
            	    case MOD:
            	        {
            	        alt53=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 53, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt53) {
            	        case 1 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:747:14: op= '*'
            	            {
            	            op=(Token)match(input,STAR,FOLLOW_STAR_in_mult7802); 

            	            }
            	            break;
            	        case 2 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:747:25: op= '/'
            	            {
            	            op=(Token)match(input,DIV,FOLLOW_DIV_in_mult7810); 

            	            }
            	            break;
            	        case 3 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:747:36: op= '%'
            	            {
            	            op=(Token)match(input,MOD,FOLLOW_MOD_in_mult7818); 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_unary_in_mult7838);
            	    e2=unary();

            	    state._fsp--;

            	    e.addOperator((op!=null?op.getText():null)); e.addExpression(e2);

            	    }
            	    break;

            	default :
            	    break loop54;
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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:752:1: add returns [AddExpression e] : e1= mult ( (op= '+' | op= '-' ) e2= mult )* ;
    public final AddExpression add() throws RecognitionException {
        AddExpression e = null;

        Token op=null;
        MultExpression e1 = null;

        MultExpression e2 = null;


         e = new AddExpression(); 
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:754:5: (e1= mult ( (op= '+' | op= '-' ) e2= mult )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:754:9: e1= mult ( (op= '+' | op= '-' ) e2= mult )*
            {
            pushFollow(FOLLOW_mult_in_add7886);
            e1=mult();

            state._fsp--;

            e.addExpression(e1);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:755:9: ( (op= '+' | op= '-' ) e2= mult )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==MINUS||LA56_0==PLUS) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:756:13: (op= '+' | op= '-' ) e2= mult
            	    {
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:756:13: (op= '+' | op= '-' )
            	    int alt55=2;
            	    int LA55_0 = input.LA(1);

            	    if ( (LA55_0==PLUS) ) {
            	        alt55=1;
            	    }
            	    else if ( (LA55_0==MINUS) ) {
            	        alt55=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 55, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt55) {
            	        case 1 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:756:14: op= '+'
            	            {
            	            op=(Token)match(input,PLUS,FOLLOW_PLUS_in_add7918); 

            	            }
            	            break;
            	        case 2 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:756:25: op= '-'
            	            {
            	            op=(Token)match(input,MINUS,FOLLOW_MINUS_in_add7926); 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_mult_in_add7946);
            	    e2=mult();

            	    state._fsp--;

            	    e.addOperator((op!=null?op.getText():null)); e.addExpression(e2);

            	    }
            	    break;

            	default :
            	    break loop56;
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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:761:1: relation returns [Expression e] : e1= add ( (op= '==' | op= '!=' | op= '<' | op= '<=' | op= '>=' | op= '>' ) e2= add )* ;
    public final Expression relation() throws RecognitionException {
        Expression e = null;

        Token op=null;
        AddExpression e1 = null;

        AddExpression e2 = null;


         e = new Expression();
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:763:5: (e1= add ( (op= '==' | op= '!=' | op= '<' | op= '<=' | op= '>=' | op= '>' ) e2= add )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:763:9: e1= add ( (op= '==' | op= '!=' | op= '<' | op= '<=' | op= '>=' | op= '>' ) e2= add )*
            {
            pushFollow(FOLLOW_add_in_relation7990);
            e1=add();

            state._fsp--;

            e.addExpression(e1);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:764:9: ( (op= '==' | op= '!=' | op= '<' | op= '<=' | op= '>=' | op= '>' ) e2= add )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( ((LA58_0>=EQUAL && LA58_0<=GREATER_THAN)||(LA58_0>=LESS_OR_EQUAL && LA58_0<=LESS_THAN)||LA58_0==NOT_EQUAL) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:765:13: (op= '==' | op= '!=' | op= '<' | op= '<=' | op= '>=' | op= '>' ) e2= add
            	    {
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:765:13: (op= '==' | op= '!=' | op= '<' | op= '<=' | op= '>=' | op= '>' )
            	    int alt57=6;
            	    switch ( input.LA(1) ) {
            	    case EQUAL:
            	        {
            	        alt57=1;
            	        }
            	        break;
            	    case NOT_EQUAL:
            	        {
            	        alt57=2;
            	        }
            	        break;
            	    case LESS_THAN:
            	        {
            	        alt57=3;
            	        }
            	        break;
            	    case LESS_OR_EQUAL:
            	        {
            	        alt57=4;
            	        }
            	        break;
            	    case GREATER_OR_EQUAL:
            	        {
            	        alt57=5;
            	        }
            	        break;
            	    case GREATER_THAN:
            	        {
            	        alt57=6;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 57, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt57) {
            	        case 1 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:765:14: op= '=='
            	            {
            	            op=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_relation8023); 

            	            }
            	            break;
            	        case 2 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:765:26: op= '!='
            	            {
            	            op=(Token)match(input,NOT_EQUAL,FOLLOW_NOT_EQUAL_in_relation8031); 

            	            }
            	            break;
            	        case 3 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:765:38: op= '<'
            	            {
            	            op=(Token)match(input,LESS_THAN,FOLLOW_LESS_THAN_in_relation8039); 

            	            }
            	            break;
            	        case 4 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:765:49: op= '<='
            	            {
            	            op=(Token)match(input,LESS_OR_EQUAL,FOLLOW_LESS_OR_EQUAL_in_relation8047); 

            	            }
            	            break;
            	        case 5 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:765:61: op= '>='
            	            {
            	            op=(Token)match(input,GREATER_OR_EQUAL,FOLLOW_GREATER_OR_EQUAL_in_relation8055); 

            	            }
            	            break;
            	        case 6 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:765:73: op= '>'
            	            {
            	            op=(Token)match(input,GREATER_THAN,FOLLOW_GREATER_THAN_in_relation8063); 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_add_in_relation8083);
            	    e2=add();

            	    state._fsp--;

            	    e.addOperator((op!=null?op.getText():null)); e.addExpression(e2);

            	    }
            	    break;

            	default :
            	    break loop58;
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

    public static class expression_return extends ParserRuleReturnScope {
        public Expression e;
    };

    // $ANTLR start "expression"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:770:1: expression returns [Expression e] : e1= relation ( (op= '&&' | op= '||' | op= 'instanceof' ) e2= relation )* ;
    public final SalsaParser.expression_return expression() throws RecognitionException {
        SalsaParser.expression_return retval = new SalsaParser.expression_return();
        retval.start = input.LT(1);

        Token op=null;
        Expression e1 = null;

        Expression e2 = null;


         retval.e = new Expression(); 
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:775:5: (e1= relation ( (op= '&&' | op= '||' | op= 'instanceof' ) e2= relation )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:776:9: e1= relation ( (op= '&&' | op= '||' | op= 'instanceof' ) e2= relation )*
            {
            retval.e.setLine(getLine(input));
            pushFollow(FOLLOW_relation_in_expression8154);
            e1=relation();

            state._fsp--;

            retval.e.addExpression(e1);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:778:9: ( (op= '&&' | op= '||' | op= 'instanceof' ) e2= relation )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==LOGICAL_AND||LA60_0==LOGICAL_OR||LA60_0==INSTANCEOF) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:779:13: (op= '&&' | op= '||' | op= 'instanceof' ) e2= relation
            	    {
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:779:13: (op= '&&' | op= '||' | op= 'instanceof' )
            	    int alt59=3;
            	    switch ( input.LA(1) ) {
            	    case LOGICAL_AND:
            	        {
            	        alt59=1;
            	        }
            	        break;
            	    case LOGICAL_OR:
            	        {
            	        alt59=2;
            	        }
            	        break;
            	    case INSTANCEOF:
            	        {
            	        alt59=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 59, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt59) {
            	        case 1 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:779:14: op= '&&'
            	            {
            	            op=(Token)match(input,LOGICAL_AND,FOLLOW_LOGICAL_AND_in_expression8188); 

            	            }
            	            break;
            	        case 2 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:779:26: op= '||'
            	            {
            	            op=(Token)match(input,LOGICAL_OR,FOLLOW_LOGICAL_OR_in_expression8196); 

            	            }
            	            break;
            	        case 3 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:779:38: op= 'instanceof'
            	            {
            	            op=(Token)match(input,INSTANCEOF,FOLLOW_INSTANCEOF_in_expression8204); 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_relation_in_expression8211);
            	    e2=relation();

            	    state._fsp--;

            	    retval.e.addOperator((op!=null?op.getText():null)); retval.e.addExpression(e2);

            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

             
                retval.e.setSalsaSource(input.toString(retval.start,input.LT(-1)));

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"


    // $ANTLR start "literal"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:785:1: literal returns [Literal literal] : ( HEX_LITERAL | DECIMAL_LITERAL | OCTAL_LITERAL | CHARACTER_LITERAL | STRING_LITERAL | FLOATING_POINT_LITERAL | (t= 'true' | t= 'false' ) | 'null' );
    public final Literal literal() throws RecognitionException {
        Literal literal = null;

        Token t=null;
        Token HEX_LITERAL68=null;
        Token DECIMAL_LITERAL69=null;
        Token OCTAL_LITERAL70=null;
        Token CHARACTER_LITERAL71=null;
        Token STRING_LITERAL72=null;
        Token FLOATING_POINT_LITERAL73=null;

        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:786:5: ( HEX_LITERAL | DECIMAL_LITERAL | OCTAL_LITERAL | CHARACTER_LITERAL | STRING_LITERAL | FLOATING_POINT_LITERAL | (t= 'true' | t= 'false' ) | 'null' )
            int alt62=8;
            switch ( input.LA(1) ) {
            case HEX_LITERAL:
                {
                alt62=1;
                }
                break;
            case DECIMAL_LITERAL:
                {
                alt62=2;
                }
                break;
            case OCTAL_LITERAL:
                {
                alt62=3;
                }
                break;
            case CHARACTER_LITERAL:
                {
                alt62=4;
                }
                break;
            case STRING_LITERAL:
                {
                alt62=5;
                }
                break;
            case FLOATING_POINT_LITERAL:
                {
                alt62=6;
                }
                break;
            case FALSE:
            case TRUE:
                {
                alt62=7;
                }
                break;
            case NULL:
                {
                alt62=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:786:9: HEX_LITERAL
                    {
                    HEX_LITERAL68=(Token)match(input,HEX_LITERAL,FOLLOW_HEX_LITERAL_in_literal8261); 
                    literal = new Literal("int", (HEX_LITERAL68!=null?HEX_LITERAL68.getText():null));

                    }
                    break;
                case 2 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:787:9: DECIMAL_LITERAL
                    {
                    DECIMAL_LITERAL69=(Token)match(input,DECIMAL_LITERAL,FOLLOW_DECIMAL_LITERAL_in_literal8273); 
                    literal = new Literal("int", (DECIMAL_LITERAL69!=null?DECIMAL_LITERAL69.getText():null));

                    }
                    break;
                case 3 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:788:9: OCTAL_LITERAL
                    {
                    OCTAL_LITERAL70=(Token)match(input,OCTAL_LITERAL,FOLLOW_OCTAL_LITERAL_in_literal8285); 
                    literal = new Literal("int", (OCTAL_LITERAL70!=null?OCTAL_LITERAL70.getText():null));

                    }
                    break;
                case 4 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:789:9: CHARACTER_LITERAL
                    {
                    CHARACTER_LITERAL71=(Token)match(input,CHARACTER_LITERAL,FOLLOW_CHARACTER_LITERAL_in_literal8297); 
                    literal = new Literal("char", (CHARACTER_LITERAL71!=null?CHARACTER_LITERAL71.getText():null));

                    }
                    break;
                case 5 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:790:9: STRING_LITERAL
                    {
                    STRING_LITERAL72=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_literal8311); 
                    literal = new Literal("java.lang.String", (STRING_LITERAL72!=null?STRING_LITERAL72.getText():null));

                    }
                    break;
                case 6 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:791:9: FLOATING_POINT_LITERAL
                    {
                    FLOATING_POINT_LITERAL73=(Token)match(input,FLOATING_POINT_LITERAL,FOLLOW_FLOATING_POINT_LITERAL_in_literal8324); 
                    literal = new Literal("double", (FLOATING_POINT_LITERAL73!=null?FLOATING_POINT_LITERAL73.getText():null));

                    }
                    break;
                case 7 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:792:9: (t= 'true' | t= 'false' )
                    {
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:792:9: (t= 'true' | t= 'false' )
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==TRUE) ) {
                        alt61=1;
                    }
                    else if ( (LA61_0==FALSE) ) {
                        alt61=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 61, 0, input);

                        throw nvae;
                    }
                    switch (alt61) {
                        case 1 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:792:10: t= 'true'
                            {
                            t=(Token)match(input,TRUE,FOLLOW_TRUE_in_literal8342); 

                            }
                            break;
                        case 2 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:792:23: t= 'false'
                            {
                            t=(Token)match(input,FALSE,FOLLOW_FALSE_in_literal8350); 

                            }
                            break;

                    }

                    literal = new Literal("boolean", (t!=null?t.getText():null));

                    }
                    break;
                case 8 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:793:9: 'null'
                    {
                    match(input,NULL,FOLLOW_NULL_in_literal8363); 
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

    // Delegated rules


    protected DFA13 dfa13 = new DFA13(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA45 dfa45 = new DFA45(this);
    static final String DFA13_eotS =
        "\5\uffff";
    static final String DFA13_eofS =
        "\5\uffff";
    static final String DFA13_minS =
        "\2\65\3\uffff";
    static final String DFA13_maxS =
        "\2\u00b9\3\uffff";
    static final String DFA13_acceptS =
        "\2\uffff\1\1\1\2\1\3";
    static final String DFA13_specialS =
        "\5\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\1\7\uffff\1\3\10\uffff\1\1\6\uffff\1\4\3\uffff\1\1\3\uffff"+
            "\3\1\2\uffff\2\1\2\uffff\1\1\3\uffff\1\1\3\uffff\1\1\122\uffff"+
            "\1\2",
            "\1\1\7\uffff\1\3\10\uffff\1\1\6\uffff\1\4\3\uffff\1\1\3\uffff"+
            "\3\1\2\uffff\2\1\2\uffff\1\1\3\uffff\1\1\3\uffff\1\1\122\uffff"+
            "\1\2",
            "",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "406:1: typeDeclaration returns [TypeDeclaration td] : ( behaviorDeclaration | classDeclaration | interfaceDeclaration );";
        }
    }
    static final String DFA15_eotS =
        "\15\uffff";
    static final String DFA15_eofS =
        "\15\uffff";
    static final String DFA15_minS =
        "\1\52\1\uffff\1\65\1\67\1\26\1\17\1\51\1\6\1\u00a4\1\26\2\uffff"+
        "\1\17";
    static final String DFA15_maxS =
        "\1\u00b8\1\uffff\1\u00b8\3\u00a4\1\51\1\54\2\u00a4\2\uffff\1\u00a4";
    static final String DFA15_acceptS =
        "\1\uffff\1\3\10\uffff\1\1\1\2\1\uffff";
    static final String DFA15_specialS =
        "\15\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\1\12\uffff\1\2\1\uffff\1\4\1\uffff\1\4\2\uffff\1\4\4\uffff"+
            "\1\4\4\uffff\1\2\1\uffff\1\4\6\uffff\2\4\1\2\3\uffff\3\2\1\uffff"+
            "\1\4\2\2\2\uffff\1\2\3\uffff\1\2\2\uffff\1\4\1\2\75\uffff\1"+
            "\5\23\uffff\1\3",
            "",
            "\1\2\1\uffff\1\4\1\uffff\1\4\2\uffff\1\4\4\uffff\1\4\4\uffff"+
            "\1\2\1\uffff\1\4\6\uffff\2\4\1\2\3\uffff\3\2\1\uffff\1\4\2\2"+
            "\2\uffff\1\2\3\uffff\1\2\2\uffff\1\4\1\2\75\uffff\1\5\23\uffff"+
            "\1\3",
            "\1\4\1\uffff\1\4\2\uffff\1\4\4\uffff\1\4\6\uffff\1\4\6\uffff"+
            "\2\4\10\uffff\1\4\13\uffff\1\4\76\uffff\1\5",
            "\1\6\u008d\uffff\1\7",
            "\1\10\6\uffff\1\6\u008d\uffff\1\7",
            "\1\11",
            "\1\12\4\uffff\1\12\21\uffff\1\13\16\uffff\1\12",
            "\1\14",
            "\1\6\u008d\uffff\1\7",
            "",
            "",
            "\1\10\6\uffff\1\6\u008d\uffff\1\7"
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
            return "()* loopback of 418:13: ( fieldVariableDeclaration | intefaceMethodDeclaration )*";
        }
    }
    static final String DFA18_eotS =
        "\17\uffff";
    static final String DFA18_eofS =
        "\17\uffff";
    static final String DFA18_minS =
        "\1\52\1\uffff\1\65\1\67\1\26\2\17\1\51\1\6\1\u00a4\1\uffff\1\26"+
        "\2\uffff\1\17";
    static final String DFA18_maxS =
        "\1\u00b8\1\uffff\1\u00b8\4\u00a4\1\51\1\54\1\u00a4\1\uffff\1\u00a4"+
        "\2\uffff\1\u00a4";
    static final String DFA18_acceptS =
        "\1\uffff\1\4\10\uffff\1\2\1\uffff\1\1\1\3\1\uffff";
    static final String DFA18_specialS =
        "\17\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\1\12\uffff\1\2\1\uffff\1\4\1\uffff\1\4\2\uffff\1\4\4\uffff"+
            "\1\4\4\uffff\1\2\1\uffff\1\4\6\uffff\2\4\1\2\3\uffff\3\2\1\uffff"+
            "\1\4\2\2\2\uffff\1\2\3\uffff\1\2\2\uffff\1\4\1\2\75\uffff\1"+
            "\5\23\uffff\1\3",
            "",
            "\1\2\1\uffff\1\4\1\uffff\1\4\2\uffff\1\4\4\uffff\1\4\4\uffff"+
            "\1\2\1\uffff\1\4\6\uffff\2\4\1\2\3\uffff\3\2\1\uffff\1\4\2\2"+
            "\2\uffff\1\2\3\uffff\1\2\2\uffff\1\4\1\2\75\uffff\1\5\23\uffff"+
            "\1\3",
            "\1\4\1\uffff\1\4\2\uffff\1\4\4\uffff\1\4\6\uffff\1\4\6\uffff"+
            "\2\4\10\uffff\1\4\13\uffff\1\4\76\uffff\1\6",
            "\1\7\u008d\uffff\1\10",
            "\1\11\6\uffff\1\7\6\uffff\1\12\u0086\uffff\1\10",
            "\1\11\6\uffff\1\7\u008d\uffff\1\10",
            "\1\13",
            "\1\14\4\uffff\1\14\21\uffff\1\15\16\uffff\1\14",
            "\1\16",
            "",
            "\1\7\u008d\uffff\1\10",
            "",
            "",
            "\1\11\6\uffff\1\7\u008d\uffff\1\10"
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "()* loopback of 436:13: ( fieldVariableDeclaration | constructorDeclaration | classMethodDeclaration )*";
        }
    }
    static final String DFA21_eotS =
        "\17\uffff";
    static final String DFA21_eofS =
        "\17\uffff";
    static final String DFA21_minS =
        "\1\52\1\uffff\1\65\1\67\1\26\2\17\1\51\1\6\1\u00a4\1\uffff\1\26"+
        "\2\uffff\1\17";
    static final String DFA21_maxS =
        "\1\u00b8\1\uffff\1\u00b8\4\u00a4\1\51\1\54\1\u00a4\1\uffff\1\u00a4"+
        "\2\uffff\1\u00a4";
    static final String DFA21_acceptS =
        "\1\uffff\1\4\10\uffff\1\2\1\uffff\1\3\1\1\1\uffff";
    static final String DFA21_specialS =
        "\17\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\1\12\uffff\1\2\1\uffff\1\4\1\uffff\1\4\2\uffff\1\4\4\uffff"+
            "\1\4\4\uffff\1\2\1\uffff\1\4\6\uffff\2\4\1\2\3\uffff\3\2\1\uffff"+
            "\1\4\2\2\2\uffff\1\2\3\uffff\1\2\2\uffff\1\4\1\2\75\uffff\1"+
            "\5\23\uffff\1\3",
            "",
            "\1\2\1\uffff\1\4\1\uffff\1\4\2\uffff\1\4\4\uffff\1\4\4\uffff"+
            "\1\2\1\uffff\1\4\6\uffff\2\4\1\2\3\uffff\3\2\1\uffff\1\4\2\2"+
            "\2\uffff\1\2\3\uffff\1\2\2\uffff\1\4\1\2\75\uffff\1\5\23\uffff"+
            "\1\3",
            "\1\4\1\uffff\1\4\2\uffff\1\4\4\uffff\1\4\6\uffff\1\4\6\uffff"+
            "\2\4\10\uffff\1\4\13\uffff\1\4\76\uffff\1\6",
            "\1\7\u008d\uffff\1\10",
            "\1\11\6\uffff\1\7\6\uffff\1\12\u0086\uffff\1\10",
            "\1\11\6\uffff\1\7\u008d\uffff\1\10",
            "\1\13",
            "\1\15\4\uffff\1\15\21\uffff\1\14\16\uffff\1\15",
            "\1\16",
            "",
            "\1\7\u008d\uffff\1\10",
            "",
            "",
            "\1\11\6\uffff\1\7\u008d\uffff\1\10"
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "()* loopback of 455:10: ( fieldVariableDeclaration | constructorDeclaration | messageHandlerDeclaration )*";
        }
    }
    static final String DFA28_eotS =
        "\16\uffff";
    static final String DFA28_eofS =
        "\16\uffff";
    static final String DFA28_minS =
        "\1\14\1\uffff\1\6\6\uffff\1\14\1\u00a4\1\6\1\u00a4\1\6";
    static final String DFA28_maxS =
        "\1\u00ba\1\uffff\1\u00bb\6\uffff\1\u00aa\4\u00a4";
    static final String DFA28_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\3\1\4\1\5\1\6\1\7\5\uffff";
    static final String DFA28_specialS =
        "\16\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\3\10\uffff\1\3\1\uffff\1\5\3\uffff\1\3\1\uffff\2\3\3\uffff"+
            "\1\3\3\uffff\1\3\20\uffff\1\1\1\uffff\1\1\2\uffff\1\1\4\uffff"+
            "\1\1\3\uffff\1\3\2\uffff\1\1\1\10\1\6\4\uffff\2\1\1\uffff\2"+
            "\3\4\uffff\1\7\1\1\11\uffff\1\3\1\uffff\1\1\76\uffff\1\2\6\3"+
            "\15\uffff\1\1\1\uffff\1\4",
            "",
            "\2\3\4\uffff\2\3\1\uffff\1\12\2\uffff\4\3\1\11\1\uffff\5\3"+
            "\1\uffff\1\3\1\uffff\1\3\2\uffff\1\3\2\uffff\1\3\5\uffff\1\3"+
            "\4\uffff\1\3\32\uffff\1\3\127\uffff\1\1\26\uffff\1\3",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\3\10\uffff\1\3\5\uffff\1\3\1\uffff\2\3\3\uffff\1\3\3\uffff"+
            "\1\3\2\uffff\1\1\33\uffff\1\3\14\uffff\2\3\17\uffff\1\3\100"+
            "\uffff\7\3",
            "\1\13",
            "\2\3\4\uffff\2\3\1\uffff\1\14\2\uffff\4\3\1\1\1\uffff\3\3\1"+
            "\uffff\3\3\1\uffff\1\3\2\uffff\1\3\2\uffff\1\3\5\uffff\1\3\4"+
            "\uffff\1\3\32\uffff\1\3\127\uffff\1\1",
            "\1\15",
            "\2\3\4\uffff\2\3\1\uffff\1\14\2\uffff\4\3\1\1\1\uffff\3\3\1"+
            "\uffff\3\3\1\uffff\1\3\2\uffff\1\3\2\uffff\1\3\5\uffff\1\3\4"+
            "\uffff\1\3\32\uffff\1\3\127\uffff\1\1"
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "549:5: ( localVariableDeclaration ( ';' | '@' ) | e1= expression ( '=' e2= expression )? ( ';' | '@' ) | joinBlockStatement ( '@' ) | blockStatement | ifStatement | returnStatement ';' | forStatement )";
        }
    }
    static final String DFA36_eotS =
        "\13\uffff";
    static final String DFA36_eofS =
        "\7\uffff\1\2\3\uffff";
    static final String DFA36_minS =
        "\1\35\1\14\1\uffff\1\14\1\uffff\1\14\1\u00a4\1\6\1\14\1\u00a4\1"+
        "\14";
    static final String DFA36_maxS =
        "\1\u00aa\1\u00b8\1\uffff\1\u00bb\1\uffff\1\u00aa\1\u00a4\1\u00bb"+
        "\1\114\1\u00a4\1\114";
    static final String DFA36_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\6\uffff";
    static final String DFA36_specialS =
        "\13\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\1\47\uffff\1\2\14\uffff\2\2\17\uffff\1\2\100\uffff\7\2",
            "\1\2\10\uffff\1\2\5\uffff\1\2\1\uffff\2\2\3\uffff\1\2\3\uffff"+
            "\1\2\20\uffff\1\4\1\uffff\1\4\2\uffff\1\4\4\uffff\1\4\3\uffff"+
            "\1\2\2\uffff\1\4\6\uffff\2\4\1\uffff\2\2\5\uffff\1\4\11\uffff"+
            "\1\2\1\uffff\1\4\76\uffff\1\3\6\2\15\uffff\1\4",
            "",
            "\2\2\1\uffff\1\6\2\uffff\4\2\1\5\1\uffff\5\2\1\uffff\1\2\1"+
            "\uffff\1\2\2\uffff\1\2\2\uffff\1\2\4\uffff\1\7\5\uffff\1\2\32"+
            "\uffff\1\2\156\uffff\1\2",
            "",
            "\1\2\10\uffff\1\2\5\uffff\1\2\1\uffff\2\2\3\uffff\1\2\3\uffff"+
            "\1\2\2\uffff\1\4\33\uffff\1\2\14\uffff\2\2\17\uffff\1\2\100"+
            "\uffff\7\2",
            "\1\10",
            "\2\2\3\uffff\3\2\1\uffff\1\2\2\uffff\4\2\2\uffff\5\2\1\4\1"+
            "\2\1\uffff\1\2\2\uffff\1\2\2\uffff\1\2\2\uffff\1\2\1\uffff\2"+
            "\2\4\uffff\1\2\23\uffff\1\4\6\uffff\1\2\5\uffff\2\4\17\uffff"+
            "\1\4\100\uffff\7\4\20\uffff\1\2",
            "\2\2\1\uffff\1\11\2\uffff\4\2\1\4\1\uffff\3\2\1\uffff\3\2\1"+
            "\uffff\1\2\2\uffff\1\2\2\uffff\1\2\4\uffff\1\7\5\uffff\1\2\32"+
            "\uffff\1\2",
            "\1\12",
            "\2\2\1\uffff\1\11\2\uffff\4\2\1\4\1\uffff\3\2\1\uffff\3\2\1"+
            "\uffff\1\2\2\uffff\1\2\2\uffff\1\2\4\uffff\1\7\5\uffff\1\2\32"+
            "\uffff\1\2"
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "678:9: ( '(' type ')' )?";
        }
    }
    static final String DFA45_eotS =
        "\11\uffff";
    static final String DFA45_eofS =
        "\11\uffff";
    static final String DFA45_minS =
        "\1\122\1\67\1\26\1\17\1\uffff\1\14\1\u00a4\1\uffff\1\17";
    static final String DFA45_maxS =
        "\1\122\1\u00b8\2\35\1\uffff\1\u00aa\1\u00a4\1\uffff\1\35";
    static final String DFA45_acceptS =
        "\4\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String DFA45_specialS =
        "\11\uffff}>";
    static final String[] DFA45_transitionS = {
            "\1\1",
            "\1\2\1\uffff\1\2\2\uffff\1\2\4\uffff\1\2\6\uffff\1\2\6\uffff"+
            "\2\2\10\uffff\1\2\13\uffff\1\2\76\uffff\1\3\23\uffff\1\4",
            "\1\5\6\uffff\1\4",
            "\1\6\6\uffff\1\5\6\uffff\1\4",
            "",
            "\1\7\10\uffff\1\7\5\uffff\1\7\1\uffff\2\7\3\uffff\1\7\3\uffff"+
            "\1\7\2\uffff\1\4\33\uffff\1\7\14\uffff\2\7\17\uffff\1\7\100"+
            "\uffff\7\7",
            "\1\10",
            "",
            "\1\6\6\uffff\1\5\6\uffff\1\4"
    };

    static final short[] DFA45_eot = DFA.unpackEncodedString(DFA45_eotS);
    static final short[] DFA45_eof = DFA.unpackEncodedString(DFA45_eofS);
    static final char[] DFA45_min = DFA.unpackEncodedStringToUnsignedChars(DFA45_minS);
    static final char[] DFA45_max = DFA.unpackEncodedStringToUnsignedChars(DFA45_maxS);
    static final short[] DFA45_accept = DFA.unpackEncodedString(DFA45_acceptS);
    static final short[] DFA45_special = DFA.unpackEncodedString(DFA45_specialS);
    static final short[][] DFA45_transition;

    static {
        int numStates = DFA45_transitionS.length;
        DFA45_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA45_transition[i] = DFA.unpackEncodedString(DFA45_transitionS[i]);
        }
    }

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = DFA45_eot;
            this.eof = DFA45_eof;
            this.min = DFA45_min;
            this.max = DFA45_max;
            this.accept = DFA45_accept;
            this.special = DFA45_special;
            this.transition = DFA45_transition;
        }
        public String getDescription() {
            return "699:1: allocation returns [Allocation a] : ( 'new' type actualParameters ( 'at' '(' uan= expression ( ',' host= expression )? ')' )? | ( 'new' ( primitiveType | qualifiedName ) ( '[' expression ']' )+ ) );";
        }
    }
 

    public static final BitSet FOLLOW_moduleDeclaration_in_compilationUnit4483 = new BitSet(new long[]{0x2020000000000000L,0x000000444CE26040L,0x0200000000000000L});
    public static final BitSet FOLLOW_importDeclaration_in_compilationUnit4498 = new BitSet(new long[]{0x2020000000000000L,0x000000444CE26040L,0x0200000000000000L});
    public static final BitSet FOLLOW_typeDeclaration_in_compilationUnit4514 = new BitSet(new long[]{0x2020000000000002L,0x000000444CE26040L,0x0200000000000000L});
    public static final BitSet FOLLOW_183_in_moduleDeclaration4541 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_qualifiedName_in_moduleDeclaration4543 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_moduleDeclaration4545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_importDeclaration4570 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_qualifiedName_in_importDeclaration4572 = new BitSet(new long[]{0x0000100000010000L});
    public static final BitSet FOLLOW_DOTSTAR_in_importDeclaration4585 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_importDeclaration4591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedName_in_qualifiedNameList4615 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_COMMA_in_qualifiedNameList4626 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_qualifiedName_in_qualifiedNameList4628 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_IDENT_in_qualifiedName4663 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_DOT_in_qualifiedName4674 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_IDENT_in_qualifiedName4676 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_set_in_modifiers4706 = new BitSet(new long[]{0x0020000000000002L,0x000000444CE20040L});
    public static final BitSet FOLLOW_FINAL_in_variableModifiers4841 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_type_in_typeList4876 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_COMMA_in_typeList4887 = new BitSet(new long[]{0x1280000000000000L,0x0000002002018102L,0x0100001000000000L});
    public static final BitSet FOLLOW_type_in_typeList4889 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_184_in_type4924 = new BitSet(new long[]{0x1280000000000000L,0x0000002002018102L,0x0000001000000000L});
    public static final BitSet FOLLOW_primitiveType_in_type4950 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_qualifiedName_in_type4964 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_LBRACK_in_type4989 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RBRACK_in_type4991 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_set_in_primitiveType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behaviorDeclaration_in_typeDeclaration5132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_typeDeclaration5144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceDeclaration_in_typeDeclaration5156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_interfaceDeclaration5193 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_INTERFACE_in_interfaceDeclaration5195 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_IDENT_in_interfaceDeclaration5197 = new BitSet(new long[]{0x0000000000800000L,0x0000000000000010L});
    public static final BitSet FOLLOW_EXTENDS_in_interfaceDeclaration5208 = new BitSet(new long[]{0x1280000000000000L,0x0000002002018102L,0x0100001000000000L});
    public static final BitSet FOLLOW_typeList_in_interfaceDeclaration5210 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LCURLY_in_interfaceDeclaration5222 = new BitSet(new long[]{0x12A0040000000000L,0x000000644EE38142L,0x0100001000000000L});
    public static final BitSet FOLLOW_fieldVariableDeclaration_in_interfaceDeclaration5240 = new BitSet(new long[]{0x12A0040000000000L,0x000000644EE38142L,0x0100001000000000L});
    public static final BitSet FOLLOW_intefaceMethodDeclaration_in_interfaceDeclaration5260 = new BitSet(new long[]{0x12A0040000000000L,0x000000644EE38142L,0x0100001000000000L});
    public static final BitSet FOLLOW_RCURLY_in_interfaceDeclaration5287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_classDeclaration5333 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_CLASS_in_classDeclaration5335 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_IDENT_in_classDeclaration5337 = new BitSet(new long[]{0x0000000000800000L,0x0000000000000810L});
    public static final BitSet FOLLOW_EXTENDS_in_classDeclaration5348 = new BitSet(new long[]{0x1280000000000000L,0x0000002002018102L,0x0100001000000000L});
    public static final BitSet FOLLOW_type_in_classDeclaration5350 = new BitSet(new long[]{0x0000000000800000L,0x0000000000000800L});
    public static final BitSet FOLLOW_IMPLEMENTS_in_classDeclaration5363 = new BitSet(new long[]{0x1280000000000000L,0x0000002002018102L,0x0100001000000000L});
    public static final BitSet FOLLOW_typeList_in_classDeclaration5365 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LCURLY_in_classDeclaration5387 = new BitSet(new long[]{0x12A0040000000000L,0x000000644EE38142L,0x0100001000000000L});
    public static final BitSet FOLLOW_fieldVariableDeclaration_in_classDeclaration5405 = new BitSet(new long[]{0x12A0040000000000L,0x000000644EE38142L,0x0100001000000000L});
    public static final BitSet FOLLOW_constructorDeclaration_in_classDeclaration5425 = new BitSet(new long[]{0x12A0040000000000L,0x000000644EE38142L,0x0100001000000000L});
    public static final BitSet FOLLOW_classMethodDeclaration_in_classDeclaration5445 = new BitSet(new long[]{0x12A0040000000000L,0x000000644EE38142L,0x0100001000000000L});
    public static final BitSet FOLLOW_RCURLY_in_classDeclaration5472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_behaviorDeclaration5508 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0200000000000000L});
    public static final BitSet FOLLOW_185_in_behaviorDeclaration5510 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_IDENT_in_behaviorDeclaration5512 = new BitSet(new long[]{0x0000000000800000L,0x0000000000000810L});
    public static final BitSet FOLLOW_EXTENDS_in_behaviorDeclaration5524 = new BitSet(new long[]{0x1280000000000000L,0x0000002002018102L,0x0100001000000000L});
    public static final BitSet FOLLOW_type_in_behaviorDeclaration5526 = new BitSet(new long[]{0x0000000000800000L,0x0000000000000800L});
    public static final BitSet FOLLOW_IMPLEMENTS_in_behaviorDeclaration5539 = new BitSet(new long[]{0x1280000000000000L,0x0000002002018102L,0x0100001000000000L});
    public static final BitSet FOLLOW_typeList_in_behaviorDeclaration5541 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LCURLY_in_behaviorDeclaration5563 = new BitSet(new long[]{0x12A0040000000000L,0x000000644EE38142L,0x0100001000000000L});
    public static final BitSet FOLLOW_fieldVariableDeclaration_in_behaviorDeclaration5578 = new BitSet(new long[]{0x12A0040000000000L,0x000000644EE38142L,0x0100001000000000L});
    public static final BitSet FOLLOW_constructorDeclaration_in_behaviorDeclaration5595 = new BitSet(new long[]{0x12A0040000000000L,0x000000644EE38142L,0x0100001000000000L});
    public static final BitSet FOLLOW_messageHandlerDeclaration_in_behaviorDeclaration5612 = new BitSet(new long[]{0x12A0040000000000L,0x000000644EE38142L,0x0100001000000000L});
    public static final BitSet FOLLOW_RCURLY_in_behaviorDeclaration5640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_intefaceMethodDeclaration5673 = new BitSet(new long[]{0x1280000000000000L,0x0000002002018102L,0x0100001000000000L});
    public static final BitSet FOLLOW_type_in_intefaceMethodDeclaration5675 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_IDENT_in_intefaceMethodDeclaration5677 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_formalParameters_in_intefaceMethodDeclaration5679 = new BitSet(new long[]{0x0000100000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_THROWS_in_intefaceMethodDeclaration5682 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_qualifiedNameList_in_intefaceMethodDeclaration5684 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_intefaceMethodDeclaration5689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_classMethodDeclaration5746 = new BitSet(new long[]{0x1280000000000000L,0x0000002002018102L,0x0100001000000000L});
    public static final BitSet FOLLOW_type_in_classMethodDeclaration5748 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_IDENT_in_classMethodDeclaration5750 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_formalParameters_in_classMethodDeclaration5752 = new BitSet(new long[]{0x0000000000800000L,0x0000000200000000L});
    public static final BitSet FOLLOW_THROWS_in_classMethodDeclaration5755 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_qualifiedNameList_in_classMethodDeclaration5757 = new BitSet(new long[]{0x0000000000800000L,0x0000000200000000L});
    public static final BitSet FOLLOW_block_in_classMethodDeclaration5769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_constructorDeclaration5808 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_IDENT_in_constructorDeclaration5810 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_formalParameters_in_constructorDeclaration5814 = new BitSet(new long[]{0x0000000000800000L,0x0000000200000000L});
    public static final BitSet FOLLOW_block_in_constructorDeclaration5816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_messageHandlerDeclaration5849 = new BitSet(new long[]{0x1280000000000000L,0x0000002002018102L,0x0100001000000000L});
    public static final BitSet FOLLOW_type_in_messageHandlerDeclaration5851 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_IDENT_in_messageHandlerDeclaration5853 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_formalParameters_in_messageHandlerDeclaration5855 = new BitSet(new long[]{0x0000000000800000L,0x0000000200000000L});
    public static final BitSet FOLLOW_block_in_messageHandlerDeclaration5866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURLY_in_block5904 = new BitSet(new long[]{0x1280044468A01000L,0x0000002A030D8722L,0x050007F000000000L});
    public static final BitSet FOLLOW_statement_in_block5907 = new BitSet(new long[]{0x1280044468A01000L,0x0000002A030D8722L,0x050007F000000000L});
    public static final BitSet FOLLOW_RCURLY_in_block5942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclaration_in_statement6007 = new BitSet(new long[]{0x0000100000000080L});
    public static final BitSet FOLLOW_SEMI_in_statement6010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_statement6014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement6032 = new BitSet(new long[]{0x00001000000000C0L});
    public static final BitSet FOLLOW_ASSIGN_in_statement6035 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_expression_in_statement6041 = new BitSet(new long[]{0x0000100000000080L});
    public static final BitSet FOLLOW_SEMI_in_statement6065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_statement6069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_joinBlockStatement_in_statement6082 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_AT_in_statement6085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blockStatement_in_statement6099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement6112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statement6124 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_statement6126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStatement_in_statement6138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_forStatement6186 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_LPAREN_in_forStatement6197 = new BitSet(new long[]{0x1280000000000000L,0x0000002002018102L,0x0100001000000000L});
    public static final BitSet FOLLOW_localVariableDeclaration_in_forStatement6212 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_forStatement6227 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_expression_in_forStatement6246 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_forStatement6248 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_expression_in_forStatement6267 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_forStatement6278 = new BitSet(new long[]{0x0000000000800000L,0x0000000200000000L});
    public static final BitSet FOLLOW_block_in_forStatement6288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_returnStatement6330 = new BitSet(new long[]{0x0000004468201002L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_expression_in_returnStatement6333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifStatement6373 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_LPAREN_in_ifStatement6375 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_expression_in_ifStatement6377 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_ifStatement6379 = new BitSet(new long[]{0x0000000000800000L,0x0000000200000000L});
    public static final BitSet FOLLOW_block_in_ifStatement6381 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_ELSE_in_ifStatement6394 = new BitSet(new long[]{0x1280004468A01000L,0x0000002A030D8722L,0x050007F000000000L});
    public static final BitSet FOLLOW_statement_in_ifStatement6396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_186_in_joinBlockStatement6427 = new BitSet(new long[]{0x0000000000800000L,0x0000000200000000L});
    public static final BitSet FOLLOW_block_in_joinBlockStatement6429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_blockStatement6467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_expressionStatement6492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_formalParameters6534 = new BitSet(new long[]{0x1280080000000000L,0x0000002002018102L,0x0100001000000000L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameters6562 = new BitSet(new long[]{0x0000080000000800L});
    public static final BitSet FOLLOW_COMMA_in_formalParameters6579 = new BitSet(new long[]{0x1280000000000000L,0x0000002002018102L,0x0100001000000000L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameters6585 = new BitSet(new long[]{0x0000080000000800L});
    public static final BitSet FOLLOW_RPAREN_in_formalParameters6611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_formalParameter6645 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_IDENT_in_formalParameter6655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_localVariableDeclaration6693 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_variableDeclaration_in_localVariableDeclaration6708 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_COMMA_in_localVariableDeclaration6730 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_variableDeclaration_in_localVariableDeclaration6736 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_modifiers_in_fieldVariableDeclaration6799 = new BitSet(new long[]{0x1280000000000000L,0x0000002002018102L,0x0100001000000000L});
    public static final BitSet FOLLOW_type_in_fieldVariableDeclaration6801 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_variableDeclaration_in_fieldVariableDeclaration6815 = new BitSet(new long[]{0x0000100000000800L});
    public static final BitSet FOLLOW_COMMA_in_fieldVariableDeclaration6838 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_variableDeclaration_in_fieldVariableDeclaration6844 = new BitSet(new long[]{0x0000100000000800L});
    public static final BitSet FOLLOW_SEMI_in_fieldVariableDeclaration6877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_variableDeclaration6916 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_ASSIGN_in_variableDeclaration6934 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_expression_in_variableDeclaration6936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_term7002 = new BitSet(new long[]{0x1280000000000000L,0x0000002002018102L,0x0100001000000000L});
    public static final BitSet FOLLOW_type_in_term7004 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_term7006 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_literal_in_term7039 = new BitSet(new long[]{0x0000000008008002L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_term7052 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_expression_in_term7058 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_term7060 = new BitSet(new long[]{0x0000000008008002L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_IDENT_in_term7076 = new BitSet(new long[]{0x0000000008408002L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_LBRACK_in_term7079 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_expression_in_term7085 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RBRACK_in_term7087 = new BitSet(new long[]{0x0000000008408002L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_allocation_in_term7113 = new BitSet(new long[]{0x0000000008008002L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_DOT_in_term7146 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_qualifiedName_in_term7152 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_actualParameters_in_term7178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_term7226 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_IDENT_in_term7238 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_actualParameters_in_term7263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_allocation7344 = new BitSet(new long[]{0x1280000000000000L,0x0000002002018102L,0x0100001000000000L});
    public static final BitSet FOLLOW_type_in_allocation7346 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_actualParameters_in_allocation7349 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x1000000000000000L});
    public static final BitSet FOLLOW_188_in_allocation7361 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_LPAREN_in_allocation7372 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_expression_in_allocation7376 = new BitSet(new long[]{0x0000080000000800L});
    public static final BitSet FOLLOW_COMMA_in_allocation7379 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_expression_in_allocation7383 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_allocation7411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_allocation7438 = new BitSet(new long[]{0x1280000000000000L,0x0000002002018102L,0x0000001000000000L});
    public static final BitSet FOLLOW_primitiveType_in_allocation7441 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_qualifiedName_in_allocation7449 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_LBRACK_in_allocation7473 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_expression_in_allocation7475 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RBRACK_in_allocation7477 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_LPAREN_in_actualParameters7512 = new BitSet(new long[]{0x0000084468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_expression_in_actualParameters7531 = new BitSet(new long[]{0x0000080000000800L});
    public static final BitSet FOLLOW_COMMA_in_actualParameters7548 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_expression_in_actualParameters7554 = new BitSet(new long[]{0x0000080000000800L});
    public static final BitSet FOLLOW_RPAREN_in_actualParameters7570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_negation7603 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_term_in_negation7609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_unary7649 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_MINUS_in_unary7657 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_LOGICAL_NOT_in_unary7665 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_INC_in_unary7673 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_DEC_in_unary7681 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_negation_in_unary7697 = new BitSet(new long[]{0x0000000000201002L});
    public static final BitSet FOLLOW_INC_in_unary7715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEC_in_unary7723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_in_mult7770 = new BitSet(new long[]{0x0002000100002002L});
    public static final BitSet FOLLOW_STAR_in_mult7802 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_DIV_in_mult7810 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_MOD_in_mult7818 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_unary_in_mult7838 = new BitSet(new long[]{0x0002000100002002L});
    public static final BitSet FOLLOW_mult_in_add7886 = new BitSet(new long[]{0x0000004040000002L});
    public static final BitSet FOLLOW_PLUS_in_add7918 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_MINUS_in_add7926 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_mult_in_add7946 = new BitSet(new long[]{0x0000004040000002L});
    public static final BitSet FOLLOW_add_in_relation7990 = new BitSet(new long[]{0x00000008031C0002L});
    public static final BitSet FOLLOW_EQUAL_in_relation8023 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_NOT_EQUAL_in_relation8031 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_LESS_THAN_in_relation8039 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_LESS_OR_EQUAL_in_relation8047 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_GREATER_OR_EQUAL_in_relation8055 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_GREATER_THAN_in_relation8063 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_add_in_relation8083 = new BitSet(new long[]{0x00000008031C0002L});
    public static final BitSet FOLLOW_relation_in_expression8154 = new BitSet(new long[]{0x0000000014000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_LOGICAL_AND_in_expression8188 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_LOGICAL_OR_in_expression8196 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_INSTANCEOF_in_expression8204 = new BitSet(new long[]{0x0000004468201000L,0x00000008000C0020L,0x000007F000000000L});
    public static final BitSet FOLLOW_relation_in_expression8211 = new BitSet(new long[]{0x0000000014000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_HEX_LITERAL_in_literal8261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECIMAL_LITERAL_in_literal8273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OCTAL_LITERAL_in_literal8285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARACTER_LITERAL_in_literal8297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_literal8311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOATING_POINT_LITERAL_in_literal8324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_literal8342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_literal8350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_literal8363 = new BitSet(new long[]{0x0000000000000002L});

}