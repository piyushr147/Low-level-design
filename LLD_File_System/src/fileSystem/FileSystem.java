package fileSystem;

public interface FileSystem {
    public void ls();
    public void mkdir(String name) throws UnsupportedOperationException;
    public AbstractFileSystem cd(String name) throws UnsupportedOperationException;
    public String pwd();
}
