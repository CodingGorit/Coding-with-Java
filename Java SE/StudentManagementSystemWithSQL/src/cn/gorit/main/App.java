package cn.gorit.main;

import cn.gorit.entity.User;
import cn.gorit.util.BaseDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import static cn.gorit.main.StudentManagement.studentManagement;

public class App {
    public static Scanner in = new Scanner(System.in);
    public static BaseDao db = new BaseDao();
    static boolean flag = true;
    public static void main(String[] args) throws SQLException {

        System.out.println("欢迎来到 学生管理系统");
        do {
            System.out.println("请你选择：\n1、登录\n2、注册\n3、退出");
            int choose = in.nextInt();
            if (choose == 1) {
                System.out.println("进入登录界面");
                login(); // 进入登录验证模块
                studentManagement();
            } else if(choose == 2) {
                System.out.println("进入注册界面");
                register();
            } else if(choose == 3) {
                System.out.println("退出系统");
                flag = false;
            }
        } while(flag);
        System.out.println("欢迎下次光临");
    }

    // 登录界面编写
    /**
     * 得到用户的 账户
     * */
    public static void login() {
        System.out.println("请输入你的账户：");
        String username = in.next();
        System.out.println("请输入你的密码：");
        String password = in.next();
        try {
            PreparedStatement ps=db.getConnect("select * from Users where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            User u = null;
            System.out.println("=================");
            if (rs.next()) {
                u = new User(rs.getInt(1),rs.getString(2),rs.getString(3));
            }
            db.closed(ps,rs);

            if (u!=null) {
                System.out.println("登录成功！！！");
            } else {
                // 登录失败
                System.out.println("你的账号或者密码有误，是否重新登录（请输入 1）");
                int choice = in.nextInt();
                if (choice == 1) {
                    login();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // 注册界面编写
    public static void register() {
        System.out.println("请输入你要注册账号：");
        String username = in.next();
        System.out.println("请输入你要注册的密码：");
        String password = in.next();
        String sql = "insert into users(username,password) values(?,?)";
        try {
            PreparedStatement ps = db.getConnect(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            int res = ps.executeUpdate();
            if (res > 0) {
                System.out.println("============  注册成功  ============");
                System.out.println("是否登录？(输入 1登录）)");
                int choice = in.nextInt();
                if (choice == 1) {
                    login();
                }
            } else {
                System.out.println("注册失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
