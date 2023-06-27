package com.dr.service.impl;

import com.dr.mapper.DeptMapper;
import com.dr.pojo.Dept;
import com.dr.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dr.mapper.LoginMapper;
import com.dr.pojo.User;
import com.dr.service.LoginService;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginMapper loginMapper;

	@Autowired
	DeptMapper deptMapper;

	public User findUser(User user) throws Exception {
		return loginMapper.selectUser(user);
	}

	public String register(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("attrInfoUserAdd", "");
		List<Dept> deptList = deptMapper.findDeptList();
		session.setAttribute("list", deptList);
		return "register";
	}

}