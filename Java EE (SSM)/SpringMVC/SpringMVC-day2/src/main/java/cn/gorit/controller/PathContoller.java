package cn.gorit.controller.origin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PathContoller {

    @RequestMapping("/aaa/{id}")
    public String test(@PathVariable("id") int id) {
        System.out.println("我接收到了参数："+id);
        return "success";
    }

    // post 请求
    @RequestMapping(value = "/aaa/{id}/bbb/{abc}",method = RequestMethod.POST)
    public String test1(@PathVariable("id") int id, @PathVariable("abc") String abc) {
        System.out.println(id + " " + abc);
        return "success";
    }

    @RequestMapping(value = "/ccc/**")
    public String test3() {
        System.out.println("通配匹配");
        return "success";
    }


}
