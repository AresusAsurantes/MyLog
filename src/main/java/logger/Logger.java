package logger;

import logger.appender.Appender;
import logger.event.LogEvent;

public interface Logger {

    String ROOT_NAME = "ROOT";

    String getName();

    Logger getParent();

    void info(String message);

    Logger getChildLogger(String name);

    Logger createChildLogger(String name);

    void addAppender(Appender appender);

    void invokeAppender(LogEvent logEvent);

}
