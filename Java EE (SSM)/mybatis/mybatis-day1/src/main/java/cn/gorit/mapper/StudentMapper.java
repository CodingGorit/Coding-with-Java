package cn.gorit.mapper;

import cn.gorit.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentMapper {

    // 查询所有学生
    public List<Student> selectAllStudent();

    // 根据 ID 查询学生
//    public Student selectStudentById(int id);
    // 使用 map 获得数据
    public Map selectStudentById(int id);

    // 在 xml 中使用 foreach 循环插入数据
    public void insertStudents(Map<String,List<Student>> map);

    // 增加学生
    public void insertStudent(Student stu);

    // 修改学生
    public void updateStudent(Student stu);

    // 删除学生
    public void  deleteStudentById(int id);

    // 条件查询
    Student selectStudentByNameAndId(@Param("stuName") String name,@Param("sno") int id);
}
