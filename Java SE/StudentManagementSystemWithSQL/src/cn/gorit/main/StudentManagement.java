package cn.gorit.main;

import cn.gorit.dao.StudentDao;
import cn.gorit.dao.impl.StudentDaoImpl;
import cn.gorit.entity.Classz;
import java.sql.SQLException;

import static cn.gorit.main.App.in;

public class StudentManagement {
    static StudentDao studentDao = new StudentDaoImpl();

    public static void studentManagement() throws SQLException {
        boolean flag = true;
        //1.添加学生信息
        //2.查询学生信息

        //3.修改学生信息
        //4.删除学生信息
        //5.退出系统
        info("======================");
        System.out.println("欢迎进入学生后台管理系统");
        info("======================");
        do {
            info("1、添加学生\n2、查询学生\n3、修改学生信息\n4、删除学生信息\n5、退出系统");
            info("请输入你的选择：");
            int choice = in.nextInt();
            if (choice == 1) {
                System.out.println("==========  添加学生 =========");
                addStudent();
            }else if(choice == 2) {
                System.out.println("==========  查询学生 =========");
                queryStudents();
            }else if(choice == 3) {
                info("===========  修改学生  ===========\n 当前的学生信息为：");
                updateStudent();
            }else if(choice == 4) {
                info("===========  删除学生  ===========");
                deleteStudent();
            }else if(choice == 5) {
                flag = false;
            } else {
                info("你输入的有误！！！ 请重新输入");
            }

        } while (flag);
        info("退出成功");

    }

    public static void queryStudents() {
        boolean flag = true;
        do {
            info("1.通过名称查询\n2.通过班级名称查询\n3.通过年龄段查询\n4.通过姓氏查询\n5.退出查询");
            int choice = in.nextInt();
            if (choice == 1) {
                info("请输入学生的姓名：");
                String stuName = in.next();
                studentDao.queryStudentByName(stuName);
            } else if (choice == 2) {
                info("请输入班级的名称（例 大三 计科5班）");
                // 请输入学生的年级
                info("请输入学生的年级：");
                String grade = in.next();
                info("请输入学生的班级");
                String clasz = in.next();
                Classz classz = new Classz(grade,clasz);
                studentDao.queryStudentByClassz(classz.toString());
            } else if (choice == 3) {
                info("请输入学生的年龄段:");
                info("初始年龄段");
                int beginAge = in.nextInt();
                info("结束年龄段");
                int endAge = in.nextInt();
                if (beginAge > endAge) {
                    studentDao.queryStudentByAge(endAge,beginAge);
                } else if (beginAge < endAge) {
                    studentDao.queryStudentByAge(beginAge,endAge);
                } else {
                    studentDao.queryStudentByAge(beginAge,endAge);
                }
            } else if (choice == 4) {
                info("请输入学生的姓矢：");
                String firstName = in.next();
                studentDao.queryStudentByFirstName(firstName);
            } else if (choice == 5) {
                flag = false;
            } else {
                System.out.println("你的输入有误，是否重新输入？ （请输入1）");
                if (in.nextInt() == 1) {
                    queryStudents();
                } else {
                    flag = false;
                }
            }

        } while (flag);
    }

    public static void addStudent() {
        int res = studentDao.addStudent();
        String inf = res > 0 ? "添加成功" : "添加失败";
        info(inf);
    }


    // 执行删除学生的方法
    public static void deleteStudent() throws SQLException {
        studentDao.queryStudents(); // 先查询所有学生
        System.out.println("请输入你要删除的学生的 ID");
        String id = in.next();
        int res = studentDao.deleteStudent(id);
        String inf = res > 0 ? "删除成功" : "删除失败";
        info(inf);
    }

    public static void updateStudent()  {
        studentDao.queryStudents(); // 先查询所有学生
        int res = studentDao.updateStudent();
        String inf = res > 0 ? "修改成功" : "修改失败";
        info(inf);
    }

    private static void info(String s) {
        System.out.println(s);
    }

}
