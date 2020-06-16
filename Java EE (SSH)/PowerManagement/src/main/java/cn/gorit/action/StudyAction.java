package cn.gorit.action;

import cn.gorit.entity.User;
import cn.gorit.entity.Users;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

// JSON 数据返回
public class StudyAction {
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    // 返回字符串
    public String testAjax() {
        str= "啊哈哈哈哈哈";
        return "success";
    }

    // 返回对象
    public String ObjectAjax() {
        User u = new User();
        u.setId(1);
        u.setUsername("aaa");
        u.setPassword("bbbb");
        u.setStatus(2);
//      将 user 对象转换为 JSON 对象
        str = JSON.toJSONString(u);
        return "success";
    }

    // 返回数组对象
    public String ArrayAjax() {
        ArrayList<Users> list = new ArrayList<Users>();
        list.add(new Users("aaa",18,"打篮球"));
        list.add(new Users("coco啊",19, "踢足球"));
        list.add(new Users("无情",20,"唱歌"));
        list.add(new Users("答答",17,"做饭"));
        JSONArray jsa = JSONArray.parseArray(JSONObject.toJSONString(list));
        str = jsa.toJSONString();
        return "success";
    }
}
