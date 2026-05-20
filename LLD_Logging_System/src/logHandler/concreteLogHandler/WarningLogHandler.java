package logHandler.concreteLogHandler;

import enums.LogLevel;
import logData.LogData;
import logHandler.LogHandler;

import java.sql.Date;
import java.time.LocalDate;

public class WarningLogHandler extends LogHandler {
    public WarningLogHandler(LogLevel level) {
        super(level);
    }

    @Override
    public void write(LogLevel level, String message) {
        if(level == LogLevel.WARNING){
            System.out.println("Warning log write");
            message = "Warning: " + message;
            LogData logData = new LogData(message, Date.valueOf(LocalDate.now()),LogLevel.WARNING);
            logPublisher.notifyObservers(logData);
        }
    }
}
