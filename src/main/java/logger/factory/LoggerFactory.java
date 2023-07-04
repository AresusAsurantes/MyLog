package logger.factory;

import logger.DefaultLoggerContext;
import logger.Logger;
import logger.LoggerContext;
import logger.joran.ContextInitializer;

public class LoggerFactory {

    private static LoggerContext loggerContext;

    private static int STATUS = 0;
    private static final int UNINITIALIZED = 0;
    private static final int INITIALIZED = 1;

    public static Logger getLogger(String name){
        checkInitialization();
        return loggerContext.getLogger(name);
    }

    private static void checkInitialization(){
        if(STATUS == UNINITIALIZED){
            loggerContext = new DefaultLoggerContext();
            new ContextInitializer(loggerContext).initialize();
            STATUS = INITIALIZED;
        }
    }
}
