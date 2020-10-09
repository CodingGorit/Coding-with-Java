package cn.gorit.controller;

import cn.gorit.websocket.ProductWebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname IndexController
 * @Description TODO
 * @Date 2020/10/8 20:40
 * @Created by CodingGorit
 * @Version 1.0
 */
@CrossOrigin
@Controller
public class IndexController {

    @Autowired
    ProductWebSocket socket;

    @GetMapping(value = "/")
    @ResponseBody
    public Object index() {
        return "Hello,ALl。This is CodingGorit's webSocket demo！";
    }

    @ResponseBody
    @GetMapping("test")
    public String test(String userId, String message) throws Exception {
        if (userId == "" || userId == null) {
            return "发送用户id不能为空";
        }
        if (message == "" || message == null) {
            return "发送信息不能为空";
        }
        new ProductWebSocket().systemSendToUser(userId, message);
        return "发送成功！";
    }

    @RequestMapping(value = "/user")
    public String user() {
        return "user.html";
    }

    @RequestMapping(value = "/ws")
    public String ws() {
        return "ws.html";
    }

    @RequestMapping(value = "/ws2")
    public String ws1() {
        return "ws2.html";
    }

    /**
     * 管理员的页面，可以发送广播消息
     * @return
     */
    @RequestMapping(value = "/admin")
    public String admin() {
        return "gb.html";
    }

    @ResponseBody
    @RequestMapping(value = "/sendAll" ,method = RequestMethod.GET)
    public String sendAll (String msg) {
        socket.sendAll(msg);
        return "发送成功";
    }
}
