package cn.gorit.dao.Impl;

import cn.gorit.dao.UserDao;
import cn.gorit.entity.User;
import cn.gorit.util.BaseDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    BaseDao db = new BaseDao();

    @Override
    public User selectUserByNameAndPwd(String username, String password) {
        try {
            User u = new User();
            PreparedStatement ps = db.getConnect("select * from db_user where username = ? and password = ? ");
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setStatus(rs.getInt(4));
            }
            System.out.println(u);
            db.closed(ps,rs);
            return u;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addUser(User u) {
        return 0;
    }

    @Override
    public int updateUser(User u) {
        return 0;
    }

    @Override
    public void deleteUserById(int id) {

    }

    // 查询所有的学生
    @Override
    public ArrayList<User> queryAllUser() {
        ArrayList<User> list = new ArrayList<User>();
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
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
