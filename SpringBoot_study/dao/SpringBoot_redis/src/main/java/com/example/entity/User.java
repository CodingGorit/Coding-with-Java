package com.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Classname User
 * @Description TODO
 * @Date 2020/10/12 21:37
 * @Created by CodingGorit
 * @Version 1.0
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 8655851615465363473L;
    private Long id;
    private String username;
    private String password;

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
