package cloudStorageProvider.concreteStorage;

import cloudStorageProvider.Storage;

public class S3Storage implements Storage {
    @Override
    public void upload(String filename, String content) {
        System.out.println("Uploading " + filename + " to AWS");
        System.out.println("content: " + content);
    }
}
