package logObserver;

import logData.LogData;

public interface LogObserver {
    public void publish(LogData logData);
}
