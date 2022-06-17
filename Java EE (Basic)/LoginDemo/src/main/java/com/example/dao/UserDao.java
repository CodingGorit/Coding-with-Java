package com.example.dao;

import com.example.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @version v1.0
 * @Classname UserDao
 * @Description 这里使用模拟数据
 * @Author CodingGorit
 * @Created on 2022/6/16 23:15
 * @IDLE IntelliJ IDEA
 **/
public class UserDao {

    private List<User> list = new ArrayList<>(3);;


    public void initData() {
        this.list.add(new User(1,"admin", "123456", 18, "唱歌，跳舞，打篮球"));
        this.list.add(new User(2,"test", "123321", 20, "看电影"));
        this.list.add(new User(3,"admin", "123456", 18, "唱歌，跳舞，打篮球"));
    }

    public List<User> getUserList() {
        return this.list;
    }

    public User getUserByUserId(Integer id) {
        User u = null;
        if (id < 0) {
            return u;
        }
        for (User user: list) {
            if (user.getUserId().equals(id)) {
                u = user;
            }
        }
        return u;
    }

    public User getUserByUsername(String username) {
        User u = null;
        if (username.equals("")) {
            return u;
        }
        if (!list.isEmpty()) {
            System.out.println("check ");
            for (User user: list) {
                if (user.getUsername().equals(username)) {
                    u = user;
                    break;
                }
            }
        }
        return u;
    }

    /**
     * if return 0 that means delete successfully, -1 means fail
     * @param id
     * @return
     */
    public Integer deleteUserById(Integer id) {
        Integer code = -1;
        if (id < 0) {
            return code;
        }
        for (int i = 0, len = list.size(); i < len; i++) {
            if (list.get(i).getUserId().equals(id)) {
                list.remove(i);
                code = 0;
                break;
            }
        }
        return code;
    }

    public void addUser(User u) {
        if (u == null) {
            return;
        }
        list.add(u);
    }

    public Integer updateUser(User u) {
        Integer code = -1;
        if (u == null || u.getUserId() == null) {
            return code;
        }
        for (int i = 0, len = list.size(); i < len; i++) {
            if (list.get(i).getUserId().equals(u.getUserId())) {
                list.remove(i);
                list.add(u);
                code = 0;
            }
        }
        return code;
    }


//    public static void main(String[] args) {
//        UserDao dao = new UserDao();
//        User u = dao.getUserByUserId(1);
//        System.out.println(u);
//    }

}
