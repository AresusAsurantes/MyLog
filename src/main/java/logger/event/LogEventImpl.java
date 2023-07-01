package logger.event;

import logger.LoggerImpl;

public class LogEventImpl implements LogEvent{

    private String message;

    private String loggerName;

    private String threadName;

    public LogEventImpl(){}

    public LogEventImpl(String message, String loggerName, String threadName){
        this.message = message;
        this.loggerName = loggerName;
        this.threadName = threadName;
    }

    @Override
    public String getLoggerName() {
        return this.loggerName;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getThreadName() {
        return this.threadName;
    }
}
