package com.example.service;


import com.example.entity.Student;

import java.util.List;

public interface StudentService {

    int deleteById(Integer id);

    int addStudent(String name, Integer age,  String gender);

    int updateStudentNameById(String name, Integer id);

    Student selectById(Integer id);

    List<Student> getAllStudents();

}
