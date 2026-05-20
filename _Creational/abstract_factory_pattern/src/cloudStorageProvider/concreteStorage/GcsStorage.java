package cloudStorageProvider.concreteStorage;

import cloudStorageProvider.Storage;

public class GcsStorage implements Storage {
    @Override
    public void upload(String filename, String content) {
        System.out.println("Uploading " + filename + " to GCP");
        System.out.println("content: " + content);
    }
}
