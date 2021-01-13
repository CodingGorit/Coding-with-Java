package Prototype.framework;
// 继承复制的接口， Cloneable 通过调用 clone 实现对象的调用
public interface Product extends Cloneable{
    public abstract  void use(String s);
    public abstract Product createClone();
}
