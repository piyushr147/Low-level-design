package logHandler;

import enums.LogLevel;
import logPublisher.LogPublisher;

public abstract class LogHandler {

    private LogHandler nextLogHandler;
    public LogPublisher logPublisher = LogPublisher.getInstance();
    private LogLevel level;
    
    public LogHandler(LogLevel level) {
        this.level = level;
    }
    
    public void setNextLogHandler(LogHandler nextLogHandler) {
        this.nextLogHandler = nextLogHandler;
    }

    public void log(LogLevel level, String message) {
        if(this.level == level){
            write(level, message);
        }
        else if(nextLogHandler != null) 
            nextLogHandler.write(level, message);
        else 
            throw new RuntimeException("Log handler for this level not found");
    }
    public abstract void write(LogLevel level, String message);
}
