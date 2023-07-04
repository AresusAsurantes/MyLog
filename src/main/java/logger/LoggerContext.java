package logger;

public interface LoggerContext {

    Logger getLogger(String name);

    Logger setLogger(String name, Logger logger);

    boolean hasLogger(String name);
}
