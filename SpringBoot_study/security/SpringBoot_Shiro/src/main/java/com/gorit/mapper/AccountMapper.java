package com.gorit.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gorit.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * mybatis plus 使用
 *
 */
@Mapper
@Repository("AccountMapper")
public interface AccountMapper extends BaseMapper<Account> {
}
