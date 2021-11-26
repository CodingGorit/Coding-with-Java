package Memento;

import Memento.game.Gamer;
import Memento.game.Memento;

/**
 * @Author Gorit
 * @Date 2021/11/24
 **/
public class Main {
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);        // 初始资金为 100 元
        Memento memento = gamer.createMemento();    // 保存最初的状态
        for (int i = 0; i < 100; i++) {
            System.out.println("=====" + (i + 1));    // 掷筛子的次数
            System.out.println("主人公当前状态" + gamer);

            gamer.bet();                            // 开始游戏
            System.out.println("所持金钱为" + gamer.getMoney() + "元");
            // 决定如何处理 Memento
            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("所持的金钱增加了，所以保存当前状态");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("所持的金钱减少了许多，因此将游戏恢复至以前状态");
                gamer.restoreMemento(memento);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("");
        }
    }
}
