package cn.gorit.dao;

import cn.gorit.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface UserDao {

    // 根据用户的账号和密码查询, 返回的到用户的账户信息
    public User selectUserByNameAndPwd(String username, String password);

    // 增加用户
    public int addUser(User u);

    // 更新用户数据
    public int updateUser(User u);

    //删除用户数据
    public void deleteUserById(int id);

    public ArrayList<User> queryAllUser();
}
