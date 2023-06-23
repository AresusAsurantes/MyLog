package logger.appender;

import logger.event.LogEvent;

public abstract class AbstractAppender implements Appender {

    private boolean finish = false;

    @Override
    public void doAppend(LogEvent logEvent){

        if(!finish){
            finish = true;



        }

    }

}