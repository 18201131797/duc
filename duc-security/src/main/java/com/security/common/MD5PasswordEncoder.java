package com.security.common;

import com.core.encrypt.EncryptAndDecryptUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @version 1.0.0.0
 * @Description: MD5加密
 * @Author: liwt
 * @date: 2019/7/1 17:12
 */

public class MD5PasswordEncoder implements PasswordEncoder {
    public String encode(CharSequence charSequence) {
        String encode = EncryptAndDecryptUtils.md5Encrypt(charSequence.toString());
        return encode;
    }

    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String encode = EncryptAndDecryptUtils.md5Encrypt(rawPassword.toString());
        boolean result = encodedPassword.toUpperCase().equals(encode.toUpperCase());
        return result;
    }
}
