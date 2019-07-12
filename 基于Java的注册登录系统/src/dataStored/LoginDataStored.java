package dataStored;

import java.util.*;
import Login.Login;
import pojo.SignIn;

public class LoginDataStored {
    public static  SignIn s=new SignIn();
    public static  List<SignIn> list=new ArrayList<SignIn>();
    public static Scanner in=new Scanner(System.in);
    static Login ll=new Login();
    
    public void init() {//初始化账号信息
    	list.add(new SignIn("aaa","bbb"));
    	list.add(new SignIn("bbb","ccc"));
    }
    
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
