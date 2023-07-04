package logger.appender;

import logger.event.LogEvent;

public interface Appender {

    String getName();

    void setName(String name);

    void doAppend(LogEvent logEvent);

}
