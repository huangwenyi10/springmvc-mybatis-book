package com.ay.test;

import java.lang.reflect.Proxy;

/**
 * 描述：测试类
 *
 * @author Ay
 * @create 2018/04/22
 **/
public class MyLoggerTest {

    public static void main(String[] args) {
        int i = 1;
        Integer ii = 1;
        if (i == ii) {
            System.out.println("111");
        }
        float iii = 1;
        if (iii == ii) {
            System.out.println("12222");
        }

        //实例化真实项目中业务类
        BusinessClassService businessClassService = new BusinessClassServiceImpl();
        //日志类的handler
        MyLoggerHandler myLoggerHandler = new MyLoggerHandler(businessClassService);
        //获得代理类对象
        BusinessClassService businessClass = (BusinessClassService) Proxy.newProxyInstance(businessClassService.getClass().getClassLoader(), businessClassService.getClass().getInterfaces(), myLoggerHandler);
        //执行代理类方法
        businessClass.doSomeThing();
    }
}
