package Memento.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @Author Gorit
 * @Date 2021/11/23
 **/
public class Gamer {
    private int money;      // 所持金钱
    private List fruits = new ArrayList();  // 获得的水果
    private Random random = new Random();   // 随机数生成器
    private static String[] fruitsname = {  // 表示水果种类的数组
            "苹果", "葡萄", "香蕉", "西瓜"
    };
    private static final String FRUIT_PREFIX = "好吃的";

    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {                 // 获取当前所持金钱
        return money;
    }

    public void bet() {                     // 投掷筛子进行游戏
        int dice = random.nextInt(6) + 1; // 1 ~ 6 任意数字
        if (dice == 1) {
            money += 100;
            info("所持金钱增加了。");
        } else if (dice == 2) {                    // 金钱减半
            money /= 2;
            info("所持金钱减半了。");
        } else if (dice == 6) {                    // 获得水果
            String f = getFruit();
            System.out.println("获得了水果 (" + f + ")");
            fruits.add(f);
        } else {
            info("什么都没有发生");
        }
    }

    public Memento createMemento() {                // 拍摄快照
        Memento m = new Memento(money);
        Iterator it = fruits.iterator();
        while (it.hasNext()) {
            String f = (String) it.next();
            if (f.startsWith(Gamer.FRUIT_PREFIX)) { // 只保存水果
                m.addFruits(f);
            }
        }
        return m;
    }

    public void restoreMemento(Memento memento) {   // 撤销
        this.money = memento.getMoney();
        this.fruits = memento.getFruits();
    }

    private String getFruit() {             // 获得一个水果
        String prefix = "";
        if (random.nextBoolean()) {
            prefix += Gamer.FRUIT_PREFIX;
        }
        return prefix + fruitsname[random.nextInt(fruitsname.length)];
    }

    @Override
    public String toString() {                      // 当前主人公状态
        return "Gamer{" +
                "money=" + money +
                ", fruits=" + fruits +
                '}';
    }

    public void info(String msg) {
        System.out.println(msg);
    }
}
