package cn.gorit.unit2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @version v1.0
 * @Classname Test2
 * @Description TODO
 * @Author CodingGorit
 * @Created on 2023-11-22 22:14
 * @IDLE IntelliJ IDEA
 * @Copyright (c) 2019 —— present fmin-courses TP Center. All rights reserved
 **/
public class Test2 {

    // Callable 有返回值
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建 Shopping
        Callable<String> callable = new Shopping();
        // 使用 FutureTask包装 Callable
        FutureTask<String> futureTask = new FutureTask<>(callable);
        // 创建线程
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("线程启动了");
        // 调用 get 之后，调用者线程进入阻塞，知道获取到线程执行结果为止
        String res = futureTask.get();
        System.out.println(res);
    }
}

class Shopping implements Callable<String> {
    @Override
    public String call() throws Exception {
        // 模拟空调配送的耗时
        System.out.println("空调配送中");
        Thread.sleep(5000);
        System.out.println("快递到家了");
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "空调到家了";
    }
}
