package logger.configurator;

import logger.Logger;
import logger.LoggerContext;
import logger.appender.ConsoleAppender;
import logger.layout.ConsoleLayout;
import logger.layout.Layout;

public class BasicConfigurator {

    private LoggerContext loggerContext;

    public BasicConfigurator(LoggerContext loggerContext) { this.loggerContext = loggerContext;}

    public void doConfig(){
        ConsoleAppender ca = new ConsoleAppender();

        Layout layout = new ConsoleLayout();
        ca.setLayout(layout);

        Logger root = loggerContext.getLogger("ROOT");
        root.addAppender(ca);
    }

}
