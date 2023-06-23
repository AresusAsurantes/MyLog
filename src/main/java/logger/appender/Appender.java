package logger.appender;

import logger.event.LogEvent;

public interface Appender {

    void doAppend(LogEvent logEvent);

}
