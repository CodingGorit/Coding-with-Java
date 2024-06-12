package cn.gorit.unit2;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @version v1.0
 * @Classname Test4
 * @Description TODO
 * @Author CodingGorit
 * @Created on 2023-11-23 0:13
 * @IDLE IntelliJ IDEA
 * @Copyright (c) 2019 —— present fmin-courses TP Center. All rights reserved
 **/
public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("修面前");
        Thread.sleep(1000);
        System.out.println("休眠后");

        // TimeUnit 代替 sleep, 更加准确表达休眠时间
//        TimeUnit.HOURS.sleep(3);
//        TimeUnit.MINUTES.sleep(24);
//        TimeUnit.SECONDS.sleep(17);

        // 获取线程ID, 从 0 开始
        Thread thread = new Thread();
//        thread.getId();

//       获取当前线程(main)
        Thread.currentThread();

//        JVM 至少存在 gc 线程,所以我们自己创建的线程 ID 不一定为 0
        System.out.println("线程ID 是" + thread.getId());

//        == 线程中断 ==
//        https://ke.qq.com/webcourse/3486171/103624726?cw_id=331361&ac_type=3#taid=11557361860030939&vid=5285890817163937015
    }
}
