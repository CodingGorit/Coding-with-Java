package cn.gorit.anno;

import java.lang.annotation.*;

/**
 * @Classname LocalLock
 * @Description 防止重复提交的注解
 * @Date 2020/10/11 10:23
 * @Created by CodingGorit
 * @Version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LocalLock {

    String key() default "";
    /**
     * TODO 由于用的 guava 暂时就忽略该属性吧 集成 redis 需要用到
     * 默认时间5秒
     */
    int expire() default 5 * 1000;
}


