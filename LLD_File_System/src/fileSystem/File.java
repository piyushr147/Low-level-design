package fileSystem;

import java.util.Date;

public class File extends AbstractFileSystem {

    public File(String name, Date createDate, AbstractFileSystem parent) {
        super(name,createDate,parent);
    }

    @Override
    public void ls() {
        System.out.println("File: " + name);
    }

    @Override
    public void mkdir(String name){
        throw new UnsupportedOperationException("Can not make a folder inside a file");
    }

    @Override
    public AbstractFileSystem cd(String name) {
        return parent;
    }

    @Override
    public String pwd() {
        String path = parent.pwd();
        return path+"/"+name;
    }
}
