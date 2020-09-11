package cn.gorit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecondController {

    //redirect 用来重定向 和 forward转发，一般用来跳转服务方法
    @RequestMapping("/hello")
    public String test(){
        return "redirect:/demo";
    }

    @RequestMapping("/demo")
    public ModelAndView demo(){
        ModelAndView view = new ModelAndView();
        view.setViewName("demo");
        view.addObject("msg","Hello World");
        return view;
    }
}
