package com.dr.service.impl;

import java.util.List;

import com.dr.pojo.UserDeptDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dr.mapper.UserMapper;
import com.dr.pojo.User;
import com.dr.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;


	public List<UserDeptDto> findUserList(int pageNo, int pageSize) {
		return userMapper.findUserList(pageNo, pageSize);
	}

	public List<User> findUserListByName(String userName) {
		return userMapper.findUserListByName(userName);
	}



	public int findUserListCount() {
		return userMapper.selectUserListCount();
	}

	public User findUserByAccount(String account) {
		return userMapper.findUserByAccount(account);
	}

	public int insertUser(User user) {
		return userMapper.insertUser(user);
	}

	public User findUserById(int id) {
		return userMapper.findUserById(id);
	}

	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}

	public int deleteUser(User user) {
		return userMapper.deleteUser(user);
	}
}
