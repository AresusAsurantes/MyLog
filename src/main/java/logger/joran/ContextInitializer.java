package logger.joran;

import logger.Constants;
import logger.LoggerContext;
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
        InputSource inputSource = findConfigSource();

        if (inputSource == null){
            // TODO
            // do default configuration
        } else {

        }

    }

    private InputSource findConfigSource(){
        String searchPath = Constants.XML_SEARCH_PATH;

        File rPackage = new File(searchPath);
        try {
            List<Path> configPathList = Files.walk(rPackage.toPath())
                    .filter(path -> path.toFile().getName().equals(Constants.CONFIG_FILE_NAME))
                    .collect(Collectors.toList());

            if (configPathList.size() > 0){
                Path path = configPathList.get(0);
                InputStream inputStream = new FileInputStream(path.toFile());
                return new InputSource(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
