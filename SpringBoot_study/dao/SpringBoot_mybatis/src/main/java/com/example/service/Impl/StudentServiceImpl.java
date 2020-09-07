package com.example.service.Impl;

import com.example.entity.Student;
import com.example.mapper.StudentMapper;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int deleteById(Integer id) {
        return studentMapper.deleteById(id);
    }

    @Override
    public int addStudent(String name, Integer age, String gender) {
        return studentMapper.addStudent(name, age, gender);
    }

    @Override
    public int updateStudentNameById(String name, Integer id) {
        return studentMapper.updateStudentNameById(name, id);
    }

    @Override
    public Student selectById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.getAllStudents();
    }
}
