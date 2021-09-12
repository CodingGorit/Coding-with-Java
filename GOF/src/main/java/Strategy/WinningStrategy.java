package Strategy;

import java.util.Random;

/**
 * @Author Gorit
 * @Date 2021/9/12
 * 第一种策略
 **/
public class WinningStrategy implements Strategy{
    private Random random; // 随机数生成
    private boolean won = false; // 保存上一次的输赢
    private Hand preHand; // 保存上一次出手势的值

    public WinningStrategy(int seed) {
        random = new Random(seed);
    }

    public Hand nextHand() {
        if (!won) {
            preHand = Hand.getHand(random.nextInt(3));
        }
        return preHand;
    }

    public void study(boolean win) {
        won = win;
    }

}
