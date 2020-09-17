package cn.gorit.mapper;

import cn.gorit.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccountMapper {

    // 查询所有账户信息
    List<Account> findAll();

    @Select("select * from account where id = #{id}")
    Account selectAccountById(int id);
}
