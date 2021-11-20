package Facade.pagemaker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author Gorit
 * @Date 2021/11/20
 * 可以获取指定数据库名（这里指txt 文本，而非关系型数据库） 所对应的 Properties 实例。
 * 我们无法生成该类的实例，只能通过它的 getProperties 静态方法获取 Properties 实例
 **/
public class Database {
    private Database () { // 防止外部 new 出 Database 实例，所有声明为 private
    }

    /**
     * @description 根据数据库名获取 Properties
     * @param dbname
     * @return prop
     */
    public static Properties getProperties(String dbname) {
        String fileName = "./mockData/" +dbname + ".txt";
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(fileName));
        } catch (IOException e) {
            System.out.println("Warning: " + fileName + " is not found.");
        }
        return prop;
    }
}
