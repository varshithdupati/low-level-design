package Problems.LoggingFramework.entities;

import java.time.LocalDateTime;

public class LogMessage {
    
    private final LocalDateTime dateTime;
    private final LogLevel level;
    private final String name;
    private final String message;

    public LogMessage(LocalDateTime dateTime, LogLevel level, String name, String message) {
        this.dateTime = dateTime;
        this.level = level;
        this.name = name;
        this.message = message;
    }

    public LogMessage(LogLevel level, String name, String message) {
        this(LocalDateTime.now(), level, name, message);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

}
