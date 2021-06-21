package TemplateMethod;

/**
 * 模板类，提供抽象方法，具体实现交给子类
 */
public abstract class AbstractDisplay {
    public abstract void open(); // 交给子类去实现
    public abstract void print(); // 同上
    public abstract void close();
    public final void display() { // 本抽象类实现的 display 方法
        open();
        for (int i=0;i<5;i++) {
            print();
        }
        close(); // 。。 这是 display 方法实现的功能
    }
}
