package logger.appender;

import logger.event.LogEvent;
import logger.layout.Layout;

import java.io.IOException;
import java.io.OutputStream;

public class ConsoleAppender extends AbstractAppender {

    private OutputStream outputStream;

    private String name;

    private Layout layout;

    @Override
    protected void append(LogEvent logEvent) {
        String formedMessage = layout.doLayout(logEvent);

        if(this.outputStream == null){
            this.outputStream = System.out;
        }

        try {
            outputStream.write(formedMessage.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setLayout(Layout layout){
        this.layout = layout;
    }
}
