package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/")
    public String index() {
        return "Hello， 项目启动成了！";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addStu(@ModelAttribute("stu") Student stu) {
        Student student = new Student(stu.getSname(),stu.getSage(),stu.getSgender());
        System.out.println(student.toString());
        int res = studentService.addStudent(student);
        if (res > 0) {
            return "添加成功";
        }
        return "添加失败";
    }

    @RequestMapping("/getall")
    public List<Student> allStudents() {
        return studentService.getAllStudents();
    }
}
