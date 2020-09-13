package cn.gorit.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getUseById(Integer id) {
        System.out.println("根据用户id查询用户");
        return "user";
    }

    public void deleteUserById(Integer id) {
        System.out.println("删除用户");
    }
}
