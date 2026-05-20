import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemNode {

    private final String name;
    private final List<FileSystemNode> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystemNode node) {
        children.add(node);
    }

    public void remove(FileSystemNode node) {
        children.remove(node);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemNode node : children) {
            totalSize += node.getSize();
        }
        return totalSize;
    }
}
