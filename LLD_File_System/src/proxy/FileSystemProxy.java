package proxy;

import enums.AccessLevel;
import fileSystem.Directory;
import fileSystem.AbstractFileSystem;
import fileSystem.FileSystem;
import user.User;

public class FileSystemProxy implements FileSystem {

    private Directory currentDirectory;
    private User user;

    public FileSystemProxy(Directory currentDirectory, User user) {
        this.currentDirectory = currentDirectory;
        this.user = user;
    }

    @Override
    public void ls() {
        if(user.hasPermission(AccessLevel.READ))
            currentDirectory.ls();
        else
            System.out.println("You do not have permission to access this file");
    }

    @Override
    public void mkdir(String name) throws UnsupportedOperationException {
        if(user.hasPermission(AccessLevel.CREATE))
            currentDirectory.mkdir(name);
        else
            System.out.println("You do not have permission to create file");
    }

    @Override
    public AbstractFileSystem cd(String name) throws UnsupportedOperationException {
        this.currentDirectory = (Directory) currentDirectory.cd(name);
        return this.currentDirectory;
    }

    @Override
    public String pwd() {
        String path = currentDirectory.pwd();
        return path+"/"+this.currentDirectory.name;
    }
}
