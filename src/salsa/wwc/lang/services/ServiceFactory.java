package salsa.wwc.lang.services;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.RollingFileAppender;

public class ServiceFactory {
    static {
        if (new File("./log4j.properties").exists()) {
            PropertyConfigurator.configure("./log4j.properties");
        } else {
            Logger rootLogger = Logger.getRootLogger();
            if (!rootLogger.getAllAppenders().hasMoreElements()) {
                rootLogger.setLevel(Level.INFO);
                rootLogger.addAppender(new ConsoleAppender(new PatternLayout(
                        "%-5p - %m%n")));

                Logger fileLogger = rootLogger.getLoggerRepository().getLogger(
                        "salsa");
                try {
                    fileLogger.addAppender(new RollingFileAppender(
                            new PatternLayout(
                                    PatternLayout.TTCC_CONVERSION_PATTERN),
                            "salsa.log"));
                } catch (IOException e) {
                }
            }
        }
    }

    private static StageService stageService;

    public synchronized static StageService getStageService() {
        if (stageService == null)
            stageService = new StageService();
        return stageService;
    }

    private static NamingService namingService;

    public synchronized static NamingService getNamingService() {
        if (namingService == null)
            namingService = new NamingService();
        return namingService;
    }

    private static ReceptionService receptionService;

    public static ReceptionService getReceptionService() {
        synchronized (ReceptionService.class) {
            if (receptionService == null)
                receptionService = new ReceptionService();
            return receptionService;
        }
    }

    public static ReceptionService getReceptionService(int port) {
        synchronized (ReceptionService.class) {
            if (receptionService == null)
                receptionService = new ReceptionService(port);
            return receptionService;
        }
    }

    private static TransportService transportService;

    public synchronized static TransportService getTransportService() {
        if (transportService == null)
            transportService = new TransportService();
        return transportService;
    }
}
