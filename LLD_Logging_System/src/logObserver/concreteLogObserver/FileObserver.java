package logObserver.concreteLogObserver;

import logData.LogData;
import logObserver.LogObserver;

public class FileObserver implements LogObserver {
    @Override
    public void publish(LogData logData) {
        System.out.println("Sending log to File");
    }
}
