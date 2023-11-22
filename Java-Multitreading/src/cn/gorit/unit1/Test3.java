package cn.gorit.unit1;

/**
 * @version v1.0
 * @Classname Test3
 * @Description TODO
 * @Author CodingGorit
 * @Created on 2023-11-22 21:44
 * @IDLE IntelliJ IDEA
 * @Copyright (c) 2019 —— present fmin-courses TP Center. All rights reserved
 **/
public class Test3 {

    public static void main(String[] args) {
        new Game().start();
        new Music().start();
    }
}

class Game extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("打游戏");
        }
    }
}


class Music extends Thread {


    @Override
    public void run() {
        while (true) {
            System.out.println("听音乐");
        }
    }
}