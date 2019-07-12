package Login;
/**
 * @author Gorit
 * @date 2019年7月12日13:36:00
 * @work 用户登录界面的实现
 * 
 * */
import java.util.Scanner;

import dataStored.LoginDataStored;

public class Login {
	static LoginDataStored l=new LoginDataStored();
	public static void login() {
		Scanner in=new Scanner(System.in);
		String account = null;
		String password = null;
		String s;
		//初始化账户信息
		l.init();
		do {
			System.out.println("欢迎来到 xxx 在线 系统");
			//菜单的使用
			System.out.println("请输入你的账号:");
			account=in.next();
			System.out.println("请输入你的密码:");
			password=in.next();
			
			for(int i=0;i<l.list.size();i++)
			if(account.equals(l.list.get(i).getAccount())) {
				if(password.equals(l.list.get(i).getPassword())) {
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
}
