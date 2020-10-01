package com.ay.proxy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 描述：日志拦截类
 *
 * @author Ay
 * @create 2018/04/22
 **/
@Aspect
@Component
public class LogInterceptor {

    @Before(value = "execution(* com.ay.controller.*.*(..))")
    public void before() {
        System.out.println("进入方法时间为:" + System.currentTimeMillis());
    }

    @After(value = "execution(* com.ay.controller.*.*(..))")
    public void after() {
        System.out.println("退出方法时间为:" + System.currentTimeMillis());
    }
}
