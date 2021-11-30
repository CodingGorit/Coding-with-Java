package dataStored;

import java.util.*;
import Login.Login;
import pojo.SignIn;

/**
*   数据存储
**/
public class LoginDataStored {
    public static SignIn s;
    public static List<SignIn> list=new ArrayList<SignIn>();
    public static Scanner in=new Scanner(System.in);    // 实例化输入流
    static Login ll=new Login();                        // 实例化登录页面
    
    // 初始化账号信息，init 方法一定会在 Register 之前执行
    public void init() {
    	list.add(new SignIn("aaa","bbb"));
    	list.add(new SignIn("bbb","ccc"));
    }
    
    // 单独的注册方法，按理说，登录 和 注册的函数应该是写在一起才对
    public static void Register() {
    	info("欢迎来到注册界面");
    	String account="";
    	String password="";
    	System.out.println("请输入你的账号:");
    	account=in.next();
    	System.out.println("请输入你的密码:");
    	password=in.next();
    	s=new SignIn(account,password);
    	list.add(s);
    	//返回登录界面
    	ll.login();
    }
    
    public static void info(String str) {
    	System.out.println(str);
    }
}
