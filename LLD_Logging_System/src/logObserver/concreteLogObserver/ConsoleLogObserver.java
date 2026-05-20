package logObserver.concreteLogObserver;

import logData.LogData;
import logObserver.LogObserver;

public class ConsoleLogObserver implements LogObserver {
    @Override
    public void publish(LogData logData) {
        System.out.println("Printing log on console: " + logData.getMessage());
    }
}
