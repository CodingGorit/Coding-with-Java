package cn.gorit.controller;

import cn.gorit.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    AccountMapper mapper;

    @RequestMapping("/index")
    public Map<String,Object> index() {
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","请求成功");
        map.put("data",new Date());
        return map;
    }

    @RequestMapping("/account")
    public Map<String,Object> findAllAccount() {
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","请求成功");
        map.put("data",mapper.findAll());
        return map;
    }

    @RequestMapping("/account/{id}")
    public Map<String,Object> findAccountById(@PathVariable("id") Integer id) {
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","请求成功");
        map.put("data",mapper.selectAccountById(id));
        return map;
    }
}
