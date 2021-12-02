package cn.gorit.dao;

import cn.gorit.entity.Classz;


public interface StudentDao {

    public int addStudent();

    // 通过 姓名查询学生
    public void queryStudentByName(String stuName);

    // 通过班级查询学生信息
    public void queryStudentByClassz(String classz);

//    OK
    // 通过年龄段查询
    public void queryStudentByAge(int beginAge, int endAge);

    // 通过姓矢查询 (模糊查询)
    public void queryStudentByFirstName(String firstName);

    // 修改学生
   public int updateStudent();

    // 删除学生
    public int deleteStudent(String id);

    public void queryStudents();
}
