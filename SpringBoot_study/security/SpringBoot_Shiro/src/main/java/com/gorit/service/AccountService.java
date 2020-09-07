package com.gorit.service;

import com.gorit.entity.Account;

public interface AccountService {
    public Account findByUsername(String username);

}
