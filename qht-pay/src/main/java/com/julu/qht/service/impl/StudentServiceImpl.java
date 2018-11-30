package com.julu.qht.service.impl;

import com.julu.qht.entity.Student;
import com.julu.qht.mapper.StudentDao;
import com.julu.qht.service.IStudentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生,1 服务实现类
 * </p>
 *
 * @author qht
 * @since 2018-11-29
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements IStudentService {

}
