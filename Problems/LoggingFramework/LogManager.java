package Problems.LoggingFramework;

import java.util.HashMap;
import java.util.Map;

public class LogManager {
    
    private static final LogManager instance = new LogManager();
    private Map<String, Logger> loggers;

    private LogManager() {
        this.loggers = new HashMap<>();
    }

    public static LogManager getInstance() {
        return instance;
    }

    public Logger getLogger(String name) {
        return loggers.computeIfAbsent(name, k -> new Logger(name));
    }

    public Map<String, Logger> getLoggers() {
        return loggers;
    }

    public void shutdown() {
        loggers.values().stream()
            .flatMap(logger -> logger.getAppenders().stream())
            .distinct()
            .forEach(appender -> appender.close());
    }

}
