package cn.gorit.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Fans {

    @Value("狂热粉丝")
    private String name;

    // 唱歌
    @Pointcut("execution(* cn.gorit.aop.Star.sing(..))")
    public void test1() {};

    // 跳舞
    @Pointcut("execution(* cn.gorit.aop.Star.dance(..))")
    public void test2() {};

    // rap
    @Pointcut("execution(* cn.gorit.aop.Star.rap(..))")
    public void test3() {};

    @Around("test2()")
    public void calling() {
        System.out.println(name + "：开始疯狂打 call 了");
    }

    @After("test1()")
    public void crying() {
        System.out.println(name + ": 开始狂吼了！！");
    }

    @After("test3()")
    public void yd() {
        System.out.println(name + ": 开始晕倒了");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fans() {
    }
}
