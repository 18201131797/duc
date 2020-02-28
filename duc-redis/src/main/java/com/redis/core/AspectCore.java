package com.redis.core;

import com.core.base.ObjectUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @description:切换核心代码
 * @author: liwt
 * @date: 2020/2/28 14:20
 * @version: 1.0.1
 */
@Component
public class AspectCore extends RedisConfiguration {


    /**
     * @param
     * @return
     * @description:转换缓存key
     * @author liwt
     * @date 2020/2/28 12:15
     * @version 1.0.1
     */
    public String baptismKey(ProceedingJoinPoint invocation, String key) {
        String prefix = redisConstant.getPrefix();
        key = prefix.concat(":").concat(key);
        String[] keys = key.split("#");
        //是否带入方法参数
        if (keys.length <= 1) {
            return key;
        }
        MethodSignature signature = (MethodSignature) invocation.getSignature();
        //参数key
        String[] paramNames = signature.getParameterNames();
        key = keys[0];
        //参数值value
        Object[] args = invocation.getArgs();
        for (int i = 1; i < keys.length; i++) {
            String[] params = keys[i].split("\\.");
            String tempValue = StringUtils.EMPTY;
            for (int j = 0; j < paramNames.length; j++) {

                if (!params[0].equals(paramNames[j])) {
                    continue;
                }
                //单层
                if (params.length <= 1) {
                    tempValue = String.valueOf(args[j]);
                    key = key.concat(":").concat(tempValue);
                    continue;
                }
                //多层
                Object obj = args[j];
                for (int k = 1; k < params.length; k++) {
                    obj = ObjectUtil.getFieldValue(obj, params[k]);
                }
                tempValue = String.valueOf(obj);
                key = key.concat(":").concat(tempValue);
            }

        }
        return key;
    }
}
