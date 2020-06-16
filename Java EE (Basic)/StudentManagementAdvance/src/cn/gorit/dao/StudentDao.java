package cn.gorit.dao;

import cn.gorit.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentDao {
    public int Login(String name, String password);

    // 添加学生
    public int addStudent(Student student, String addStuClazz, String Grade, String studentClazz);

    // 修改班级表
    public void updateClasz(String grade, String clasz, String id);

    // 通过 姓名查询学生
    public void queryStudentByName(String stuName);

    // 通过班级查询学生信息
    public void queryStudentByClassz(String classz);

//    OK
    // 通过年龄段查询
    public void queryStudentByAge(int beginAge, int endAge);

    // 通过姓矢查询 (模糊查询)
    public void queryStudentByFirstName(String firstName);

    //根据学生 stuId 查到学生
    public Student queryStudentById(String stuId);

    // 修改学生
   public int updateStudent(Student stu, String addStuClazz, String Grade, String studentClazz);

    // 删除学生
    public int deleteStudent(String id) throws SQLException;

    public ArrayList<Student> queryStudents();
}
