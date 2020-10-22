package cn.gorit;

import cn.gorit.entity.User;
import cn.gorit.mapper.UserMapper;
import cn.gorit.service.IUserService;
import cn.gorit.util.RedisCacheUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    IUserService service;

    @Test
    void contextLoads() {
        List<User> list = service.list();
        for (User u:list) {
            System.out.println(u.toString());
        }
    }

    @Test
    void getUserById() {
        User u = service.getById(1);
        System.out.println(u.toString());
    }

    @Test
    void updateUser() {
        Integer id = 1;
        User u = new User();
        u.setId(id);
        u.setName("张三");
        u.setAge(20);
        u.setEmail("123@163.com");
        System.out.println(service.getById(id).toString());
        boolean res = service.saveOrUpdate(u);
        if (res)
            System.out.println("更新成功");

        System.out.println(service.getById(id).toString());
    }

    @Test
    void delete() {
        service.removeById(1);
        User user = service.getById(1);

        if (user == null) {
            System.out.println("用户已经删除，所以不存在");
        }
    }

    @Autowired
    private UserMapper mapper;

    @Test
    void addUser() {
        User user = new User();
        user.setName("丽丽");
        user.setAge(19);
        user.setEmail("1231@121.com");
        mapper.addUser(user);
//        boolean res = service.save(user);
            System.out.println("添加成功");
    }

    @Test
    void TestRedis() {
        RedisCacheUtil redisCacheUtil = new RedisCacheUtil("v");
        redisCacheUtil.putObject("aaa",111);
    }

    @Test
    void getResdis() {
        RedisCacheUtil redisCacheUtil = new RedisCacheUtil("v");
        Object obj = redisCacheUtil.getObject("aaa");
        System.out.println(obj);
    }


}
