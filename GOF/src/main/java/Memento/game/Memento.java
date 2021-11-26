package Memento.game;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Gorit
 * @Date 2021/11/23
 **/
public class Memento {
    int money;      // 主人公所持金钱
    ArrayList fruits;   // 获得的水果

    public Memento(int money) {     // wide interface
        this.money = money;
        this.fruits = new ArrayList(16);
    }

    public int getMoney() {     // 获取当前所持金钱   // narrow interface
        return money;
    }

    public void addFruits(String fruit) {   // 添加水果
        fruits.add(fruit);
    }

    public List getFruits() {       // wide interface
        return (List) fruits.clone();
    }
}
