package Bridge;

import Bridge.impl.DisplayImpl;
/**
 * @Author Gorit
 * @Date 2021/9/12
 * 类的功能层次结构
 * 该类的功能可以理解为抽象的，负责 ”显示一些东西“
 **/

public class Display {
    // 桥梁出现了，链接 Display 和 DisplayImpl
    private DisplayImpl impl;

    public Display(DisplayImpl impl) {
        this.impl = impl;
    }

    // 显示前的处理
    public void open() {
        impl.rawOpen();
    }

    // 显示处理
    public void print() {
        impl.rawPrint();
    }

    // 显示后的处理
    public void close() {
        impl.rawClose();
    }

    public final void display () {
        open();
        print();
        close();
    }
}