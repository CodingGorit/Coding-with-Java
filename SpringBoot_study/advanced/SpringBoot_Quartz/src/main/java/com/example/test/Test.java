package com.example.test;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020/10/19 22:33
 * @Created by CodingGorit
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        //
        SchedulerFactory sf = new StdSchedulerFactory();
        // 获取调度器
        Scheduler scheduler = sf.getScheduler();
        // 创建任务
        JobDetail jd = JobBuilder.newJob(PrintMsgWork.class)
                .withIdentity("job1","group1")
                .build();
        // 创建触发器
        Trigger t = TriggerBuilder
                .newTrigger()
                .withIdentity("trigger1","tgroup1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(1)
                        .repeatForever())
                .build();
        // 将任务和触发器整合
        scheduler.scheduleJob(jd,t);
        System.out.println("-------------------------");
        //开始执行
        scheduler.start();
        TimeUnit.MINUTES.sleep(1);
        //停止执行
        scheduler.shutdown();
        System.out.println("-------------------------");
    }
}
