package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/")
    public String index() {
        return "Hello, 项目启动成功了";
    }


    @RequestMapping("/getall")
    public List<Student> queryAllStudents() {
        return studentService.getAllStudents();
    }


    // 使用 ModelAttribute 接收一个 对象参数
    @RequestMapping("/add")
    public String addStudents(@ModelAttribute("stu") Student student) {
        System.out.println(student.getSname() + " " + student.getSage() + " " + student.getSgender());
        int res = studentService.addStudent(student.getSname(),student.getSage(),student.getSgender());
        System.out.println(res);
        if (res > 0) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }

    // 根据 id 查找学生信息，使用 restfull 风格的 API
    @RequestMapping("/student/{id}")
    public Student queryStudentById(@PathVariable("id") Integer id) {
        return studentService.selectById(id);
    }

    @RequestMapping(value = "/student/{id}",method = RequestMethod.DELETE)
    public Map<String, Object> deleteStudent(@PathVariable("id") Integer id) {
        System.out.println("接收到了 delete 方法，删除学生信息");
        int res = studentService.deleteById(id);
        Map<String,Object> map = new HashMap<>();
        if (res > 0) {
            map.put("code",200);
            map.put("msg", "删除成功");
            return map;
        } else {
            map.put("code",500);
            map.put("msg", "删除失败");
            return map;
        }
    }


}
