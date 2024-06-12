package cn.gorit.test;

/**
 * @version v1.0
 * @Classname Test1
 * @Description TODO
 * @Author CodingGorit
 * @Created on 2024-06-12 21:19
 * @IDLE IntelliJ IDEA
 * @Copyright (c) 2019 ¡ª¡ª present fmin-courses TP Center. All rights reserved
 **/
public class Test1 {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL JDBC Driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
