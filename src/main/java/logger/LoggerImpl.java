package logger;

import logger.appender.Appender;
import logger.appender.AppenderAttachableImpl;
import logger.event.LogEvent;
import logger.event.LogEventImpl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LoggerImpl implements Logger{

    private final String name;

    private final Logger parent;

    private LoggerContext loggerContext;

    private List<Logger> childList;

    private AppenderAttachableImpl aai;

    public LoggerImpl(String name, Logger parent, LoggerContext loggerContext){
        this.name = name;
        this.parent = parent;
        this.loggerContext = loggerContext;
        this.aai = new AppenderAttachableImpl();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Logger getParent() {
        return this.parent;
    }

    @Override
    public void info(String message) {
        LogEvent event = new LogEventImpl(message, this.name, Thread.currentThread().getName());
        Logger l = this;
        for (; l != null; l = l.getParent()) {
            l.invokeAppender(event);
        }
    }

    @Override
    public Logger getChildLogger(String name) {
        if(childList == null){
            return null;
        }

        for (int i = 0; i < childList.size(); i++){
            Logger logger = childList.get(i);
            if(logger.getName().equals(name)){
                return logger;
            }
        }

        return null;
    }

    @Override
    public Logger createChildLogger(String name) {

        Logger logger = new LoggerImpl(name, this, this.loggerContext);

        if (this.childList == null){
           this.childList = new LinkedList<>();
        }

        this.childList.add(logger);

        return logger;
    }

    @Override
    public void addAppender(Appender appender){
        aai.addAppender(appender);
    }

    @Override
    public void invokeAppender(LogEvent logEvent){
        this.aai.doLoopAppenders(logEvent);
    }

}
