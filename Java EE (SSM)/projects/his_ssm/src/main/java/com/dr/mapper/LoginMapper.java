package com.dr.mapper;

import com.dr.pojo.User;

public interface LoginMapper {
	User selectUser(User user);
	
}