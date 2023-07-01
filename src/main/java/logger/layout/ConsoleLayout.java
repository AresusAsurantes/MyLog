package logger.layout;

import logger.event.LogEvent;

import java.text.SimpleDateFormat;

public class ConsoleLayout implements Layout{

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:MM:SS");

    @Override
    public String doLayout(LogEvent logEvent) {
        StringBuilder sb = new StringBuilder();
        sb.append(format.format(System.currentTimeMillis()));
        sb.append(" ");
        sb.append("[");
        sb.append(logEvent.getThreadName());
        sb.append("] ");
        sb.append(logEvent.getLoggerName());
        sb.append("-");
        sb.append(logEvent.getMessage());
        sb.append("\n");
        return sb.toString();
    }
}
