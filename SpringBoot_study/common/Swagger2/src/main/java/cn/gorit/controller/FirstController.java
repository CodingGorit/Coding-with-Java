package cn.gorit.controller;

import cn.gorit.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Api 注解用于类上，表示这个类是 swagger 的资源
 * @ApiOperation  注解用于方法，表示一个 http 请求的操作
 * @ApiParam 注解用于参数上，用来表明参数信息
 * */

@RestController
@RequestMapping("/swagger")
@Api(value = "Swagger2 在线接口文档")
public class FirstController {

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "根据 id 获取唯一表示用户的信息")
    public User getUserInfo(@PathVariable @ApiParam(value = "用户唯一表示") Long id) {
        return new User(id,"zhangsan","lisi");
    }

    @RequestMapping("/test")
    public Map<String,Object> my_map() {
        Map<String,Object> map = new HashMap<>();
        map.put("name","Gorit");
        map.put("Grade","大三 计科");
        map.put("age",18);
        return map;
    }

}
