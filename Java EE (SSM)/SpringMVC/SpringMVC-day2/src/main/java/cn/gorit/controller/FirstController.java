package cn.gorit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FirstController {

    @RequestMapping(value = "/main")
    public String index() {
        return "main";
    }

    @GetMapping("/red")
    public String second() {
        System.out.println("我重定向了！！！");
        return "redirect:index.jsp";
    }

    @GetMapping("/test")
    public String aa() {
        System.out.println("test");
        return "success";
    }

}
