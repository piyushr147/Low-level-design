package logHandler.concreteLogHandler;

import enums.LogLevel;
import logData.LogData;
import logHandler.LogHandler;

import java.sql.Date;
import java.time.LocalDate;

public class ErrorLogHandler extends LogHandler {

    public ErrorLogHandler(LogLevel level){
        super(level);
    }

    @Override
    public void write(LogLevel level, String message) {
        if(level == LogLevel.ERROR){
            System.out.println("Error log write");
            message = "Error: " + message;
            LogData logData = new LogData(message, Date.valueOf(LocalDate.now()),LogLevel.ERROR);
            logPublisher.notifyObservers(logData);
        }
    }
}
