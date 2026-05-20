package logHandler.concreteLogHandler;

import enums.LogLevel;
import logData.LogData;
import logHandler.LogHandler;

import java.sql.Date;
import java.time.LocalDate;

public class DebugLogHandler extends LogHandler {
    public DebugLogHandler(LogLevel level) {
        super(level);
    }

    @Override
    public void write(LogLevel level, String message) {
        if(level == LogLevel.DEBUG){
            System.out.println("Debug log write");
            message = "Debug: " + message;
            LogData logData = new LogData(message, Date.valueOf(LocalDate.now()),LogLevel.DEBUG);
            logPublisher.notifyObservers(logData);
        }
    }
}
