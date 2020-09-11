package cn.gorit.aop;


import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Laywer {
    // 单独声明 pointcut

    @Pointcut("execution(* cn.gorit.aop.People.speak(..))")
    public void test1() {};

    @Pointcut("execution(* cn.gorit.aop.People.listen())")
    public void test2() {};

    @Before("test1() || test2()")
    public void before() {
        System.out.println("前置通知：下面有我的委托人讲话");
    }

    @After("test1()()")
    public void after() {
        System.out.println("后置通知：我的委托人讲述完毕");
    }

    @Around("test1()")
    public void around(ProceedingJoinPoint pp) throws Throwable {
        System.out.println("环绕通知：在目标方法之前执行！！！！！");
//        Object[] args = new Object[1];
//        args[0] = "Hello World";
//        System.out.println(pp.getTarget());
        pp.proceed(); // method.invoke()
        System.out.println("环绕通知：在目标方法之后执行！！！！！");
    }
//    public void before(org.aspectj.lang.JoinPoint joinPoint) throws Throwable {
//    }
//
//    public void after(org.aspectj.lang.JoinPoint joinPoint) throws Throwable {
//    }
}
