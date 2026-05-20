package cloudStorageProvider.concreteQueue;

import cloudStorageProvider.Queue;

public class PubSubQueue implements Queue {

    @Override
    public void push(String message){
        System.out.println("Pushing message to pub/sub: " + message);
    }
}
