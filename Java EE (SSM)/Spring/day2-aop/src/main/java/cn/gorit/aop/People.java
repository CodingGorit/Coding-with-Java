package cn.gorit.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class People {
    @Value("小明")
    private String name;

    public People() {
    }

    public void speak() {
        System.out.println("委托人："+name+"开始讲话");
    }

    public void listen() {
        System.out.println("委托人："+name+"开始听人说话了");
    }

    public People(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
