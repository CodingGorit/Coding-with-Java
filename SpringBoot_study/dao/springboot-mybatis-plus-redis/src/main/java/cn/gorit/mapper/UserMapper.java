package cn.gorit.mapper;

import cn.gorit.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Gorit
 * @since 2020-10-15
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    public void addUser(User user);
}
