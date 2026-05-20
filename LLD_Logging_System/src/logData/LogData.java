package logData;

import enums.LogLevel;

import java.util.Date;

public class LogData {
    private String message;
    private Date date;
    private LogLevel level;

    public LogData(String message, Date date, LogLevel type) {
        this.message = message;
        this.date = date;
        this.level = type;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public LogLevel getLevel() {
        return level;
    }
}
