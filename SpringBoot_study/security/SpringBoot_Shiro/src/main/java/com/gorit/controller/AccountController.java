package com.gorit.controller;

import com.gorit.entity.Account;
import com.gorit.mapper.AccountMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    AccountMapper mapper;

    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url) {
        return url;
    }

    // 登录逻辑交给 Shiro 完成
    @PostMapping("/login")
    public String login(String username, String password, Model model) {
        // 登录接口，结合 Shiro 处理
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        // 验证失败会产生异常
        try {
            subject.login(token); // 进入 Realm 中，进行认证方法
            Account account = (Account) subject.getPrincipal();
            // 将登录成功的用户信息存入 session
            subject.getSession().setAttribute("account",account);
            return "index"; // 没有异常登录成功
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            model.addAttribute("msg","用户名错误");
            return "login";
        } catch (IncorrectCredentialsException e) { // 非法密码异常
            model.addAttribute("msg","密码错误");
            e.printStackTrace();
            return "login";
        }
    }

    @GetMapping("/unauth")
    @ResponseBody
    public String unauth() {
        return "未授权，无法访问";
    }

    @GetMapping("/logout")
    public String logout() {
        // 销毁 session 退出
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:login";
    }
}
