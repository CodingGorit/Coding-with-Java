package Visitor;

/**
 * @Author Gorit
 * @Date 2021/10/24
 **/
public class File extends Entry {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
