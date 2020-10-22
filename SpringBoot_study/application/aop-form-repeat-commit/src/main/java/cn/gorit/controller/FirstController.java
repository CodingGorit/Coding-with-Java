package cn.gorit.controller;

import cn.gorit.anno.LocalLock;
import cn.gorit.entity.Result;
import cn.gorit.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname FirstController
 * @Description TODO
 * @Date 2020/10/6 18:20
 * @Created by CodingGorit
 * @Version 1.0
 */

// 这里模拟增删改查，就不用数据库了
@RestController
public class FirstController {

    static List<User> list = new ArrayList<>();
    {
        list.add(new User(1,"牛二",13));
        list.add(new User(2,"张三",14));
        list.add(new User(3,"王五",15));
    }
    /**
     * 查询所有的用户
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public Result queryAllUsers() {
        return new Result<>(200,"查询成功",list);
    }

    /**
     * 根据 ID 查询用户
     */
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public Result queryUserById(@PathVariable("id") Integer id) {
        return new Result<>(200,"查询成功",list.get(id-1));
    }

    /**
     * 添加用户，返回添加的结果
     */
    @LocalLock(key = "user:arg[0]")
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public Result addUser(User user) {
        list.add(user);
        return new Result<>(200,"添加成功",list);
    }

    /**
     * 修改用户要用到 PUT 和 DELETE 方法，这里就不测试了
     */

}
