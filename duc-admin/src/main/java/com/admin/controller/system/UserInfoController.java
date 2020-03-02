package com.admin.controller.system;

import com.admin.source.pojo.dto.MsUserInfoDto;
import com.admin.source.service.user.MsUserInfoService;
import com.github.pagehelper.PageInfo;
import com.web.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/system/userinfo")
public class UserInfoController {


    @Autowired
    private MsUserInfoService msUserInfoService;

    @GetMapping("/list")
    public String login() {
        return "system/admin-list";
    }

    @GetMapping("/page-list")
    @ResponseBody
    public Result pageList(MsUserInfoDto msUserInfoDto) {
        PageInfo pageInfo = msUserInfoService.pageList(msUserInfoDto);
        return Result.resultSuccess(10001, pageInfo);
    }
}
