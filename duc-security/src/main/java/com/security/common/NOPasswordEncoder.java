package com.security.common;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @version 1.0.0.0
 * @Description: 不加密
 * @Author: liwt
 * @date: 2019/7/1 17:12
 */

public class NOPasswordEncoder implements PasswordEncoder {
    public String encode(CharSequence charSequence) {
        String encode = charSequence.toString();
        return encode;
    }

    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String encode = rawPassword.toString();
        boolean result = encodedPassword.equals(encode);
        return result;
    }
}
