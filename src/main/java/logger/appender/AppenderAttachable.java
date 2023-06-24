package logger.appender;

import java.util.Iterator;

public interface AppenderAttachable {

    void addAppender(Appender appender);

    boolean isAttached(Appender appender);

    Iterator<Appender> getIterator();

}
