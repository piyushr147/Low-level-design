package cloudStorageProvider.app;

import cloudStorageProvider.ClientConnectorFactory;
import cloudStorageProvider.Queue;
import cloudStorageProvider.Storage;

public class CloudApp {
    private Storage storage;
    private Queue queue;

    public CloudApp(ClientConnectorFactory factory){
        storage = factory.createStorage();
        queue = factory.createQueue();
    }

    public void sendData(String fileName,String content){
        System.out.println("Sending data to cloud");
        this.storage.upload(fileName,content);
    }

    public void PushMessage(String message){
        System.out.println("Pushing message to cloud");
        this.queue.push(message);
    }
}
