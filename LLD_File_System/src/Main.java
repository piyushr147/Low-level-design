import enums.AccessLevel;
import fileSystem.AbstractFileSystem;
import fileSystem.Directory;
import fileSystem.File;
import fileSystem.FileSystem;
import proxy.FileSystemProxy;
import user.User;

import java.sql.Date;
import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User user = new User("piyush");
        user.addAccessLevels(AccessLevel.READ);
        user.addAccessLevels(AccessLevel.WRITE);
        user.addAccessLevels(AccessLevel.CREATE);

        Directory directory = new Directory("root", Date.valueOf(LocalDate.now()),null);
        FileSystemProxy fileSystemProxy = new FileSystemProxy(directory,user);

        fileSystemProxy.ls();
        fileSystemProxy.pwd();
        fileSystemProxy.mkdir("var");
        fileSystemProxy.mkdir("user");
        fileSystemProxy.ls();
        fileSystemProxy.cd("var");
        fileSystemProxy.mkdir("text");
        fileSystemProxy.ls();
        fileSystemProxy.cd("..");
        fileSystemProxy.pwd();
    }
}