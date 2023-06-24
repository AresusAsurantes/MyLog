package logger;

import logger.event.LogEvent;

public interface Logger {

    String ROOT_NAME = "ROOT";

    String getName();

    void info(String message);

    Logger getChildLogger(String name);

    Logger createChildLogger(String name);
}
