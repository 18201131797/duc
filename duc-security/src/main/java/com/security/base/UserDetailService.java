package com.security.base;

import com.core.log.Logger;
import com.security.entity.BaseSecurityEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public abstract class UserDetailService<T> implements UserDetailsService {


    /**
     * 根据用户名获取用户信息
     *
     * @param username
     * @return
     */
    protected abstract T findUserByName(String username);


    /**
     * 获取所属角色
     *
     * @param user
     * @param list
     */
    protected abstract void getRoles(T user, List<GrantedAuthority> list);


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        T user = findUserByName(username);
        if (user == null) {
            Logger.getLog().error("找不到该账户信息！");
            throw new UsernameNotFoundException("找不到该账户信息！");                    //抛出异常，会根据配置跳到登录失败页面
        }
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();                    //GrantedAuthority是security提供的权限类，

        getRoles(user, list);
        UserSecurity userSecurity = new UserSecurity((BaseSecurityEntity) user, list);
        return userSecurity;
    }


}
