package com.gorit.config;

import com.gorit.realm.AccountRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Shiro 的相关配置写在这里，权限认证做好了，就要编写配置
 *  realm 注入到 manager
 *  manager 注入到
 *  https://www.bilibili.com/video/BV16C4y187S9?p=3  15:21
 */

@Configuration
public class ShiroConfig {

    // 创建一个对象，并丢入到 SpringIoc 容器中
    @Bean
    public AccountRealm accountRealm() {
        return new AccountRealm();
    }

    // 安全管理器配置
    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("accountRealm") AccountRealm accountRealm) {
        // 创建对象
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        // 将注入到 IOC 的 Realm 取出来
        manager.setRealm(accountRealm);
        return manager;
    }

    // 配置过滤器工厂
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        // 权限设置
        Map<String,String> map = new HashMap<>();
        map.put("/main", "authc");
        map.put("/manage","perms[manage]");
        map.put("/administrator", "roles[administrator]");
        // 创建过滤拦截
        factoryBean.setFilterChainDefinitionMap(map);
        // 设置登录页面, 解决默认显示 login.jsp 的问题
        factoryBean.setLoginUrl("/login");
        // 设置未授权页面, 直接显示内容，防止用户看到报错信息
        factoryBean.setUnauthorizedUrl("/unauth");
        return factoryBean;
    }
}
