package cn.gorit.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Classname RequestAsepect
 * @Description TODO
 * @Date 2020/10/6 19:35
 * @Created by CodingGorit
 * @Version 1.0
 */

@Component
@Aspect
public class RequestAsepect {

    private Logger log = LoggerFactory.getLogger(RequestAsepect.class);


    @Pointcut("execution(* cn.gorit.controller..* (..))")
    public void log() {}

    @Before("log()")
    public void doBefore (JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        log.info("方法执行之前");
        HttpServletRequest request = attributes.getRequest();
        String uri = request.getRequestURI();
        // 记录请求的内容
        printRequestLog(joinPoint,request,uri);
    }

    @Around(value = "log()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ob = pjp.proceed();
        long time = System.currentTimeMillis() - startTime;
        log.info("耗时 : {}", time);
        return ob;
    }

    @AfterReturning(returning = "res",pointcut = "log()")
    public void doAfter (Object res) throws JsonProcessingException {
        String result = new ObjectMapper().writeValueAsString(res);
        log.info("返回值：{}",res);
    }

    private void printRequestLog(JoinPoint joinPoint, HttpServletRequest request, String uri) {
        log.info("请求地址：{}",uri);
        log.info("请求方式：{}",request.getMethod());

        String controllername =  joinPoint.getSignature().getDeclaringTypeName();
        log.info("方法 : {} {}",controllername,joinPoint.getSignature().getName());
        String params = Arrays.toString(joinPoint.getArgs());
        log.info("请求参数：{}",params);
    }


}
