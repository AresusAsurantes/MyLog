import logger.Logger;
import logger.factory.LoggerFactory;

public class DemoApp {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("Demo.Class");
        System.out.println(1);
    }
}
