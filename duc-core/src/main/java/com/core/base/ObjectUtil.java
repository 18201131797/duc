package com.core.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description:动态设置获取类的属性值
 * @author: liwt
 * @date: 2020/2/28 14:07
 * @version: 1.0.1
 */
public class ObjectUtil {

    /**
     * @param
     * @return
     * @description:过滤不需要属性
     * @author liwt
     * @date 2020/2/28 14:08
     * @version 1.0.1
     */
    private static Boolean needFilterField(Field field) {
        // 过滤静态属性
        if (Modifier.isStatic(field.getModifiers())) {
            return true;
        }
        // 过滤transient 关键字修饰的属性
        if (Modifier.isTransient(field.getModifiers())) {
            return true;
        }
        return false;
    }

    /**
     * @param
     * @return
     * @description:利用Java反射根据类的名称获取属性信息和父类的属性信息
     * @author liwt
     * @date 2020/2/28 14:08
     * @version 1.0.1
     */
    public static Map<String, Field> getFieldList(Object obj) {
        Map<String, Field> fieldMap = new LinkedHashMap<>();
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (needFilterField(field)) {
                continue;
            }
            fieldMap.put(field.getName(), field);
        }
        getParentField(clazz, fieldMap);
        return fieldMap;
    }

    /**
     * @param
     * @return
     * @description:递归所有父类属性
     * @author liwt
     * @date 2020/2/28 14:08
     * @version 1.0.1
     */
    private static void getParentField(Class<?> clazz, Map<String, Field> fieldMap) {
        Class<?> superClazz = clazz.getSuperclass();
        if (superClazz != null) {
            Field[] superFields = superClazz.getDeclaredFields();
            for (Field field : superFields) {
                if (needFilterField(field)) {
                    continue;
                }
                fieldMap.put(field.getName(), field);
            }
            getParentField(superClazz, fieldMap);
        }
    }

    /**
     * @param
     * @return
     * @description:根据类获取属性信息和父类的属性信息
     * @author liwt
     * @date 2020/2/28 14:08
     * @version 1.0.1
     */
    public static Map<String, Method> getMethodMap(Object obj) {
        Map<String, Method> methodMap = new LinkedHashMap<>();
        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            methodMap.put(method.getName(), method);
        }
        getParentMethod(clazz, methodMap);
        return methodMap;
    }

    /**
     * @param
     * @return
     * @description:递归所有父类方法
     * @author liwt
     * @date 2020/2/28 14:08
     * @version 1.0.1
     */
    private static void getParentMethod(Class<?> clazz, Map<String, Method> methodMap) {
        Class<?> superClazz = clazz.getSuperclass();
        if (superClazz != null) {
            Method[] superMethods = superClazz.getMethods();
            for (Method field : superMethods) {
                methodMap.put(field.getName(), field);
            }
            getParentMethod(superClazz, methodMap);
        }
    }

    /**
     * @param
     * @return
     * @description:根据属性名获取属性值
     * @author liwt
     * @date 2020/2/28 14:08
     * @version 1.0.1
     */
    public static Object getFieldValue(Object obj, String fieldName) {
        try {
            Map<String, Method> methodMap = getMethodMap(obj);
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = methodMap.get(getter);
            Object value = null;
            if (method != null) {
                value = method.invoke(obj, new Object[]{});
            }
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param
     * @return
     * @description:设置属性值
     * @author liwt
     * @date 2020/2/28 14:09
     * @version 1.0.1
     */
    public static void setFieldValue(Object obj, String fieldName, Object value) {
        try {
            Map<String, Field> fields = getFieldList(obj);
            Field f = fields.get(fieldName);
            if (f != null) {
                f.setAccessible(true);
                f.set(obj, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
