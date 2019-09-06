package com.security.base;

import com.security.entity.BaseSecurityMenu;
import com.security.entity.BaseSecurityUserInfo;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
public class UserSecurity implements UserDetails {
    //用户权限
    private Collection<? extends GrantedAuthority> getAuthorities;
    //用户信息
    private BaseSecurityUserInfo baseSecurityUserInfo;
    //用户菜单
    private Collection<? extends BaseSecurityMenu> baseSecurityMenu;

    public UserSecurity(BaseSecurityUserInfo baseSecurityUserInfo, Collection<? extends BaseSecurityMenu> baseSecurityMenu, Collection<? extends GrantedAuthority> getAuthorities) {
        this.baseSecurityUserInfo = baseSecurityUserInfo;
        this.getAuthorities = getAuthorities;
        this.baseSecurityMenu = baseSecurityMenu;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthorities;
    }

    public String getPassword() {
        return baseSecurityUserInfo.getPassword();
    }

    public String getUsername() {
        return baseSecurityUserInfo.getUserName();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }
}
