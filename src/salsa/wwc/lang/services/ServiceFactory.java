package salsa.lang.services;

public class ServiceFactory {

    private static StageService stageService;
    public synchronized static StageService getStageService() {
        if (stageService == null)
            stageService = new StageService();
        return stageService;
    }
}
