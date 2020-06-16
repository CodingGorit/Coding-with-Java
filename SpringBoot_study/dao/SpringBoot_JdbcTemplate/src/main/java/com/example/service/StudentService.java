package com.example.service;

import com.example.dao.StudentDao;
import com.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    public int addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentDao.queryStudents();
    }
}
