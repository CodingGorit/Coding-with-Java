package Visitor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author Gorit
 * @Date 2021/10/24
 **/
public class Directory extends Entry {
    private String name;        // 文件夹名字
    private ArrayList dir = new ArrayList();    // 目标条目集合

    public Directory(String name) {
        this.name = name;
    }
    public String getName() {       // 获取名字
        return name;
    }

    public int getSize() {
        int size = 0;
        Iterator it = dir.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            size += entry.getSize();
        }
        return size;
    }
    public Entry add(Entry entry) {     // 增加目录条目
        dir.add(entry);
        return this;
    }

    public Iterator iterator() {        // 生成 iterator
        return dir.iterator();
    }

    public void accept(Visitor v) {     // 接受访问者的访问
        v.visit(this);
    }
}
