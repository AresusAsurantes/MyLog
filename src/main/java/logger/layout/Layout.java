package logger.layout;

import logger.event.LogEvent;

public interface Layout {

    String doLayout(LogEvent logEvent);

}
