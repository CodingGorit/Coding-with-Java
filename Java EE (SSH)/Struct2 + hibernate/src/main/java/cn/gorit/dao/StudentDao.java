package cn.gorit.dao;

import cn.gorit.entity.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentDao {
    //查询所有学生
    public List<Student> queryStudents();

    // 删除学生
    public int deleteStudent(String id);

    // 添加学生
    public int addStudent(Student student,String Grade, String Clazz);

    // 更新学生
    public int updateStudent(Student student,String Grade, String Clazz);
}
