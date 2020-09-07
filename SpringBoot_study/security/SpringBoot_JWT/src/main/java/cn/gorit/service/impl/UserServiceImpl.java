package cn.gorit.service.impl;

import cn.gorit.dao.UserDAO;
import cn.gorit.entity.User;
import cn.gorit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO dao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(User user) {
        // 根据接收的用户名，密码查询数据库
        User userDB = dao.login(user);
        if (userDB != null)
            return userDB;
        throw new RuntimeException("登录失败");
    }
}
