package Iterator;

/**
 * 用于遍历集合中的元素，相当于循环中的循环变量
 * 以下实现了一个最简单的 Iterator 接口
 */
public interface Iterator {
    public abstract boolean hasNext();
    public abstract Object next();
}
