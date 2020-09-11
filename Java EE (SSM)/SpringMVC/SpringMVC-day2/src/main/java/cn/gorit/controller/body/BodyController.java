package cn.gorit.controller.body;

import cn.gorit.entity.Student;
import org.springframework.web.bind.annotation.PostMapping;

public class BodyController {

    // 参数列表要一一对应，就能都接收得到
    @PostMapping("/student")
    public String addStudent(Student stu,String str) {
        System.out.println(stu.toString());
        System.out.println("str");
        return "main";
    }
}
