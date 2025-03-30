public class Logger {
    public static void main(String[]  args) {
        ILogger logger = LoggerFactory.createLogger(LogLevel.INFO);
        logger.log();
    }
}

class LoggerFactory {
    public static ILogger createLogger(String logLevel) {
        if (logLevel.equals(LogLevel.DEBUG)) {
            return new DebugLogger();
        }
        else if (logLevel.equals(LogLevel.ERROR)) {
            return new ErrorLogger();
        }
        else if (logLevel.equals(LogLevel.INFO)) {
            return new InfoLogger();
        }
        return null;
    }
}

class LogLevel {
    public static String DEBUG = "Debug";
    public static String ERROR = "Error";
    public static String INFO = "Info";
}

interface ILogger {
    public void log();
}

class DebugLogger implements ILogger {
    @Override
    public void log() {
        System.out.println("This is a Debug Log message");
    }
}

class ErrorLogger implements ILogger {
    @Override
    public void log() {
        System.out.println("This is a Error Log message");
    }
}

class InfoLogger implements ILogger {
    @Override
    public void log() {
        System.out.println("This is a Info Log message");
    }
}