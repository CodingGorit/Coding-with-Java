package cn.gorit.util;

import java.sql.*;

public class BaseDao {
    private String Driver = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/studentmanagementsystem?useUnicode=true&characterEncoding=utf8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private Connection con = null;

    // 获取连接 1
    public Statement getConnection() {
        Statement ps = null;
        try {
            Class.forName(Driver);
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            ps = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    // 获取连接
    public PreparedStatement getConnect(String sql) throws SQLException {
        PreparedStatement ps = null;

        try {
            Class.forName(Driver);

            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);

            ps = con.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ps;
    }

    // 关闭连接
    public void closed(PreparedStatement ps, ResultSet set) throws SQLException {
        if (ps!=null) {
            ps.close();
        }

        if (set!=null) {
            set.close();
        }

        if (con!=null) {
            con.close();
        }
    }

}