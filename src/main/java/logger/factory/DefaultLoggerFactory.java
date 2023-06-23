package factory;

import logger.Logger;
import logger.LoggerContext;
import logger.factory.LoggerFactory;

public class DefaultLoggerFactory implements LoggerFactory {

    LoggerContext loggerContext;

    @Override
    public Logger getLogger(String name) {
        return null;
    }
}
