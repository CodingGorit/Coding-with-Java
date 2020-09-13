package cn.gorit.log;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

// 声明这是一个切面类
@Component
@Aspect
public class LogAspect {
    /**
     * 切入点为 service 方法中任意类，任意方法，任意参数
     *
     * service 下的所有类中的方法
     */
    @Pointcut("execution(* cn.gorit.service.*.*(..))")
    public void pc1() {}

    // 配置前置通知
    @Before(value = "pc1()")
    public void before(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println("前置通知"+name+"方法开始执行了。。。");
    }

    // 配置后置通知
    @After(value = "pc1()")
    public void after(JoinPoint jp) {
        String name = jp.getSignature().getName();
        System.out.println("后置通知"+name+"方法开始执行结束了。。。");
    }

    // 配置返回通知
    @AfterReturning(value = "pc1()",returning = "result")
    public void afterReturning(JoinPoint jp,Object result) {
        String name = jp.getSignature().getName();
        System.out.println("返回通知："+name+"方法的返回值："+ result);
    }

    // 环绕通知
    @AfterThrowing(value = "pc1()",throwing = "e")
    public void afterThrowing(JoinPoint jp,Exception e) {
        String name = jp.getSignature().getName();
        System.out.println("环绕通知：方法抛出异常了，异常是"+e.getMessage());
    }

    @Around("pc1()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        return pjp.proceed();
    }
}
