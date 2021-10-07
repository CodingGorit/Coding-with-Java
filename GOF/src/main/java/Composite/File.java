package Composite;

/**
 * @Author Gorit
 * @Date 2021/10/7
 *
 * @example
 * new File("readne.md", 1000);
 **/
public class File extends Entry {
    private String name;

    private int size;

    public File(String name, Integer size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // 使用 this，自动调用 toString() 等价于 this.toString()
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }
}
