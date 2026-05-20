package cloudStorageProvider;

public interface ClientConnectorFactory {
    Storage createStorage();
    Queue createQueue();
}
