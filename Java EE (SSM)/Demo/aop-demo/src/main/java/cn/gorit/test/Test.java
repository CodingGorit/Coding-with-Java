package cn.gorit.test;


import cn.gorit.aop.Star;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        Star s = ac.getBean(Star.class);
        s.sing();
        s.dance();
        s.rap();
    }
}
