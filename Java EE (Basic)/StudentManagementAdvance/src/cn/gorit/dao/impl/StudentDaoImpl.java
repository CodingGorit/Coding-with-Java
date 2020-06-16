package cn.gorit.dao.impl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import cn.gorit.dao.StudentDao;
import cn.gorit.entity.*;
import cn.gorit.util.*;

public class StudentDaoImpl implements StudentDao {

    BaseDao db = new BaseDao();
    Scanner in = new Scanner(System.in);

    @Override
    public int Login(String username, String password) {
        try {
            PreparedStatement ps = db.getConnect("select * from Users where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            User u = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new User(rs.getInt(1),rs.getString(2),rs.getString(3));
            }
            db.closed(ps,rs);
            if (u!=null) {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int addStudent(Student stu, String addStuClazz, String Grade, String studentClazz) {
//        System.out.println("������ѧ���� ID");
//        stu.setStuId(in.next());
//        System.out.println("������ѧ��������");
//        stu.setStuName(in.next());
//        System.out.println("������ѧ��������");
//        stu.setStuAge(in.nextInt());

//        System.out.println("������ѧ�����꼶");
//        String grade = in.next();
//
//        System.out.println("������ѧ�����ڰ༶");
//        String clasz = in.next();

        // �Ȳ���༶��
        Classz classz = new Classz(Grade,studentClazz);

        // ѧ�����ڰ༶����
        stu.setClassz(classz.toString());
        // �������ݿ�
        String sql = "insert into student(stuId, stuName, stuAge, classz) values(?,?,?,?)";

        try {
            PreparedStatement ps = db.getConnect(sql);
            ps.setString(1, stu.getStuId());
            ps.setString(2,stu.getStuName());
            ps.setInt(3,stu.getStuAge());
            ps.setString(4, stu.getClassz());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            addClasz(Grade,studentClazz,stu);
        }
        return 0;
    }

    public  void addClasz(String grade, String clasz, Student stu) {
        String sql = "insert into classz(grade, clasz, stuId) values(?,?,?)";
        try {
            PreparedStatement ps = db.getConnect(sql);
            ps.setString(1,grade);
            ps.setString(2,clasz);
            ps.setString(3,stu.getStuId());
            int res = ps.executeUpdate();
            if (res > 0) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // OK
    public ArrayList<Student> queryStudents() {
        try {
            PreparedStatement ps = db.getConnect("select * from student");
            ResultSet rs = ps.executeQuery();
            Student stu = null;
            ArrayList<Student> list = new ArrayList<Student>();
            while (rs.next()) {
//                System.out.println(rs.getString(1) + "\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
                stu = new Student(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4));
                list.add(stu);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public void queryStudentByName(String stuName) {
        String sql = "select * from student where stuName = ?";
        try {
            PreparedStatement ps = db.getConnect(sql);
            ps.setString(1,stuName);
            ResultSet set = ps.executeQuery();
            while (set.next()) {
                System.out.println(set.getString(1) + "\t"+set.getString(2)+"\t"+set.getInt(3)+"\t"+set.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void queryStudentByClassz(String classz) {
        String sql = "select * from student where classz = ?";
        try {
            PreparedStatement ps = db.getConnect(sql);
            ps.setString(1,classz);
            ResultSet set = ps.executeQuery();
            while (set.next()) {
                System.out.println(set.getString(1) + "\t"+set.getString(2)+"\t"+set.getInt(3)+"\t"+set.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void queryStudentByAge(int beginAge, int endAge) {
        if (beginAge != endAge) {
            String sql = "select * from student where stuAge between ? and ?";
            try {
                PreparedStatement ps = db.getConnect(sql);
                ps.setInt(1,beginAge);
                ps.setInt(2,endAge);
                ps.executeQuery();
                ResultSet set = ps.executeQuery();
                while (set.next()) {
                    System.out.println(set.getString(1) + "\t"+set.getString(2)+"\t"+set.getInt(3)+"\t"+set.getString(4));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            String sql = "select * from student where stuAge = ? ";
            try {
                PreparedStatement ps = db.getConnect(sql);
                ps.setInt(1,beginAge);
                ps.executeQuery();
                ResultSet set = ps.executeQuery();
                while (set.next()) {
                    System.out.println(set.getString(1) + "\t"+set.getString(2)+"\t"+set.getInt(3)+"\t"+set.getString(4));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // ģ����ѯ
    public void queryStudentByFirstName(String firstName) {
        String sql = "select * from student where stuName like ?";
        try {
            PreparedStatement ps = db.getConnect(sql);
            ps.setString(1,"%"+firstName+"%");
            ps.executeQuery();
            ResultSet set = ps.getResultSet();
            while (set.next()) {
                System.out.println(set.getString(1) + "\t"+set.getString(2)+"\t"+set.getInt(3)+"\t"+set.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Student queryStudentById(String stuId) {
        String sql = "select * from student where stuId = ?";
        try {
            PreparedStatement ps = db.getConnect(sql);
            ps.setString(1,stuId);
            Student u = null;
            ResultSet set = ps.executeQuery();
            if (set.next()) {
                 u = new Student(set.getString(1),set.getString(2),set.getInt(3),set.getString(4));
            }
            db.closed(ps,set);
            if (u != null) {
                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateClasz(String grade, String clasz, String id) {
        String sql = "update classz set grade = ?, clasz = ? where stuId = ?";
        try {
            PreparedStatement ps = db.getConnect(sql);
            ps.setString(1,grade);
            ps.setString(2,clasz);
            ps.setString(3,id);
            int res = ps.executeUpdate();
            if (res >0) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // OK
    public int updateStudent(Student stu, String addStuClazz, String Grade, String studentClazz)  {

        Classz classz = new Classz();
        classz.setGrade(Grade);

        classz.setClasz(studentClazz);
        stu.setClassz(addStuClazz);
        try {
            // ���޸İ༶��
            updateClasz(Grade,studentClazz,stu.getStuId());

            PreparedStatement ps = db.getConnect("update student set stuName = ?, stuAge = ?, classz = ? where stuId = ?");
            ps.setString(1,stu.getStuName());
            ps.setInt(2,stu.getStuAge());
            ps.setString(3,stu.getClassz());
            ps.setString(4,stu.getStuId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    // OK
    public int deleteStudent(String id) {
        try {
            // ��ɾ������ϵ�����
            PreparedStatement ps1 = db.getConnect("delete from classz where stuId = ?");
            ps1.setString(1,id);
            int res1 = ps1.executeUpdate();
            if (res1 > 0) {
                System.out.println("���ɾ���ɹ�");
            }

            // ��ɾ�� ѧ�������Ϣ
            PreparedStatement ps = db.getConnect("delete from student where stuId = ?");
            ps.setString(1,id);
            int res = ps.executeUpdate();
            System.out.println(res);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
