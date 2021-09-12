package Bridge.impl;

/**
 * @Author Gorit
 * @Date 2021/9/12
 * 桥的另一侧
 * 属于类实现的层次结构
 **/
public abstract class DisplayImpl {
    public abstract void rawOpen();

    public abstract void rawPrint();

    public abstract void rawClose();
}