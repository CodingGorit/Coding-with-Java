package cn.gorit.test;

import cn.gorit.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

public class Test {
    private static final Logger log = Logger.getLogger("Test");


    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        // setter 注入

//        Student s1 = (Student)ac.getBean("s1");
        Student s3 = (Student)ac.getBean("s3");
        // 构造函数注入
        Student s4 = (Student)ac.getBean("s4");
        Student s5 = (Student)ac.getBean("s5");
        Student s6 = (Student)ac.getBean("s6");

        log.info("setter 注入，根据 name 注入："+s3.toString());

        log.info("构造器注入，根据 name 注入 "+s4.toString());
        log.info("构造器注入，根据 Type 注入 "+s5.toString());
    }
}
