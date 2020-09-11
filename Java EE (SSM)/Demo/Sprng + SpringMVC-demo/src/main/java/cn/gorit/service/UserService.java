package cn.gorit.service;

import cn.gorit.dao.UserDao;
import cn.gorit.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao dao;

    public int insertUsr(User u) {
        return dao.addUser(u);
    }

    public User selectUser(String userId) {
        return dao.selectUserByUserId(userId);
    }
}
