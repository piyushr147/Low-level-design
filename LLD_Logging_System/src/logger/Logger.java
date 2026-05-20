package logger;

import enums.LogLevel;
import logHandler.LogHandler;
import logPublisher.LogPublisher;
import loggerManager.LoggerManager;

public class Logger {
    private LoggerManager loggerManager;
    private LogHandler logHandler;
    private LogPublisher logPublisher;

    private Logger() {
        System.out.println("Singleton Constructor Called");
        loggerManager = new LoggerManager();
        logHandler = loggerManager.buildLogHandler();
        logPublisher = loggerManager.buildLogPublisher();
    }

    private static class SingletonHolder{
        public static final Logger instance = new Logger();
    }

    public static Logger getInstance(){
        return SingletonHolder.instance;
    }

    public void info(String msg){
        logHandler.log(LogLevel.INFO,msg);
    }

    public void debug(String msg){
        logHandler.log(LogLevel.DEBUG,msg);
    }

    public void warn(String msg){
        logHandler.log(LogLevel.WARNING,msg);
    }

    public void error(String msg){
        logHandler.log(LogLevel.ERROR,msg);
    }
}
