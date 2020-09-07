package com.example.mapper;

import com.example.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/***
 *  mapper 就代替了 dao 层完成了操作
 *  使用 mapper 注解之后，就可以不必再去写对应的映射 xml 了
 *  使用 Component 注解标识这个类，表明它是被 Spring 所管理的
 */

@Mapper
@Component("studentMapper")
public interface StudentMapper {
    @Update("delete from student where id = #{id}")
    int deleteById(@Param("id") Integer id);

    @Insert("insert into student(sname,sage,sgender) values(#{name}, #{age}, #{gender})")
    int addStudent(@Param("name") String name, @Param("age") Integer age, @Param("gender") String gender);

    @Update("update student set sname = #{name} where id = #{id}")
    int updateStudentNameById(@Param("name") String name,@Param("id") Integer id);

    @Select("select * from student where id = #{id}")
    Student selectByPrimaryKey(@Param("id") Integer id);

    @Select("select * from student")
    List<Student> getAllStudents();
}