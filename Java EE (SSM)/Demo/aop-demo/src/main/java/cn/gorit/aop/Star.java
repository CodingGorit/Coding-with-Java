package cn.gorit.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Star {

    @Value("蔡徐坤")
    private String name;


    public void sing() {
        System.out.println(name + "开始唱歌了");
    }

    public void dance() {
        System.out.println(name + "开始跳舞了");
    }

    public void rap() {
        System.out.println(name + "开始rap 了");
    }
}
