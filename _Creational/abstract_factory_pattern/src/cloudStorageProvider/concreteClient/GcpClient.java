package cloudStorageProvider.concreteClient;

import cloudStorageProvider.ClientConnectorFactory;
import cloudStorageProvider.Queue;
import cloudStorageProvider.Storage;
import cloudStorageProvider.concreteQueue.PubSubQueue;
import cloudStorageProvider.concreteStorage.GcsStorage;

public class GcpClient implements ClientConnectorFactory {

    public GcpClient(){
        System.out.println("GCP Client called");
    }

    @Override
    public Storage createStorage() {
        return new GcsStorage();
    }

    @Override
    public Queue createQueue() {
        return new PubSubQueue();
    }
}
