package com.security.base;

import com.core.log.Logger;
import com.security.entity.BaseSecurityMenu;
import com.security.entity.BaseSecurityUserInfo;
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
     *@description:获取所属角色
     *
     *@param
     *@author liwt
     *@date 2019/9/6 15:52
     *@return
     *@version 1.0.1
    */
    protected abstract void getRoles(T user, List<GrantedAuthority> grantedAuthorityList);

    /**
     *@description:获取用户菜单
     *
     *@param
     *@author liwt
     *@date 2019/9/5 20:28
     *@return
     *@version 1.0.1
     */
    protected abstract void getMenu(T user, List<BaseSecurityMenu> baseSecurityMenuList);

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        T user = findUserByName(username);
        if (user == null) {
            Logger.getLog().error("找不到该账户信息！");
            throw new UsernameNotFoundException("找不到该账户信息！");                    //抛出异常，会根据配置跳到登录失败页面
        }
        List<GrantedAuthority> grantedAuthorityArrayList = new ArrayList<GrantedAuthority>();                    //GrantedAuthority是security提供的权限类，

        //初始化权限
        getRoles(user, grantedAuthorityArrayList);

        List<BaseSecurityMenu> baseSecurityMenuList = new ArrayList<BaseSecurityMenu>();

        //初始化菜单
        getMenu(user, baseSecurityMenuList);

        UserSecurity userSecurity = new UserSecurity((BaseSecurityUserInfo) user, baseSecurityMenuList, grantedAuthorityArrayList);
        return userSecurity;
    }


}
