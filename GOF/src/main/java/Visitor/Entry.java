package Visitor;

import java.util.Iterator;

/**
 * @Author Gorit
 * @Date 2021/10/24
 * 本质上和 Composite 的 Entry 是一样的。
 * 实现 Element 接口中声明的抽象方法，为了使 Entry 适用 Visitor 模式
 **/
public abstract class Entry implements Element{
    public abstract String getName();  // 获取名字
    public abstract int getSize();      // 获取大小
    public Entry add(Entry entry) {     // 增加目录条目
        throw new FileTreatmentException();
    }
    public Iterator iterator() {        // 生成 Iterator
        throw new FileTreatmentException();
    }

    public String toString() {          // 显示字符串
        return getName() + " (" + getSize() +") ";
    }
}
