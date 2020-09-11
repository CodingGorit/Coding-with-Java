package cn.gorit.controller.cookie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;

@Controller
public class CookieController {

    @RequestMapping(value = "/cookie/test")
    public String test(@CookieValue("JSESSIONID") Cookie c) {
        System.out.println(c.getValue());
        return "success";
    }

    // headers 必须增加请求头
    @RequestMapping(value = "/cookie/test1",headers = "cookie")
    public String test1(@CookieValue("token") Cookie c) {
        System.out.println(c.getValue());
        return "success";
    }
}
