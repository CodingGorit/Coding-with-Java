package com.example.dao;

import com.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    // 增加学生
    public int addStudent(Student student) {
        return jdbcTemplate.update("insert into student(sname,sage,sgender) values (?,?,?)",student.getSname(),student.getSage(),student.getSgender());
    }

    // 查询所有学生
    public List<Student> queryStudents() {
        return jdbcTemplate.query("select * from student",new BeanPropertyRowMapper<>(Student.class));
    }

//    delete 和 update 都是使用 该方式，需要用到对象的时候，使用 new BeanPropertyRowMapper<>(Student.class)
}
