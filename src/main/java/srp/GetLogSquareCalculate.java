package srp;

import org.apache.log4j.Logger;

public class GetLogSquareCalculate implements GetLog {
    @Override
    public Logger getLog(String className) {
        return Logger.getLogger(className.getClass());
    }

    public void consolePrintLog(Logger log) {
        System.out.println(log);
    }
}
