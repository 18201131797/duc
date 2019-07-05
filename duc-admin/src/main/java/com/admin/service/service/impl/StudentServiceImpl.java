package com.admin.service.service.impl;

import com.admin.service.entity.Student;
import com.admin.service.mapper.StudentMapper;
import com.admin.service.service.IStudentService;
import com.redis.annotation.Cacheable;
import com.tkmybatis.base.IBaseMapper;
import com.tkmybatis.base.IBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0.0.0
 * @Description:
 * @Author: liwt
 * @date: 2019/5/30 9:19
 */
@Service
public class StudentServiceImpl extends IBaseServiceImpl<Student> implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    protected IBaseMapper<Student> mapper() {
        return studentMapper;
    }

    @Cacheable(key = "selectAll")
    @Override
    public List<Student> selectAll() {
        return mapper().selectAll();
    }


}
