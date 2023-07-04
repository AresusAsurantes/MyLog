package logger.utils;

public class LoggerNameUtils {

    public static int getSeparatorIndexOf(String name, int startIdx){
        return name.indexOf('.', startIdx);
    }

}
