package Strategy;

/**
 * @Author Gorit
 * @Date 2021/9/12
 * 表示程序猜拳手势的类。在该类的内部
 * int 表示手势，0 石头，1 表示剪刀，2 表示布，将值保存在 handValue 字段中
 * 我们需要三个 Hand 实例，保存在
 **/
public class Hand {
    public static final int HANDVALUE_GUU = 0; // 石头
    public static final int HANDVALUE_CHO = 1; // 剪刀
    public static final int HANDVALUE_PAA = 2; // 布
    public static final Hand[] hand = { // 表示猜拳中 3 种手势的实例
            new Hand(HANDVALUE_GUU),
            new Hand(HANDVALUE_CHO),
            new Hand(HANDVALUE_PAA),
    };
    // 猜拳中手势对应的字符串
    private static final String[] name = {"石头","剪刀","布"};
    // 猜拳中出的手势价值
    private int handvalue;
    private Hand(int handvalue) {
        this.handvalue = handvalue;
    }
    // 根据手势获取对应实例
    public static Hand getHand(int handvalue) {
        return hand[handvalue];
    }
    // 如果 this 赢了 h则返回 true
    public boolean isStrongerThan (Hand h) {
        return fight(h) == 1;
    }

    // 如果 this 输给了 h 返回 true
    public boolean isWeakerThan (Hand h) {
        return fight(h) == -1;
    }

    // 计分  平 0  胜 1 负 -1
    private int fight(Hand h) {
        if (this == h) {
            return 0;
        } else if ((this.handvalue + 1) % 3 == h.handvalue) {
            return 1;
        } else {
            return -1;
        }
    }

    // 转换手势对应的字符串
    public String toString () {
        return name[handvalue];
    }
}