package Problems.LoggingFramework.formatters;

import Problems.LoggingFramework.entities.LogMessage;

public class SimpleFormatter implements LogFormatter {
    
    @Override
    public String format(LogMessage logMessage) {
        return String.format("%s [%s] %s: %s",
                logMessage.getDateTime(),
                logMessage.getLevel(),
                logMessage.getName(),
                logMessage.getMessage());
    }
    
}
