package logger;

import logger.event.LogEvent;

public interface Logger {

    String getName(LogEvent logEvent);

    void info(String message);
}
