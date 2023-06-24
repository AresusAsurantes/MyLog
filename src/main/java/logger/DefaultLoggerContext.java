package logger;

import logger.appender.AppenderAttachable;
import logger.utils.LoggerNameUtils;

import java.util.HashMap;
import java.util.Map;

public class DefaultLoggerContext implements LoggerContext {

    private Map<String, Logger> loggerCache;
    private final Logger root;

    public DefaultLoggerContext(){
        loggerCache = new HashMap<>();
        root = new LoggerImpl("ROOT", null, this);
        loggerCache.put(Logger.ROOT_NAME, root);
    }

    @Override
    public Logger getLogger(String name) {
        if(name == null){
            throw new IllegalArgumentException("name argument cannot be null");
        }

        if(Logger.ROOT_NAME.equals(name)){
            return this.root;
        }

        Logger logger = root, childLogger = loggerCache.get(name);
        if(childLogger != null){
            return childLogger;
        }

        int i = 0;
        String childName;
        while(true){
            int h = LoggerNameUtils.getSeparatorIndexOf(name, i);
            if (h != -1){
                childName = name.substring(0, h);
            } else {
                childName = name;
            }

            childLogger = logger.getChildLogger(childName);
            if(childLogger == null){
                childLogger = logger.createChildLogger(childName);
                loggerCache.put(childName, childLogger);
                logger = childLogger;
            }

            if(h == -1){
                return childLogger;
            }

            i = h+1;
        }
    }

    @Override
    public Logger setLogger(String name, Logger logger) {
        return loggerCache.put(name, logger);
    }

    @Override
    public boolean hasLogger(String name) {
        return loggerCache.containsKey(name);
    }
}
