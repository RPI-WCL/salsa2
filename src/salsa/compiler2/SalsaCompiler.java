package salsa.compiler2;

import jargs.gnu.CmdLineParser;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;

import salsa.compiler2.definitions.CompilationUnit;

public class SalsaCompiler {
    
    private static void printUsage() {
        System.err.println("usage: salsac <options> <source files>");
        System.err.println("where possible options include:");
        System.err.println(
            "  {-k, --keep-javasource} \t Specify if need to keep Java source code\n" +
            "  {-d,--destination} <dir> \t Specify where to place generated class files\n" +
            "  {-c, --classpath} <path> \t Specify where to find user class files and annotation processors\n" +
            "  {-j, --javaonly} \t Generate Java source code only\n");
    }
    
    private static void printInfo() {
        System.err.println("\nSALSA compiler 1.2\n");
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        boolean succeed = true;
        printInfo();
        CmdLineParser cmdParser = new CmdLineParser();
        CmdLineParser.Option destition = cmdParser.addStringOption('d', "destination");
        CmdLineParser.Option keepJavaSrc = cmdParser.addBooleanOption('k', "keep-javasource");
        CmdLineParser.Option classPath = cmdParser.addStringOption('c', "classpath");
        CmdLineParser.Option javaOnly= cmdParser.addStringOption('j', "javaonly");
        try {
            cmdParser.parse(args);
        }
        catch ( CmdLineParser.OptionException e ) {
            System.err.println(e.getMessage());
            printUsage();
            System.exit(2);
        }
        String[] salsaFileNames = cmdParser.getRemainingArgs();
        if (salsaFileNames == null || salsaFileNames.length == 0) {
            printUsage();
            System.exit(2);
        }
        
        // Add class paths
        String cpString = (String)cmdParser.getOptionValue(classPath);
        if (cpString != null && cpString.length() > 0) {
            String classPathStr = System.getProperty("java.class.path");
            System.setProperty("java.class.path", cpString + File.pathSeparator
                    + classPathStr);
        }
        
        CompilationUnit[] cus = new CompilationUnit[salsaFileNames.length];
        System.err.println("Parsing...");
        for (int i = 0; i < salsaFileNames.length; i++) {
            try {
                CharStream input = new ANTLRFileStream(salsaFileNames[i]);
                SalsaLexer lex = new SalsaLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lex);
                SalsaParser parser = new SalsaParser(tokens);
                cus[i] = parser.compilationUnit();
                cus[i].setSourceFileName(salsaFileNames[i]);
                if (!parser.hasErrors()) {
                    System.err.println("  Parse " + parser.getSourceName() + " successfully");
                } else {
                    System.err.println("  Parse " + parser.getSourceName() + " failed");
                    succeed = false;
                }
                System.gc();
            } catch (Exception fne) {
                System.err.println(fne.getMessage());
                fne.printStackTrace();
                succeed = false;
            }
        }
        if (!succeed)
            System.exit(2);
        
        System.err.println();
        System.err.println("Typechecking...");
        for (CompilationUnit cu : cus) {
            SalsaSource.resetErrorNum();
            cu.analyze(null, null, null);
            if (SalsaSource.getErrorNum() > 0) {
                succeed = false;
                System.err.println("  Typecheck " + cu.getSourceFileName() + " failed, total error: " + SalsaSource.getErrorNum());
            }
            else {
                System.err.println("  Typecheck " + cu.getSourceFileName() + " successfully");
            }
            System.gc();
        }
        System.err.println();

        if (!succeed)
            System.exit(2);
        
        List<String> generatedFiles = new ArrayList<String>();
        if (succeed) {
            System.err.println("Generating...");
            for (CompilationUnit cu : cus) {
                generatedFiles.addAll(cu.generateJavaCode());
                System.gc();
            }
            System.err.println("  Generate Java source code successfully");
        }
        Boolean javaOnlyValue = (Boolean) cmdParser.getOptionValue(javaOnly,
                Boolean.FALSE);
        if (!javaOnlyValue) {
            // Invoking javac to compile Java source code
            StringBuilder sb = new StringBuilder();
            sb.append("javac ");
            sb.append("-cp " + System.getProperty("java.class.path") + " ");

            String destValue = (String)cmdParser.getOptionValue(destition);
            if (destValue != null) {
                sb.append("-d ").append(destValue).append(" ");
            }
            
            for (String path : generatedFiles)
                sb.append(path).append(" ");
            System.err.println("\nCompiling...");
            Process p = Runtime.getRuntime().exec(sb.toString());
            InputStream in = p.getErrorStream();
            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char)c);
            }
            in.close();
            p.waitFor();
            if (p.exitValue() == 0) {
                System.err.println("  Compile Java source code successfully");
                Boolean keepJavaValue = (Boolean) cmdParser.getOptionValue(keepJavaSrc,
                        Boolean.TRUE);
                if (!keepJavaValue) {
                    for (String path : generatedFiles) {
                        File f = new File(path);
                        if (f.exists())
                            f.delete();
                    }
                    System.err.println("\n  Generated Java source deleted");
                }
            } else {
                System.err.println("\n  Compile Java source code failed, " +
                        "please check the Java source code " +
                        "and make sure \"javac\" is in your path");
            }
        }
        System.err.println();
    }
}
