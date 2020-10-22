package com.example.test;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname PrintMsgWork
 * @Description TODO
 * @Date 2020/10/19 23:03
 * @Created by CodingGorit
 * @Version 1.0
 */
public class PrintMsgWork implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String msg=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        System.out.println("当前时间为："+msg);
    }
}
