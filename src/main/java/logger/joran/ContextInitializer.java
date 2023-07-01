package logger.joran;

import logger.Constants;
import logger.Logger;
import logger.LoggerContext;
import logger.LoggerImpl;
import logger.configurator.BasicConfigurator;
import org.xml.sax.InputSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ContextInitializer {

    private LoggerContext loggerContext;

    public ContextInitializer(LoggerContext loggerContext){
        this.loggerContext = loggerContext;
    }

    public void initialize(){
        InputStream inputStream = findConfigSource();

        if (inputStream == null){
            // TODO
            // do default configuration
            new BasicConfigurator(loggerContext).doConfig();


        } else {
            InputSource inputSource = new InputSource();

            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private InputStream findConfigSource(){
        String searchPath = Constants.XML_SEARCH_PATH;
        try {
            File rPackage = new File(searchPath);
            List<Path> configPathList = Files.walk(rPackage.toPath())
                    .filter(path -> path.toFile().getName().equals(Constants.CONFIG_FILE_NAME))
                    .collect(Collectors.toList());

            if (configPathList.size() > 0){
                Path path = configPathList.get(0);
                return new FileInputStream(path.toFile());
            }
        } catch (IOException e) {
            return null;
        } finally {
            return null;
        }
    }

}
