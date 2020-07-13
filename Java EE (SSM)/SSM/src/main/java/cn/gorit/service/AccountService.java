package cn.gorit.service;

import cn.gorit.entity.Account;

import java.util.List;

public interface AccountService {

    // 查询所有账户信息
    public List<Account> findAll();

    // 保存账户信息
    public void saveAccount(Account account);
}
