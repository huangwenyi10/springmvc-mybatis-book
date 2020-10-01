package com.ay.test;

import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * 描述：日志实现类
 *
 * @author Ay
 * @create 2018/04/22
 **/
public class MyLoggerImpl implements MyLogger {

    public void saveIntoMethodTime(Method method) {
        System.out.println("进入" + method.getName() + "方法时间为: " + System.currentTimeMillis());
    }

    public void saveOutMethodTime(Method method) {
        System.out.println("退出" + method.getName() + "方法时间为：" + System.currentTimeMillis());

    }
}
