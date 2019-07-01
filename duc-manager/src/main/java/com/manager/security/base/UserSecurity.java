package com.manager.security.base;

import com.manager.security.entity.BaseSecurityEntity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
public class UserSecurity implements UserDetails {
    private Collection<? extends GrantedAuthority> getAuthorities;
    private BaseSecurityEntity baseSecurityEntity;

    public UserSecurity(BaseSecurityEntity baseSecurityEntity, Collection<? extends GrantedAuthority> getAuthorities) {
        this.baseSecurityEntity = baseSecurityEntity;
        this.getAuthorities = getAuthorities;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthorities;
    }

    public String getPassword() {
        return baseSecurityEntity.getPassword();
    }

    public String getUsername() {
        return baseSecurityEntity.getUsername();
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
