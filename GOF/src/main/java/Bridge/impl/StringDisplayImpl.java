package Bridge.impl;

/**
 * @Author Gorit
 * @Date 2021/9/12
 * 属于：类的实现层次结构
 **/
public class StringDisplayImpl extends DisplayImpl{
    private String string; // 要显示的字符串
    private int width;  // 以字节单位计算出字符串的位置

    public StringDisplayImpl(String string) {
        this.string = string;
        this.width = string.getBytes().length;
    }

    public void rawOpen() {
        printLine();
    }


    public void rawPrint() {
        System.out.println("|" + string + "|");     // 前后修饰 |
    }

    public void rawClose() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");  // 用于显示方框角的 “+”
        for (int i = 0; i < width ; i++) {  // 作用方框的边框
            System.out.print("-");
        }
        System.out.println("+");     //     显示用来表示方框的角的“+”
    }
}