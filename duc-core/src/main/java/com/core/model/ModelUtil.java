package com.core.model;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:实体与实体转换
 *
 * @author: liwt
 * @date: 2019/8/5 19:24
 * @version: 1.0.1
*/
public class ModelUtil {

    /**
     *@description:实体相同字段copy List
     *
     *@param
     *@author liwt
     *@date 2019/8/5 19:25
     *@return
     *@version 1.0.1
    */
    public static <T> List<T> modelToModel(List target, Class<T> clazz) {
        List<T> result = new ArrayList<>();
        try {
            for (Object item : target) {
                T t = clazz.newInstance();
                BeanUtils.copyProperties(item, t);
                result.add(t);
            }
        } catch (Exception e) {

        }
        return result;
    }

    /**
     *@description:实体相同字段copy
     *
     *@param
     *@author liwt
     *@date 2019/8/5 19:25
     *@return
     *@version 1.0.1
    */
    public static <T> T modelToModel(Object target, Class<T> clazz) {
        T t = null;
        try {
            t = clazz.newInstance();
            BeanUtils.copyProperties(target, t);
        } catch (Exception e) {

        }
        return t;
    }
}
