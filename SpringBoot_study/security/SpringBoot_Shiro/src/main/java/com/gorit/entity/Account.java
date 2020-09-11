package com.gorit.entity;

import lombok.Data;

@Data
public class Account {
    private Integer id;
    private String username;
    private String password;
    private String perms; // 用户权限
    private String role; // 用户角色
}
