package cn.gorit.dao.impl;

import cn.gorit.dao.UserDao;
import cn.gorit.entity.User;
import cn.gorit.util.BaseDao;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 表名  mvc_user
 */
@Repository
public class UserDaoImpl implements UserDao {
    static BaseDao db = new BaseDao();

    @Override
    public User selectUserByUserId(String userId) {
        User user = null;
        try {
            String sql = "select * from mvc_user where userId = ?";
            PreparedStatement ps = db.getConnect(sql);
            ps.setString(1,userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6));
            }
            db.closed(ps,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public int addUser(User u) {
        try {
            String sql = "insert into mvc_user(userId,password,username,age,email) values(?,?,?,?,?)";
            PreparedStatement ps = db.getConnect(sql);
            ps.setString(1,u.getUserId());
            ps.setString(2,u.getPassword());
            ps.setString(3,u.getUsername());
            ps.setInt(4,u.getAge());
            ps.setString(5,u.getEmail());
            ps.execute();
            db.closed(ps,null);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
}
