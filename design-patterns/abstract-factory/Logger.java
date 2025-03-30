public class Logger {
    public static void main(String[]  args) {
        ILoggerFactory loggerFactory = ILoggerFactory.createLoggerFactory("console");
        if(loggerFactory != null) {
            ILogger debugLogger = loggerFactory.createDebugLogger();
            ILogger errorLogger = loggerFactory.createErrorLogger();
            ILogger infoLogger = loggerFactory.createInfoLogger();
            debugLogger.log();
            errorLogger.log();
            infoLogger.log();
        }
    }
}

abstract class ILoggerFactory {
    public abstract DebugLogger createDebugLogger();
    public abstract ErrorLogger createErrorLogger();
    public abstract InfoLogger createInfoLogger(); 

    public static ILoggerFactory createLoggerFactory(String type) {
        if (type.equals("console")) {
            return new ConsoleLoggerFactory();
        }
        else if (type.equals("file")) {
            return new FileLoggerFactory();
        }

        return null;
    }
}

class ConsoleLoggerFactory extends ILoggerFactory {
    
    @Override
    public DebugLogger createDebugLogger() {
        return new DebugLogger();
    }

    @Override
    public ErrorLogger createErrorLogger() {
        return new ErrorLogger();
    }

    @Override
    public InfoLogger createInfoLogger() {
        return new InfoLogger();
    }
}

class FileLoggerFactory extends ILoggerFactory {
    @Override
    public DebugLogger createDebugLogger() {
        return new DebugLogger();
    }

    @Override
    public ErrorLogger createErrorLogger() {
        return new ErrorLogger();
    }

    @Override
    public InfoLogger createInfoLogger() {
        return new InfoLogger();
    }
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

class LogLevel {
    public static String DEBUG = "Debug";
    public static String ERROR = "Error";
    public static String INFO = "Info";
}
