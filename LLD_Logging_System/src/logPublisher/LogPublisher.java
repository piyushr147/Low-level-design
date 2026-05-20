package logPublisher;

import logData.LogData;
import logObserver.LogObserver;

import java.util.ArrayList;
import java.util.List;

public class LogPublisher {
    private List<LogObserver> logObservers;

    private static class SingletonHolder{
        private static final LogPublisher Instance = new LogPublisher();
    }

    public static LogPublisher getInstance(){
        return SingletonHolder.Instance;
    }

    private LogPublisher() {
        logObservers = new ArrayList<>();
    }

    public void addObserver(LogObserver observer) {
        logObservers.add(observer);
    }

    public void removeObserver(LogObserver observer) {
        logObservers.remove(observer);
    }

    public void notifyObservers(LogData logData){
        for(LogObserver logObserver: logObservers){
            logObserver.publish(logData);
        }
    }
}
