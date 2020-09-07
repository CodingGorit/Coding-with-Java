package cn.gorit.controller;

import cn.gorit.common.exception.GlobalExceptionHandler;
import cn.gorit.common.lang.Result;
import cn.gorit.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    protected static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }

    // 参数缺失异常测试
    @PostMapping("/test")
    public Result test(@RequestParam("name") String name, @RequestParam("pass") String pass) {
        logger.info("name {}",name);
        logger.info("pass {}",pass);
        User user = new User(name,pass);
        if (user.getUsername().equals("") || user.getPassword().equals("")) {
            return Result.fail("500",null);
        }
        return  Result.succ("操作成功",user);
    }

    // 空指针异常测试
    @RequestMapping("/test1")
    public void handleNullPointerException() {
        User u = null;
        u.getUsername();
    }
}
