package Problems.LoggingFramework.appenders;

import java.io.FileWriter;

import Problems.LoggingFramework.entities.LogMessage;
import Problems.LoggingFramework.formatters.LogFormatter;
import Problems.LoggingFramework.formatters.SimpleFormatter;

public class FileAppender implements LogAppender {
    
    private LogFormatter formatter;
    private final FileWriter fileWriter;

    public FileAppender(LogFormatter formatter, String filePath) {
        this.formatter = formatter;
        try {
            this.fileWriter = new FileWriter(filePath, true); // Open in append mode
        } catch (Exception e) {
            throw new RuntimeException("Failed to open file: " + e.getMessage());
        }
    }

    public FileAppender(String filePath) {
        this(new SimpleFormatter(), filePath);
    }

    @Override
    public void append(LogMessage logMessage) {
        try {
            fileWriter.write(formatter.format(logMessage) + System.lineSeparator());
            fileWriter.flush();
        } catch (Exception e) {
            throw new RuntimeException("Failed to write to file: " + e.getMessage());
        }
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
        try {
            fileWriter.close();
        } catch (Exception e) {
            throw new RuntimeException("Failed to close file: " + e.getMessage());
        }
    }
    
}
