package com.admin.controller;

import com.admin.service.entity.Student;
import com.admin.service.service.IStudentService;
import com.web.base.BaseController;
import com.web.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @version 1.0.0.0
 * @Description:
 * @Author: liwt
 * @date: 2019/5/24 0:45
 */

@Api(description = "用户接口")
@RestController
@RequestMapping("/index")
public class TestController extends BaseController {


    @Autowired
    private IStudentService studentService;


    @ApiOperation(value = "新增用户1", notes = "新增注册2")
    @GetMapping
    public Result index() {

        return Result.resultSuccess(10001, studentService.selectAll());
    }


    @ApiOperation(value = "新增用户", notes = "新增注册")
    @GetMapping("/login")
    public Result token() {
        List<Student> all = studentService.selectAll();
        return Result.resultSuccess(10001, all);
    }
}

