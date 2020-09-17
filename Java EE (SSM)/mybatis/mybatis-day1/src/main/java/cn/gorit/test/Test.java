package cn.gorit.test;

import cn.gorit.entity.Student;
import cn.gorit.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws IOException {
        // 加载配置文件
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

        // 创建能执行映射文件中的 SqlSession
        SqlSession session = sessionFactory.openSession();
        // 获取映射，自动创建 mapper 接口的实现，直接调用数据库的方法
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        // 添加数据
//        mapper.insertStudent(new Student("小T","男",19));
//        session.commit();


        // 获取
//        Map<Object,Object> map = mapper.selectStudentById(1);
//        System.out.println(stu.toString());
//        System.out.println(map.toString());
//        stu.setSname("张");
//        stu.setAge(10);
//        stu.setGender("女");

        // 修改数据
//        mapper.updateStudent(stu);
//        session.commit();
//


        // 删除数据
//        mapper.deleteStudentById(3);
//        session.commit();

//        List<Student> list = mapper.selectAllStudent();
//        System.out.println(list.toString());

        // 条件查询
//        Student student = mapper.selectStudentByNameAndId("张",1);
//        System.out.println(student);

        // 循环插入数据
        List<Student> list = new ArrayList<>();
        list.add(new Student("a1","男",14));
        list.add(new Student("a2","女",16));
        list.add(new Student("a3","男",18));

        Map<String,List<Student>> map = new HashMap<>();
        map.put("slist",list);
        mapper.insertStudents(map);
        session.commit();
    }
}
