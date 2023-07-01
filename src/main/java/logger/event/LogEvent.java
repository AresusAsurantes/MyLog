package logger.event;

import logger.appender.Appender;

public interface LogEvent {

    String getLoggerName();

    String getMessage();

    String getThreadName();

}
