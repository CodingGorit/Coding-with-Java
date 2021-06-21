package Iterator;

public interface Aggregate {
    // 该方法会生成一个用于遍历集合的迭代器，当需要遍历集合的元素时，可以调用该方法
    public abstract Iterator iterator();
}