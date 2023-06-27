package com.dr.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dr.mapper.UserMapper;
import com.dr.pojo.BatchList;
import com.dr.pojo.UserDeptDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.dr.pojo.Dept;
import com.dr.pojo.User;
import com.dr.service.DeptService;
import com.dr.service.UserService;
@Controller
@RequestMapping("/userManage")
public class UserController {
	@Autowired
	UserService userService;

	@Autowired
	DeptService deptService;

	@Autowired
	private HttpServletRequest request;

	/*
	 * 加载用户列表,支持查询字符串保持
	 */
	@RequestMapping("/userList.action")
	public ModelAndView userList() throws Exception {
		int pageNo = 1;
		String str = request.getParameter("pageNo");
		if (str != null) {
			pageNo = Integer.parseInt(str);
		}
		int pageSize = 5;
		List<UserDeptDto> list = userService.findUserList(pageSize * (pageNo - 1), pageSize);
//		System.out.println(list.size() + " pageNo =>" + pageSize * (pageNo - 1) + " pageSize =>" + pageSize);
		int count = userService.findUserListCount();
		int pageCount = 0;
		if (count % pageSize == 0) {
			pageCount = count / pageSize;
		} else {
			pageCount = count / pageSize + 1;
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("pageNo", pageNo);
		mav.addObject("pageCount", pageCount);
		mav.addObject("attrUserName", "");
		mav.setViewName("userManage/userList");
		return mav;
	}

	/**
	 * 模糊查询，搜索
	 * @param txtUserName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userListbyName.action")
	public ModelAndView userListbyName(String txtUserName) throws Exception {
		List<User> list = userService.findUserListByName(txtUserName);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("attrUserName", txtUserName);
		mav.setViewName("userManage/userList");
		return mav;
	}

	// ---------------------------------- 增加 ---------------------------------
	// ============= 增加用户页面 =============
	@RequestMapping("/userAdd.action")
	public ModelAndView userAdd() throws Exception {
		ModelAndView mav = new ModelAndView();
		List<Dept> deptList = deptService.findDeptList();
		mav.addObject("attrDeptList", deptList);
		mav.setViewName("userManage/userAdd");
		return mav;
	}

	// ---------------------------------- 修改 ---------------------------------
	// ============= 修改用户页面 =============
	@RequestMapping("/userUpdate.action")
	public ModelAndView userUpdate(Integer id) throws Exception {
		User user = userService.findUserById(id);
		ModelAndView mav = new ModelAndView();
		List<Dept> deptList = deptService.findDeptList();
		mav.addObject("attrDeptList", deptList);
		mav.addObject("attrUser", user);
		mav.setViewName("/userManage/userUpdate");// WEBINF/jsp//[userManage/userUpdate].jsp
		return mav;
	}

	// ============= 执行修改操作 =============
	@RequestMapping("/doUserUpdate.action")
	public ModelAndView doUserUpdate(HttpSession session, User user) throws Exception {
		User loginUser = (User) session.getAttribute("loginUser");
		Long id = loginUser.getId();
		user.setUpdateUser(id + "");
		userService.updateUser(user);
		return userList();
	}

	// ============= 执行增加操作 =============

	@RequestMapping("/doUserAdd.action")
	public ModelAndView doUserAdd(User user) throws Exception {
		HttpSession session = request.getSession();
		User target = userService.findUserByAccount(user.getAccount());
		ModelAndView mav = new ModelAndView();
		if (target == null) {// 账户不存在
			User loginUser = (User) session.getAttribute("loginUser");
			Long id = loginUser.getId();
			user.setCreateUser(id + "");
			userService.insertUser(user);
			mav = userList();
		} else {
			mav.addObject("attrInfoUserAdd", "系统帐户已经存在，请重新输入");
			mav.setViewName("userManage/userAdd");
		}
		return mav;
	}

	// ---------------------------------- 删除 ---------------------------------
	// ============= 执行删除操作 =============
	@RequestMapping("/doUserDelete.action")
	public ModelAndView doUserDelete(User user) throws Exception {
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		Long userId = loginUser.getId();
		user.setUpdateUser(userId + "");
		userService.deleteUser(user);
		return userList();
	}

	@RequestMapping("/doUserDeleteAll.action")
	@ResponseBody
	public String doUserDeleteAll(@RequestBody BatchList batchList) {
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		Long userId = loginUser.getId();
		List<Long> list = batchList.getList();
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				User u = new User();
				u.setUpdateUser(String.valueOf(userId));
				u.setId(list.get(i));
				userService.deleteUser(u);
			}
			return "success";
		} else {
			return "fail";
		}
	}
}
