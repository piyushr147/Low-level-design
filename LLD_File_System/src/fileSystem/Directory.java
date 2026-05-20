package fileSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Directory extends AbstractFileSystem {

    private List<AbstractFileSystem> children = new ArrayList<>();
    public Directory(String name, Date createDate, AbstractFileSystem parent) {
        super(name, createDate, parent);
    }

    @Override
    public void ls() {
        System.out.println("Directory :" + name);
        for(AbstractFileSystem child : children) {
            child.ls();
        }
    }

    @Override
    public void mkdir(String name) throws UnsupportedOperationException {
        AbstractFileSystem abstractFileSystem = new Directory(name, createDate, this);
        if(children.stream().anyMatch(file-> Objects.equals(file.name, name))) {
            System.out.println("Directory with same name already exists");
            return;
        }
        System.out.println("Created new Directory: "+name);
        children.add(abstractFileSystem);
    }

    public AbstractFileSystem cd(String name) {
        if(name.equals("..")) {
            return parent;
        }
        else{
            for(AbstractFileSystem child : children) {
                if(child.name.equals(name)) {
                    return child;
                }
            }
        }
        return this;
    }

    @Override
    public String pwd() {
        String path = parent.pwd();
        return path+"/"+name;
    }

    public void rm(String name) {
        children.removeIf(child -> child.name.equals(name));
    }
}
