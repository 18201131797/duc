package com.manager.security;

import com.manager.security.base.UserDetailService;
import com.manager.source.entity.Role;
import com.manager.source.entity.User;
import com.manager.source.entity.UserRole;
import com.manager.source.service.role.RoleService;
import com.manager.source.service.role.UserRoleService;
import com.manager.source.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SecurityConfig extends UserDetailService<User> {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;


    @Override
    protected User findUserByName(String username) {
        return userService.selectOne(User.builder().username(username).build());
    }

    @Override
    protected void getRoles(User user, List<GrantedAuthority> list) {
        List<UserRole> userRoles = userRoleService.select(UserRole.builder().userid(user.getId()).build());
        Example example = new Example(Role.class);
        example.createCriteria().andIn("roleid", userRoles.stream().map(u -> u.getRoleid()).collect(Collectors.toList()));
        List<Role> roles = roleService.selectByExample(example);
        for (Role item : roles) {
            //权限如果前缀是ROLE_，security就会认为这是个角色信息，而不是权限，例如ROLE_MENBER就是MENBER角色，CAN_SEND就是CAN_SEND权限
            list.add(new SimpleGrantedAuthority(item.getCode()));
        }
    }


}
