package cn.gorit.menu;

import cn.gorit.dao.AccountInfo;
import cn.gorit.pojo.Account;

import java.util.List;
import java.util.Scanner;

/**
 * @Author Gorit
 * @Date 2021/12/2
 * @Website https://www.gorit.cn
 **/
public class ShowMenus {
    static Scanner in = new Scanner(System.in);
    AccountInfo accountInfo = new AccountInfo();
    // 展示主页面
    public void showMainMenu() {
        int t = -1;
        do {
            info("欢迎来到 用户后台管理系统");
            info("1、注册");
            info("2、登录");
            info("3、退出");
            info("请输入你的选择:");
            t = in.nextInt();
            switch (t) {
                case 1:
                    //进入注册界面
                    register();
                    break;
                case 2:
                    //进入登录界面
                    login();
                    break;
                case 3:
                    //退出
                    return;
                default:
                    info("你的输入有误，请重新输入...");
                    t=in.nextInt();
                    break;
            }
        }while(t!=1 && t!=2);
    }

    // 展示注册页面
    public void register() {
        info("========== 欢迎来到注册界面 ============");
        String username = "";
        String password = "";
        info("请输入你的账号:");
        username = in.next();
        info("请输入你的密码:");
        password = in.next();
        Account account = new Account(username,password);
        Integer res =  accountInfo.addAccount(account);
        if (res > 0) {
            info("注册成功");
        } else {
            info("注册失败");
            // 你还可以自己扩展，注册失败，重新注册
        }
        //返回登录界面
        login();
    }
    // 展示登录页面
    public void login() {
        String username = "";
        String password = "null";
        String s = "";
        do {
            info("欢迎来到 用户管理系统");
            //菜单的使用
            info("请输入你的账号:");
            username=in.next();
            info("请输入你的密码:");
            password=in.next();
            if(accountInfo.checkAccountIsExist(username)) {
                if(accountInfo.checkPassIsExist(password)) {
                    System.out.println("恭喜你登录成功！！！");
                    System.out.println("..............");
                    s=in.next();// 用于暂停。。。

                }else {
                    System.out.println("密码错误，请重新尝试");
                }
            }else {
                System.out.println("账户错误，请重新输入");
            }

        }while(true);//账号密码输不对，就一直输入
    }

    public static void info(String str) {
        System.out.println(str);
    }
}
