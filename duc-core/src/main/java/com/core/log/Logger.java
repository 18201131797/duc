package com.core.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @description:日志封装类
 *
 * @author: liwt
 * @date: 2019/9/5 11:25
 * @version: 1.0.1
*/
public class Logger {

    private static Log log = null;

    /**
     *@description:获取日志
     *
     *@param
     *@author liwt
     *@date 2019/9/5 11:25
     *@return
     *@version 1.0.1
    */
    public static Log getLog() {
        try {
            StackTraceElement[] stackTrace = new Exception().getStackTrace();
            String classname = stackTrace[1].getClassName();
            Class<?> aClass = Class.forName(classname);
            log = LogFactory.getLog(aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (log == null) {
            log = LogFactory.getLog(Logger.class);
        }
        return log;
    }
}
