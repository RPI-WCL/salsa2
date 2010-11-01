// $ANTLR 3.2 Sep 23, 2009 12:02:23 /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g 2010-10-31 22:05:51

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "AND_ASSIGN", "ASSIGN", "AT", "BIT_SHIFT_RIGHT", "BIT_SHIFT_RIGHT_ASSIGN", "COLON", "COMMA", "DEC", "DIV", "DIV_ASSIGN", "DOT", "DOTSTAR", "ELLIPSIS", "EQUAL", "GREATER_OR_EQUAL", "GREATER_THAN", "INC", "LBRACK", "LCURLY", "LESS_OR_EQUAL", "LESS_THAN", "LOGICAL_AND", "LOGICAL_NOT", "LOGICAL_OR", "LPAREN", "MINUS", "MINUS_ASSIGN", "MOD", "MOD_ASSIGN", "NOT", "NOT_EQUAL", "OR", "OR_ASSIGN", "PLUS", "PLUS_ASSIGN", "QUESTION", "RBRACK", "RCURLY", "RPAREN", "SEMI", "SHIFT_LEFT", "SHIFT_LEFT_ASSIGN", "SHIFT_RIGHT", "SHIFT_RIGHT_ASSIGN", "STAR", "STAR_ASSIGN", "XOR", "XOR_ASSIGN", "ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE", "CASE", "CATCH", "CHAR", "CLASS", "CONTINUE", "DEFAULT", "DO", "DOUBLE", "ELSE", "ENUM", "EXTENDS", "FALSE", "FINAL", "FINALLY", "FLOAT", "FOR", "IF", "IMPLEMENTS", "INSTANCEOF", "INTERFACE", "IMPORT", "INT", "LONG", "NATIVE", "NEW", "NULL", "PACKAGE", "PRIVATE", "PROTECTED", "PUBLIC", "RETURN", "SHORT", "STATIC", "STRICTFP", "SUPER", "SWITCH", "SYNCHRONIZED", "THROW", "THROWS", "TRANSIENT", "TRUE", "TRY", "VOID", "VOLATILE", "WHILE", "ANNOTATION_INIT_ARRAY_ELEMENT", "ANNOTATION_INIT_BLOCK", "ANNOTATION_INIT_DEFAULT_KEY", "ANNOTATION_INIT_KEY_LIST", "ANNOTATION_LIST", "ANNOTATION_METHOD_DECL", "ANNOTATION_SCOPE", "ANNOTATION_TOP_LEVEL_SCOPE", "ARGUMENT_LIST", "ARRAY_DECLARATOR", "ARRAY_DECLARATOR_LIST", "ARRAY_ELEMENT_ACCESS", "ARRAY_INITIALIZER", "BLOCK_SCOPE", "CAST_EXPR", "CATCH_CLAUSE_LIST", "CLASS_CONSTRUCTOR_CALL", "CLASS_INSTANCE_INITIALIZER", "CLASS_STATIC_INITIALIZER", "CLASS_TOP_LEVEL_SCOPE", "CONSTRUCTOR_DECL", "ENUM_TOP_LEVEL_SCOPE", "EXPR", "EXTENDS_BOUND_LIST", "EXTENDS_CLAUSE", "FOR_CONDITION", "FOR_EACH", "FOR_INIT", "FOR_UPDATE", "FORMAL_PARAM_LIST", "FORMAL_PARAM_STD_DECL", "FORMAL_PARAM_VARARG_DECL", "FUNCTION_METHOD_DECL", "GENERIC_TYPE_ARG_LIST", "GENERIC_TYPE_PARAM_LIST", "INTERFACE_TOP_LEVEL_SCOPE", "IMPLEMENTS_CLAUSE", "LABELED_STATEMENT", "LOCAL_MODIFIER_LIST", "JAVA_SOURCE", "METHOD_CALL", "MODIFIER_LIST", "PARENTESIZED_EXPR", "POST_DEC", "POST_INC", "PRE_DEC", "PRE_INC", "QUALIFIED_TYPE_IDENT", "STATIC_ARRAY_CREATOR", "SUPER_CONSTRUCTOR_CALL", "SWITCH_BLOCK_LABEL_LIST", "THIS_CONSTRUCTOR_CALL", "THROWS_CLAUSE", "TYPE", "UNARY_MINUS", "UNARY_PLUS", "VAR_DECLARATION", "VAR_DECLARATOR", "VAR_DECLARATOR_LIST", "VOID_METHOD_DECL", "IDENT", "HEX_LITERAL", "DECIMAL_LITERAL", "OCTAL_LITERAL", "CHARACTER_LITERAL", "STRING_LITERAL", "FLOATING_POINT_LITERAL", "HEX_DIGIT", "INTEGER_TYPE_SUFFIX", "EXPONENT", "FLOAT_TYPE_SUFFIX", "ESCAPE_SEQUENCE", "UNICODE_ESCAPE", "OCTAL_ESCAPE", "Letter", "JavaIDDigit", "WS", "COMMENT", "LINE_COMMENT", "'module'", "'Token'", "'behavior'", "'join'", "'<-'", "'at'"
    };
    public static final int PACKAGE=84;
    public static final int STAR=49;
    public static final int MOD=32;
    public static final int DO=64;
    public static final int GENERIC_TYPE_PARAM_LIST=137;
    public static final int NOT=34;
    public static final int EOF=-1;
    public static final int ANNOTATION_METHOD_DECL=108;
    public static final int BIT_SHIFT_RIGHT_ASSIGN=9;
    public static final int UNARY_PLUS=158;
    public static final int TYPE=156;
    public static final int FINAL=70;
    public static final int RPAREN=43;
    public static final int INC=21;
    public static final int IMPORT=78;
    public static final int STRING_LITERAL=168;
    public static final int CAST_EXPR=117;
    public static final int NOT_EQUAL=35;
    public static final int RETURN=88;
    public static final int ENUM_TOP_LEVEL_SCOPE=124;
    public static final int ANNOTATION_INIT_KEY_LIST=106;
    public static final int RBRACK=41;
    public static final int PRE_DEC=148;
    public static final int SWITCH_BLOCK_LABEL_LIST=153;
    public static final int STATIC=90;
    public static final int ELSE=66;
    public static final int MINUS_ASSIGN=31;
    public static final int STRICTFP=91;
    public static final int NATIVE=81;
    public static final int ELLIPSIS=17;
    public static final int PRE_INC=149;
    public static final int CHARACTER_LITERAL=167;
    public static final int LCURLY=23;
    public static final int UNARY_MINUS=157;
    public static final int OCTAL_ESCAPE=176;
    public static final int INT=79;
    public static final int FORMAL_PARAM_VARARG_DECL=134;
    public static final int INTERFACE_TOP_LEVEL_SCOPE=138;
    public static final int WS=179;
    public static final int LOCAL_MODIFIER_LIST=141;
    public static final int LESS_THAN=25;
    public static final int EXTENDS_BOUND_LIST=126;
    public static final int JavaIDDigit=178;
    public static final int DECIMAL_LITERAL=165;
    public static final int FOR_INIT=130;
    public static final int PROTECTED=86;
    public static final int LBRACK=22;
    public static final int THIS_CONSTRUCTOR_CALL=154;
    public static final int FLOAT=72;
    public static final int POST_DEC=146;
    public static final int ANNOTATION_SCOPE=109;
    public static final int STATIC_ARRAY_CREATOR=151;
    public static final int LPAREN=29;
    public static final int AT=7;
    public static final int IMPLEMENTS=75;
    public static final int XOR_ASSIGN=52;
    public static final int LOGICAL_OR=28;
    public static final int IDENT=163;
    public static final int PLUS=38;
    public static final int ANNOTATION_INIT_BLOCK=104;
    public static final int GENERIC_TYPE_ARG_LIST=136;
    public static final int GREATER_THAN=20;
    public static final int LESS_OR_EQUAL=24;
    public static final int CLASS_STATIC_INITIALIZER=121;
    public static final int HEX_DIGIT=170;
    public static final int SHORT=89;
    public static final int INSTANCEOF=76;
    public static final int MINUS=30;
    public static final int SEMI=44;
    public static final int STAR_ASSIGN=50;
    public static final int VAR_DECLARATOR_LIST=161;
    public static final int COLON=10;
    public static final int OR_ASSIGN=37;
    public static final int ENUM=67;
    public static final int RCURLY=42;
    public static final int PLUS_ASSIGN=39;
    public static final int FUNCTION_METHOD_DECL=135;
    public static final int INTERFACE=77;
    public static final int DIV=13;
    public static final int POST_INC=147;
    public static final int LONG=80;
    public static final int CLASS_CONSTRUCTOR_CALL=119;
    public static final int PUBLIC=87;
    public static final int ARRAY_INITIALIZER=115;
    public static final int CATCH_CLAUSE_LIST=118;
    public static final int SUPER_CONSTRUCTOR_CALL=152;
    public static final int EXPONENT=172;
    public static final int WHILE=102;
    public static final int MOD_ASSIGN=33;
    public static final int CASE=58;
    public static final int NEW=82;
    public static final int CHAR=60;
    public static final int CLASS_INSTANCE_INITIALIZER=120;
    public static final int ARRAY_ELEMENT_ACCESS=114;
    public static final int FOR_CONDITION=128;
    public static final int VAR_DECLARATION=159;
    public static final int DIV_ASSIGN=14;
    public static final int BREAK=56;
    public static final int LOGICAL_AND=26;
    public static final int FOR_UPDATE=131;
    public static final int FLOATING_POINT_LITERAL=169;
    public static final int VOID_METHOD_DECL=162;
    public static final int DOUBLE=65;
    public static final int VOID=100;
    public static final int SUPER=92;
    public static final int COMMENT=180;
    public static final int FLOAT_TYPE_SUFFIX=173;
    public static final int IMPLEMENTS_CLAUSE=139;
    public static final int LINE_COMMENT=181;
    public static final int PRIVATE=85;
    public static final int BLOCK_SCOPE=116;
    public static final int SWITCH=93;
    public static final int ANNOTATION_INIT_DEFAULT_KEY=105;
    public static final int NULL=83;
    public static final int VAR_DECLARATOR=160;
    public static final int ANNOTATION_LIST=107;
    public static final int THROWS=96;
    public static final int ASSERT=54;
    public static final int METHOD_CALL=143;
    public static final int TRY=99;
    public static final int SHIFT_LEFT=45;
    public static final int SHIFT_RIGHT=47;
    public static final int FORMAL_PARAM_STD_DECL=133;
    public static final int OR=36;
    public static final int SHIFT_RIGHT_ASSIGN=48;
    public static final int JAVA_SOURCE=142;
    public static final int CATCH=59;
    public static final int FALSE=69;
    public static final int INTEGER_TYPE_SUFFIX=171;
    public static final int Letter=177;
    public static final int THROW=95;
    public static final int DEC=12;
    public static final int CLASS=61;
    public static final int BIT_SHIFT_RIGHT=8;
    public static final int THROWS_CLAUSE=155;
    public static final int GREATER_OR_EQUAL=19;
    public static final int FOR=73;
    public static final int LOGICAL_NOT=27;
    public static final int ABSTRACT=53;
    public static final int AND=4;
    public static final int AND_ASSIGN=5;
    public static final int MODIFIER_LIST=144;
    public static final int IF=74;
    public static final int CONSTRUCTOR_DECL=123;
    public static final int ESCAPE_SEQUENCE=174;
    public static final int LABELED_STATEMENT=140;
    public static final int UNICODE_ESCAPE=175;
    public static final int BOOLEAN=55;
    public static final int SYNCHRONIZED=94;
    public static final int EXPR=125;
    public static final int CLASS_TOP_LEVEL_SCOPE=122;
    public static final int CONTINUE=62;
    public static final int COMMA=11;
    public static final int TRANSIENT=97;
    public static final int EQUAL=18;
    public static final int ARGUMENT_LIST=111;
    public static final int QUALIFIED_TYPE_IDENT=150;
    public static final int HEX_LITERAL=164;
    public static final int DOT=15;
    public static final int SHIFT_LEFT_ASSIGN=46;
    public static final int FORMAL_PARAM_LIST=132;
    public static final int DOTSTAR=16;
    public static final int ANNOTATION_TOP_LEVEL_SCOPE=110;
    public static final int T__184=184;
    public static final int T__183=183;
    public static final int BYTE=57;
    public static final int T__186=186;
    public static final int T__185=185;
    public static final int XOR=51;
    public static final int T__187=187;
    public static final int VOLATILE=101;
    public static final int PARENTESIZED_EXPR=145;
    public static final int ARRAY_DECLARATOR_LIST=113;
    public static final int DEFAULT=63;
    public static final int T__182=182;
    public static final int OCTAL_LITERAL=166;
    public static final int TRUE=98;
    public static final int EXTENDS_CLAUSE=127;
    public static final int ARRAY_DECLARATOR=112;
    public static final int QUESTION=40;
    public static final int FINALLY=71;
    public static final int ASSIGN=6;
    public static final int ANNOTATION_INIT_ARRAY_ELEMENT=103;
    public static final int EXTENDS=68;
    public static final int FOR_EACH=129;

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



    // $ANTLR start "compilationUnit"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:320:1: compilationUnit returns [CompilationUnit cu] : ( moduleDeclaration )? ( importDeclaration )* ( typeDeclaration )+ ;
    public final CompilationUnit compilationUnit() throws RecognitionException {
        CompilationUnit cu = null;

        String moduleDeclaration1 = null;

        String importDeclaration2 = null;

        TypeDeclaration typeDeclaration3 = null;



            enableErrorMessageCollection(true);
            cu = new CompilationUnit();

        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:325:5: ( ( moduleDeclaration )? ( importDeclaration )* ( typeDeclaration )+ )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:325:9: ( moduleDeclaration )? ( importDeclaration )* ( typeDeclaration )+
            {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:325:9: ( moduleDeclaration )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==182) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:325:10: moduleDeclaration
                    {
                    pushFollow(FOLLOW_moduleDeclaration_in_compilationUnit4442);
                    moduleDeclaration1=moduleDeclaration();

                    state._fsp--;

                    cu.setModuleName(moduleDeclaration1); moduleName = moduleDeclaration1;

                    }
                    break;

            }

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:326:9: ( importDeclaration )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==IMPORT) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:326:10: importDeclaration
            	    {
            	    pushFollow(FOLLOW_importDeclaration_in_compilationUnit4457);
            	    importDeclaration2=importDeclaration();

            	    state._fsp--;

            	    cu.addImport(importDeclaration2);

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:327:9: ( typeDeclaration )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==ABSTRACT||LA3_0==BOOLEAN||LA3_0==BYTE||(LA3_0>=CHAR && LA3_0<=CLASS)||LA3_0==DOUBLE||LA3_0==FINAL||LA3_0==FLOAT||LA3_0==INTERFACE||(LA3_0>=INT && LA3_0<=NATIVE)||(LA3_0>=PRIVATE && LA3_0<=PUBLIC)||(LA3_0>=SHORT && LA3_0<=STRICTFP)||LA3_0==SYNCHRONIZED||LA3_0==TRANSIENT||(LA3_0>=VOID && LA3_0<=VOLATILE)||LA3_0==IDENT||(LA3_0>=183 && LA3_0<=184)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:327:10: typeDeclaration
            	    {
            	    pushFollow(FOLLOW_typeDeclaration_in_compilationUnit4473);
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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:330:1: moduleDeclaration returns [String value] : 'module' qualifiedName ';' ;
    public final String moduleDeclaration() throws RecognitionException {
        String value = null;

        SalsaParser.qualifiedName_return qualifiedName4 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:331:5: ( 'module' qualifiedName ';' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:331:9: 'module' qualifiedName ';'
            {
            match(input,182,FOLLOW_182_in_moduleDeclaration4500); 
            pushFollow(FOLLOW_qualifiedName_in_moduleDeclaration4502);
            qualifiedName4=qualifiedName();

            state._fsp--;

            match(input,SEMI,FOLLOW_SEMI_in_moduleDeclaration4504); 
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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:334:1: importDeclaration returns [String value] : 'import' qualifiedName ( '.*' )? ';' ;
    public final String importDeclaration() throws RecognitionException {
        String value = null;

        SalsaParser.qualifiedName_return qualifiedName5 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:335:5: ( 'import' qualifiedName ( '.*' )? ';' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:335:9: 'import' qualifiedName ( '.*' )? ';'
            {
            match(input,IMPORT,FOLLOW_IMPORT_in_importDeclaration4529); 
            pushFollow(FOLLOW_qualifiedName_in_importDeclaration4531);
            qualifiedName5=qualifiedName();

            state._fsp--;

            value = (qualifiedName5!=null?input.toString(qualifiedName5.start,qualifiedName5.stop):null);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:336:9: ( '.*' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==DOTSTAR) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:336:10: '.*'
                    {
                    match(input,DOTSTAR,FOLLOW_DOTSTAR_in_importDeclaration4544); 
                    value += ".*";

                    }
                    break;

            }

            match(input,SEMI,FOLLOW_SEMI_in_importDeclaration4550); 

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:340:1: qualifiedNameList : qualifiedName ( ',' qualifiedName )* ;
    public final void qualifiedNameList() throws RecognitionException {
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:341:5: ( qualifiedName ( ',' qualifiedName )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:341:9: qualifiedName ( ',' qualifiedName )*
            {
            pushFollow(FOLLOW_qualifiedName_in_qualifiedNameList4574);
            qualifiedName();

            state._fsp--;

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:342:9: ( ',' qualifiedName )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==COMMA) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:342:10: ',' qualifiedName
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_qualifiedNameList4585); 
            	    pushFollow(FOLLOW_qualifiedName_in_qualifiedNameList4587);
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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:346:1: qualifiedName : IDENT ( '.' IDENT )* ;
    public final SalsaParser.qualifiedName_return qualifiedName() throws RecognitionException {
        SalsaParser.qualifiedName_return retval = new SalsaParser.qualifiedName_return();
        retval.start = input.LT(1);

        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:347:5: ( IDENT ( '.' IDENT )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:347:9: IDENT ( '.' IDENT )*
            {
            match(input,IDENT,FOLLOW_IDENT_in_qualifiedName4622); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:348:9: ( '.' IDENT )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==DOT) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:348:10: '.' IDENT
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_qualifiedName4633); 
            	    match(input,IDENT,FOLLOW_IDENT_in_qualifiedName4635); 

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:351:1: modifiers : ( 'public' | 'protected' | 'private' | 'static' | 'abstract' | 'final' | 'native' | 'synchronized' | 'transient' | 'volatile' | 'strictfp' )* ;
    public final SalsaParser.modifiers_return modifiers() throws RecognitionException {
        SalsaParser.modifiers_return retval = new SalsaParser.modifiers_return();
        retval.start = input.LT(1);

        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:352:5: ( ( 'public' | 'protected' | 'private' | 'static' | 'abstract' | 'final' | 'native' | 'synchronized' | 'transient' | 'volatile' | 'strictfp' )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:353:5: ( 'public' | 'protected' | 'private' | 'static' | 'abstract' | 'final' | 'native' | 'synchronized' | 'transient' | 'volatile' | 'strictfp' )*
            {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:353:5: ( 'public' | 'protected' | 'private' | 'static' | 'abstract' | 'final' | 'native' | 'synchronized' | 'transient' | 'volatile' | 'strictfp' )*
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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:367:1: variableModifiers : ( 'final' )* ;
    public final void variableModifiers() throws RecognitionException {
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:368:5: ( ( 'final' )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:368:9: ( 'final' )*
            {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:368:9: ( 'final' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==FINAL) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:368:13: 'final'
            	    {
            	    match(input,FINAL,FOLLOW_FINAL_in_variableModifiers4800); 

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:372:1: typeList returns [List<String> l] : t1= type ( ',' t2= type )* ;
    public final List<String> typeList() throws RecognitionException {
        List<String> l = null;

        SalsaParser.type_return t1 = null;

        SalsaParser.type_return t2 = null;


         l = new ArrayList<String>();
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:374:5: (t1= type ( ',' t2= type )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:374:9: t1= type ( ',' t2= type )*
            {
            pushFollow(FOLLOW_type_in_typeList4847);
            t1=type();

            state._fsp--;

            l.add((t1!=null?input.toString(t1.start,t1.stop):null));
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:375:9: ( ',' t2= type )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==COMMA) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:375:10: ',' t2= type
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_typeList4860); 
            	    pushFollow(FOLLOW_type_in_typeList4866);
            	    t2=type();

            	    state._fsp--;

            	    l.add((t2!=null?input.toString(t2.start,t2.stop):null));

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
        return l;
    }
    // $ANTLR end "typeList"

    public static class type_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "type"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:379:1: type : ( 'Token' )? ( primitiveType | qualifiedName ) ( '[' ']' )* ;
    public final SalsaParser.type_return type() throws RecognitionException {
        SalsaParser.type_return retval = new SalsaParser.type_return();
        retval.start = input.LT(1);

        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:380:5: ( ( 'Token' )? ( primitiveType | qualifiedName ) ( '[' ']' )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:380:9: ( 'Token' )? ( primitiveType | qualifiedName ) ( '[' ']' )*
            {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:380:9: ( 'Token' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==183) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:380:10: 'Token'
                    {
                    match(input,183,FOLLOW_183_in_type4903); 

                    }
                    break;

            }

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:381:9: ( primitiveType | qualifiedName )
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
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:382:13: primitiveType
                    {
                    pushFollow(FOLLOW_primitiveType_in_type4929);
                    primitiveType();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:383:13: qualifiedName
                    {
                    pushFollow(FOLLOW_qualifiedName_in_type4943);
                    qualifiedName();

                    state._fsp--;


                    }
                    break;

            }

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:385:9: ( '[' ']' )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==LBRACK) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:385:10: '[' ']'
            	    {
            	    match(input,LBRACK,FOLLOW_LBRACK_in_type4968); 
            	    match(input,RBRACK,FOLLOW_RBRACK_in_type4970); 

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:388:1: primitiveType : ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' | 'void' );
    public final SalsaParser.primitiveType_return primitiveType() throws RecognitionException {
        SalsaParser.primitiveType_return retval = new SalsaParser.primitiveType_return();
        retval.start = input.LT(1);

        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:389:5: ( 'boolean' | 'char' | 'byte' | 'short' | 'int' | 'long' | 'float' | 'double' | 'void' )
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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:400:1: typeDeclaration returns [TypeDeclaration td] : ( behaviorDeclaration | classDeclaration | interfaceDeclaration );
    public final TypeDeclaration typeDeclaration() throws RecognitionException {
        typeDeclaration_stack.push(new typeDeclaration_scope());
        TypeDeclaration td = null;

        BehaviorDeclaration behaviorDeclaration6 = null;

        ClassDeclaration classDeclaration7 = null;

        InterfaceDeclaration interfaceDeclaration8 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:403:5: ( behaviorDeclaration | classDeclaration | interfaceDeclaration )
            int alt13=3;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:403:9: behaviorDeclaration
                    {
                    pushFollow(FOLLOW_behaviorDeclaration_in_typeDeclaration5116);
                    behaviorDeclaration6=behaviorDeclaration();

                    state._fsp--;

                    td = behaviorDeclaration6;

                    }
                    break;
                case 2 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:404:9: classDeclaration
                    {
                    pushFollow(FOLLOW_classDeclaration_in_typeDeclaration5128);
                    classDeclaration7=classDeclaration();

                    state._fsp--;

                    td = classDeclaration7;

                    }
                    break;
                case 3 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:405:9: interfaceDeclaration
                    {
                    pushFollow(FOLLOW_interfaceDeclaration_in_typeDeclaration5140);
                    interfaceDeclaration8=interfaceDeclaration();

                    state._fsp--;

                    td = interfaceDeclaration8;

                    }
                    break;

            }
             td.setModuleName(moduleName);
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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:408:1: interfaceDeclaration returns [InterfaceDeclaration in] : modifiers 'interface' IDENT ( 'extends' typeList )? '{' ( fieldVariableDeclaration | intefaceMethodDeclaration )* '}' ;
    public final InterfaceDeclaration interfaceDeclaration() throws RecognitionException {
        InterfaceDeclaration in = null;

        SalsaParser.fieldVariableDeclaration_return fieldVariableDeclaration9 = null;

        InterfaceMethodDeclaration intefaceMethodDeclaration10 = null;


         in = new InterfaceDeclaration(); 
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:410:5: ( modifiers 'interface' IDENT ( 'extends' typeList )? '{' ( fieldVariableDeclaration | intefaceMethodDeclaration )* '}' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:410:9: modifiers 'interface' IDENT ( 'extends' typeList )? '{' ( fieldVariableDeclaration | intefaceMethodDeclaration )* '}'
            {
            pushFollow(FOLLOW_modifiers_in_interfaceDeclaration5177);
            modifiers();

            state._fsp--;

            match(input,INTERFACE,FOLLOW_INTERFACE_in_interfaceDeclaration5179); 
            match(input,IDENT,FOLLOW_IDENT_in_interfaceDeclaration5181); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:411:9: ( 'extends' typeList )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==EXTENDS) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:411:10: 'extends' typeList
                    {
                    match(input,EXTENDS,FOLLOW_EXTENDS_in_interfaceDeclaration5192); 
                    pushFollow(FOLLOW_typeList_in_interfaceDeclaration5194);
                    typeList();

                    state._fsp--;


                    }
                    break;

            }

            match(input,LCURLY,FOLLOW_LCURLY_in_interfaceDeclaration5206); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:413:13: ( fieldVariableDeclaration | intefaceMethodDeclaration )*
            loop15:
            do {
                int alt15=3;
                alt15 = dfa15.predict(input);
                switch (alt15) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:413:17: fieldVariableDeclaration
            	    {
            	    pushFollow(FOLLOW_fieldVariableDeclaration_in_interfaceDeclaration5224);
            	    fieldVariableDeclaration9=fieldVariableDeclaration();

            	    state._fsp--;

            	    in.addFieldVariableDeclaration((fieldVariableDeclaration9!=null?fieldVariableDeclaration9.sd:null));

            	    }
            	    break;
            	case 2 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:414:17: intefaceMethodDeclaration
            	    {
            	    pushFollow(FOLLOW_intefaceMethodDeclaration_in_interfaceDeclaration5244);
            	    intefaceMethodDeclaration10=intefaceMethodDeclaration();

            	    state._fsp--;

            	    in.addMethodDeclaration(intefaceMethodDeclaration10);

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            match(input,RCURLY,FOLLOW_RCURLY_in_interfaceDeclaration5271); 

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:419:1: classDeclaration returns [ClassDeclaration cd] : modifiers 'class' IDENT ( 'extends' type )? ( 'implements' typeList )? '{' ( fieldVariableDeclaration | constructorDeclaration | classMethodDeclaration )* '}' ;
    public final ClassDeclaration classDeclaration() throws RecognitionException {
        ClassDeclaration cd = null;

        Token IDENT11=null;
        SalsaParser.fieldVariableDeclaration_return fieldVariableDeclaration12 = null;

        ConstructorDeclaration constructorDeclaration13 = null;

        ClassMethodDeclaration classMethodDeclaration14 = null;


         cd = new ClassDeclaration(); 
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:421:5: ( modifiers 'class' IDENT ( 'extends' type )? ( 'implements' typeList )? '{' ( fieldVariableDeclaration | constructorDeclaration | classMethodDeclaration )* '}' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:421:9: modifiers 'class' IDENT ( 'extends' type )? ( 'implements' typeList )? '{' ( fieldVariableDeclaration | constructorDeclaration | classMethodDeclaration )* '}'
            {
            pushFollow(FOLLOW_modifiers_in_classDeclaration5317);
            modifiers();

            state._fsp--;

            match(input,CLASS,FOLLOW_CLASS_in_classDeclaration5319); 
            IDENT11=(Token)match(input,IDENT,FOLLOW_IDENT_in_classDeclaration5321); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:422:9: ( 'extends' type )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==EXTENDS) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:422:10: 'extends' type
                    {
                    match(input,EXTENDS,FOLLOW_EXTENDS_in_classDeclaration5332); 
                    pushFollow(FOLLOW_type_in_classDeclaration5334);
                    type();

                    state._fsp--;


                    }
                    break;

            }

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:423:9: ( 'implements' typeList )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==IMPLEMENTS) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:423:10: 'implements' typeList
                    {
                    match(input,IMPLEMENTS,FOLLOW_IMPLEMENTS_in_classDeclaration5347); 
                    pushFollow(FOLLOW_typeList_in_classDeclaration5349);
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
                    
            match(input,LCURLY,FOLLOW_LCURLY_in_classDeclaration5371); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:431:13: ( fieldVariableDeclaration | constructorDeclaration | classMethodDeclaration )*
            loop18:
            do {
                int alt18=4;
                alt18 = dfa18.predict(input);
                switch (alt18) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:431:17: fieldVariableDeclaration
            	    {
            	    pushFollow(FOLLOW_fieldVariableDeclaration_in_classDeclaration5389);
            	    fieldVariableDeclaration12=fieldVariableDeclaration();

            	    state._fsp--;

            	    cd.addFieldVariableDeclaration((fieldVariableDeclaration12!=null?fieldVariableDeclaration12.sd:null));

            	    }
            	    break;
            	case 2 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:432:17: constructorDeclaration
            	    {
            	    pushFollow(FOLLOW_constructorDeclaration_in_classDeclaration5409);
            	    constructorDeclaration13=constructorDeclaration();

            	    state._fsp--;

            	    cd.addMethodDeclaration(constructorDeclaration13);

            	    }
            	    break;
            	case 3 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:433:17: classMethodDeclaration
            	    {
            	    pushFollow(FOLLOW_classMethodDeclaration_in_classDeclaration5429);
            	    classMethodDeclaration14=classMethodDeclaration();

            	    state._fsp--;

            	    cd.addMethodDeclaration(classMethodDeclaration14);

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            match(input,RCURLY,FOLLOW_RCURLY_in_classDeclaration5456); 

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:438:1: behaviorDeclaration returns [BehaviorDeclaration bd] : modifiers 'behavior' IDENT ( 'extends' type )? ( 'implements' typeList )? '{' ( fieldVariableDeclaration | constructorDeclaration | messageHandlerDeclaration )* '}' ;
    public final BehaviorDeclaration behaviorDeclaration() throws RecognitionException {
        BehaviorDeclaration bd = null;

        Token IDENT17=null;
        SalsaParser.type_return type15 = null;

        List<String> typeList16 = null;

        SalsaParser.modifiers_return modifiers18 = null;

        SalsaParser.fieldVariableDeclaration_return fieldVariableDeclaration19 = null;

        ConstructorDeclaration constructorDeclaration20 = null;

        MessageHandlerDeclaration messageHandlerDeclaration21 = null;


         bd = new BehaviorDeclaration();
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:440:5: ( modifiers 'behavior' IDENT ( 'extends' type )? ( 'implements' typeList )? '{' ( fieldVariableDeclaration | constructorDeclaration | messageHandlerDeclaration )* '}' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:440:9: modifiers 'behavior' IDENT ( 'extends' type )? ( 'implements' typeList )? '{' ( fieldVariableDeclaration | constructorDeclaration | messageHandlerDeclaration )* '}'
            {
            pushFollow(FOLLOW_modifiers_in_behaviorDeclaration5492);
            modifiers18=modifiers();

            state._fsp--;

            match(input,184,FOLLOW_184_in_behaviorDeclaration5494); 
            IDENT17=(Token)match(input,IDENT,FOLLOW_IDENT_in_behaviorDeclaration5496); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:441:9: ( 'extends' type )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==EXTENDS) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:441:10: 'extends' type
                    {
                    match(input,EXTENDS,FOLLOW_EXTENDS_in_behaviorDeclaration5508); 
                    pushFollow(FOLLOW_type_in_behaviorDeclaration5510);
                    type15=type();

                    state._fsp--;

                    bd.setExtendsName((type15!=null?input.toString(type15.start,type15.stop):null));

                    }
                    break;

            }

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:442:9: ( 'implements' typeList )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==IMPLEMENTS) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:442:10: 'implements' typeList
                    {
                    match(input,IMPLEMENTS,FOLLOW_IMPLEMENTS_in_behaviorDeclaration5525); 
                    pushFollow(FOLLOW_typeList_in_behaviorDeclaration5527);
                    typeList16=typeList();

                    state._fsp--;

                    bd.setImplementNames(typeList16);

                    }
                    break;

            }

               bd.setName((IDENT17!=null?IDENT17.getText():null)); 
                        bd.setModifiers((modifiers18!=null?input.toString(modifiers18.start,modifiers18.stop):null));
                        String canonicalName = moduleName + "." + (IDENT17!=null?IDENT17.getText():null);
                        ((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType = new SymbolType(canonicalName, SymbolType.ACTOR_TYPE);
                        CompilerHelper.addInitKnownType(((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType);
                        bd.setSymbolType(((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType);
                    
            match(input,LCURLY,FOLLOW_LCURLY_in_behaviorDeclaration5551); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:451:10: ( fieldVariableDeclaration | constructorDeclaration | messageHandlerDeclaration )*
            loop21:
            do {
                int alt21=4;
                alt21 = dfa21.predict(input);
                switch (alt21) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:451:14: fieldVariableDeclaration
            	    {
            	    pushFollow(FOLLOW_fieldVariableDeclaration_in_behaviorDeclaration5566);
            	    fieldVariableDeclaration19=fieldVariableDeclaration();

            	    state._fsp--;

            	    bd.addFieldVariableDeclaration((fieldVariableDeclaration19!=null?fieldVariableDeclaration19.sd:null));

            	    }
            	    break;
            	case 2 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:452:14: constructorDeclaration
            	    {
            	    pushFollow(FOLLOW_constructorDeclaration_in_behaviorDeclaration5583);
            	    constructorDeclaration20=constructorDeclaration();

            	    state._fsp--;

            	    bd.addMethodDeclaration(constructorDeclaration20);

            	    }
            	    break;
            	case 3 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:453:14: messageHandlerDeclaration
            	    {
            	    pushFollow(FOLLOW_messageHandlerDeclaration_in_behaviorDeclaration5600);
            	    messageHandlerDeclaration21=messageHandlerDeclaration();

            	    state._fsp--;

            	    bd.addMethodDeclaration(messageHandlerDeclaration21);

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            match(input,RCURLY,FOLLOW_RCURLY_in_behaviorDeclaration5628); 

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:458:1: intefaceMethodDeclaration returns [InterfaceMethodDeclaration m] : modifiers type IDENT formalParameters ( 'throws' qualifiedNameList )? ';' ;
    public final InterfaceMethodDeclaration intefaceMethodDeclaration() throws RecognitionException {
        InterfaceMethodDeclaration m = null;

        Token IDENT23=null;
        List<FormalParameter> formalParameters22 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:459:5: ( modifiers type IDENT formalParameters ( 'throws' qualifiedNameList )? ';' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:459:10: modifiers type IDENT formalParameters ( 'throws' qualifiedNameList )? ';'
            {
            pushFollow(FOLLOW_modifiers_in_intefaceMethodDeclaration5661);
            modifiers();

            state._fsp--;

            pushFollow(FOLLOW_type_in_intefaceMethodDeclaration5663);
            type();

            state._fsp--;

            IDENT23=(Token)match(input,IDENT,FOLLOW_IDENT_in_intefaceMethodDeclaration5665); 
            pushFollow(FOLLOW_formalParameters_in_intefaceMethodDeclaration5667);
            formalParameters22=formalParameters();

            state._fsp--;

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:459:48: ( 'throws' qualifiedNameList )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==THROWS) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:459:49: 'throws' qualifiedNameList
                    {
                    match(input,THROWS,FOLLOW_THROWS_in_intefaceMethodDeclaration5670); 
                    pushFollow(FOLLOW_qualifiedNameList_in_intefaceMethodDeclaration5672);
                    qualifiedNameList();

                    state._fsp--;


                    }
                    break;

            }

            match(input,SEMI,FOLLOW_SEMI_in_intefaceMethodDeclaration5677); 

                        m = new InterfaceMethodDeclaration();
            //            List<FormalParameter> list = formalParameters22;
            //            List<String> typeList = new ArrayList<String>();
            //            for (FormalParameter fp : list) {
            //                typeList.add(fp.getType());
            //            }
            //            SymbolMethod sm = new SymbolMethod((IDENT23!=null?IDENT23.getText():null), "", typeList.toArray(new String[0]));
            //            m.setSymbolMethod(sm);
            //            ((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType.addMethod(sm);
                    

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:473:1: classMethodDeclaration returns [ClassMethodDeclaration cd] : modifiers type IDENT formalParameters ( 'throws' qualifiedNameList )? block ;
    public final ClassMethodDeclaration classMethodDeclaration() throws RecognitionException {
        ClassMethodDeclaration cd = null;

        Token IDENT26=null;
        SalsaParser.modifiers_return modifiers24 = null;

        SalsaParser.type_return type25 = null;

        List<FormalParameter> formalParameters27 = null;

        Block block28 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:474:5: ( modifiers type IDENT formalParameters ( 'throws' qualifiedNameList )? block )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:474:9: modifiers type IDENT formalParameters ( 'throws' qualifiedNameList )? block
            {
            pushFollow(FOLLOW_modifiers_in_classMethodDeclaration5734);
            modifiers24=modifiers();

            state._fsp--;

            pushFollow(FOLLOW_type_in_classMethodDeclaration5736);
            type25=type();

            state._fsp--;

            IDENT26=(Token)match(input,IDENT,FOLLOW_IDENT_in_classMethodDeclaration5738); 
            pushFollow(FOLLOW_formalParameters_in_classMethodDeclaration5740);
            formalParameters27=formalParameters();

            state._fsp--;

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:474:47: ( 'throws' qualifiedNameList )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==THROWS) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:474:48: 'throws' qualifiedNameList
                    {
                    match(input,THROWS,FOLLOW_THROWS_in_classMethodDeclaration5743); 
                    pushFollow(FOLLOW_qualifiedNameList_in_classMethodDeclaration5745);
                    qualifiedNameList();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_block_in_classMethodDeclaration5757);
            block28=block();

            state._fsp--;


                        cd = new ClassMethodDeclaration((modifiers24!=null?input.toString(modifiers24.start,modifiers24.stop):null), (type25!=null?input.toString(type25.start,type25.stop):null), (IDENT26!=null?IDENT26.getText():null), formalParameters27, block28);
            //            List<FormalParameter> list = formalParameters27;
            //            List<String> typeList = new ArrayList<String>();
            //            for (FormalParameter fp : list) {   
            //                typeList.add(fp.getType());
            //            }
            //            SymbolMethod sm = new SymbolMethod((IDENT26!=null?IDENT26.getText():null), (type25!=null?input.toString(type25.start,type25.stop):null), typeList.toArray(new String[0]));
            //            cd.setSymbolMethod(sm);
            //            ((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType.addMethod(sm);
                    

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:489:1: constructorDeclaration returns [ConstructorDeclaration cd] : modifiers IDENT formalParameters block ;
    public final ConstructorDeclaration constructorDeclaration() throws RecognitionException {
        ConstructorDeclaration cd = null;

        Token IDENT30=null;
        SalsaParser.modifiers_return modifiers29 = null;

        List<FormalParameter> formalParameters31 = null;

        Block block32 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:490:5: ( modifiers IDENT formalParameters block )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:490:9: modifiers IDENT formalParameters block
            {
            pushFollow(FOLLOW_modifiers_in_constructorDeclaration5796);
            modifiers29=modifiers();

            state._fsp--;

            IDENT30=(Token)match(input,IDENT,FOLLOW_IDENT_in_constructorDeclaration5798); 
            int ln = getLine(input);
            pushFollow(FOLLOW_formalParameters_in_constructorDeclaration5802);
            formalParameters31=formalParameters();

            state._fsp--;

            pushFollow(FOLLOW_block_in_constructorDeclaration5804);
            block32=block();

            state._fsp--;

               cd = new ConstructorDeclaration((modifiers29!=null?input.toString(modifiers29.start,modifiers29.stop):null), (IDENT30!=null?IDENT30.getText():null), formalParameters31, block32);
                        cd.setLine(ln);
            //            List<FormalParameter> list = formalParameters31;
            //            List<String> typeList = new ArrayList<String>();
            //            for (FormalParameter fp : list) {
            //                typeList.add(fp.getType());
            //            }
            //            SymbolMethod sm = new SymbolMethod((IDENT30!=null?IDENT30.getText():null), "", typeList.toArray(new String[0]));
            //            cd.setSymbolMethod(sm);
            //            ((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType.addMethod(sm);            
                    

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:504:1: messageHandlerDeclaration returns [MessageHandlerDeclaration md] : modifiers type IDENT formalParameters block ;
    public final MessageHandlerDeclaration messageHandlerDeclaration() throws RecognitionException {
        MessageHandlerDeclaration md = null;

        Token IDENT35=null;
        SalsaParser.modifiers_return modifiers33 = null;

        SalsaParser.type_return type34 = null;

        List<FormalParameter> formalParameters36 = null;

        Block block37 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:505:5: ( modifiers type IDENT formalParameters block )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:505:9: modifiers type IDENT formalParameters block
            {
            pushFollow(FOLLOW_modifiers_in_messageHandlerDeclaration5837);
            modifiers33=modifiers();

            state._fsp--;

            pushFollow(FOLLOW_type_in_messageHandlerDeclaration5839);
            type34=type();

            state._fsp--;

            IDENT35=(Token)match(input,IDENT,FOLLOW_IDENT_in_messageHandlerDeclaration5841); 
            pushFollow(FOLLOW_formalParameters_in_messageHandlerDeclaration5843);
            formalParameters36=formalParameters();

            state._fsp--;

            pushFollow(FOLLOW_block_in_messageHandlerDeclaration5854);
            block37=block();

            state._fsp--;


                        md = new MessageHandlerDeclaration((modifiers33!=null?input.toString(modifiers33.start,modifiers33.stop):null), (type34!=null?input.toString(type34.start,type34.stop):null), (IDENT35!=null?IDENT35.getText():null), formalParameters36, block37);
            //            String returnType = CompilerHelper.TOKEN + " " + (type34!=null?input.toString(type34.start,type34.stop):null);
            //            List<FormalParameter> list = formalParameters36;
            //            List<String> typeList = new ArrayList<String>();
            //            for (FormalParameter fp : list) {   
            //                typeList.add(fp.getType());
            //            }
            //            SymbolMethod sm = new SymbolMethod((IDENT35!=null?IDENT35.getText():null), returnType, typeList.toArray(new String[0]));
            //            md.setSymbolMethod(sm);
            //            ((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType.addMethod(sm);
                    

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:522:1: block returns [Block b] : '{' ( statement )* '}' ;
    public final Block block() throws RecognitionException {
        Block b = null;

        SalsaParser.statement_return statement38 = null;


         
            b = new Block();
            boolean isPreviousLineContinuation = false;   

        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:527:5: ( '{' ( statement )* '}' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:527:9: '{' ( statement )* '}'
            {
            match(input,LCURLY,FOLLOW_LCURLY_in_block5892); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:527:13: ( statement )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==DEC||LA24_0==INC||LA24_0==LCURLY||LA24_0==LOGICAL_NOT||(LA24_0>=LPAREN && LA24_0<=MINUS)||LA24_0==NOT||LA24_0==PLUS||(LA24_0>=BOOLEAN && LA24_0<=BYTE)||LA24_0==CHAR||LA24_0==CONTINUE||(LA24_0>=DO && LA24_0<=DOUBLE)||LA24_0==FALSE||(LA24_0>=FLOAT && LA24_0<=IF)||(LA24_0>=INT && LA24_0<=LONG)||(LA24_0>=NEW && LA24_0<=NULL)||(LA24_0>=RETURN && LA24_0<=SHORT)||LA24_0==SWITCH||LA24_0==THROW||(LA24_0>=TRUE && LA24_0<=VOID)||LA24_0==WHILE||(LA24_0>=IDENT && LA24_0<=FLOATING_POINT_LITERAL)||LA24_0==183||LA24_0==185) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:527:14: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_block5895);
            	    statement38=statement();

            	    state._fsp--;


            	                if ((statement38!=null?statement38.stat:null) != null) {
            	                    b.addStatement((statement38!=null?statement38.stat:null));
            	                    (statement38!=null?statement38.stat:null).setAfterContinuation(isPreviousLineContinuation);
            	                    isPreviousLineContinuation = (statement38!=null?statement38.stat:null).isInContinuation();
            	                }
            	                

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            match(input,RCURLY,FOLLOW_RCURLY_in_block5930); 

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:540:1: statement returns [Statement stat] : ( localVariableDeclaration ( ';' | '@' ) | e1= expression ( '=' e2= expression )? ( ';' | '@' ) | joinBlockStatement ( '@' ) | blockStatement | ifStatement | returnStatement ';' | forStatement | whileStatement | doWhileStatement ';' | breakStatement ';' | continueStatement ';' | tryStatement | throwStatement ';' | switchStatement ) ;
    public final SalsaParser.statement_return statement() throws RecognitionException {
        statement_stack.push(new statement_scope());
        SalsaParser.statement_return retval = new SalsaParser.statement_return();
        retval.start = input.LT(1);

        SalsaParser.expression_return e1 = null;

        SalsaParser.expression_return e2 = null;

        SalsaParser.localVariableDeclaration_return localVariableDeclaration39 = null;

        JoinBlockStatement joinBlockStatement40 = null;

        BlockStatement blockStatement41 = null;

        IfStatement ifStatement42 = null;

        ReturnStatement returnStatement43 = null;

        ForStatement forStatement44 = null;

        WhileStatement whileStatement45 = null;

        DoWhileStatement doWhileStatement46 = null;

        BreakStatement breakStatement47 = null;

        ContinueStatement continueStatement48 = null;

        TryStatement tryStatement49 = null;

        ThrowStatement throwStatement50 = null;

        SwitchStatement switchStatement51 = null;


        boolean isContinuation = false; ((statement_scope)statement_stack.peek()).isSendMessage = false;
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:547:5: ( ( localVariableDeclaration ( ';' | '@' ) | e1= expression ( '=' e2= expression )? ( ';' | '@' ) | joinBlockStatement ( '@' ) | blockStatement | ifStatement | returnStatement ';' | forStatement | whileStatement | doWhileStatement ';' | breakStatement ';' | continueStatement ';' | tryStatement | throwStatement ';' | switchStatement ) )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:547:7: ( localVariableDeclaration ( ';' | '@' ) | e1= expression ( '=' e2= expression )? ( ';' | '@' ) | joinBlockStatement ( '@' ) | blockStatement | ifStatement | returnStatement ';' | forStatement | whileStatement | doWhileStatement ';' | breakStatement ';' | continueStatement ';' | tryStatement | throwStatement ';' | switchStatement )
            {
            int ln = getLine(input);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:548:5: ( localVariableDeclaration ( ';' | '@' ) | e1= expression ( '=' e2= expression )? ( ';' | '@' ) | joinBlockStatement ( '@' ) | blockStatement | ifStatement | returnStatement ';' | forStatement | whileStatement | doWhileStatement ';' | breakStatement ';' | continueStatement ';' | tryStatement | throwStatement ';' | switchStatement )
            int alt28=14;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:549:9: localVariableDeclaration ( ';' | '@' )
                    {
                    pushFollow(FOLLOW_localVariableDeclaration_in_statement5995);
                    localVariableDeclaration39=localVariableDeclaration();

                    state._fsp--;

                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:549:34: ( ';' | '@' )
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
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:549:35: ';'
                            {
                            match(input,SEMI,FOLLOW_SEMI_in_statement5998); 

                            }
                            break;
                        case 2 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:549:41: '@'
                            {
                            match(input,AT,FOLLOW_AT_in_statement6002); 
                            isContinuation=true;

                            }
                            break;

                    }

                    retval.stat = (localVariableDeclaration39!=null?localVariableDeclaration39.ld:null);

                    }
                    break;
                case 2 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:550:9: e1= expression ( '=' e2= expression )? ( ';' | '@' )
                    {
                    pushFollow(FOLLOW_expression_in_statement6020);
                    e1=expression();

                    state._fsp--;

                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:550:25: ( '=' e2= expression )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==ASSIGN) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:550:26: '=' e2= expression
                            {
                            match(input,ASSIGN,FOLLOW_ASSIGN_in_statement6023); 
                            pushFollow(FOLLOW_expression_in_statement6029);
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
                            
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:557:9: ( ';' | '@' )
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
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:557:10: ';'
                            {
                            match(input,SEMI,FOLLOW_SEMI_in_statement6053); 

                            }
                            break;
                        case 2 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:557:16: '@'
                            {
                            match(input,AT,FOLLOW_AT_in_statement6057); 
                            isContinuation=true;

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:558:9: joinBlockStatement ( '@' )
                    {
                    pushFollow(FOLLOW_joinBlockStatement_in_statement6070);
                    joinBlockStatement40=joinBlockStatement();

                    state._fsp--;

                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:558:28: ( '@' )
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:558:29: '@'
                    {
                    match(input,AT,FOLLOW_AT_in_statement6073); 

                    }

                     retval.stat = joinBlockStatement40; isContinuation=true;

                    }
                    break;
                case 4 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:559:9: blockStatement
                    {
                    pushFollow(FOLLOW_blockStatement_in_statement6087);
                    blockStatement41=blockStatement();

                    state._fsp--;

                    retval.stat = blockStatement41;

                    }
                    break;
                case 5 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:560:9: ifStatement
                    {
                    pushFollow(FOLLOW_ifStatement_in_statement6100);
                    ifStatement42=ifStatement();

                    state._fsp--;

                    retval.stat = ifStatement42;

                    }
                    break;
                case 6 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:561:9: returnStatement ';'
                    {
                    pushFollow(FOLLOW_returnStatement_in_statement6112);
                    returnStatement43=returnStatement();

                    state._fsp--;

                    match(input,SEMI,FOLLOW_SEMI_in_statement6114); 
                    retval.stat = returnStatement43; 

                    }
                    break;
                case 7 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:562:9: forStatement
                    {
                    pushFollow(FOLLOW_forStatement_in_statement6126);
                    forStatement44=forStatement();

                    state._fsp--;

                    retval.stat = forStatement44; 

                    }
                    break;
                case 8 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:563:9: whileStatement
                    {
                    pushFollow(FOLLOW_whileStatement_in_statement6138);
                    whileStatement45=whileStatement();

                    state._fsp--;

                    retval.stat = whileStatement45; 

                    }
                    break;
                case 9 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:564:9: doWhileStatement ';'
                    {
                    pushFollow(FOLLOW_doWhileStatement_in_statement6150);
                    doWhileStatement46=doWhileStatement();

                    state._fsp--;

                    match(input,SEMI,FOLLOW_SEMI_in_statement6152); 
                    retval.stat = doWhileStatement46; 

                    }
                    break;
                case 10 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:565:9: breakStatement ';'
                    {
                    pushFollow(FOLLOW_breakStatement_in_statement6164);
                    breakStatement47=breakStatement();

                    state._fsp--;

                    match(input,SEMI,FOLLOW_SEMI_in_statement6166); 
                    retval.stat = breakStatement47; 

                    }
                    break;
                case 11 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:566:9: continueStatement ';'
                    {
                    pushFollow(FOLLOW_continueStatement_in_statement6178);
                    continueStatement48=continueStatement();

                    state._fsp--;

                    match(input,SEMI,FOLLOW_SEMI_in_statement6180); 
                    retval.stat = continueStatement48; 

                    }
                    break;
                case 12 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:567:9: tryStatement
                    {
                    pushFollow(FOLLOW_tryStatement_in_statement6192);
                    tryStatement49=tryStatement();

                    state._fsp--;

                    retval.stat = tryStatement49; 

                    }
                    break;
                case 13 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:568:9: throwStatement ';'
                    {
                    pushFollow(FOLLOW_throwStatement_in_statement6204);
                    throwStatement50=throwStatement();

                    state._fsp--;

                    match(input,SEMI,FOLLOW_SEMI_in_statement6206); 
                    retval.stat = throwStatement50; 

                    }
                    break;
                case 14 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:569:9: switchStatement
                    {
                    pushFollow(FOLLOW_switchStatement_in_statement6218);
                    switchStatement51=switchStatement();

                    state._fsp--;

                    retval.stat = switchStatement51; 

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


    // $ANTLR start "doWhileStatement"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:575:1: doWhileStatement returns [DoWhileStatement s] : 'do' st= statement 'while' '(' e= expression ')' ;
    public final DoWhileStatement doWhileStatement() throws RecognitionException {
        DoWhileStatement s = null;

        SalsaParser.statement_return st = null;

        SalsaParser.expression_return e = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:576:5: ( 'do' st= statement 'while' '(' e= expression ')' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:576:9: 'do' st= statement 'while' '(' e= expression ')'
            {
            match(input,DO,FOLLOW_DO_in_doWhileStatement6265); 
            pushFollow(FOLLOW_statement_in_doWhileStatement6271);
            st=statement();

            state._fsp--;

            match(input,WHILE,FOLLOW_WHILE_in_doWhileStatement6273); 
            match(input,LPAREN,FOLLOW_LPAREN_in_doWhileStatement6275); 
            pushFollow(FOLLOW_expression_in_doWhileStatement6281);
            e=expression();

            state._fsp--;

            match(input,RPAREN,FOLLOW_RPAREN_in_doWhileStatement6283); 
            s = new DoWhileStatement((st!=null?st.stat:null), (e!=null?e.e:null));

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
    // $ANTLR end "doWhileStatement"


    // $ANTLR start "whileStatement"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:580:1: whileStatement returns [WhileStatement s] : 'while' '(' e= expression ')' st= statement ;
    public final WhileStatement whileStatement() throws RecognitionException {
        WhileStatement s = null;

        SalsaParser.expression_return e = null;

        SalsaParser.statement_return st = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:581:5: ( 'while' '(' e= expression ')' st= statement )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:581:9: 'while' '(' e= expression ')' st= statement
            {
            match(input,WHILE,FOLLOW_WHILE_in_whileStatement6325); 
            match(input,LPAREN,FOLLOW_LPAREN_in_whileStatement6327); 
            pushFollow(FOLLOW_expression_in_whileStatement6333);
            e=expression();

            state._fsp--;

            match(input,RPAREN,FOLLOW_RPAREN_in_whileStatement6335); 
            pushFollow(FOLLOW_statement_in_whileStatement6341);
            st=statement();

            state._fsp--;

            s = new WhileStatement((e!=null?e.e:null), (st!=null?st.stat:null));

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
    // $ANTLR end "whileStatement"


    // $ANTLR start "throwStatement"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:585:1: throwStatement returns [ThrowStatement s] : 'throw' e= expression ;
    public final ThrowStatement throwStatement() throws RecognitionException {
        ThrowStatement s = null;

        SalsaParser.expression_return e = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:586:5: ( 'throw' e= expression )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:586:9: 'throw' e= expression
            {
            match(input,THROW,FOLLOW_THROW_in_throwStatement6378); 
            pushFollow(FOLLOW_expression_in_throwStatement6384);
            e=expression();

            state._fsp--;

            s = new ThrowStatement((e!=null?e.e:null));

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
    // $ANTLR end "throwStatement"


    // $ANTLR start "breakStatement"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:590:1: breakStatement returns [BreakStatement s] : 'break' ;
    public final BreakStatement breakStatement() throws RecognitionException {
        BreakStatement s = null;

        s = new BreakStatement();
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:592:5: ( 'break' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:592:9: 'break'
            {
            match(input,BREAK,FOLLOW_BREAK_in_breakStatement6426); 

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
    // $ANTLR end "breakStatement"


    // $ANTLR start "continueStatement"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:596:1: continueStatement returns [ContinueStatement s] : 'continue' ;
    public final ContinueStatement continueStatement() throws RecognitionException {
        ContinueStatement s = null;

        s = new ContinueStatement();
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:598:5: ( 'continue' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:598:9: 'continue'
            {
            match(input,CONTINUE,FOLLOW_CONTINUE_in_continueStatement6462); 

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
    // $ANTLR end "continueStatement"


    // $ANTLR start "tryStatement"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:601:1: tryStatement returns [TryStatement s] : 'try' b1= block ( 'catch' '(' fp= formalParameter ')' b2= block )* ( 'finally' b3= block )? ;
    public final TryStatement tryStatement() throws RecognitionException {
        TryStatement s = null;

        Block b1 = null;

        SalsaParser.formalParameter_return fp = null;

        Block b2 = null;

        Block b3 = null;


        s = new TryStatement(); 
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:603:5: ( 'try' b1= block ( 'catch' '(' fp= formalParameter ')' b2= block )* ( 'finally' b3= block )? )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:603:9: 'try' b1= block ( 'catch' '(' fp= formalParameter ')' b2= block )* ( 'finally' b3= block )?
            {
            match(input,TRY,FOLLOW_TRY_in_tryStatement6494); 
            pushFollow(FOLLOW_block_in_tryStatement6502);
            b1=block();

            state._fsp--;

            s.setTryBlock(b1);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:604:9: ( 'catch' '(' fp= formalParameter ')' b2= block )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==CATCH) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:604:13: 'catch' '(' fp= formalParameter ')' b2= block
            	    {
            	    match(input,CATCH,FOLLOW_CATCH_in_tryStatement6518); 
            	    match(input,LPAREN,FOLLOW_LPAREN_in_tryStatement6520); 
            	    pushFollow(FOLLOW_formalParameter_in_tryStatement6526);
            	    fp=formalParameter();

            	    state._fsp--;

            	    match(input,RPAREN,FOLLOW_RPAREN_in_tryStatement6528); 
            	    pushFollow(FOLLOW_block_in_tryStatement6534);
            	    b2=block();

            	    state._fsp--;

            	    s.addCatchBlock(b2); s.addCatchFP((fp!=null?fp.fp:null));

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:607:9: ( 'finally' b3= block )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==FINALLY) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:607:13: 'finally' b3= block
                    {
                    match(input,FINALLY,FOLLOW_FINALLY_in_tryStatement6573); 
                    pushFollow(FOLLOW_block_in_tryStatement6579);
                    b3=block();

                    state._fsp--;

                    s.setFinallyBlock(b3);

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
    // $ANTLR end "tryStatement"


    // $ANTLR start "switchStatement"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:612:1: switchStatement returns [SwitchStatement s] : 'switch' '(' expression ')' '{' ( switchBlockStatementGroup )* '}' ;
    public final SwitchStatement switchStatement() throws RecognitionException {
        SwitchStatement s = null;

        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:613:5: ( 'switch' '(' expression ')' '{' ( switchBlockStatementGroup )* '}' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:613:9: 'switch' '(' expression ')' '{' ( switchBlockStatementGroup )* '}'
            {
            match(input,SWITCH,FOLLOW_SWITCH_in_switchStatement6640); 
            match(input,LPAREN,FOLLOW_LPAREN_in_switchStatement6642); 
            pushFollow(FOLLOW_expression_in_switchStatement6644);
            expression();

            state._fsp--;

            match(input,RPAREN,FOLLOW_RPAREN_in_switchStatement6646); 
            match(input,LCURLY,FOLLOW_LCURLY_in_switchStatement6656); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:615:13: ( switchBlockStatementGroup )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==CASE||LA31_0==DEFAULT) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:615:14: switchBlockStatementGroup
            	    {
            	    pushFollow(FOLLOW_switchBlockStatementGroup_in_switchStatement6671);
            	    switchBlockStatementGroup();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            match(input,RCURLY,FOLLOW_RCURLY_in_switchStatement6683); 

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
    // $ANTLR end "switchStatement"


    // $ANTLR start "switchBlockStatementGroup"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:619:1: switchBlockStatementGroup : switchLabel ( blockStatement )* ;
    public final void switchBlockStatementGroup() throws RecognitionException {
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:620:5: ( switchLabel ( blockStatement )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:621:9: switchLabel ( blockStatement )*
            {
            pushFollow(FOLLOW_switchLabel_in_switchBlockStatementGroup6721);
            switchLabel();

            state._fsp--;

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:622:9: ( blockStatement )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==LCURLY) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:622:10: blockStatement
            	    {
            	    pushFollow(FOLLOW_blockStatement_in_switchBlockStatementGroup6732);
            	    blockStatement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
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
    // $ANTLR end "switchBlockStatementGroup"


    // $ANTLR start "switchLabel"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:626:1: switchLabel : ( 'case' expression ':' | 'default' ':' );
    public final void switchLabel() throws RecognitionException {
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:627:5: ( 'case' expression ':' | 'default' ':' )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==CASE) ) {
                alt33=1;
            }
            else if ( (LA33_0==DEFAULT) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:627:9: 'case' expression ':'
                    {
                    match(input,CASE,FOLLOW_CASE_in_switchLabel6763); 
                    pushFollow(FOLLOW_expression_in_switchLabel6765);
                    expression();

                    state._fsp--;

                    match(input,COLON,FOLLOW_COLON_in_switchLabel6767); 

                    }
                    break;
                case 2 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:628:9: 'default' ':'
                    {
                    match(input,DEFAULT,FOLLOW_DEFAULT_in_switchLabel6777); 
                    match(input,COLON,FOLLOW_COLON_in_switchLabel6779); 

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
        return ;
    }
    // $ANTLR end "switchLabel"


    // $ANTLR start "forStatement"
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:632:1: forStatement returns [ForStatement s] : 'for' '(' ( localVariableDeclaration )? ';' (e1= expression )? ';' (e2= expression )? ')' st= statement ;
    public final ForStatement forStatement() throws RecognitionException {
        ForStatement s = null;

        SalsaParser.expression_return e1 = null;

        SalsaParser.expression_return e2 = null;

        SalsaParser.statement_return st = null;

        SalsaParser.localVariableDeclaration_return localVariableDeclaration52 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:633:5: ( 'for' '(' ( localVariableDeclaration )? ';' (e1= expression )? ';' (e2= expression )? ')' st= statement )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:633:9: 'for' '(' ( localVariableDeclaration )? ';' (e1= expression )? ';' (e2= expression )? ')' st= statement
            {
            match(input,FOR,FOLLOW_FOR_in_forStatement6804); 
            match(input,LPAREN,FOLLOW_LPAREN_in_forStatement6815); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:635:13: ( localVariableDeclaration )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==BOOLEAN||LA34_0==BYTE||LA34_0==CHAR||LA34_0==DOUBLE||LA34_0==FLOAT||(LA34_0>=INT && LA34_0<=LONG)||LA34_0==SHORT||LA34_0==VOID||LA34_0==IDENT||LA34_0==183) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:635:14: localVariableDeclaration
                    {
                    pushFollow(FOLLOW_localVariableDeclaration_in_forStatement6831);
                    localVariableDeclaration52=localVariableDeclaration();

                    state._fsp--;


                    }
                    break;

            }

            match(input,SEMI,FOLLOW_SEMI_in_forStatement6848); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:637:13: (e1= expression )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==DEC||LA35_0==INC||LA35_0==LOGICAL_NOT||(LA35_0>=LPAREN && LA35_0<=MINUS)||LA35_0==NOT||LA35_0==PLUS||LA35_0==FALSE||(LA35_0>=NEW && LA35_0<=NULL)||LA35_0==TRUE||(LA35_0>=IDENT && LA35_0<=FLOATING_POINT_LITERAL)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:637:14: e1= expression
                    {
                    pushFollow(FOLLOW_expression_in_forStatement6868);
                    e1=expression();

                    state._fsp--;


                    }
                    break;

            }

            match(input,SEMI,FOLLOW_SEMI_in_forStatement6872); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:638:13: (e2= expression )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==DEC||LA36_0==INC||LA36_0==LOGICAL_NOT||(LA36_0>=LPAREN && LA36_0<=MINUS)||LA36_0==NOT||LA36_0==PLUS||LA36_0==FALSE||(LA36_0>=NEW && LA36_0<=NULL)||LA36_0==TRUE||(LA36_0>=IDENT && LA36_0<=FLOATING_POINT_LITERAL)) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:638:14: e2= expression
                    {
                    pushFollow(FOLLOW_expression_in_forStatement6892);
                    e2=expression();

                    state._fsp--;


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_forStatement6905); 
            pushFollow(FOLLOW_statement_in_forStatement6919);
            st=statement();

            state._fsp--;


                        s = new ForStatement((localVariableDeclaration52!=null?localVariableDeclaration52.ld:null), (e1!=null?e1.e:null), (e2!=null?e2.e:null), (st!=null?st.stat:null));
                    

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:646:1: returnStatement returns [ReturnStatement s] : 'return' ( expression )? ;
    public final ReturnStatement returnStatement() throws RecognitionException {
        ReturnStatement s = null;

        SalsaParser.expression_return expression53 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:647:5: ( 'return' ( expression )? )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:647:9: 'return' ( expression )?
            {
            match(input,RETURN,FOLLOW_RETURN_in_returnStatement6961); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:647:18: ( expression )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==DEC||LA37_0==INC||LA37_0==LOGICAL_NOT||(LA37_0>=LPAREN && LA37_0<=MINUS)||LA37_0==NOT||LA37_0==PLUS||LA37_0==FALSE||(LA37_0>=NEW && LA37_0<=NULL)||LA37_0==TRUE||(LA37_0>=IDENT && LA37_0<=FLOATING_POINT_LITERAL)) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:647:19: expression
                    {
                    pushFollow(FOLLOW_expression_in_returnStatement6964);
                    expression53=expression();

                    state._fsp--;


                    }
                    break;

            }

             s = new ReturnStatement((expression53!=null?expression53.e:null)); 

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:651:1: ifStatement returns [IfStatement s] : 'if' '(' expression ')' s1= statement ( 'else' s2= statement )? ;
    public final IfStatement ifStatement() throws RecognitionException {
        IfStatement s = null;

        SalsaParser.statement_return s1 = null;

        SalsaParser.statement_return s2 = null;

        SalsaParser.expression_return expression54 = null;


        s = new IfStatement();
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:653:5: ( 'if' '(' expression ')' s1= statement ( 'else' s2= statement )? )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:653:9: 'if' '(' expression ')' s1= statement ( 'else' s2= statement )?
            {
            match(input,IF,FOLLOW_IF_in_ifStatement7004); 
            match(input,LPAREN,FOLLOW_LPAREN_in_ifStatement7006); 
            pushFollow(FOLLOW_expression_in_ifStatement7008);
            expression54=expression();

            state._fsp--;

            match(input,RPAREN,FOLLOW_RPAREN_in_ifStatement7010); 
            pushFollow(FOLLOW_statement_in_ifStatement7016);
            s1=statement();

            state._fsp--;

            s.setExpression((expression54!=null?expression54.e:null)); s.setIfStatement((s1!=null?s1.stat:null));
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:654:9: ( 'else' s2= statement )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==ELSE) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:654:10: 'else' s2= statement
                    {
                    match(input,ELSE,FOLLOW_ELSE_in_ifStatement7029); 
                    pushFollow(FOLLOW_statement_in_ifStatement7035);
                    s2=statement();

                    state._fsp--;

                    s.setElseStatement((s2!=null?s2.stat:null));

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:657:1: joinBlockStatement returns [JoinBlockStatement s] : 'join' block ;
    public final JoinBlockStatement joinBlockStatement() throws RecognitionException {
        JoinBlockStatement s = null;

        Block block55 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:658:5: ( 'join' block )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:658:9: 'join' block
            {
            match(input,185,FOLLOW_185_in_joinBlockStatement7066); 
            pushFollow(FOLLOW_block_in_joinBlockStatement7068);
            block55=block();

            state._fsp--;

            s = new JoinBlockStatement(block55);

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:661:1: blockStatement returns [BlockStatement s] : block ;
    public final BlockStatement blockStatement() throws RecognitionException {
        BlockStatement s = null;

        Block block56 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:662:5: ( block )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:662:9: block
            {
            pushFollow(FOLLOW_block_in_blockStatement7106);
            block56=block();

            state._fsp--;

            s = new BlockStatement(block56);

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:665:1: expressionStatement returns [ExpressionStatement s] : expression ;
    public final ExpressionStatement expressionStatement() throws RecognitionException {
        ExpressionStatement s = null;

        SalsaParser.expression_return expression57 = null;


        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:666:5: ( expression )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:666:9: expression
            {
            pushFollow(FOLLOW_expression_in_expressionStatement7131);
            expression57=expression();

            state._fsp--;

            s = new ExpressionStatement((expression57!=null?expression57.e:null));

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:670:1: formalParameters returns [List<FormalParameter> list] : '(' (f1= formalParameter ( ',' f2= formalParameter )* )? ')' ;
    public final List<FormalParameter> formalParameters() throws RecognitionException {
        List<FormalParameter> list = null;

        SalsaParser.formalParameter_return f1 = null;

        SalsaParser.formalParameter_return f2 = null;


         list = new ArrayList<FormalParameter>(); 
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:672:5: ( '(' (f1= formalParameter ( ',' f2= formalParameter )* )? ')' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:672:9: '(' (f1= formalParameter ( ',' f2= formalParameter )* )? ')'
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_formalParameters7173); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:673:9: (f1= formalParameter ( ',' f2= formalParameter )* )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==BOOLEAN||LA40_0==BYTE||LA40_0==CHAR||LA40_0==DOUBLE||LA40_0==FLOAT||(LA40_0>=INT && LA40_0<=LONG)||LA40_0==SHORT||LA40_0==VOID||LA40_0==IDENT||LA40_0==183) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:674:13: f1= formalParameter ( ',' f2= formalParameter )*
                    {
                    pushFollow(FOLLOW_formalParameter_in_formalParameters7201);
                    f1=formalParameter();

                    state._fsp--;

                     list.add((f1!=null?f1.fp:null)); 
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:675:13: ( ',' f2= formalParameter )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==COMMA) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:675:14: ',' f2= formalParameter
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_formalParameters7218); 
                    	    pushFollow(FOLLOW_formalParameter_in_formalParameters7224);
                    	    f2=formalParameter();

                    	    state._fsp--;

                    	    list.add((f2!=null?f2.fp:null));

                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_formalParameters7250); 

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:681:1: formalParameter returns [FormalParameter fp] : type IDENT ;
    public final SalsaParser.formalParameter_return formalParameter() throws RecognitionException {
        SalsaParser.formalParameter_return retval = new SalsaParser.formalParameter_return();
        retval.start = input.LT(1);

        Token IDENT59=null;
        SalsaParser.type_return type58 = null;


        SymbolType st;
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:684:5: ( type IDENT )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:684:9: type IDENT
            {
            pushFollow(FOLLOW_type_in_formalParameter7284);
            type58=type();

            state._fsp--;

            IDENT59=(Token)match(input,IDENT,FOLLOW_IDENT_in_formalParameter7294); 
             retval.fp = new FormalParameter((type58!=null?input.toString(type58.start,type58.stop):null), (IDENT59!=null?IDENT59.getText():null));

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:689:1: localVariableDeclaration returns [LocalVariableDeclaration ld, String canonicalType] : type v1= variableDeclaration[$type.text] ( ',' v2= variableDeclaration[$type.text] )* ;
    public final SalsaParser.localVariableDeclaration_return localVariableDeclaration() throws RecognitionException {
        SalsaParser.localVariableDeclaration_return retval = new SalsaParser.localVariableDeclaration_return();
        retval.start = input.LT(1);

        SalsaParser.variableDeclaration_return v1 = null;

        SalsaParser.variableDeclaration_return v2 = null;

        SalsaParser.type_return type60 = null;


         retval.ld = new LocalVariableDeclaration(); String rawType; SymbolType st;
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:691:5: ( type v1= variableDeclaration[$type.text] ( ',' v2= variableDeclaration[$type.text] )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:691:9: type v1= variableDeclaration[$type.text] ( ',' v2= variableDeclaration[$type.text] )*
            {
            pushFollow(FOLLOW_type_in_localVariableDeclaration7332);
            type60=type();

            state._fsp--;

            pushFollow(FOLLOW_variableDeclaration_in_localVariableDeclaration7347);
            v1=variableDeclaration((type60!=null?input.toString(type60.start,type60.stop):null));

            state._fsp--;

             
                        (v1!=null?v1.vd:null).setType((type60!=null?input.toString(type60.start,type60.stop):null));       
                        retval.ld.addVariableDeclaration((v1!=null?v1.vd:null));
                    
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:697:9: ( ',' v2= variableDeclaration[$type.text] )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==COMMA) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:697:10: ',' v2= variableDeclaration[$type.text]
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_localVariableDeclaration7369); 
            	    pushFollow(FOLLOW_variableDeclaration_in_localVariableDeclaration7375);
            	    v2=variableDeclaration((type60!=null?input.toString(type60.start,type60.stop):null));

            	    state._fsp--;

            	     (v2!=null?v2.vd:null).setType((type60!=null?input.toString(type60.start,type60.stop):null));
            	                  retval.ld.addVariableDeclaration((v2!=null?v2.vd:null));

            	    }
            	    break;

            	default :
            	    break loop41;
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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:703:1: fieldVariableDeclaration returns [FieldVariableDeclaration sd, String canonicalType] : modifiers type v1= variableDeclaration[$type.text] ( ',' v2= variableDeclaration[$type.text] )* ';' ;
    public final SalsaParser.fieldVariableDeclaration_return fieldVariableDeclaration() throws RecognitionException {
        SalsaParser.fieldVariableDeclaration_return retval = new SalsaParser.fieldVariableDeclaration_return();
        retval.start = input.LT(1);

        SalsaParser.variableDeclaration_return v1 = null;

        SalsaParser.variableDeclaration_return v2 = null;

        SalsaParser.type_return type61 = null;

        SalsaParser.modifiers_return modifiers62 = null;


         retval.sd = new FieldVariableDeclaration(); String rawType; SymbolType st;
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:705:5: ( modifiers type v1= variableDeclaration[$type.text] ( ',' v2= variableDeclaration[$type.text] )* ';' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:705:9: modifiers type v1= variableDeclaration[$type.text] ( ',' v2= variableDeclaration[$type.text] )* ';'
            {
            pushFollow(FOLLOW_modifiers_in_fieldVariableDeclaration7438);
            modifiers62=modifiers();

            state._fsp--;

            pushFollow(FOLLOW_type_in_fieldVariableDeclaration7440);
            type61=type();

            state._fsp--;

            pushFollow(FOLLOW_variableDeclaration_in_fieldVariableDeclaration7454);
            v1=variableDeclaration((type61!=null?input.toString(type61.start,type61.stop):null));

            state._fsp--;


                        (v1!=null?v1.vd:null).setType((type61!=null?input.toString(type61.start,type61.stop):null)); 
                        (v1!=null?v1.vd:null).setModifiers((modifiers62!=null?input.toString(modifiers62.start,modifiers62.stop):null));         
                        retval.sd.addVariableDeclaration((v1!=null?v1.vd:null));
                        SymbolField sf = new SymbolField((v1!=null?v1.vd:null).getName(), (type61!=null?input.toString(type61.start,type61.stop):null));
                        ((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType.addField(sf);
                    
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:714:9: ( ',' v2= variableDeclaration[$type.text] )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==COMMA) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:714:10: ',' v2= variableDeclaration[$type.text]
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_fieldVariableDeclaration7477); 
            	    pushFollow(FOLLOW_variableDeclaration_in_fieldVariableDeclaration7483);
            	    v2=variableDeclaration((type61!=null?input.toString(type61.start,type61.stop):null));

            	    state._fsp--;


            	                (v2!=null?v2.vd:null).setType((type61!=null?input.toString(type61.start,type61.stop):null)); 
            	                (v2!=null?v2.vd:null).setModifiers((modifiers62!=null?input.toString(modifiers62.start,modifiers62.stop):null));         
            	    	        retval.sd.addVariableDeclaration((v2!=null?v2.vd:null));
            	                sf = new SymbolField((v2!=null?v2.vd:null).getName(), (type61!=null?input.toString(type61.start,type61.stop):null));
            	                ((typeDeclaration_scope)typeDeclaration_stack.peek()).currentType.addField(sf);
            	            

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            match(input,SEMI,FOLLOW_SEMI_in_fieldVariableDeclaration7516); 

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:727:1: variableDeclaration[String type] returns [VariableDeclaration vd, String value] : IDENT ( '=' expression )? ;
    public final SalsaParser.variableDeclaration_return variableDeclaration(String type) throws RecognitionException {
        SalsaParser.variableDeclaration_return retval = new SalsaParser.variableDeclaration_return();
        retval.start = input.LT(1);

        Token IDENT63=null;
        SalsaParser.expression_return expression64 = null;


         retval.vd = new VariableDeclaration(); retval.vd.setType(type); 
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:729:5: ( IDENT ( '=' expression )? )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:729:9: IDENT ( '=' expression )?
            {
            IDENT63=(Token)match(input,IDENT,FOLLOW_IDENT_in_variableDeclaration7555); 
            retval.vd.setName((IDENT63!=null?IDENT63.getText():null)); retval.value =(IDENT63!=null?IDENT63.getText():null); retval.vd.setLine(getLine(input));
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:730:9: ( '=' expression )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==ASSIGN) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:730:10: '=' expression
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_variableDeclaration7573); 
                    pushFollow(FOLLOW_expression_in_variableDeclaration7575);
                    expression64=expression();

                    state._fsp--;

                       
                    	        retval.vd.setInitExpresssion((expression64!=null?expression64.e:null));

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:737:1: term returns [Term t] : ( '(' type ')' )? ( literal | '(' e1= expression ')' | v1= IDENT ( '[' index= expression ']' )* | allocation ) ( '.' v2= qualifiedName (p1= actualParameters )? | ( '<-' | '!' ) v3= IDENT p2= actualParameters )? ;
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

        SalsaParser.type_return type65 = null;

        Literal literal66 = null;

        SalsaParser.allocation_return allocation67 = null;


         retval.t = new Term(); int arrayDims = 0; String type = null;
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:740:5: ( ( '(' type ')' )? ( literal | '(' e1= expression ')' | v1= IDENT ( '[' index= expression ']' )* | allocation ) ( '.' v2= qualifiedName (p1= actualParameters )? | ( '<-' | '!' ) v3= IDENT p2= actualParameters )? )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:740:9: ( '(' type ')' )? ( literal | '(' e1= expression ')' | v1= IDENT ( '[' index= expression ']' )* | allocation ) ( '.' v2= qualifiedName (p1= actualParameters )? | ( '<-' | '!' ) v3= IDENT p2= actualParameters )?
            {
            retval.t.setLine(getLine(input));
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:741:9: ( '(' type ')' )?
            int alt44=2;
            alt44 = dfa44.predict(input);
            switch (alt44) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:741:10: '(' type ')'
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_term7641); 
                    pushFollow(FOLLOW_type_in_term7643);
                    type65=type();

                    state._fsp--;

                    match(input,RPAREN,FOLLOW_RPAREN_in_term7645); 
                    retval.t.setCastType((type65!=null?input.toString(type65.start,type65.stop):null));

                    }
                    break;

            }

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:742:9: ( literal | '(' e1= expression ')' | v1= IDENT ( '[' index= expression ']' )* | allocation )
            int alt46=4;
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
                alt46=1;
                }
                break;
            case LPAREN:
                {
                alt46=2;
                }
                break;
            case IDENT:
                {
                alt46=3;
                }
                break;
            case NEW:
                {
                alt46=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:743:13: literal
                    {
                    pushFollow(FOLLOW_literal_in_term7678);
                    literal66=literal();

                    state._fsp--;

                    retval.t.setLiteral(literal66);

                    }
                    break;
                case 2 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:744:10: '(' e1= expression ')'
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_term7691); 
                    pushFollow(FOLLOW_expression_in_term7697);
                    e1=expression();

                    state._fsp--;

                    match(input,RPAREN,FOLLOW_RPAREN_in_term7699); 
                    retval.t.setExpression((e1!=null?e1.e:null));

                    }
                    break;
                case 3 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:745:10: v1= IDENT ( '[' index= expression ']' )*
                    {
                    v1=(Token)match(input,IDENT,FOLLOW_IDENT_in_term7715); 
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:745:21: ( '[' index= expression ']' )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==LBRACK) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:745:22: '[' index= expression ']'
                    	    {
                    	    match(input,LBRACK,FOLLOW_LBRACK_in_term7718); 
                    	    pushFollow(FOLLOW_expression_in_term7724);
                    	    index=expression();

                    	    state._fsp--;

                    	    match(input,RBRACK,FOLLOW_RBRACK_in_term7726); 
                    	    retval.t.addIndexExpression((index!=null?index.e:null)); arrayDims++;

                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);

                     retval.t.setVarName((v1!=null?v1.getText():null)); 

                    }
                    break;
                case 4 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:747:10: allocation
                    {
                    pushFollow(FOLLOW_allocation_in_term7752);
                    allocation67=allocation();

                    state._fsp--;

                    retval.t.setAllocation((allocation67!=null?allocation67.a:null));

                    }
                    break;

            }

            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:760:9: ( '.' v2= qualifiedName (p1= actualParameters )? | ( '<-' | '!' ) v3= IDENT p2= actualParameters )?
            int alt48=3;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==DOT) ) {
                alt48=1;
            }
            else if ( (LA48_0==LOGICAL_NOT||LA48_0==186) ) {
                alt48=2;
            }
            switch (alt48) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:761:13: '.' v2= qualifiedName (p1= actualParameters )?
                    {
                    match(input,DOT,FOLLOW_DOT_in_term7809); 
                    pushFollow(FOLLOW_qualifiedName_in_term7815);
                    v2=qualifiedName();

                    state._fsp--;

                    retval.t.setSelector((v2!=null?input.toString(v2.start,v2.stop):null));
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:762:17: (p1= actualParameters )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==LPAREN) ) {
                        alt47=1;
                    }
                    switch (alt47) {
                        case 1 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:762:18: p1= actualParameters
                            {
                            pushFollow(FOLLOW_actualParameters_in_term7841);
                            p1=actualParameters();

                            state._fsp--;

                            retval.t.setActualArguments(p1);

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:765:13: ( '<-' | '!' ) v3= IDENT p2= actualParameters
                    {
                    if ( input.LA(1)==LOGICAL_NOT||input.LA(1)==186 ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    v3=(Token)match(input,IDENT,FOLLOW_IDENT_in_term7901); 
                    retval.t.setMessageName((v3!=null?v3.getText():null));
                    pushFollow(FOLLOW_actualParameters_in_term7926);
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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:773:1: allocation returns [Allocation a] : ( 'new' type actualParameters ( 'at' '(' uan= expression ( ',' host= expression )? ')' )? | ( 'new' ( primitiveType | qualifiedName ) ( '[' expression ']' )+ ) );
    public final SalsaParser.allocation_return allocation() throws RecognitionException {
        SalsaParser.allocation_return retval = new SalsaParser.allocation_return();
        retval.start = input.LT(1);

        SalsaParser.expression_return uan = null;

        SalsaParser.expression_return host = null;

        SalsaParser.type_return type68 = null;

        List<Expression> actualParameters69 = null;

        SalsaParser.primitiveType_return primitiveType70 = null;

        SalsaParser.qualifiedName_return qualifiedName71 = null;

        SalsaParser.expression_return expression72 = null;


         retval.a = new Allocation(); String temp = null;
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:776:5: ( 'new' type actualParameters ( 'at' '(' uan= expression ( ',' host= expression )? ')' )? | ( 'new' ( primitiveType | qualifiedName ) ( '[' expression ']' )+ ) )
            int alt53=2;
            alt53 = dfa53.predict(input);
            switch (alt53) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:778:3: 'new' type actualParameters ( 'at' '(' uan= expression ( ',' host= expression )? ')' )?
                    {
                    match(input,NEW,FOLLOW_NEW_in_allocation8000); 
                    pushFollow(FOLLOW_type_in_allocation8002);
                    type68=type();

                    state._fsp--;

                    pushFollow(FOLLOW_actualParameters_in_allocation8005);
                    actualParameters69=actualParameters();

                    state._fsp--;

                    retval.a.setType((type68!=null?input.toString(type68.start,type68.stop):null)); retval.a.setActualArguments(actualParameters69);
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:780:3: ( 'at' '(' uan= expression ( ',' host= expression )? ')' )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==187) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:780:4: 'at' '(' uan= expression ( ',' host= expression )? ')'
                            {
                            match(input,187,FOLLOW_187_in_allocation8017); 
                            match(input,LPAREN,FOLLOW_LPAREN_in_allocation8028); 
                            pushFollow(FOLLOW_expression_in_allocation8032);
                            uan=expression();

                            state._fsp--;

                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:781:28: ( ',' host= expression )?
                            int alt49=2;
                            int LA49_0 = input.LA(1);

                            if ( (LA49_0==COMMA) ) {
                                alt49=1;
                            }
                            switch (alt49) {
                                case 1 :
                                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:781:29: ',' host= expression
                                    {
                                    match(input,COMMA,FOLLOW_COMMA_in_allocation8035); 
                                    pushFollow(FOLLOW_expression_in_allocation8039);
                                    host=expression();

                                    state._fsp--;

                                    retval.a.setHostExpression((host!=null?host.e:null));

                                    }
                                    break;

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_allocation8067); 
                            retval.a.setUANExpression((uan!=null?uan.e:null));

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:788:3: ( 'new' ( primitiveType | qualifiedName ) ( '[' expression ']' )+ )
                    {
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:788:3: ( 'new' ( primitiveType | qualifiedName ) ( '[' expression ']' )+ )
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:788:4: 'new' ( primitiveType | qualifiedName ) ( '[' expression ']' )+
                    {
                    match(input,NEW,FOLLOW_NEW_in_allocation8094); 
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:788:10: ( primitiveType | qualifiedName )
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==BOOLEAN||LA51_0==BYTE||LA51_0==CHAR||LA51_0==DOUBLE||LA51_0==FLOAT||(LA51_0>=INT && LA51_0<=LONG)||LA51_0==SHORT||LA51_0==VOID) ) {
                        alt51=1;
                    }
                    else if ( (LA51_0==IDENT) ) {
                        alt51=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 51, 0, input);

                        throw nvae;
                    }
                    switch (alt51) {
                        case 1 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:788:11: primitiveType
                            {
                            pushFollow(FOLLOW_primitiveType_in_allocation8097);
                            primitiveType70=primitiveType();

                            state._fsp--;

                            temp = (primitiveType70!=null?input.toString(primitiveType70.start,primitiveType70.stop):null);

                            }
                            break;
                        case 2 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:788:59: qualifiedName
                            {
                            pushFollow(FOLLOW_qualifiedName_in_allocation8105);
                            qualifiedName71=qualifiedName();

                            state._fsp--;

                            temp = (qualifiedName71!=null?input.toString(qualifiedName71.start,qualifiedName71.stop):null);

                            }
                            break;

                    }

                    retval.a.setType(temp);
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:790:5: ( '[' expression ']' )+
                    int cnt52=0;
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==LBRACK) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:790:6: '[' expression ']'
                    	    {
                    	    match(input,LBRACK,FOLLOW_LBRACK_in_allocation8129); 
                    	    pushFollow(FOLLOW_expression_in_allocation8131);
                    	    expression72=expression();

                    	    state._fsp--;

                    	    match(input,RBRACK,FOLLOW_RBRACK_in_allocation8133); 
                    	    retval.a.addExpression((expression72!=null?expression72.e:null));

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt52 >= 1 ) break loop52;
                                EarlyExitException eee =
                                    new EarlyExitException(52, input);
                                throw eee;
                        }
                        cnt52++;
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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:794:1: actualParameters returns [List<Expression> list] : '(' (e1= expression ( ',' e2= expression )* )? ')' ;
    public final List<Expression> actualParameters() throws RecognitionException {
        List<Expression> list = null;

        SalsaParser.expression_return e1 = null;

        SalsaParser.expression_return e2 = null;


         list = new ArrayList<Expression>();
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:796:5: ( '(' (e1= expression ( ',' e2= expression )* )? ')' )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:796:9: '(' (e1= expression ( ',' e2= expression )* )? ')'
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_actualParameters8168); 
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:797:13: (e1= expression ( ',' e2= expression )* )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==DEC||LA55_0==INC||LA55_0==LOGICAL_NOT||(LA55_0>=LPAREN && LA55_0<=MINUS)||LA55_0==NOT||LA55_0==PLUS||LA55_0==FALSE||(LA55_0>=NEW && LA55_0<=NULL)||LA55_0==TRUE||(LA55_0>=IDENT && LA55_0<=FLOATING_POINT_LITERAL)) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:797:14: e1= expression ( ',' e2= expression )*
                    {
                    pushFollow(FOLLOW_expression_in_actualParameters8187);
                    e1=expression();

                    state._fsp--;

                    list.add((e1!=null?e1.e:null));
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:798:13: ( ',' e2= expression )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==COMMA) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:798:14: ',' e2= expression
                    	    {
                    	    match(input,COMMA,FOLLOW_COMMA_in_actualParameters8204); 
                    	    pushFollow(FOLLOW_expression_in_actualParameters8210);
                    	    e2=expression();

                    	    state._fsp--;

                    	    list.add((e2!=null?e2.e:null));

                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,RPAREN,FOLLOW_RPAREN_in_actualParameters8226); 

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:803:1: negation returns [NegationExpression e] : ( '~' )* term ;
    public final NegationExpression negation() throws RecognitionException {
        NegationExpression e = null;

        SalsaParser.term_return term73 = null;


         e = new NegationExpression();
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:805:5: ( ( '~' )* term )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:805:9: ( '~' )* term
            {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:805:9: ( '~' )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==NOT) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:805:10: '~'
            	    {
            	    match(input,NOT,FOLLOW_NOT_in_negation8259); 
            	    e.addOperator("~");

            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);

            pushFollow(FOLLOW_term_in_negation8265);
            term73=term();

            state._fsp--;

            e.setTerm((term73!=null?term73.t:null));

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:808:1: unary returns [UnaryExpression e] : ( (op= '+' | op= '-' | op= '!' | op= '++' | op= '--' ) )* negation ( (op2= '++' | op2= '--' ) )? {...}?;
    public final UnaryExpression unary() throws RecognitionException {
        UnaryExpression e = null;

        Token op=null;
        Token op2=null;
        NegationExpression negation74 = null;


         e = new UnaryExpression();
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:810:5: ( ( (op= '+' | op= '-' | op= '!' | op= '++' | op= '--' ) )* negation ( (op2= '++' | op2= '--' ) )? {...}?)
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:810:9: ( (op= '+' | op= '-' | op= '!' | op= '++' | op= '--' ) )* negation ( (op2= '++' | op2= '--' ) )? {...}?
            {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:810:9: ( (op= '+' | op= '-' | op= '!' | op= '++' | op= '--' ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==DEC||LA58_0==INC||LA58_0==LOGICAL_NOT||LA58_0==MINUS||LA58_0==PLUS) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:810:10: (op= '+' | op= '-' | op= '!' | op= '++' | op= '--' )
            	    {
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:810:10: (op= '+' | op= '-' | op= '!' | op= '++' | op= '--' )
            	    int alt57=5;
            	    switch ( input.LA(1) ) {
            	    case PLUS:
            	        {
            	        alt57=1;
            	        }
            	        break;
            	    case MINUS:
            	        {
            	        alt57=2;
            	        }
            	        break;
            	    case LOGICAL_NOT:
            	        {
            	        alt57=3;
            	        }
            	        break;
            	    case INC:
            	        {
            	        alt57=4;
            	        }
            	        break;
            	    case DEC:
            	        {
            	        alt57=5;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 57, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt57) {
            	        case 1 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:810:11: op= '+'
            	            {
            	            op=(Token)match(input,PLUS,FOLLOW_PLUS_in_unary8305); 

            	            }
            	            break;
            	        case 2 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:810:22: op= '-'
            	            {
            	            op=(Token)match(input,MINUS,FOLLOW_MINUS_in_unary8313); 

            	            }
            	            break;
            	        case 3 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:810:33: op= '!'
            	            {
            	            op=(Token)match(input,LOGICAL_NOT,FOLLOW_LOGICAL_NOT_in_unary8321); 

            	            }
            	            break;
            	        case 4 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:810:44: op= '++'
            	            {
            	            op=(Token)match(input,INC,FOLLOW_INC_in_unary8329); 

            	            }
            	            break;
            	        case 5 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:810:56: op= '--'
            	            {
            	            op=(Token)match(input,DEC,FOLLOW_DEC_in_unary8337); 

            	            }
            	            break;

            	    }

            	    e.addOperator((op!=null?op.getText():null));

            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

            pushFollow(FOLLOW_negation_in_unary8353);
            negation74=negation();

            state._fsp--;

            e.addExpression(negation74);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:812:9: ( (op2= '++' | op2= '--' ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==DEC||LA60_0==INC) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:812:10: (op2= '++' | op2= '--' )
                    {
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:812:10: (op2= '++' | op2= '--' )
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==INC) ) {
                        alt59=1;
                    }
                    else if ( (LA59_0==DEC) ) {
                        alt59=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 59, 0, input);

                        throw nvae;
                    }
                    switch (alt59) {
                        case 1 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:812:11: op2= '++'
                            {
                            op2=(Token)match(input,INC,FOLLOW_INC_in_unary8371); 

                            }
                            break;
                        case 2 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:812:24: op2= '--'
                            {
                            op2=(Token)match(input,DEC,FOLLOW_DEC_in_unary8379); 

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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:817:1: mult returns [MultExpression e] : e1= unary ( (op= '*' | op= '/' | op= '%' | op= '*=' | op= '/=' ) e2= unary )* ;
    public final MultExpression mult() throws RecognitionException {
        MultExpression e = null;

        Token op=null;
        UnaryExpression e1 = null;

        UnaryExpression e2 = null;


         e = new MultExpression();
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:819:5: (e1= unary ( (op= '*' | op= '/' | op= '%' | op= '*=' | op= '/=' ) e2= unary )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:819:9: e1= unary ( (op= '*' | op= '/' | op= '%' | op= '*=' | op= '/=' ) e2= unary )*
            {
            pushFollow(FOLLOW_unary_in_mult8426);
            e1=unary();

            state._fsp--;

            e.addExpression(e1);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:820:9: ( (op= '*' | op= '/' | op= '%' | op= '*=' | op= '/=' ) e2= unary )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( ((LA62_0>=DIV && LA62_0<=DIV_ASSIGN)||LA62_0==MOD||(LA62_0>=STAR && LA62_0<=STAR_ASSIGN)) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:821:13: (op= '*' | op= '/' | op= '%' | op= '*=' | op= '/=' ) e2= unary
            	    {
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:821:13: (op= '*' | op= '/' | op= '%' | op= '*=' | op= '/=' )
            	    int alt61=5;
            	    switch ( input.LA(1) ) {
            	    case STAR:
            	        {
            	        alt61=1;
            	        }
            	        break;
            	    case DIV:
            	        {
            	        alt61=2;
            	        }
            	        break;
            	    case MOD:
            	        {
            	        alt61=3;
            	        }
            	        break;
            	    case STAR_ASSIGN:
            	        {
            	        alt61=4;
            	        }
            	        break;
            	    case DIV_ASSIGN:
            	        {
            	        alt61=5;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 61, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt61) {
            	        case 1 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:821:14: op= '*'
            	            {
            	            op=(Token)match(input,STAR,FOLLOW_STAR_in_mult8458); 

            	            }
            	            break;
            	        case 2 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:821:25: op= '/'
            	            {
            	            op=(Token)match(input,DIV,FOLLOW_DIV_in_mult8466); 

            	            }
            	            break;
            	        case 3 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:821:36: op= '%'
            	            {
            	            op=(Token)match(input,MOD,FOLLOW_MOD_in_mult8474); 

            	            }
            	            break;
            	        case 4 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:821:47: op= '*='
            	            {
            	            op=(Token)match(input,STAR_ASSIGN,FOLLOW_STAR_ASSIGN_in_mult8482); 

            	            }
            	            break;
            	        case 5 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:821:59: op= '/='
            	            {
            	            op=(Token)match(input,DIV_ASSIGN,FOLLOW_DIV_ASSIGN_in_mult8490); 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_unary_in_mult8510);
            	    e2=unary();

            	    state._fsp--;

            	    e.addOperator((op!=null?op.getText():null)); e.addExpression(e2);

            	    }
            	    break;

            	default :
            	    break loop62;
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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:826:1: add returns [AddExpression e] : e1= mult ( (op= '+' | op= '-' | op= '+=' | op= '-=' ) e2= mult )* ;
    public final AddExpression add() throws RecognitionException {
        AddExpression e = null;

        Token op=null;
        MultExpression e1 = null;

        MultExpression e2 = null;


         e = new AddExpression(); 
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:828:5: (e1= mult ( (op= '+' | op= '-' | op= '+=' | op= '-=' ) e2= mult )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:828:9: e1= mult ( (op= '+' | op= '-' | op= '+=' | op= '-=' ) e2= mult )*
            {
            pushFollow(FOLLOW_mult_in_add8558);
            e1=mult();

            state._fsp--;

            e.addExpression(e1);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:829:9: ( (op= '+' | op= '-' | op= '+=' | op= '-=' ) e2= mult )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( ((LA64_0>=MINUS && LA64_0<=MINUS_ASSIGN)||(LA64_0>=PLUS && LA64_0<=PLUS_ASSIGN)) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:830:13: (op= '+' | op= '-' | op= '+=' | op= '-=' ) e2= mult
            	    {
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:830:13: (op= '+' | op= '-' | op= '+=' | op= '-=' )
            	    int alt63=4;
            	    switch ( input.LA(1) ) {
            	    case PLUS:
            	        {
            	        alt63=1;
            	        }
            	        break;
            	    case MINUS:
            	        {
            	        alt63=2;
            	        }
            	        break;
            	    case PLUS_ASSIGN:
            	        {
            	        alt63=3;
            	        }
            	        break;
            	    case MINUS_ASSIGN:
            	        {
            	        alt63=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 63, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt63) {
            	        case 1 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:830:14: op= '+'
            	            {
            	            op=(Token)match(input,PLUS,FOLLOW_PLUS_in_add8590); 

            	            }
            	            break;
            	        case 2 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:830:25: op= '-'
            	            {
            	            op=(Token)match(input,MINUS,FOLLOW_MINUS_in_add8598); 

            	            }
            	            break;
            	        case 3 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:830:36: op= '+='
            	            {
            	            op=(Token)match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_add8606); 

            	            }
            	            break;
            	        case 4 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:830:48: op= '-='
            	            {
            	            op=(Token)match(input,MINUS_ASSIGN,FOLLOW_MINUS_ASSIGN_in_add8614); 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_mult_in_add8634);
            	    e2=mult();

            	    state._fsp--;

            	    e.addOperator((op!=null?op.getText():null)); e.addExpression(e2);

            	    }
            	    break;

            	default :
            	    break loop64;
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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:835:1: relation returns [Expression e] : e1= add ( (op= '==' | op= '!=' | op= '<' | op= '<=' | op= '>=' | op= '>' ) e2= add )* ;
    public final Expression relation() throws RecognitionException {
        Expression e = null;

        Token op=null;
        AddExpression e1 = null;

        AddExpression e2 = null;


         e = new Expression();
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:837:5: (e1= add ( (op= '==' | op= '!=' | op= '<' | op= '<=' | op= '>=' | op= '>' ) e2= add )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:837:9: e1= add ( (op= '==' | op= '!=' | op= '<' | op= '<=' | op= '>=' | op= '>' ) e2= add )*
            {
            pushFollow(FOLLOW_add_in_relation8678);
            e1=add();

            state._fsp--;

            e.addExpression(e1);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:838:9: ( (op= '==' | op= '!=' | op= '<' | op= '<=' | op= '>=' | op= '>' ) e2= add )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( ((LA66_0>=EQUAL && LA66_0<=GREATER_THAN)||(LA66_0>=LESS_OR_EQUAL && LA66_0<=LESS_THAN)||LA66_0==NOT_EQUAL) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:839:13: (op= '==' | op= '!=' | op= '<' | op= '<=' | op= '>=' | op= '>' ) e2= add
            	    {
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:839:13: (op= '==' | op= '!=' | op= '<' | op= '<=' | op= '>=' | op= '>' )
            	    int alt65=6;
            	    switch ( input.LA(1) ) {
            	    case EQUAL:
            	        {
            	        alt65=1;
            	        }
            	        break;
            	    case NOT_EQUAL:
            	        {
            	        alt65=2;
            	        }
            	        break;
            	    case LESS_THAN:
            	        {
            	        alt65=3;
            	        }
            	        break;
            	    case LESS_OR_EQUAL:
            	        {
            	        alt65=4;
            	        }
            	        break;
            	    case GREATER_OR_EQUAL:
            	        {
            	        alt65=5;
            	        }
            	        break;
            	    case GREATER_THAN:
            	        {
            	        alt65=6;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 65, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt65) {
            	        case 1 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:839:14: op= '=='
            	            {
            	            op=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_relation8711); 

            	            }
            	            break;
            	        case 2 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:839:26: op= '!='
            	            {
            	            op=(Token)match(input,NOT_EQUAL,FOLLOW_NOT_EQUAL_in_relation8719); 

            	            }
            	            break;
            	        case 3 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:839:38: op= '<'
            	            {
            	            op=(Token)match(input,LESS_THAN,FOLLOW_LESS_THAN_in_relation8727); 

            	            }
            	            break;
            	        case 4 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:839:49: op= '<='
            	            {
            	            op=(Token)match(input,LESS_OR_EQUAL,FOLLOW_LESS_OR_EQUAL_in_relation8735); 

            	            }
            	            break;
            	        case 5 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:839:61: op= '>='
            	            {
            	            op=(Token)match(input,GREATER_OR_EQUAL,FOLLOW_GREATER_OR_EQUAL_in_relation8743); 

            	            }
            	            break;
            	        case 6 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:839:73: op= '>'
            	            {
            	            op=(Token)match(input,GREATER_THAN,FOLLOW_GREATER_THAN_in_relation8751); 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_add_in_relation8771);
            	    e2=add();

            	    state._fsp--;

            	    e.addOperator((op!=null?op.getText():null)); e.addExpression(e2);

            	    }
            	    break;

            	default :
            	    break loop66;
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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:844:1: expression returns [Expression e] : e1= relation ( (op= '&&' | op= '||' | op= 'instanceof' ) e2= relation )* ;
    public final SalsaParser.expression_return expression() throws RecognitionException {
        SalsaParser.expression_return retval = new SalsaParser.expression_return();
        retval.start = input.LT(1);

        Token op=null;
        Expression e1 = null;

        Expression e2 = null;


         retval.e = new Expression(); 
        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:849:5: (e1= relation ( (op= '&&' | op= '||' | op= 'instanceof' ) e2= relation )* )
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:850:9: e1= relation ( (op= '&&' | op= '||' | op= 'instanceof' ) e2= relation )*
            {
            retval.e.setLine(getLine(input));
            pushFollow(FOLLOW_relation_in_expression8842);
            e1=relation();

            state._fsp--;

            retval.e.addExpression(e1);
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:852:9: ( (op= '&&' | op= '||' | op= 'instanceof' ) e2= relation )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==LOGICAL_AND||LA68_0==LOGICAL_OR||LA68_0==INSTANCEOF) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:853:13: (op= '&&' | op= '||' | op= 'instanceof' ) e2= relation
            	    {
            	    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:853:13: (op= '&&' | op= '||' | op= 'instanceof' )
            	    int alt67=3;
            	    switch ( input.LA(1) ) {
            	    case LOGICAL_AND:
            	        {
            	        alt67=1;
            	        }
            	        break;
            	    case LOGICAL_OR:
            	        {
            	        alt67=2;
            	        }
            	        break;
            	    case INSTANCEOF:
            	        {
            	        alt67=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 67, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt67) {
            	        case 1 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:853:14: op= '&&'
            	            {
            	            op=(Token)match(input,LOGICAL_AND,FOLLOW_LOGICAL_AND_in_expression8876); 

            	            }
            	            break;
            	        case 2 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:853:26: op= '||'
            	            {
            	            op=(Token)match(input,LOGICAL_OR,FOLLOW_LOGICAL_OR_in_expression8884); 

            	            }
            	            break;
            	        case 3 :
            	            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:853:38: op= 'instanceof'
            	            {
            	            op=(Token)match(input,INSTANCEOF,FOLLOW_INSTANCEOF_in_expression8892); 

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_relation_in_expression8899);
            	    e2=relation();

            	    state._fsp--;

            	    retval.e.addOperator((op!=null?op.getText():null)); retval.e.addExpression(e2);

            	    }
            	    break;

            	default :
            	    break loop68;
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
    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:859:1: literal returns [Literal literal] : ( HEX_LITERAL | DECIMAL_LITERAL | OCTAL_LITERAL | CHARACTER_LITERAL | STRING_LITERAL | FLOATING_POINT_LITERAL | (t= 'true' | t= 'false' ) | 'null' );
    public final Literal literal() throws RecognitionException {
        Literal literal = null;

        Token t=null;
        Token HEX_LITERAL75=null;
        Token DECIMAL_LITERAL76=null;
        Token OCTAL_LITERAL77=null;
        Token CHARACTER_LITERAL78=null;
        Token STRING_LITERAL79=null;
        Token FLOATING_POINT_LITERAL80=null;

        try {
            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:860:5: ( HEX_LITERAL | DECIMAL_LITERAL | OCTAL_LITERAL | CHARACTER_LITERAL | STRING_LITERAL | FLOATING_POINT_LITERAL | (t= 'true' | t= 'false' ) | 'null' )
            int alt70=8;
            switch ( input.LA(1) ) {
            case HEX_LITERAL:
                {
                alt70=1;
                }
                break;
            case DECIMAL_LITERAL:
                {
                alt70=2;
                }
                break;
            case OCTAL_LITERAL:
                {
                alt70=3;
                }
                break;
            case CHARACTER_LITERAL:
                {
                alt70=4;
                }
                break;
            case STRING_LITERAL:
                {
                alt70=5;
                }
                break;
            case FLOATING_POINT_LITERAL:
                {
                alt70=6;
                }
                break;
            case FALSE:
            case TRUE:
                {
                alt70=7;
                }
                break;
            case NULL:
                {
                alt70=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }

            switch (alt70) {
                case 1 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:860:9: HEX_LITERAL
                    {
                    HEX_LITERAL75=(Token)match(input,HEX_LITERAL,FOLLOW_HEX_LITERAL_in_literal8949); 
                    literal = new Literal("int", (HEX_LITERAL75!=null?HEX_LITERAL75.getText():null));

                    }
                    break;
                case 2 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:861:9: DECIMAL_LITERAL
                    {
                    DECIMAL_LITERAL76=(Token)match(input,DECIMAL_LITERAL,FOLLOW_DECIMAL_LITERAL_in_literal8961); 
                    literal = new Literal("int", (DECIMAL_LITERAL76!=null?DECIMAL_LITERAL76.getText():null));

                    }
                    break;
                case 3 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:862:9: OCTAL_LITERAL
                    {
                    OCTAL_LITERAL77=(Token)match(input,OCTAL_LITERAL,FOLLOW_OCTAL_LITERAL_in_literal8973); 
                    literal = new Literal("int", (OCTAL_LITERAL77!=null?OCTAL_LITERAL77.getText():null));

                    }
                    break;
                case 4 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:863:9: CHARACTER_LITERAL
                    {
                    CHARACTER_LITERAL78=(Token)match(input,CHARACTER_LITERAL,FOLLOW_CHARACTER_LITERAL_in_literal8985); 
                    literal = new Literal("char", (CHARACTER_LITERAL78!=null?CHARACTER_LITERAL78.getText():null));

                    }
                    break;
                case 5 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:864:9: STRING_LITERAL
                    {
                    STRING_LITERAL79=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_literal8999); 
                    literal = new Literal("java.lang.String", (STRING_LITERAL79!=null?STRING_LITERAL79.getText():null));

                    }
                    break;
                case 6 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:865:9: FLOATING_POINT_LITERAL
                    {
                    FLOATING_POINT_LITERAL80=(Token)match(input,FLOATING_POINT_LITERAL,FOLLOW_FLOATING_POINT_LITERAL_in_literal9012); 
                    literal = new Literal("double", (FLOATING_POINT_LITERAL80!=null?FLOATING_POINT_LITERAL80.getText():null));

                    }
                    break;
                case 7 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:866:9: (t= 'true' | t= 'false' )
                    {
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:866:9: (t= 'true' | t= 'false' )
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==TRUE) ) {
                        alt69=1;
                    }
                    else if ( (LA69_0==FALSE) ) {
                        alt69=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 69, 0, input);

                        throw nvae;
                    }
                    switch (alt69) {
                        case 1 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:866:10: t= 'true'
                            {
                            t=(Token)match(input,TRUE,FOLLOW_TRUE_in_literal9030); 

                            }
                            break;
                        case 2 :
                            // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:866:23: t= 'false'
                            {
                            t=(Token)match(input,FALSE,FOLLOW_FALSE_in_literal9038); 

                            }
                            break;

                    }

                    literal = new Literal("boolean", (t!=null?t.getText():null));

                    }
                    break;
                case 8 :
                    // /media/DEVELOP/wcl/software/salsa2/src/salsa/compiler2/Salsa.g:867:9: 'null'
                    {
                    match(input,NULL,FOLLOW_NULL_in_literal9051); 
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
    protected DFA44 dfa44 = new DFA44(this);
    protected DFA53 dfa53 = new DFA53(this);
    static final String DFA13_eotS =
        "\5\uffff";
    static final String DFA13_eofS =
        "\5\uffff";
    static final String DFA13_minS =
        "\2\65\3\uffff";
    static final String DFA13_maxS =
        "\2\u00b8\3\uffff";
    static final String DFA13_acceptS =
        "\2\uffff\1\1\1\2\1\3";
    static final String DFA13_specialS =
        "\5\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\1\7\uffff\1\3\10\uffff\1\1\6\uffff\1\4\3\uffff\1\1\3\uffff"+
            "\3\1\2\uffff\2\1\2\uffff\1\1\2\uffff\1\1\3\uffff\1\1\122\uffff"+
            "\1\2",
            "\1\1\7\uffff\1\3\10\uffff\1\1\6\uffff\1\4\3\uffff\1\1\3\uffff"+
            "\3\1\2\uffff\2\1\2\uffff\1\1\2\uffff\1\1\3\uffff\1\1\122\uffff"+
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
            return "400:1: typeDeclaration returns [TypeDeclaration td] : ( behaviorDeclaration | classDeclaration | interfaceDeclaration );";
        }
    }
    static final String DFA15_eotS =
        "\15\uffff";
    static final String DFA15_eofS =
        "\15\uffff";
    static final String DFA15_minS =
        "\1\52\1\uffff\1\65\1\67\1\26\1\17\1\51\1\6\1\u00a3\1\26\2\uffff"+
        "\1\17";
    static final String DFA15_maxS =
        "\1\u00b7\1\uffff\1\u00b7\3\u00a3\1\51\1\54\2\u00a3\2\uffff\1\u00a3";
    static final String DFA15_acceptS =
        "\1\uffff\1\3\10\uffff\1\1\1\2\1\uffff";
    static final String DFA15_specialS =
        "\15\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\1\12\uffff\1\2\1\uffff\1\4\1\uffff\1\4\2\uffff\1\4\4\uffff"+
            "\1\4\4\uffff\1\2\1\uffff\1\4\6\uffff\2\4\1\2\3\uffff\3\2\1\uffff"+
            "\1\4\2\2\2\uffff\1\2\2\uffff\1\2\2\uffff\1\4\1\2\75\uffff\1"+
            "\5\23\uffff\1\3",
            "",
            "\1\2\1\uffff\1\4\1\uffff\1\4\2\uffff\1\4\4\uffff\1\4\4\uffff"+
            "\1\2\1\uffff\1\4\6\uffff\2\4\1\2\3\uffff\3\2\1\uffff\1\4\2\2"+
            "\2\uffff\1\2\2\uffff\1\2\2\uffff\1\4\1\2\75\uffff\1\5\23\uffff"+
            "\1\3",
            "\1\4\1\uffff\1\4\2\uffff\1\4\4\uffff\1\4\6\uffff\1\4\6\uffff"+
            "\2\4\10\uffff\1\4\12\uffff\1\4\76\uffff\1\5",
            "\1\6\u008c\uffff\1\7",
            "\1\10\6\uffff\1\6\u008c\uffff\1\7",
            "\1\11",
            "\1\12\4\uffff\1\12\21\uffff\1\13\16\uffff\1\12",
            "\1\14",
            "\1\6\u008c\uffff\1\7",
            "",
            "",
            "\1\10\6\uffff\1\6\u008c\uffff\1\7"
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
            return "()* loopback of 413:13: ( fieldVariableDeclaration | intefaceMethodDeclaration )*";
        }
    }
    static final String DFA18_eotS =
        "\17\uffff";
    static final String DFA18_eofS =
        "\17\uffff";
    static final String DFA18_minS =
        "\1\52\1\uffff\1\65\1\67\1\26\2\17\1\51\1\6\1\u00a3\1\uffff\1\26"+
        "\2\uffff\1\17";
    static final String DFA18_maxS =
        "\1\u00b7\1\uffff\1\u00b7\4\u00a3\1\51\1\54\1\u00a3\1\uffff\1\u00a3"+
        "\2\uffff\1\u00a3";
    static final String DFA18_acceptS =
        "\1\uffff\1\4\10\uffff\1\2\1\uffff\1\3\1\1\1\uffff";
    static final String DFA18_specialS =
        "\17\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\1\12\uffff\1\2\1\uffff\1\4\1\uffff\1\4\2\uffff\1\4\4\uffff"+
            "\1\4\4\uffff\1\2\1\uffff\1\4\6\uffff\2\4\1\2\3\uffff\3\2\1\uffff"+
            "\1\4\2\2\2\uffff\1\2\2\uffff\1\2\2\uffff\1\4\1\2\75\uffff\1"+
            "\5\23\uffff\1\3",
            "",
            "\1\2\1\uffff\1\4\1\uffff\1\4\2\uffff\1\4\4\uffff\1\4\4\uffff"+
            "\1\2\1\uffff\1\4\6\uffff\2\4\1\2\3\uffff\3\2\1\uffff\1\4\2\2"+
            "\2\uffff\1\2\2\uffff\1\2\2\uffff\1\4\1\2\75\uffff\1\5\23\uffff"+
            "\1\3",
            "\1\4\1\uffff\1\4\2\uffff\1\4\4\uffff\1\4\6\uffff\1\4\6\uffff"+
            "\2\4\10\uffff\1\4\12\uffff\1\4\76\uffff\1\6",
            "\1\7\u008c\uffff\1\10",
            "\1\11\6\uffff\1\7\6\uffff\1\12\u0085\uffff\1\10",
            "\1\11\6\uffff\1\7\u008c\uffff\1\10",
            "\1\13",
            "\1\15\4\uffff\1\15\21\uffff\1\14\16\uffff\1\15",
            "\1\16",
            "",
            "\1\7\u008c\uffff\1\10",
            "",
            "",
            "\1\11\6\uffff\1\7\u008c\uffff\1\10"
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
            return "()* loopback of 431:13: ( fieldVariableDeclaration | constructorDeclaration | classMethodDeclaration )*";
        }
    }
    static final String DFA21_eotS =
        "\17\uffff";
    static final String DFA21_eofS =
        "\17\uffff";
    static final String DFA21_minS =
        "\1\52\1\uffff\1\65\1\67\1\26\2\17\1\51\1\6\1\u00a3\1\uffff\1\26"+
        "\2\uffff\1\17";
    static final String DFA21_maxS =
        "\1\u00b7\1\uffff\1\u00b7\4\u00a3\1\51\1\54\1\u00a3\1\uffff\1\u00a3"+
        "\2\uffff\1\u00a3";
    static final String DFA21_acceptS =
        "\1\uffff\1\4\10\uffff\1\2\1\uffff\1\3\1\1\1\uffff";
    static final String DFA21_specialS =
        "\17\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\1\12\uffff\1\2\1\uffff\1\4\1\uffff\1\4\2\uffff\1\4\4\uffff"+
            "\1\4\4\uffff\1\2\1\uffff\1\4\6\uffff\2\4\1\2\3\uffff\3\2\1\uffff"+
            "\1\4\2\2\2\uffff\1\2\2\uffff\1\2\2\uffff\1\4\1\2\75\uffff\1"+
            "\5\23\uffff\1\3",
            "",
            "\1\2\1\uffff\1\4\1\uffff\1\4\2\uffff\1\4\4\uffff\1\4\4\uffff"+
            "\1\2\1\uffff\1\4\6\uffff\2\4\1\2\3\uffff\3\2\1\uffff\1\4\2\2"+
            "\2\uffff\1\2\2\uffff\1\2\2\uffff\1\4\1\2\75\uffff\1\5\23\uffff"+
            "\1\3",
            "\1\4\1\uffff\1\4\2\uffff\1\4\4\uffff\1\4\6\uffff\1\4\6\uffff"+
            "\2\4\10\uffff\1\4\12\uffff\1\4\76\uffff\1\6",
            "\1\7\u008c\uffff\1\10",
            "\1\11\6\uffff\1\7\6\uffff\1\12\u0085\uffff\1\10",
            "\1\11\6\uffff\1\7\u008c\uffff\1\10",
            "\1\13",
            "\1\15\4\uffff\1\15\21\uffff\1\14\16\uffff\1\15",
            "\1\16",
            "",
            "\1\7\u008c\uffff\1\10",
            "",
            "",
            "\1\11\6\uffff\1\7\u008c\uffff\1\10"
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
            return "()* loopback of 451:10: ( fieldVariableDeclaration | constructorDeclaration | messageHandlerDeclaration )*";
        }
    }
    static final String DFA28_eotS =
        "\25\uffff";
    static final String DFA28_eofS =
        "\25\uffff";
    static final String DFA28_minS =
        "\1\14\1\uffff\1\6\15\uffff\1\u00a3\1\14\1\6\1\u00a3\1\6";
    static final String DFA28_maxS =
        "\1\u00b9\1\uffff\1\u00ba\15\uffff\1\u00a3\1\u00a9\3\u00a3";
    static final String DFA28_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13"+
        "\1\14\1\15\1\16\5\uffff";
    static final String DFA28_specialS =
        "\25\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\3\10\uffff\1\3\1\uffff\1\5\3\uffff\1\3\1\uffff\2\3\3\uffff"+
            "\1\3\3\uffff\1\3\20\uffff\1\1\1\13\1\1\2\uffff\1\1\1\uffff\1"+
            "\14\1\uffff\1\12\1\1\3\uffff\1\3\2\uffff\1\1\1\10\1\6\4\uffff"+
            "\2\1\1\uffff\2\3\4\uffff\1\7\1\1\3\uffff\1\17\1\uffff\1\16\2"+
            "\uffff\1\3\1\15\1\1\1\uffff\1\11\74\uffff\1\2\6\3\15\uffff\1"+
            "\1\1\uffff\1\4",
            "",
            "\2\3\4\uffff\3\3\1\20\2\uffff\4\3\1\21\1\uffff\5\3\1\uffff"+
            "\3\3\2\uffff\1\3\2\uffff\2\3\4\uffff\1\3\4\uffff\2\3\31\uffff"+
            "\1\3\126\uffff\1\1\26\uffff\1\3",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\22",
            "\1\3\10\uffff\1\3\5\uffff\1\3\1\uffff\2\3\3\uffff\1\3\3\uffff"+
            "\1\3\2\uffff\1\1\33\uffff\1\3\14\uffff\2\3\16\uffff\1\3\100"+
            "\uffff\7\3",
            "\2\3\4\uffff\3\3\1\23\2\uffff\4\3\1\1\1\uffff\3\3\1\uffff\5"+
            "\3\2\uffff\1\3\2\uffff\2\3\4\uffff\1\3\4\uffff\2\3\31\uffff"+
            "\1\3\126\uffff\1\1",
            "\1\24",
            "\2\3\4\uffff\3\3\1\23\2\uffff\4\3\1\1\1\uffff\3\3\1\uffff\5"+
            "\3\2\uffff\1\3\2\uffff\2\3\4\uffff\1\3\4\uffff\2\3\31\uffff"+
            "\1\3\126\uffff\1\1"
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
            return "548:5: ( localVariableDeclaration ( ';' | '@' ) | e1= expression ( '=' e2= expression )? ( ';' | '@' ) | joinBlockStatement ( '@' ) | blockStatement | ifStatement | returnStatement ';' | forStatement | whileStatement | doWhileStatement ';' | breakStatement ';' | continueStatement ';' | tryStatement | throwStatement ';' | switchStatement )";
        }
    }
    static final String DFA44_eotS =
        "\13\uffff";
    static final String DFA44_eofS =
        "\7\uffff\1\2\3\uffff";
    static final String DFA44_minS =
        "\1\35\1\14\1\uffff\1\14\1\uffff\1\u00a3\1\14\1\6\1\14\1\u00a3\1"+
        "\14";
    static final String DFA44_maxS =
        "\1\u00a9\1\u00b7\1\uffff\1\u00ba\1\uffff\1\u00a3\1\u00a9\1\u00ba"+
        "\1\114\1\u00a3\1\114";
    static final String DFA44_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\6\uffff";
    static final String DFA44_specialS =
        "\13\uffff}>";
    static final String[] DFA44_transitionS = {
            "\1\1\47\uffff\1\2\14\uffff\2\2\16\uffff\1\2\100\uffff\7\2",
            "\1\2\10\uffff\1\2\5\uffff\1\2\1\uffff\2\2\3\uffff\1\2\3\uffff"+
            "\1\2\20\uffff\1\4\1\uffff\1\4\2\uffff\1\4\4\uffff\1\4\3\uffff"+
            "\1\2\2\uffff\1\4\6\uffff\2\4\1\uffff\2\2\5\uffff\1\4\10\uffff"+
            "\1\2\1\uffff\1\4\76\uffff\1\3\6\2\15\uffff\1\4",
            "",
            "\3\2\1\5\2\uffff\4\2\1\6\1\uffff\5\2\1\uffff\3\2\2\uffff\1"+
            "\2\2\uffff\2\2\3\uffff\1\7\5\uffff\2\2\31\uffff\1\2\155\uffff"+
            "\1\2",
            "",
            "\1\10",
            "\1\2\10\uffff\1\2\5\uffff\1\2\1\uffff\2\2\3\uffff\1\2\3\uffff"+
            "\1\2\2\uffff\1\4\33\uffff\1\2\14\uffff\2\2\16\uffff\1\2\100"+
            "\uffff\7\2",
            "\2\2\2\uffff\6\2\2\uffff\4\2\2\uffff\5\2\1\4\3\2\2\uffff\1"+
            "\2\2\uffff\2\2\1\uffff\1\2\1\uffff\2\2\4\uffff\2\2\22\uffff"+
            "\1\4\6\uffff\1\2\5\uffff\2\4\16\uffff\1\4\100\uffff\7\4\20\uffff"+
            "\1\2",
            "\3\2\1\11\2\uffff\4\2\1\4\1\uffff\3\2\1\uffff\5\2\2\uffff\1"+
            "\2\2\uffff\2\2\3\uffff\1\7\5\uffff\2\2\31\uffff\1\2",
            "\1\12",
            "\3\2\1\11\2\uffff\4\2\1\4\1\uffff\3\2\1\uffff\5\2\2\uffff\1"+
            "\2\2\uffff\2\2\3\uffff\1\7\5\uffff\2\2\31\uffff\1\2"
    };

    static final short[] DFA44_eot = DFA.unpackEncodedString(DFA44_eotS);
    static final short[] DFA44_eof = DFA.unpackEncodedString(DFA44_eofS);
    static final char[] DFA44_min = DFA.unpackEncodedStringToUnsignedChars(DFA44_minS);
    static final char[] DFA44_max = DFA.unpackEncodedStringToUnsignedChars(DFA44_maxS);
    static final short[] DFA44_accept = DFA.unpackEncodedString(DFA44_acceptS);
    static final short[] DFA44_special = DFA.unpackEncodedString(DFA44_specialS);
    static final short[][] DFA44_transition;

    static {
        int numStates = DFA44_transitionS.length;
        DFA44_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA44_transition[i] = DFA.unpackEncodedString(DFA44_transitionS[i]);
        }
    }

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = DFA44_eot;
            this.eof = DFA44_eof;
            this.min = DFA44_min;
            this.max = DFA44_max;
            this.accept = DFA44_accept;
            this.special = DFA44_special;
            this.transition = DFA44_transition;
        }
        public String getDescription() {
            return "741:9: ( '(' type ')' )?";
        }
    }
    static final String DFA53_eotS =
        "\11\uffff";
    static final String DFA53_eofS =
        "\11\uffff";
    static final String DFA53_minS =
        "\1\122\1\67\1\26\1\17\1\uffff\1\14\1\u00a3\1\uffff\1\17";
    static final String DFA53_maxS =
        "\1\122\1\u00b7\2\35\1\uffff\1\u00a9\1\u00a3\1\uffff\1\35";
    static final String DFA53_acceptS =
        "\4\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String DFA53_specialS =
        "\11\uffff}>";
    static final String[] DFA53_transitionS = {
            "\1\1",
            "\1\2\1\uffff\1\2\2\uffff\1\2\4\uffff\1\2\6\uffff\1\2\6\uffff"+
            "\2\2\10\uffff\1\2\12\uffff\1\2\76\uffff\1\3\23\uffff\1\4",
            "\1\5\6\uffff\1\4",
            "\1\6\6\uffff\1\5\6\uffff\1\4",
            "",
            "\1\7\10\uffff\1\7\5\uffff\1\7\1\uffff\2\7\3\uffff\1\7\3\uffff"+
            "\1\7\2\uffff\1\4\33\uffff\1\7\14\uffff\2\7\16\uffff\1\7\100"+
            "\uffff\7\7",
            "\1\10",
            "",
            "\1\6\6\uffff\1\5\6\uffff\1\4"
    };

    static final short[] DFA53_eot = DFA.unpackEncodedString(DFA53_eotS);
    static final short[] DFA53_eof = DFA.unpackEncodedString(DFA53_eofS);
    static final char[] DFA53_min = DFA.unpackEncodedStringToUnsignedChars(DFA53_minS);
    static final char[] DFA53_max = DFA.unpackEncodedStringToUnsignedChars(DFA53_maxS);
    static final short[] DFA53_accept = DFA.unpackEncodedString(DFA53_acceptS);
    static final short[] DFA53_special = DFA.unpackEncodedString(DFA53_specialS);
    static final short[][] DFA53_transition;

    static {
        int numStates = DFA53_transitionS.length;
        DFA53_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA53_transition[i] = DFA.unpackEncodedString(DFA53_transitionS[i]);
        }
    }

    class DFA53 extends DFA {

        public DFA53(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 53;
            this.eot = DFA53_eot;
            this.eof = DFA53_eof;
            this.min = DFA53_min;
            this.max = DFA53_max;
            this.accept = DFA53_accept;
            this.special = DFA53_special;
            this.transition = DFA53_transition;
        }
        public String getDescription() {
            return "773:1: allocation returns [Allocation a] : ( 'new' type actualParameters ( 'at' '(' uan= expression ( ',' host= expression )? ')' )? | ( 'new' ( primitiveType | qualifiedName ) ( '[' expression ']' )+ ) );";
        }
    }
 

    public static final BitSet FOLLOW_moduleDeclaration_in_compilationUnit4442 = new BitSet(new long[]{0x2020000000000000L,0x000000224CE26040L,0x0100000000000000L});
    public static final BitSet FOLLOW_importDeclaration_in_compilationUnit4457 = new BitSet(new long[]{0x2020000000000000L,0x000000224CE26040L,0x0100000000000000L});
    public static final BitSet FOLLOW_typeDeclaration_in_compilationUnit4473 = new BitSet(new long[]{0x2020000000000002L,0x000000224CE26040L,0x0100000000000000L});
    public static final BitSet FOLLOW_182_in_moduleDeclaration4500 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_qualifiedName_in_moduleDeclaration4502 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_moduleDeclaration4504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_importDeclaration4529 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_qualifiedName_in_importDeclaration4531 = new BitSet(new long[]{0x0000100000010000L});
    public static final BitSet FOLLOW_DOTSTAR_in_importDeclaration4544 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_importDeclaration4550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qualifiedName_in_qualifiedNameList4574 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_COMMA_in_qualifiedNameList4585 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_qualifiedName_in_qualifiedNameList4587 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_IDENT_in_qualifiedName4622 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_DOT_in_qualifiedName4633 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_IDENT_in_qualifiedName4635 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_set_in_modifiers4665 = new BitSet(new long[]{0x0020000000000002L,0x000000224CE20040L});
    public static final BitSet FOLLOW_FINAL_in_variableModifiers4800 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_type_in_typeList4847 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_COMMA_in_typeList4860 = new BitSet(new long[]{0x1280000000000000L,0x0000001002018102L,0x0080000800000000L});
    public static final BitSet FOLLOW_type_in_typeList4866 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_183_in_type4903 = new BitSet(new long[]{0x1280000000000000L,0x0000001002018102L,0x0000000800000000L});
    public static final BitSet FOLLOW_primitiveType_in_type4929 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_qualifiedName_in_type4943 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_LBRACK_in_type4968 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RBRACK_in_type4970 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_set_in_primitiveType0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_behaviorDeclaration_in_typeDeclaration5116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classDeclaration_in_typeDeclaration5128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_interfaceDeclaration_in_typeDeclaration5140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_interfaceDeclaration5177 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_INTERFACE_in_interfaceDeclaration5179 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_IDENT_in_interfaceDeclaration5181 = new BitSet(new long[]{0x0000000000800000L,0x0000000000000010L});
    public static final BitSet FOLLOW_EXTENDS_in_interfaceDeclaration5192 = new BitSet(new long[]{0x1280000000000000L,0x0000001002018102L,0x0080000800000000L});
    public static final BitSet FOLLOW_typeList_in_interfaceDeclaration5194 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LCURLY_in_interfaceDeclaration5206 = new BitSet(new long[]{0x12A0040000000000L,0x000000324EE38142L,0x0080000800000000L});
    public static final BitSet FOLLOW_fieldVariableDeclaration_in_interfaceDeclaration5224 = new BitSet(new long[]{0x12A0040000000000L,0x000000324EE38142L,0x0080000800000000L});
    public static final BitSet FOLLOW_intefaceMethodDeclaration_in_interfaceDeclaration5244 = new BitSet(new long[]{0x12A0040000000000L,0x000000324EE38142L,0x0080000800000000L});
    public static final BitSet FOLLOW_RCURLY_in_interfaceDeclaration5271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_classDeclaration5317 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_CLASS_in_classDeclaration5319 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_IDENT_in_classDeclaration5321 = new BitSet(new long[]{0x0000000000800000L,0x0000000000000810L});
    public static final BitSet FOLLOW_EXTENDS_in_classDeclaration5332 = new BitSet(new long[]{0x1280000000000000L,0x0000001002018102L,0x0080000800000000L});
    public static final BitSet FOLLOW_type_in_classDeclaration5334 = new BitSet(new long[]{0x0000000000800000L,0x0000000000000800L});
    public static final BitSet FOLLOW_IMPLEMENTS_in_classDeclaration5347 = new BitSet(new long[]{0x1280000000000000L,0x0000001002018102L,0x0080000800000000L});
    public static final BitSet FOLLOW_typeList_in_classDeclaration5349 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LCURLY_in_classDeclaration5371 = new BitSet(new long[]{0x12A0040000000000L,0x000000324EE38142L,0x0080000800000000L});
    public static final BitSet FOLLOW_fieldVariableDeclaration_in_classDeclaration5389 = new BitSet(new long[]{0x12A0040000000000L,0x000000324EE38142L,0x0080000800000000L});
    public static final BitSet FOLLOW_constructorDeclaration_in_classDeclaration5409 = new BitSet(new long[]{0x12A0040000000000L,0x000000324EE38142L,0x0080000800000000L});
    public static final BitSet FOLLOW_classMethodDeclaration_in_classDeclaration5429 = new BitSet(new long[]{0x12A0040000000000L,0x000000324EE38142L,0x0080000800000000L});
    public static final BitSet FOLLOW_RCURLY_in_classDeclaration5456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_behaviorDeclaration5492 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_184_in_behaviorDeclaration5494 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_IDENT_in_behaviorDeclaration5496 = new BitSet(new long[]{0x0000000000800000L,0x0000000000000810L});
    public static final BitSet FOLLOW_EXTENDS_in_behaviorDeclaration5508 = new BitSet(new long[]{0x1280000000000000L,0x0000001002018102L,0x0080000800000000L});
    public static final BitSet FOLLOW_type_in_behaviorDeclaration5510 = new BitSet(new long[]{0x0000000000800000L,0x0000000000000800L});
    public static final BitSet FOLLOW_IMPLEMENTS_in_behaviorDeclaration5525 = new BitSet(new long[]{0x1280000000000000L,0x0000001002018102L,0x0080000800000000L});
    public static final BitSet FOLLOW_typeList_in_behaviorDeclaration5527 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LCURLY_in_behaviorDeclaration5551 = new BitSet(new long[]{0x12A0040000000000L,0x000000324EE38142L,0x0080000800000000L});
    public static final BitSet FOLLOW_fieldVariableDeclaration_in_behaviorDeclaration5566 = new BitSet(new long[]{0x12A0040000000000L,0x000000324EE38142L,0x0080000800000000L});
    public static final BitSet FOLLOW_constructorDeclaration_in_behaviorDeclaration5583 = new BitSet(new long[]{0x12A0040000000000L,0x000000324EE38142L,0x0080000800000000L});
    public static final BitSet FOLLOW_messageHandlerDeclaration_in_behaviorDeclaration5600 = new BitSet(new long[]{0x12A0040000000000L,0x000000324EE38142L,0x0080000800000000L});
    public static final BitSet FOLLOW_RCURLY_in_behaviorDeclaration5628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_intefaceMethodDeclaration5661 = new BitSet(new long[]{0x1280000000000000L,0x0000001002018102L,0x0080000800000000L});
    public static final BitSet FOLLOW_type_in_intefaceMethodDeclaration5663 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_IDENT_in_intefaceMethodDeclaration5665 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_formalParameters_in_intefaceMethodDeclaration5667 = new BitSet(new long[]{0x0000100000000000L,0x0000000100000000L});
    public static final BitSet FOLLOW_THROWS_in_intefaceMethodDeclaration5670 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_qualifiedNameList_in_intefaceMethodDeclaration5672 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_intefaceMethodDeclaration5677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_classMethodDeclaration5734 = new BitSet(new long[]{0x1280000000000000L,0x0000001002018102L,0x0080000800000000L});
    public static final BitSet FOLLOW_type_in_classMethodDeclaration5736 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_IDENT_in_classMethodDeclaration5738 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_formalParameters_in_classMethodDeclaration5740 = new BitSet(new long[]{0x0000000000800000L,0x0000000100000000L});
    public static final BitSet FOLLOW_THROWS_in_classMethodDeclaration5743 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_qualifiedNameList_in_classMethodDeclaration5745 = new BitSet(new long[]{0x0000000000800000L,0x0000000100000000L});
    public static final BitSet FOLLOW_block_in_classMethodDeclaration5757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_constructorDeclaration5796 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_IDENT_in_constructorDeclaration5798 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_formalParameters_in_constructorDeclaration5802 = new BitSet(new long[]{0x0000000000800000L,0x0000000100000000L});
    public static final BitSet FOLLOW_block_in_constructorDeclaration5804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifiers_in_messageHandlerDeclaration5837 = new BitSet(new long[]{0x1280000000000000L,0x0000001002018102L,0x0080000800000000L});
    public static final BitSet FOLLOW_type_in_messageHandlerDeclaration5839 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_IDENT_in_messageHandlerDeclaration5841 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_formalParameters_in_messageHandlerDeclaration5843 = new BitSet(new long[]{0x0000000000800000L,0x0000000100000000L});
    public static final BitSet FOLLOW_block_in_messageHandlerDeclaration5854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURLY_in_block5892 = new BitSet(new long[]{0x5380044468A01000L,0x0000005DA30D8723L,0x028003F800000000L});
    public static final BitSet FOLLOW_statement_in_block5895 = new BitSet(new long[]{0x5380044468A01000L,0x0000005DA30D8723L,0x028003F800000000L});
    public static final BitSet FOLLOW_RCURLY_in_block5930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_localVariableDeclaration_in_statement5995 = new BitSet(new long[]{0x0000100000000080L});
    public static final BitSet FOLLOW_SEMI_in_statement5998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_statement6002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_statement6020 = new BitSet(new long[]{0x00001000000000C0L});
    public static final BitSet FOLLOW_ASSIGN_in_statement6023 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_expression_in_statement6029 = new BitSet(new long[]{0x0000100000000080L});
    public static final BitSet FOLLOW_SEMI_in_statement6053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_statement6057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_joinBlockStatement_in_statement6070 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_AT_in_statement6073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blockStatement_in_statement6087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_statement6100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_statement6112 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_statement6114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStatement_in_statement6126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStatement_in_statement6138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_doWhileStatement_in_statement6150 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_statement6152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_breakStatement_in_statement6164 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_statement6166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_continueStatement_in_statement6178 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_statement6180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tryStatement_in_statement6192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_throwStatement_in_statement6204 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_statement6206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_switchStatement_in_statement6218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DO_in_doWhileStatement6265 = new BitSet(new long[]{0x5380004468A01000L,0x0000005DA30D8723L,0x028003F800000000L});
    public static final BitSet FOLLOW_statement_in_doWhileStatement6271 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
    public static final BitSet FOLLOW_WHILE_in_doWhileStatement6273 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_LPAREN_in_doWhileStatement6275 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_expression_in_doWhileStatement6281 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_doWhileStatement6283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_whileStatement6325 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_LPAREN_in_whileStatement6327 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_expression_in_whileStatement6333 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_whileStatement6335 = new BitSet(new long[]{0x5380004468A01000L,0x0000005DA30D8723L,0x028003F800000000L});
    public static final BitSet FOLLOW_statement_in_whileStatement6341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROW_in_throwStatement6378 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_expression_in_throwStatement6384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BREAK_in_breakStatement6426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTINUE_in_continueStatement6462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRY_in_tryStatement6494 = new BitSet(new long[]{0x0000000000800000L,0x0000000100000000L});
    public static final BitSet FOLLOW_block_in_tryStatement6502 = new BitSet(new long[]{0x0800000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_CATCH_in_tryStatement6518 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_LPAREN_in_tryStatement6520 = new BitSet(new long[]{0x1280000000000000L,0x0000001002018102L,0x0080000800000000L});
    public static final BitSet FOLLOW_formalParameter_in_tryStatement6526 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_tryStatement6528 = new BitSet(new long[]{0x0000000000800000L,0x0000000100000000L});
    public static final BitSet FOLLOW_block_in_tryStatement6534 = new BitSet(new long[]{0x0800000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_FINALLY_in_tryStatement6573 = new BitSet(new long[]{0x0000000000800000L,0x0000000100000000L});
    public static final BitSet FOLLOW_block_in_tryStatement6579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SWITCH_in_switchStatement6640 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_LPAREN_in_switchStatement6642 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_expression_in_switchStatement6644 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_switchStatement6646 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_LCURLY_in_switchStatement6656 = new BitSet(new long[]{0x8400040000000000L});
    public static final BitSet FOLLOW_switchBlockStatementGroup_in_switchStatement6671 = new BitSet(new long[]{0x8400040000000000L});
    public static final BitSet FOLLOW_RCURLY_in_switchStatement6683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_switchLabel_in_switchBlockStatementGroup6721 = new BitSet(new long[]{0x0000000000800002L,0x0000000100000000L});
    public static final BitSet FOLLOW_blockStatement_in_switchBlockStatementGroup6732 = new BitSet(new long[]{0x0000000000800002L,0x0000000100000000L});
    public static final BitSet FOLLOW_CASE_in_switchLabel6763 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_expression_in_switchLabel6765 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_switchLabel6767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFAULT_in_switchLabel6777 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_COLON_in_switchLabel6779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_forStatement6804 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_LPAREN_in_forStatement6815 = new BitSet(new long[]{0x1280100000000000L,0x0000001002018102L,0x0080000800000000L});
    public static final BitSet FOLLOW_localVariableDeclaration_in_forStatement6831 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_forStatement6848 = new BitSet(new long[]{0x0000104468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_expression_in_forStatement6868 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_SEMI_in_forStatement6872 = new BitSet(new long[]{0x0000084468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_expression_in_forStatement6892 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_forStatement6905 = new BitSet(new long[]{0x5380004468A01000L,0x0000005DA30D8723L,0x028003F800000000L});
    public static final BitSet FOLLOW_statement_in_forStatement6919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_returnStatement6961 = new BitSet(new long[]{0x0000004468201002L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_expression_in_returnStatement6964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifStatement7004 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_LPAREN_in_ifStatement7006 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_expression_in_ifStatement7008 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_ifStatement7010 = new BitSet(new long[]{0x5380004468A01000L,0x0000005DA30D8723L,0x028003F800000000L});
    public static final BitSet FOLLOW_statement_in_ifStatement7016 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_ELSE_in_ifStatement7029 = new BitSet(new long[]{0x5380004468A01000L,0x0000005DA30D8723L,0x028003F800000000L});
    public static final BitSet FOLLOW_statement_in_ifStatement7035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_185_in_joinBlockStatement7066 = new BitSet(new long[]{0x0000000000800000L,0x0000000100000000L});
    public static final BitSet FOLLOW_block_in_joinBlockStatement7068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_blockStatement7106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_expressionStatement7131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_formalParameters7173 = new BitSet(new long[]{0x1280080000000000L,0x0000001002018102L,0x0080000800000000L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameters7201 = new BitSet(new long[]{0x0000080000000800L});
    public static final BitSet FOLLOW_COMMA_in_formalParameters7218 = new BitSet(new long[]{0x1280000000000000L,0x0000001002018102L,0x0080000800000000L});
    public static final BitSet FOLLOW_formalParameter_in_formalParameters7224 = new BitSet(new long[]{0x0000080000000800L});
    public static final BitSet FOLLOW_RPAREN_in_formalParameters7250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_formalParameter7284 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_IDENT_in_formalParameter7294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_localVariableDeclaration7332 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_variableDeclaration_in_localVariableDeclaration7347 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_COMMA_in_localVariableDeclaration7369 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_variableDeclaration_in_localVariableDeclaration7375 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_modifiers_in_fieldVariableDeclaration7438 = new BitSet(new long[]{0x1280000000000000L,0x0000001002018102L,0x0080000800000000L});
    public static final BitSet FOLLOW_type_in_fieldVariableDeclaration7440 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_variableDeclaration_in_fieldVariableDeclaration7454 = new BitSet(new long[]{0x0000100000000800L});
    public static final BitSet FOLLOW_COMMA_in_fieldVariableDeclaration7477 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_variableDeclaration_in_fieldVariableDeclaration7483 = new BitSet(new long[]{0x0000100000000800L});
    public static final BitSet FOLLOW_SEMI_in_fieldVariableDeclaration7516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_variableDeclaration7555 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_ASSIGN_in_variableDeclaration7573 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_expression_in_variableDeclaration7575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_term7641 = new BitSet(new long[]{0x1280000000000000L,0x0000001002018102L,0x0080000800000000L});
    public static final BitSet FOLLOW_type_in_term7643 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_term7645 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_literal_in_term7678 = new BitSet(new long[]{0x0000000008008002L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_term7691 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_expression_in_term7697 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_term7699 = new BitSet(new long[]{0x0000000008008002L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_IDENT_in_term7715 = new BitSet(new long[]{0x0000000008408002L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_LBRACK_in_term7718 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_expression_in_term7724 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RBRACK_in_term7726 = new BitSet(new long[]{0x0000000008408002L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_allocation_in_term7752 = new BitSet(new long[]{0x0000000008008002L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_DOT_in_term7809 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_qualifiedName_in_term7815 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_actualParameters_in_term7841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_term7889 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_IDENT_in_term7901 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_actualParameters_in_term7926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_allocation8000 = new BitSet(new long[]{0x1280000000000000L,0x0000001002018102L,0x0080000800000000L});
    public static final BitSet FOLLOW_type_in_allocation8002 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_actualParameters_in_allocation8005 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_187_in_allocation8017 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_LPAREN_in_allocation8028 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_expression_in_allocation8032 = new BitSet(new long[]{0x0000080000000800L});
    public static final BitSet FOLLOW_COMMA_in_allocation8035 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_expression_in_allocation8039 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_allocation8067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEW_in_allocation8094 = new BitSet(new long[]{0x1280000000000000L,0x0000001002018102L,0x0000000800000000L});
    public static final BitSet FOLLOW_primitiveType_in_allocation8097 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_qualifiedName_in_allocation8105 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_LBRACK_in_allocation8129 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_expression_in_allocation8131 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RBRACK_in_allocation8133 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_LPAREN_in_actualParameters8168 = new BitSet(new long[]{0x0000084468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_expression_in_actualParameters8187 = new BitSet(new long[]{0x0000080000000800L});
    public static final BitSet FOLLOW_COMMA_in_actualParameters8204 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_expression_in_actualParameters8210 = new BitSet(new long[]{0x0000080000000800L});
    public static final BitSet FOLLOW_RPAREN_in_actualParameters8226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_negation8259 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_term_in_negation8265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_unary8305 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_MINUS_in_unary8313 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_LOGICAL_NOT_in_unary8321 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_INC_in_unary8329 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_DEC_in_unary8337 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_negation_in_unary8353 = new BitSet(new long[]{0x0000000000201002L});
    public static final BitSet FOLLOW_INC_in_unary8371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEC_in_unary8379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_in_mult8426 = new BitSet(new long[]{0x0006000100006002L});
    public static final BitSet FOLLOW_STAR_in_mult8458 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_DIV_in_mult8466 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_MOD_in_mult8474 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_STAR_ASSIGN_in_mult8482 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_DIV_ASSIGN_in_mult8490 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_unary_in_mult8510 = new BitSet(new long[]{0x0006000100006002L});
    public static final BitSet FOLLOW_mult_in_add8558 = new BitSet(new long[]{0x000000C0C0000002L});
    public static final BitSet FOLLOW_PLUS_in_add8590 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_MINUS_in_add8598 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_add8606 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_MINUS_ASSIGN_in_add8614 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_mult_in_add8634 = new BitSet(new long[]{0x000000C0C0000002L});
    public static final BitSet FOLLOW_add_in_relation8678 = new BitSet(new long[]{0x00000008031C0002L});
    public static final BitSet FOLLOW_EQUAL_in_relation8711 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_NOT_EQUAL_in_relation8719 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_LESS_THAN_in_relation8727 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_LESS_OR_EQUAL_in_relation8735 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_GREATER_OR_EQUAL_in_relation8743 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_GREATER_THAN_in_relation8751 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_add_in_relation8771 = new BitSet(new long[]{0x00000008031C0002L});
    public static final BitSet FOLLOW_relation_in_expression8842 = new BitSet(new long[]{0x0000000014000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_LOGICAL_AND_in_expression8876 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_LOGICAL_OR_in_expression8884 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_INSTANCEOF_in_expression8892 = new BitSet(new long[]{0x0000004468201000L,0x00000004000C0020L,0x000003F800000000L});
    public static final BitSet FOLLOW_relation_in_expression8899 = new BitSet(new long[]{0x0000000014000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_HEX_LITERAL_in_literal8949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECIMAL_LITERAL_in_literal8961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OCTAL_LITERAL_in_literal8973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARACTER_LITERAL_in_literal8985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_literal8999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOATING_POINT_LITERAL_in_literal9012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_literal9030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_literal9038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_literal9051 = new BitSet(new long[]{0x0000000000000002L});

}