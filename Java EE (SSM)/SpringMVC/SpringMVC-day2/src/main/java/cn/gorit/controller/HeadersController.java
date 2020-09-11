package cn.gorit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HeadersController {
    /**
     * 限定请求头
     * 限定请求方法
     * 限定请求路径
     * 限定请求参数
     * @return
     */

    // 指定请求头必须包含固定的请求头，不然无法访问
    @RequestMapping(value = "/hc",method = RequestMethod.GET,headers = {"abc=12","hhh"})
    public String test() {
        System.out.println("Header 的请求方法");
        return "success";
    }

    @RequestMapping(value = "/hc1",method = RequestMethod.GET,headers = {"hhhh"})
    public String test1() {
        System.out.println("请求头为 hhhh");
        return "success";
    }
}
