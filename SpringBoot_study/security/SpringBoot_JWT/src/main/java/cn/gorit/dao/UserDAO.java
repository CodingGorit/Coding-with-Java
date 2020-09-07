package cn.gorit.dao;

import cn.gorit.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDAO {

    // 直接读取 user 的字段
    @Select("select * from user where username=#{username} and password = #{password}")
    User login(User user);
}
