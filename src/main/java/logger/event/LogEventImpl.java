package logger.event;

public class LogEventImpl implements LogEvent{

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getThreadName() {
        return null;
    }
}
