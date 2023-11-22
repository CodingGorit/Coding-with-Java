package cn.gorit.unit2;

/**
 * @version v1.0
 * @Classname Test1
 * @Description TODO
 * @Author CodingGorit
 * @Created on 2023-11-22 22:06
 * @IDLE IntelliJ IDEA
 * @Copyright (c) 2019 —— present fmin-courses TP Center. All rights reserved
 **/
public class Test1 {
    public static void main(String[] args) {
        new Thread(new Game()).start();
        new Thread(new Music()).start();
    }
}


class Game implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("打游戏");
        }
    }
}


class Music implements Runnable {


    @Override
    public void run() {
        while (true) {
            System.out.println("听音乐");
        }
    }
}