package com.admin.load;

import com.admin.service.entity.Student;
import com.admin.service.service.IStudentService;
import com.google.gson.Gson;
import com.redis.base.IBaseLaunch;
import com.redis.base.ICacheFactory;
import com.redis.base.ILoadCache;
import com.web.spring.SpringLoad;

import java.util.List;

/**
 * @version 1.0.0.0
 * @Description:
 * @Author: liwt
 * @date: 2019/5/31 15:37
 */
public class StudentLoad implements ILoadCache<String> {

    private IBaseLaunch<ICacheFactory> launch = SpringLoad.getInstance(IBaseLaunch.class);


    private IStudentService studentService = SpringLoad.getInstance(IStudentService.class);

    @Override
    public String load(String key) {
        List<Student> students = studentService.selectAll();
        Gson gson = new Gson();
        String value = gson.toJson(students);
        launch.loadServiceCache("test").set(value);
        return value;
    }
}
