package cn.gorit.unit2;

import java.util.concurrent.TimeUnit;

/**
 * @version v1.0
 * @Classname Test3
 * @Description TODO
 * @Author CodingGorit
 * @Created on 2023-11-23 0:06
 * @IDLE IntelliJ IDEA
 * @Copyright (c) 2019 —— present fmin-courses TP Center. All rights reserved
 **/
public class Test3 {

    public static void main(String[] args) throws InterruptedException {
        // 非守护线程：则 main 不会结束
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("111");
                        TimeUnit.SECONDS.sleep(1);
                    } catch (Exception e) {

                    }
                }
            }
        });

        // 设置thread为当前守护现线程
        thread.setDaemon(true);
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("main 线程执行结束");
    }
}
