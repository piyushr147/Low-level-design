package fileSystem;

import java.util.Date;

public abstract class AbstractFileSystem implements FileSystem {
    public String name;
    public Date createDate;
    public AbstractFileSystem parent;

    public AbstractFileSystem(String name, Date createDate, AbstractFileSystem parent) {
        this.name = name;
        this.createDate = createDate;
        this.parent = parent;
    }
}
