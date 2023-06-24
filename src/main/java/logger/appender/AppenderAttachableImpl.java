package logger.appender;

import logger.event.LogEvent;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AppenderAttachableImpl implements AppenderAttachable {

    private final List<Appender> appenderList;

    public AppenderAttachableImpl(){
        this.appenderList = new LinkedList<>();
    }

    @Override
    public void addAppender(Appender appender) {
        appenderList.add(appender);
    }

    @Override
    public boolean isAttached(Appender appender) {
        for (Appender appender1 : appenderList) {
            if(appender1.getName().equals(appender.getName())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Appender> getIterator() {
        return appenderList.iterator();
    }

    public void doLoopAppenders(LogEvent logEvent){
        for (Appender appender : this.appenderList) {
            appender.doAppend(logEvent);
        }
    }
}
