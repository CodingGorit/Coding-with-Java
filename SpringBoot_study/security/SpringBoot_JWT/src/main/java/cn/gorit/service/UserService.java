package cn.gorit.service;

import cn.gorit.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User login(User user);
}
