package cn.gorit.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @version v1.0
 * @Classname Audience
 * @Description TODO
 * @Author CodingGorit
 * @Created on 2023/2/12 22:28
 * @IDLE IntelliJ IDEA
 **/
@Aspect
@Component
public class Audience {
    //前置注解
    @Before("execution(* cn.gorit.second.Performance.*())")
    public void silenceCellPhones(){
        System.out.println("silence Cell Phones-----前");
    }
    //返回注解
    @AfterReturning("execution(* cn.gorit.second.Performance.*())")
    public void applause(){
        System.out.println("CLAP CLAP CLAP!!!-----返回");
    }
    //后置注解
    @After("execution(* cn.gorit.second.Performance.*())")
    public void goBye() {
        System.out.println("Bye Bye-----后");
    }
    //异常注解
    @AfterThrowing("execution(* cn.gorit.second.Performance.*())")
    public void demandRefund(){
        System.out.println("Demanding a refund-----异常");
    }
    //环绕注解
    @Around("execution(* cn.gorit.second.Performance.*())")
    public void watchPerformance(ProceedingJoinPoint joinPoint){	//jp就相当于 通知
        try {
            System.out.println("环绕前");
            joinPoint.proceed();
            System.out.println("环绕返回");
        } catch (Throwable throwable) {
            System.out.println("环绕异常");
        }finally {
            System.out.println("环绕后");
        }
    }
}