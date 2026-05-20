package loggerManager;

import enums.LogLevel;
import logHandler.LogHandler;
import logHandler.concreteLogHandler.DebugLogHandler;
import logHandler.concreteLogHandler.ErrorLogHandler;
import logHandler.concreteLogHandler.InfoLogHandler;
import logHandler.concreteLogHandler.WarningLogHandler;
import logObserver.concreteLogObserver.ConsoleLogObserver;
import logObserver.concreteLogObserver.DbLogObserver;
import logObserver.concreteLogObserver.FileObserver;
import logPublisher.LogPublisher;

public class LoggerManager {

    public LogHandler buildLogHandler() {
        LogHandler info = new InfoLogHandler(LogLevel.INFO);
        LogHandler debug = new DebugLogHandler(LogLevel.DEBUG);
        LogHandler warning = new WarningLogHandler(LogLevel.WARNING);
        LogHandler error = new ErrorLogHandler(LogLevel.ERROR);

        warning.setNextLogHandler(error);
        debug.setNextLogHandler(warning);
        info.setNextLogHandler(debug);
        return info;
    }

    public LogPublisher buildLogPublisher(){
        LogPublisher logPublisher = LogPublisher.getInstance();
        logPublisher.addObserver(new ConsoleLogObserver());
        logPublisher.addObserver(new DbLogObserver());
        logPublisher.addObserver(new FileObserver());
        return logPublisher;
    }
}
