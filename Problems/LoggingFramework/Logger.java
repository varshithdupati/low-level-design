package Problems.LoggingFramework;

import java.util.ArrayList;
import java.util.List;

import Problems.LoggingFramework.entities.LogLevel;
import Problems.LoggingFramework.entities.LogMessage;
import Problems.LoggingFramework.appenders.LogAppender;

public class Logger {
    
    private final String name;
    private LogLevel level;
    private final List<LogAppender> appenders;

    public Logger(String name, LogLevel level, List<LogAppender> appenders) {
        this.name = name;
        this.level = level;
        this.appenders = appenders;
    }

    public Logger(String name, LogLevel level) {
        this(name, level, new ArrayList<>());
    }

    public Logger(String name) {
        this(name, LogLevel.INFO);
    }

    public String getName() {
        return name;
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public void addAppender(LogAppender appender) {
        appenders.add(appender);
    }

    public void removeAppender(LogAppender appender) {
        appenders.remove(appender);
    }

    public List<LogAppender> getAppenders() {
        return appenders;
    }

    public void log(LogLevel level, String message) {
        if (level.isGreaterOrEqual(this.level)) {
            LogMessage logMessage = new LogMessage(level, name, message);
            for (LogAppender appender : appenders) {
                appender.append(logMessage);
            }
        }
    }

    public void trace(String message) {
        log(LogLevel.TRACE, message);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }
    
}
