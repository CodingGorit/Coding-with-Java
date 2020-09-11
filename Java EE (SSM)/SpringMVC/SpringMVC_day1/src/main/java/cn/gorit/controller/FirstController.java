package cn.gorit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FirstController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index() {
        return "index.jsp";
    }

    @GetMapping("/red")
    public String second() {
        System.out.println("我重定向了！！！");
        return "redirect:index.jsp";
    }

    @GetMapping("/hello")
    public String test() {
        System.out.println("我是第一个 springmvc 方法执行了");
        return "index";
    }

    @GetMapping("/test")
    public String aa() {
        System.out.println("test");
        return "success";
    }
}
