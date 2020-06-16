package service;

import entity.User;

public interface UserService {
    // 登录验证
    User checklogin(String username, String password);
}
