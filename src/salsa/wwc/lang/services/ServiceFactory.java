package salsa.wwc.lang.services;

import java.io.File;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

public class ServiceFactory {
    
//    static {
//        if (new File("./log4j.properties").exists()) {
//            PropertyConfigurator.configure("./log4j.properties");
//        }
//        else {
//            System.err.println("Load default log4j configuration.");
//            BasicConfigurator.configure();
//        }
//    }

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
        if (receptionService == null)
            receptionService = new ReceptionService();
        return receptionService;
    }
    
    private static TransportService transportService;
    public static TransportService getTransportService() {
        if (transportService == null)
            transportService = new TransportService();
        return transportService;
    }
}
