package Facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author Gorit
 * @Date 2021/11/20
 * 通过 HtmlWriter 和 Database 类为目标生成 Web 页面
 *
 * ！！！
 * PageMaker 类一手包办了调用 HtmlWriter 类的方法这一工作。
 * 对外部，它只提供了 makeWelcomePage 接口
 **/
public class PageMaker {
    private PageMaker() {} // 防止外部 new 出实例

    /**
     * 根据指定邮件地址和文件名生成对应的 Web 页面
     * @param mailaddr
     * @param filename
     */
    public static void makeWelcomePage(String mailaddr, String filename) {
        try {
            Properties mailProp = Database.getProperties("maildata");
            String username = mailProp.getProperty(mailaddr);
            HtmlWriter writer = new HtmlWriter(new FileWriter("./mockData/" + filename));
            writer.title("Welcome to " + username + "'s page!");
            writer.paragraph(username + " 欢迎来到 " + username + "的主页。");
            writer.paragraph("等着你爹邮件!");
            writer.mailto(mailaddr, username);
            writer.close();
            System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
