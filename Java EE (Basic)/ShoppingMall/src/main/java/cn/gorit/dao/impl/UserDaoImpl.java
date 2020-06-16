package cn.gorit.dao.impl;

import cn.gorit.dao.UserDao;
import cn.gorit.entity.User;
import cn.gorit.util.BaseDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    BaseDao db = new BaseDao();

    @Override
    public int Login(String username, String password) {
        try {
            PreparedStatement ps = db.getConnect("select * from user where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            User u = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
                u = new User(rs.getInt(1),rs.getString(2),rs.getString(3));
            }

            if (u!=null) {
                return 1;
            }
            db.closed(ps,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
