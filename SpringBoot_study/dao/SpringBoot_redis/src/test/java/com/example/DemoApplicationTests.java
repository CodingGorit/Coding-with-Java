package com.example;

import com.example.entity.User;
import com.example.service.RedisService;
import com.example.util.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class DemoApplicationTests {

    @Resource
    private RedisService rs;

    @Autowired
    private RedisUtil ru;

    @Test
    void contextLoads() throws JsonProcessingException {
        rs.setString("wechat","gorit 得小站");
        log.info("我得个人网站是：{}",rs.getString("wechat"));

        ObjectMapper mapper = new ObjectMapper();
        User user = new User(1L,"Gorit","123321");
        rs.setString("userinfo", mapper.writeValueAsString(user));
        log.info("用户信息： {}",rs.getString("userinfo"));

        // 测试 hash
        rs.setHash("user","name",mapper.writeValueAsString(user));
        log.info("用户姓名：{}",rs.getHash("user","name"));

        // 列表操作
        rs.setList("list","1");
        rs.setList("list","2");
        rs.setList("list","3");
        log.info("list: {}", rs.getList("list",0,-1));

    }

    @Test
    void testRedisUtil() {
        ru.set("wechat","gorit 得小站");
        log.info("我得个人网站是：{}",ru.get("wechat"));

        ru.set("age",18);
        log.info("我得个人网站是：{}",ru.get("age"));

        
    }

}
