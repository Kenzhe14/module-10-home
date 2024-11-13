import java.util.List;
import java.util.ArrayList;

abstract class FileSystemComponent {
    protected String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    abstract void Display(int depth);
    abstract void GetSize();

    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public FileSystemComponent getChild(int index) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}

class File extends FileSystemComponent {
    private String name;
    private int size;

    public File(String name, int size) {
        super(name);
        this.name = name;
        this.size = size;
    }

    @Override
    void Display(int depth) {
        System.out.println(new String(new char[depth]).replace("\0", "-") + " File: " + name);
    }

    @Override
    void GetSize() {
        System.out.println(name + " Size = " + size);
    }
}

class Directory extends FileSystemComponent {
    private List<FileSystemComponent> children = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    @Override
    public void add(FileSystemComponent component) {
        children.add(component);
    }

    @Override
    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    @Override
    public FileSystemComponent getChild(int index) {
        return children.get(index);
    }

    @Override
    public void Display(int depth) {
        System.out.println(new String(new char[depth]).replace("\0", "-") + " Directory: " + name);
        for (FileSystemComponent component : children) {
            component.Display(depth + 2);
        }
    }

    @Override
    void GetSize() {

    }
}

public class Composite {
    public static void main(String[] args) {
        Directory root = new Directory("Root");
        File file = new File("File 1", 50);
        File file2 = new File("File 2", 20);

        Directory subdir = new Directory("Sub dir");
        File subfile = new File("Sub file", 10);

        Directory subsubdir = new Directory("Sub sub dir");
        File subsubfile = new File("Sub sub file", 15);

        root.add(file);
        root.add(file2);

        subdir.add(subfile);
        root.add(subdir);

        subsubdir.add(subsubfile);
        subdir.add(subsubdir);

        root.Display(1);
        root.GetSize();
        file.GetSize();
        file2.GetSize();
        subfile.GetSize();
        subsubfile.GetSize();
    }
}