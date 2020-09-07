package cn.gorit.common.exception;


import cn.gorit.common.lang.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ControllerAdvice 注解的功能，能够拦截所有的异常
 *  使用 logeer 将移仓信息打印出来
 * */

@RestControllerAdvice
public class GlobalExceptionHandler {
    // 打印 log
    // 记得加上这个哇，这是告诉全世界，你要开始在这类里面使用日志
    protected static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // 参数缺失异常处理
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Result handleHttpMessageNotReadableException (MissingServletRequestParameterException ex) {
        logger.error("缺少请求参数, {}",ex.getMessage());
        return  Result.fail("缺少必要的请求参数");
    }

    //    空指针异常
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleTypeMismatchException(NullPointerException ex) {
        logger.error("空指针异常，{}",ex.getMessage());
        return Result.fail(500,"空指针异常",null);
    }

    //    一劳永逸
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleUnexpectedServer(Exception e) {
        logger.error("系统异常");
        return  Result.fail(500,"系统内部出现异常");
    }

}
