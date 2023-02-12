package cn.gorit.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @version v1.0
 * @Classname ConfigAspect
 * @Description TODO
 * @Author CodingGorit
 * @Created on 2023/2/12 22:29
 * @IDLE IntelliJ IDEA
 **/
@EnableAspectJAutoProxy//开启切面自动代理
@Configuration
@ComponentScan
public class ConfigAspect {
}
