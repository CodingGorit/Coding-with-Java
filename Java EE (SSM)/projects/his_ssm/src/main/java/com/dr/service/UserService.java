package com.dr.service;

import java.util.List;

import com.dr.pojo.User;
import com.dr.pojo.UserDeptDto;

public interface UserService {

	List<UserDeptDto> findUserList(int pageNo, int pageSize);
	int findUserListCount();

	List<User> findUserListByName(String userName);

	User findUserByAccount(String account);
	int insertUser(User user);
	User findUserById(int id);
	int updateUser(User user);
	int deleteUser(User user);
}
