package logHandler.concreteLogHandler;

import enums.LogLevel;
import logData.LogData;
import logHandler.LogHandler;

import java.sql.Date;
import java.time.LocalDate;

public class InfoLogHandler extends LogHandler {

    public InfoLogHandler(LogLevel level) {
        super(level);
    }

    @Override
    public void write(LogLevel level, String message) {
        if(level == LogLevel.INFO){
            System.out.println("InfoLog write");
            message = "Info: " + message;
            LogData logData = new LogData(message, Date.valueOf(LocalDate.now()),LogLevel.INFO);
            logPublisher.notifyObservers(logData);
        }
    }
}
