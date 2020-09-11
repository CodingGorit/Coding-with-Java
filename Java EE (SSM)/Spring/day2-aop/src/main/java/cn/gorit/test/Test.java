package cn.gorit.test;


import cn.gorit.aop.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

//        Student s1 = (Student) ac.getBean("s1");

//        AOP xml 配置
//        People p = (People) ac.getBean("p");
//        p.speak();
//        p.listen("adaw");

//        AOP 注解
        People p = ac.getBean(People.class);
        p.speak();
        p.listen(); // 配置两个 切入点
    }
}
