package com.ay.test;

import java.lang.reflect.Method;

/**
 * 描述：日志类接口
 *
 * @author Ay
 * @create 2018/04/22
 **/
public interface MyLogger {

    /**
     * 纪录进入方法时间
     */
    void saveIntoMethodTime(Method method);

    /**
     * 纪录退出方法时间
     */
    void saveOutMethodTime(Method method);
}
