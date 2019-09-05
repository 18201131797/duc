package com.admin.security;

import com.admin.source.entity.MsRole;
import com.admin.source.entity.MsUserInfo;
import com.admin.source.entity.MsUserRole;
import com.admin.source.service.role.MsRoleService;
import com.admin.source.service.role.MsUserRoleService;
import com.admin.source.service.user.MsUserInfoService;
import com.security.base.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SecurityConfig extends UserDetailService<MsUserInfo> {

    @Autowired
    private MsUserInfoService msUserInfoService;

    @Autowired
    private MsRoleService msRoleService;

    @Autowired
    private MsUserRoleService msUserRoleService;


    @Override
    protected MsUserInfo findUserByName(String username) {
        return msUserInfoService.selectOne(MsUserInfo.builder().userName(username).build());
    }

    @Override
    protected void getRoles(MsUserInfo user, List<GrantedAuthority> list) {
        List<MsUserRole> userRoles = msUserRoleService.select(MsUserRole.builder().id(user.getId()).build());
        Example example = new Example(MsRole.class);
        example.createCriteria().andIn("id", userRoles.stream().map(u -> u.getId()).collect(Collectors.toList()));
        List<MsRole> roles = msRoleService.selectByExample(example);
        for (MsRole item : roles) {
            //权限如果前缀是ROLE_，security就会认为这是个角色信息，而不是权限，例如ROLE_MENBER就是MENBER角色，CAN_SEND就是CAN_SEND权限
            list.add(new SimpleGrantedAuthority(item.getRoleCode()));
        }
    }


}
