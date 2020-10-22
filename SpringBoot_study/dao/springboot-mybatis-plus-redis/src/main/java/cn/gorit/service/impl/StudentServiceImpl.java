package cn.gorit.service.impl;

import cn.gorit.entity.Student;
import cn.gorit.mapper.StudentMapper;
import cn.gorit.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Gorit
 * @since 2020-10-19
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
