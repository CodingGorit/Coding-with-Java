package com.example.demo;

import com.example.demo.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    MailService service;

    @Test
    void contextLoads() {
        service.sendSimpleMail("caidewei121@163.com",
                "749958162@qq.com",
                "749958162@qq.con",
                "Hello World",
                "我是测试邮件,\n 你好，金波");
    }

}
