package cn.gorit.unit1;

/**
 * @version v1.0
 * @Classname Test2
 * @Description TODO
 * @Author CodingGorit
 * @Created on 2023-11-22 21:41
 * @IDLE IntelliJ IDEA
 * @Copyright (c) 2019 —— present fmin-courses TP Center. All rights reserved
 **/
public class Test2 {

    public static void main(String[] args) {
        // 匿名内部类
        new Thread() {
            @Override
            public void run() {
                listenMusic();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                playGame();
            }
        }.start();
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
