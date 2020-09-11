package com.gorit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gorit.entity.Account;
import com.gorit.mapper.AccountMapper;
import com.gorit.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper mapper;

    @Override
    public Account findByUsername(String username) {
        // 条件查询
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username",username);
        return mapper.selectOne(wrapper);
    }
}
