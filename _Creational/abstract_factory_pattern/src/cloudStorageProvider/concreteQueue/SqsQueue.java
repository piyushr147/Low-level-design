package cloudStorageProvider.concreteQueue;

import cloudStorageProvider.Queue;

public class SqsQueue implements Queue {
    @Override
    public void push(String message) {
        System.out.println("Pushing message to sqs" + message);
    }
}
