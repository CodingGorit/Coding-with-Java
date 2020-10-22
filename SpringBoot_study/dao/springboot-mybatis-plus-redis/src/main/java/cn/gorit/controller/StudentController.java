package cn.gorit.controller;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Gorit
 * @since 2020-10-19
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    //    fixedRate: 定时多久执行一次（上一次开始执行时间点后xx秒再次执行；

//    fixedDelay: 上一次执行结束时间点后xx秒再次执行

//    fixedDelayString:  字符串形式，可以通过配置文件指定

//    cron = "0  30 * * * *" 每半个小时执行一次

    // 最简单的定时任务执行
    @Scheduled(fixedRate = 5000)
    public void read() {
        System.out.println("read() 方法执行了，5s 执行一次");
    }


    @Scheduled(fixedDelay = 1000)
    public void waitMethod() {
        System.out.println("我是 waitMethod() 方法，停顿1秒");
    }
}
