package service.Impl;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {

    // 这里业务层调用持久层的方法
    @Autowired
    private UserDao ud;

    @Override
    public User checklogin(String username, String password) {
        return ud.selectByUsernameAndPassword(username,password);
    }
}
