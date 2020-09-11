package cn.gorit.controller.json;

import cn.gorit.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class JSONController {

    @RequestMapping(value = "/json/test1",method = RequestMethod.GET)
    @ResponseBody
    public String testjson() {
        return "Hello World";
    }

    @RequestMapping("/json/test")
    @ResponseBody
    public Map<String,Object> test() {
        Map<String,Object> map = new HashMap<>();
        List<Student> list = new ArrayList<>();
        list.add(new Student("小红","男",18));
        list.add(new Student("小红","女",14));
        list.add(new Student("小皮","男",28));
        map.put("msg","请求成功");
        map.put("code",200);
        map.put("data",list);
        return map;
    }

    // 接收 JSON 格式的请求参数
    @RequestMapping("/json/test2")
    @ResponseBody
    public Map<String,Object> test2(@RequestBody Student student) {
        Map<String,Object> map = new HashMap<>();
        List<Student> list = new ArrayList<>();
        list.add(new Student("小红","男",18));
        list.add(student);
        map.put("msg","请求成功");
        map.put("code",200);
        map.put("data",list);
        return map;
    }
}
