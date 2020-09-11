package cn.gorit.dao;

import cn.gorit.entity.User;

public interface UserDao {

    public User selectUserByUserId(String userId);

    public int addUser(User u);
}
