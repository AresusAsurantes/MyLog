import logger.Logger;
import logger.factory.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.Format;
import java.text.MessageFormat;

public class DemoApp {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("Demo.Class");
        logger.info("Hello World!!!");
//        MessageFormat format = new MessageFormat("%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n");
//        MessageFormat format = new MessageFormat("{%tc} {thread} {class} - {message}");
//        Object[] arg = {System.currentTimeMillis(), Thread.currentThread(), DemoApp.class, "hello"};
//        String format1 = format.format(arg);
//        OutputStream outputStream = System.out;
//        try {
//            outputStream.write(format1.getBytes());
//            outputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
