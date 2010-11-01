package salsa.wwc.lang.services;

import java.io.File;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import salsa.compiler2.SalsaCompiler;

public class Theater {


    private static void printUsage(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("theater <options>", options);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Option help = new Option("h", "help", false, "Print this message");
        Option version = new Option("v", "version", false,
                "Print the version information and exit");

        Option port = OptionBuilder
                .withArgName("port number")
                .hasArg()
                .withDescription(
                        "Specify on which port the theater listens to, default is 4040")
                .create("p");
        Option classpath = OptionBuilder
                .withArgName("path")
                .hasArg()
                .withDescription(
                        "Specify where to find user class files and annotation processors")
                .create("cp");
        Options options = new Options();
        options.addOption(port);
        options.addOption(classpath);
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
            
            if (line.getArgList().size() > 0) {
                printUsage(options);
                System.exit(1);
            }

            if (line.hasOption("p")) {
                try {
                    String s = line.getOptionValue("p");
                    int p = Integer.valueOf(s);
                    ServiceFactory.getReceptionService(p);
                } catch (NumberFormatException e) {
                    throw new ParseException("Invalid port number");
                }
            }
            ServiceFactory.getNamingService();
            ServiceFactory.getTransportService();
        } catch (ParseException e) {
            System.err.println("" + e.getMessage());
            printUsage(options);
            System.exit(1);
        }
    }

}
