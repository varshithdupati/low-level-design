package Problems.LoggingFramework.appenders;

import Problems.LoggingFramework.entities.LogMessage;
import Problems.LoggingFramework.formatters.LogFormatter;

public interface LogAppender {
    
    void append(LogMessage logMessage);
    void setFormatter(LogFormatter formatter);
    LogFormatter getFormatter();
    void close();

}
