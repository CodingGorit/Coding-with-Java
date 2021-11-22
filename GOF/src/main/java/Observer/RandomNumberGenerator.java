package Observer;

import java.util.Random;

/**
 * @Author Gorit
 * @Date 2021/11/22
 **/
public class RandomNumberGenerator extends NumberGenerator {
    private Random random = new Random();   // 随机数生成器
    private int number;             // 当前数值
    public int getNumber() {        // 获取当前值
        return number;
    }

    public void execute() {
        for (int i = 0; i < 20; i++) {
            number = random.nextInt(50);    // 随机生成 0 ~ 49 的20个整数
            notifyObservers();
        }
    }
}
