package cn.gorit.controller;

import cn.gorit.mapper.map1.BookMapper1;
import cn.gorit.mapper.map2.BookMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BookController {

    @Autowired
    BookMapper1 bookMapper1;

    @Autowired
    BookMapper2 bookMapper2;

    @GetMapping("/book1")
    public Map<String,Object> test1() {
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","获取成功");
        map.put("data",bookMapper1.getAllBooks());
        return map;
    }

    @GetMapping("/book2")
    public Map<String,Object> test2() {
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","获取成功");
        map.put("data",bookMapper2.getAllBooks());
        return map;
    }
}
