package dao;

import entity.User;

public interface UserDao {

    // 用户登录验证
    public User selectByUsernameAndPassword(String username, String password);
}
