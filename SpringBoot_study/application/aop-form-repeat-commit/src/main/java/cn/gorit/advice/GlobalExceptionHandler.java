package cn.gorit.advice;

import cn.gorit.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Classname GlobalExceptionHandler
 * @Description TODO
 * @Date 2020/10/12 19:59
 * @Created by CodingGorit
 * @Version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public Result<Object> handleException(Exception ex) {
        log.error(ex.getMessage());
        return new Result<>(500,ex.getMessage());
    }
}
