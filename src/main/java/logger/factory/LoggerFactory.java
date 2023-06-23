package logger.factory;

import logger.Logger;

public interface LoggerFactory {

    Logger getLogger(String name);

}
