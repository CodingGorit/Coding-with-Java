package Bridge;

import Bridge.impl.DisplayImpl;

/**
 * @Author Gorit
 * @Date 2021/9/12
 * 类的功能层次结构件
 * 再 Display 的基础上增加了 规定显示次数的新功能，也就是 mutilDisplay 方法
 **/
public class CountDisplay extends Display{

    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    // 显示 num 此
    public void mutiDisplay(int num) {
        open();
        for (int i = 1; i <= num ; i++) {
            print();
        }
        close();
    }
}
