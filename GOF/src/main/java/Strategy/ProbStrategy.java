package Strategy;

import java.util.Random;

/**
 * @Author Gorit
 * @Date 2021/9/12
 * 第二种策略
 * 它会记录之前出的手势，和输赢，来算出下次该出的手势
 **/
public class ProbStrategy implements Strategy {
    private Random random;
    private int preHandValue = 0;
    private int currentHandValue = 0;
    // history[上一局出的手势][这一局出的手势] ，是一张表，根据过去的胜负进行概率计算
    private int[][] history = {
            {1,1,1,},
            {1,1,1,},
            {1,1,1,},
    };

    public ProbStrategy(int seed) {
        random = new Random(seed);
    }

    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentHandValue));
        int handvalue = 0;
        if (bet < history[currentHandValue][0]) {
            handvalue = 0;
        } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) {
            handvalue = 1;
        } else {
            handvalue = 2;
        }
        preHandValue = currentHandValue;
        currentHandValue = handvalue;
        return Hand.getHand(handvalue);
    }

    private int getSum(int hv) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum+=history[hv][i];
        }
        return sum;
    }

    /**
     * 根据 nextHand 方法返回手势的胜负结果来更新 history 字段中的值
     * @param win
     */
    public void study(boolean win) {
        if (win) {
            history[preHandValue][currentHandValue]++;
        } else {
            history[preHandValue][(currentHandValue + 1) % 3]++;
            history[preHandValue][(currentHandValue + 2) % 3]++;
        }
    }

}
