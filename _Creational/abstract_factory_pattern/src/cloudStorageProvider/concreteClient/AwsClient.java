package cloudStorageProvider.concreteClient;

import cloudStorageProvider.ClientConnectorFactory;
import cloudStorageProvider.Queue;
import cloudStorageProvider.Storage;
import cloudStorageProvider.concreteQueue.SqsQueue;
import cloudStorageProvider.concreteStorage.S3Storage;

public class AwsClient implements ClientConnectorFactory {

    public AwsClient(){
        System.out.println("AWS Client called");
    }

    @Override
    public Storage createStorage() {
        return new S3Storage();
    }

    @Override
    public Queue createQueue() {
        return new SqsQueue();
    }
}
