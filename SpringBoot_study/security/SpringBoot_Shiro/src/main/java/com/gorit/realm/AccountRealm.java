package com.gorit.realm;

import com.gorit.entity.Account;
import com.gorit.service.AccountService;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Shiro 自定义 realm
 * 登录操作，过来权限的判断
 */
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    private AccountService accountService;

    /**
     * 用户权限信息集合，授权时使用
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取当前登录的用户信息
        Subject subject = SecurityUtils.getSubject();
        Account account = (Account) subject.getPrincipal();

        // 设置角色
        Set<String> roles = new HashSet<>();
        roles.add(account.getRole());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);

        // 设置权限
        info.addStringPermission(account.getPerms());
        return info;
    }

    /**
     * 用户角色信息，认证时使用
     * 过程：
     *  1. 客户端传送过来的账号 和 密码，会封装到 token 里面
     *  2. 然后验证账户是否存在
     *  3. 账户存在就返回 SimpleAuthenticationInfo 对象 在判断传过来的密码和  token 里面的是否一致
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获得 token
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        token.getUsername()
        Account account = accountService.findByUsername(token.getUsername());
        // 验证账号是否存在
        if (account!=null) {
            // 密码验证
            return new SimpleAuthenticationInfo(account,account.getPassword(),getName());
        }
        return null;
    }
}
