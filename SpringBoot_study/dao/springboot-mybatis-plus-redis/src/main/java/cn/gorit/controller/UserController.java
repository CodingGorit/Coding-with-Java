package cn.gorit.controller;


import cn.gorit.entity.User;
import cn.gorit.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Gorit
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping("/user/{id}")
    public Object getUserById(@PathVariable("id") Integer id) {
        User user = userService.getById(id);

        return user;
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public Object getUser() {
        return userService.list();
    }


}
