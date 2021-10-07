package Composite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author Gorit
 * @Date 2021/10/7
 * @desc 表示文件夹的类
 **/
public class Dirextory extends Entry {
    private String name; // 文件夹名称
    private ArrayList directory = new ArrayList(); // 文件夹中目录的集合
    public Dirextory(String name) {
        this.name = name;
    }

    public String getName() {   // 获取名字
        return name;
    }

    // 这里我们无法确认是目录的实例 还是 文件的实例，所有用 Iterator，都可以得到大小
    public int getSize() {
        int size = 0;
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry)it.next();
            size += entry.getSize();
        }
        return size;
    }

    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }

    protected void printList(String prefix) { // 显示目录条目一览
        System.out.println(prefix + "/" + this);
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry)it.next();
            entry.printList(prefix + "/" + name);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getDirectory() {
        return directory;
    }

    public void setDirectory(ArrayList directory) {
        this.directory = directory;
    }
}
