package logger;

import java.util.HashMap;
import java.util.Map;

public class DefaultLoggerContext implements LoggerContext {

    Map<String, Logger> loggerMap = new HashMap<>();

    @Override
    public Logger getLogger(String name) {
        return loggerMap.get(name);
    }

    @Override
    public Logger setLogger(String name, Logger logger) {
        return loggerMap.put(name, logger);
    }
}
