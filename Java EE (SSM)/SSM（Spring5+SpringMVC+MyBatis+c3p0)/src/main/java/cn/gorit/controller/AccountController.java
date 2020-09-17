package cn.gorit.controller;

import cn.gorit.entity.Account;
import cn.gorit.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// 账户 web
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        // 使用 RequestBody 来标识这个方法，这样返回的就是一个字符串，不然 springmvc 就会去寻找同名的 jsp 文件
        return "Hello World";
    }

    // 查询数据
    @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("表现层，查询所有账户...");
//        调用 service 方法
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "list";
    }

    // 保存数据
    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("表现层，保存账户...");
        System.out.println(account);
//        调用 service 方法
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }
}
