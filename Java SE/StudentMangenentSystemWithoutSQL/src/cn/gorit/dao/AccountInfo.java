package cn.gorit.dao;

import cn.gorit.pojo.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Gorit
 * @Date 2021/12/2
 * @Website https://www.gorit.cn
 * 这里模拟从数据库中取数据，并作数据查询的操作
 **/
public class AccountInfo {
    private List<Account> list;

    public List<Account> getAccountList() {
        return list;
    }

    private void setList(List<Account> list) {
        this.list = list;
    }

    public AccountInfo() {
        // 初始化数据
        this.init();
    }

    public void init() {
        if (list == null || list.size() != 0) {
            list = new ArrayList<>(16);
            list.add(new Account("admin", "123456"));
            list.add(new Account("aaa", "bbb"));
            list.add(new Account("aba", "123"));
        }
    }

    // 根据账户名称查询数据是否存在（后续学习了 SQL，这些都是在 SQL 里面完成操作的）
    public boolean checkAccountIsExist(String username) {
        if (list.size() == 0) {
            return false;
        } else {
            for (Account item: list) {
                if (item.getUsername().equals(username)) {
                    return true;
                }
            }
            return false;
        }
    }

    // 根据密码查询数据是否正确（后续学习了 SQL，这些都是在 SQL 里面完成操作的）
    public boolean checkPassIsExist(String password) {
        if (list.size() == 0) {
            return false;
        } else {
            for (Account item: list) {
                if (item.getPassword().equals(password)) {
                    return true;
                }
            }
            return false;
        }
    }

    public Integer addAccount(Account account) {
        if (account == null) {
            return 0;
        }
        // 避免插入重复的
        boolean flag = checkAccountIsExist(account.getUsername());
        if (!flag) {
            list.add(account);
            return 1;
        }
        return 0;
    }

    // 修改密码实现？


}
