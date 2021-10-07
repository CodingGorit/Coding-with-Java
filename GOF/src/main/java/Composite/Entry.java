package Composite;

/**
 * @Author Gorit
 * @Date 2021/10/7
 * @desc 表示目录条目的抽象类， File 和 Directory 为其子类
 **/
public abstract class Entry {

    public abstract String getName(); // 获取名字

    public abstract int getSize(); // 获取大小

    /**
     * 向文件夹中放入 文件 或 文件夹，该功能由子类 Directory 实现
     * @param entry
     * @return
     */
    public Entry add(Entry entry) { // 加入目录条目
        throw new FileTreatmentException();
    }

    public void printList() {
        printList("");
    }

    /**
     * 显示文件夹内容的一览
     * @param prefix
     */
    protected abstract void printList(String prefix);

    // 显示代码类文字
    public String toString() {
        return getName() + " (" + getSize() +")";
    }
}
