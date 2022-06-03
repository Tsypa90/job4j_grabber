package srp;

import org.apache.log4j.Logger;

public class GetLogSquareCalculate implements GetLog {
    @Override
    public Logger getLog(String className) {
        return Logger.getLogger(className.getClass());
    }

    @Override
    public void printLog(Logger logger) {
        System.out.println(logger);
    }
}
