package com.dr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dr.pojo.Dept;
import com.dr.service.DeptService;
import com.dr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.dr.pojo.User;
import com.dr.service.LoginService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class LoginController {
	@Autowired
	LoginService loginService;

	@Autowired
	UserService userService;

	@Autowired
	DeptService deptService;

	@Autowired
	private HttpServletRequest request;

	/*
	 * index.jsp，跳转过来，加载登录页面
	 */
	@RequestMapping("/login.action")
	public String loginPage() throws Exception {
		return "login";
	}

	@GetMapping("/register.action")
	public String registerPage(HttpServletRequest request) throws Exception {
		return loginService.register(request);
	}

	@RequestMapping(path = "/doUserRegister.action", produces = "text/html;charset=utf-8")
	public ModelAndView doUserRegister(User user) throws Exception {
		HttpSession session = request.getSession();
		User target = userService.findUserByAccount(user.getAccount());
		ModelAndView mav = null;
		if (target == null) {// 账户不存在
			userService.insertUser(user);
			mav = new ModelAndView("redirect:/index.jsp");
		} else {
			mav = new ModelAndView();
			mav.addObject("attrInfoUserAdd", "系统帐户已经存在，请重新输入");
			mav.setViewName("register");
		}
		return mav;
	}

	@RequestMapping("/loginSubmit.action")
	public String loginSubmit(HttpServletRequest request, User user) throws Exception {
		User loginUser = loginService.findUser(user);
		if (loginUser == null) {
			request.setAttribute("loginErrMsg", "用户名或密码错误，请重新输 入！");
			return "login";
		} else {
			request.getSession().setAttribute("loginUser", loginUser);
			return "redirect:/userManage/userList.action";
		}
	}


	// 退出登陆
	@GetMapping("/logout.action")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("loginUser");
		ModelAndView mv = new ModelAndView("redirect:/index.jsp");
		return mv;
	}
}