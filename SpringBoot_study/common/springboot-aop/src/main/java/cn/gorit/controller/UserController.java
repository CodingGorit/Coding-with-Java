package cn.gorit.controller;

import cn.gorit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") Integer id) {
        return service.getUseById(id);
    }

    // 由于前端不容易实现 delete 请求，这里用 路径区别删除请求
    @GetMapping("/user/del/{id}")
    public void deleteUserVyId(@PathVariable("id") Integer id) {
         service.deleteUserById(id);
    }
}
