public class Main {
    public static void main(String[] args) {

        File file1 = new File("resume.pdf", 120);
        File file2 = new File("photo.jpg", 200);

        Folder documents = new Folder("Documents");
        documents.add(file1);
        documents.add(file2);

        Folder root = new Folder("Root");
        root.add(documents);
        root.add(new File("readme.txt", 50));

        System.out.println("Total size of root: " + root.getSize());
    }
}
