package Visitor;

/**
 * @Author Gorit
 * @Date 2021/10/24
 * Element 接口表示接受访问者（Visitor）的访问接口
 **/
public interface Element {
    public abstract void accept(Visitor v);
}
