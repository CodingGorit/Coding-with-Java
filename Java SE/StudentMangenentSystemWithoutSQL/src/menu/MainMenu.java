package menu;
/**
 * @author Gorit
 * @date 2019年7月12日
 * @work 主界面的展示
 * */

import java.util.Scanner;

import Login.Login;
import dataStored.LoginDataStored;

public class MainMenu {
	static Scanner in=new Scanner(System.in);
	static Login l=new Login();//登录界面
	static LoginDataStored lo=new LoginDataStored();
	public static void mainMenu() {
		int t=-1;
		do {
			info("欢迎来到 xxx 系统");
			info("1、注册");
			info("2、登录");
			info("3、退出");
			info("请输入你的选择:");
			t=in.nextInt();
			switch (t) {
			case 1:
				//进入注册界面
				lo.Register();
				break;
			case 2:
				//进入登录界面
				l.login();
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
	
	public static void info(String str) {
		System.out.println(str);
	}
}
