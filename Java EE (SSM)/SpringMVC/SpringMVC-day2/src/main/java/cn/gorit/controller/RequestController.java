package cn.gorit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestController {

    // 请求多个路径
    @RequestMapping(value = {"/test/mapping","/test/1"})
    public String mappingTest() {
        return "main";
    }
}
