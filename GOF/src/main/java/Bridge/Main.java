package Bridge;

import Bridge.impl.StringDisplayImpl;

/**
 * @Author Gorit
 * @Date 2021/9/12
 * 将上述四个类组合起来显示字符串。
 * 虽然变量 d1 中保存的是 Display 类的实例
 **/
public class Main {

    public static void main(String[] args) {
        Display d1 = new Display(new StringDisplayImpl("Hello World"));
        Display d2 = new CountDisplay(new StringDisplayImpl("Hello, Gorit"));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello,WuHan"));
        d1.display();
        d2.display();
        d3.display();
        d3.mutiDisplay(3);

    }
}
