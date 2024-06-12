package cn.gorit.util;

import java.sql.*;

public class BaseDao {
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private Connection con = null;

    // ��ȡ����
    public PreparedStatement getConnect(String sql) throws SQLException {
        PreparedStatement ps = null;
        try {
            Class.forName(DRIVER_NAME);
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            ps = con.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ps;
    }

    // �ر�����
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