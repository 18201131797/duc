package com.admin.security;

import com.admin.enums.EEnable;
import com.admin.source.entity.*;
import com.admin.source.service.menu.MsMenuService;
import com.admin.source.service.menu.MsRoleMenuService;
import com.admin.source.service.role.MsRoleService;
import com.admin.source.service.role.MsUserRoleService;
import com.admin.source.service.user.MsUserInfoService;
import com.security.base.UserDetailService;
import com.security.entity.BaseSecurityMenu;
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

    @Autowired
    private MsRoleMenuService mRoleMenuService;

    @Autowired
    private MsMenuService msMenuService;


    @Override
    protected MsUserInfo findUserByName(String username) {
        return msUserInfoService.selectOne(MsUserInfo.builder().userName(username).build());
    }

    @Override
    protected void getRoles(MsUserInfo user, List<GrantedAuthority> grantedAuthorityList) {
        List<MsUserRole> userRoles = msUserRoleService.select(MsUserRole.builder().id(user.getId()).deleteFlag(EEnable.TRUE.getCode()).build());
        if (userRoles.isEmpty()) {
            return;
        }
        Example example = new Example(MsRole.class);
        example.createCriteria().andEqualTo("deleteFlag", EEnable.TRUE.getCode()).andIn("id", userRoles.stream().map(u -> u.getId()).collect(Collectors.toList()));
        List<MsRole> roles = msRoleService.selectByExample(example);
        for (MsRole item : roles) {
            //权限如果前缀是ROLE_，security就会认为这是个角色信息，而不是权限，例如ROLE_MENBER就是MENBER角色，CAN_SEND就是CAN_SEND权限
            grantedAuthorityList.add(new SimpleGrantedAuthority(item.getRoleCode()));
        }
    }

    @Override
    protected void getMenu(MsUserInfo user, List<BaseSecurityMenu> baseSecurityMenuList) {
        List<MsUserRole> userRoles = msUserRoleService.select(MsUserRole.builder().id(user.getId()).deleteFlag(EEnable.TRUE.getCode()).build());
        if (userRoles.isEmpty()) {
            return;
        }
        Example example = new Example(MsRoleMenu.class);
        example.createCriteria().andEqualTo("deleteFlag", EEnable.TRUE.getCode()).andIn("roleId", userRoles.stream().map(u -> u.getId()).collect(Collectors.toList()));
        List<MsRoleMenu> msRoleMenus = mRoleMenuService.selectByExample(example);
        if (msRoleMenus.isEmpty()) {
            return;
        }
        example.clear();
        example.createCriteria().andEqualTo("deleteFlag", EEnable.TRUE.getCode()).andIn("id", msRoleMenus.stream().map(m -> m.getMenuId()).collect(Collectors.toList()));
        List<MsMenu> msMenus = msMenuService.selectByExample(example);
        msMenus.stream().forEach(m -> baseSecurityMenuList.add(m));
    }


}
