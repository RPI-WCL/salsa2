package salsa.compiler2;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import salsa.compiler2.definitions.CompilationUnit;

public class SalsaCompiler {
    
    public static final String version = "SALSA 2.0a";

    private static void printUsage(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("salsac <options> <files>", options);
        // System.err.println("usage: salsac <options> <source files>");
        // System.err.println("where possible options include:");
        // System.err.println(
        // "  {-k, --keep-javasource} \t Specify if need to keep Java source code\n"
        // +
        // "  {-d,--destination} <dir> \t Specify where to place generated class files\n"
        // +
        // "  {-c, --classpath} <path> \t Specify where to find user class files and annotation processors\n"
        // +
        // "  {-j, --javaonly} \t Generate Java source code only\n");
    }

    private static void printInfo() {
        System.err.println("\nSALSA compiler 2.0alpha\n");
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        boolean succeed = true;
        // printInfo();
        // CmdLineParser cmdParser = new CmdLineParser();
        // CmdLineParser.Option destition = cmdParser.addStringOption('d',
        // "destination");
        // CmdLineParser.Option keepJavaSrc = cmdParser.addBooleanOption('k',
        // "keep-javasource");
        // CmdLineParser.Option classPath = cmdParser.addStringOption('c',
        // "classpath");
        // CmdLineParser.Option javaOnly= cmdParser.addStringOption('j',
        // "javaonly");
        // try {
        // cmdParser.parse(args);
        // }
        // catch ( CmdLineParser.OptionException e ) {
        // System.err.println(e.getMessage());
        // printUsage();
        // System.exit(2);
        // }
        // String[] salsaFileNames = cmdParser.getRemainingArgs();
        // if (salsaFileNames == null || salsaFileNames.length == 0) {
        // printUsage();
        // System.exit(2);
        // }

        Option help = new Option("h", "help", false, "Print this message");
        Option version = new Option("v", "version", false,
                "Print the version information and exit");
        Option javaonly = new Option("j", "javaonly", false,
                "Generate Java code only");
        Option destination = OptionBuilder
                .withArgName("directory")
                .hasArg()
                .withDescription(
                        "Specify where to place generated java/class files")
                .create("d");
        Option classpath = OptionBuilder
                .withArgName("path")
                .hasArg()
                .withDescription(
                        "Specify where to find user class files and annotation processors")
                .create("cp");
        // Option classpath2 = OptionBuilder
        // .withArgName("path")
        // .hasArg()
        // .withDescription(
        // "Specify where to find user class files and annotation processors")
        // .create("classpath");
        Options options = new Options();

        options.addOption(destination);
        options.addOption(classpath);
        // options.addOption(classpath2);
        options.addOption(javaonly);
        options.addOption(version);
        options.addOption(help);
        CommandLineParser cmdParser = new GnuParser();
        try {
            // parse the command line arguments
            CommandLine line = cmdParser.parse(options, args);
            
            if (line.hasOption("h") || line.hasOption("help")) {
                printUsage(options);
                System.exit(0);
            }
            
            if (line.hasOption("v") || line.hasOption("version")) {
                System.out.println(SalsaCompiler.version);
                System.exit(0);
            }
            
            if (line.hasOption("cp")) {
                // Add class paths
                String cpString = line.getOptionValue("cp");
                if (cpString != null && cpString.length() > 0) {
                    String classPathStr = System.getProperty("java.class.path");
                    System.setProperty("java.class.path", cpString
                            + File.pathSeparator + classPathStr);
                }
            }

            String[] salsaFileNames = line.getArgs();
            if (salsaFileNames.length == 0)
                throw new ParseException("No input file");

            System.out.println("\n" + SalsaCompiler.version + " Compiler\n");
            
            // Compile Java source first
            
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
                    List<String> errorMessages = parser.getMessages();
                    if (errorMessages == null || errorMessages.size() == 0) {
                        System.err.println("  Parse " + parser.getSourceName()
                                + " successfully");
                    } else {
                        System.err.println("  Parse " + parser.getSourceName()
                                + " failed, total error: "
                                + errorMessages.size());
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
                cu.analyzeMethod(null);
                if (SalsaSource.getErrorNum() > 0) {
                    succeed = false;
                    System.err.println("  Typecheck " + cu.getSourceFileName()
                            + " failed, total error: "
                            + SalsaSource.getErrorNum());
                } else {
                }
                System.gc();
            }
            if (!succeed) {
                System.err
                        .println("If your SALSA program refers to any Java libraries, " +
                        		"they have to be compiled first and import them in your SALSA code");
              System.exit(2);
            }

            for (CompilationUnit cu : cus) {
                SalsaSource.resetErrorNum();
                cu.analyze(null, null, null);
                if (SalsaSource.getErrorNum() > 0) {
                    succeed = false;
                    System.err.println("  Typecheck " + cu.getSourceFileName()
                            + " failed, total error: "
                            + SalsaSource.getErrorNum());
                } else {
                    System.err.println("  Typecheck " + cu.getSourceFileName()
                            + " successfully");
                }
                System.gc();
            }
            System.err.println();

            if (!succeed) {
                System.err
                        .println("If your SALSA program refers to any Java libraries, "
                                + "they have to be compiled first and import them in your SALSA code");
               System.exit(2);
            }

            List<String> generatedFiles = new ArrayList<String>();
            if (succeed) {
                System.err.println("Generating...");
                for (CompilationUnit cu : cus) {
                    generatedFiles.addAll(cu.generateJavaCode());
                    System.gc();
                }
                System.err.println("  Generate Java source code successfully");
            }
            Boolean javaOnlyValue = line.hasOption("j")
                    || line.hasOption("javaonly");
            if (!javaOnlyValue) {
                // Invoking javac to compile Java source code
                StringBuilder sb = new StringBuilder();
                sb.append("javac ");
                sb.append("-cp " + System.getProperty("java.class.path") + " ");

                if (line.hasOption("d")) {
                    sb.append("-d ").append(line.getOptionValue("d"))
                            .append(" ");
                }

                for (String path : generatedFiles)
                    sb.append(path).append(" ");
                System.err.println("\nCompiling...");
                Process p = Runtime.getRuntime().exec(sb.toString());
                InputStream in = p.getErrorStream();
                int c;
                while ((c = in.read()) != -1) {
                    System.out.print((char) c);
                }
                in.close();
                p.waitFor();
                if (p.exitValue() == 0) {
                    System.err
                            .println("  Compile Java source code successfully");
                } else {
                    System.err.println("\n  Compile Java source code failed, "
                            + "please check the Java source code "
                            + "and make sure \"javac\" is in your path");
                }
            }
        } catch (ParseException exp) {
            // oops, something went wrong
            System.err.println("" + exp.getMessage());
            printUsage(options);
            System.exit(1);
        }

        System.err.println();
    }
}
