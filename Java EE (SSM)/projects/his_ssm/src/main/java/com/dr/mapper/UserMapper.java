package com.dr.mapper;
import java.util.List;

import com.dr.pojo.User;
import com.dr.pojo.UserDeptDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

	@Select("SELECT s.*,d.deptName FROM sysuser s,dept d WHERE s.deptId=d.deptId AND del=0 ORDER BY s.id LIMIT #{pageNo}, #{pageSize}")
	List<UserDeptDto> findUserList(@Param("pageNo") int pageNo,@Param("pageSize") int pageSize);

	// 此方法暂时未使用
	List<User> selectUserList(int pageNo, int pageSize);

	// 查询总数
	@Select("SELECT COUNT(*) FROM sysuser s,dept d WHERE s.deptId=d.deptId AND del=0")
	int selectUserListCount();

	List<User> findUserListByName(String userName);
	User findUserByAccount(String account);
	int insertUser(User user);
	User findUserById(int id); 
	int updateUser(User user);
	int deleteUser(User user);
}
