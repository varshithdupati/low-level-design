package Problems.LoggingFramework;

import Problems.LoggingFramework.appenders.ConsoleAppender;
import Problems.LoggingFramework.entities.LogLevel;

public class LoggerDemo {
    
    public static void main(String[] args) {
        LogManager logManager = LogManager.getInstance();
        
        Logger logger1 = logManager.getLogger("Logger1");
        logger1.addAppender(new ConsoleAppender());
        logger1.info("This is an info message from Logger1.");
        logger1.error("This is an error message from Logger1.");
        logger1.debug("This message won't appear");

        Logger logger2 = logManager.getLogger("Logger2");
        logger2.addAppender(new ConsoleAppender());
        logger2.setLevel(LogLevel.TRACE);
        logger2.debug("This is a debug message from Logger2.");
        logger2.warn("This is a warning message from Logger2.");
        
        logManager.shutdown();
    }

}
