package cn.gorit.controller.user;

import cn.gorit.common.dto.LoginDto;
import cn.gorit.dao.UserDao;
import cn.gorit.entity.User;
import cn.gorit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService us;

    // 用户登录的账号密码接收
    @PostMapping("/login")
    public ModelAndView login(LoginDto dto) {
        ModelAndView view = new ModelAndView();
        // 验证登录
        User u = us.selectUser(dto.getUserId());
        view.addObject("u",u);
        if (u.getPassword().equals(dto.getPassword())) {
            view.setViewName("main");
        } else {
            view.setViewName("error");
        }
        return view;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(User u) throws IOException {
        System.out.println(u.toString());
        int res = us.insertUsr(u);
        if (res > 0) {
            return "success";
        } else {
            return "error";
        }
    }
}
