package cn.gorit;

import cn.gorit.entity.User;
import cn.gorit.util.BaseDao;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class test {
    BaseDao db = new BaseDao();

    @Test
    public void login() {
        try {
            User u = new User();
            PreparedStatement ps = db.getConnect("select * from db_user where username = ? and password = ? ");
            ps.setString(1,"admin");
            ps.setString(2,"32");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setStatus(rs.getInt(4));
            }
            System.out.println(u);
            db.closed(ps,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void query() {
        List<User> list = new ArrayList<User>();
        try {
            PreparedStatement ps = db.getConnect("select * from db_user");
            ResultSet rs = ps.executeQuery();
            User user = null;
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setStatus(rs.getInt(4));
                list.add(user);
            }
            for (User u: list) {
                System.out.println(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
