package Problems.LoggingFramework.formatters;

import Problems.LoggingFramework.entities.LogMessage;

public interface LogFormatter {
    
    String format(LogMessage logMessage);

}
