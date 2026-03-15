package Problems.LoggingFramework.appenders;

import Problems.LoggingFramework.entities.LogMessage;
import Problems.LoggingFramework.formatters.LogFormatter;
import Problems.LoggingFramework.formatters.SimpleFormatter;

public class ConsoleAppender implements LogAppender {
    
    private LogFormatter formatter;

    public ConsoleAppender(LogFormatter formatter) {
        this.formatter = formatter;
    }

    public ConsoleAppender() {
        this(new SimpleFormatter());
    }

    @Override
    public void append(LogMessage logMessage) {
        System.out.println(formatter.format(logMessage));
    }

    @Override
    public void setFormatter(LogFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public LogFormatter getFormatter() {
        return formatter;
    }

    @Override
    public void close() {
        // No resources to close for console appender
    }
    
    
}
