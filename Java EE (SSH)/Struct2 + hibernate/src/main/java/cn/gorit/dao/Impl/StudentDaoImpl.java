package cn.gorit.dao.Impl;

import cn.gorit.dao.StudentDao;
import cn.gorit.entity.ClasszEntity;
import cn.gorit.entity.Student;
import cn.gorit.entity.User;
import cn.gorit.util.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    Session session =  HibernateUtils.getSession();
    Transaction t = session.beginTransaction();
    @Override
    public List<Student> queryStudents() {
        Criteria criteria = session.createCriteria(Student.class);
        List<Student> list = criteria.list();
//        for (Student stu: list) {
//            System.out.println(list.toString());
//        }
        return list;
    }

    @Override
    public int deleteStudent(String id) {
        Student student = session.get(Student.class,id);
        ClasszEntity clazz = session.get(ClasszEntity.class,id);
        System.out.println(student.toString());
        session.delete(clazz);
        session.delete(student);
        t.commit();
        session.close();
        return 1;
    }

    @Override
    public int addStudent(Student student,String Grade, String Clazz) {
        Student stu = session.get(Student.class,student.getStuId());

//        添加学生所在年级
        ClasszEntity clazz = new ClasszEntity();
        clazz.setStuId(student.getStuId());
        clazz.setGrade(Grade);
        clazz.setClasz(Clazz);
        // 先判断插入的学生的 学号是否存在，如果不存在，则允许插入
        if (stu == null) {
            session.save(student);
            session.save(clazz);
            t.commit();
            session.close();
            return 1;
        } else {
            return 0;
        }
    }

    // 更新学生数据
    @Override
    public int updateStudent(Student student, String Grade, String Clazz) {

        ClasszEntity clazz = new ClasszEntity();
        clazz.setStuId(student.getStuId());
        clazz.setGrade(Grade);
        clazz.setClasz(Clazz);

        session.update(clazz);
        session.update(student);
        t.commit();
        session.close();
        return 1;
    }
}
