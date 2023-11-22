package cn.gorit.unit1;

/**
 * @version v1.0
 * @Classname Test1
 * @Description TODO
 * @Author CodingGorit
 * @Created on 2023-11-22 21:39
 * @IDLE IntelliJ IDEA
 * @Copyright (c) 2019 —— present fmin-courses TP Center. All rights reserved
 **/
public class Test1 {

    /**
     * 同时听音乐 和 打游戏场景
     * @param args
     */
    public static void main(String[] args) {
        // 默认串行处理
        listenMusic();
        playGame();
    }

    private static void listenMusic() {
        while (true) {
            System.out.println("Listen Music");
        }
    }

    private static void playGame() {
        while (true) {
            System.out.println("play game");
        }
    }
}
