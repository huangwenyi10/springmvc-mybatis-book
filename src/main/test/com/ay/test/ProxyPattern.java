package com.ay.test;

/**
 * 描述：客户端类
 *
 * @author Ay
 * @create 2018/04/22
 **/
public class ProxyPattern {
    public static void main(String[] args) {
        Proxy proxy = new Proxy(new RealSubject());
        proxy.operation();
    }
}

/**
 * 描述：抽象主题类
 *
 * @author Ay
 * @create 2018/04/22
 **/
abstract class Subject {
    abstract void operation();
}

/**
 * 描述：具体主题类
 *
 * @author Ay
 * @create 2018/04/22
 **/
class RealSubject extends Subject {

    void operation() {
        System.out.println("operation ......");
    }
}

/**
 * 描述：代理类
 *
 * @author Ay
 * @create 2018/04/22
 **/
class Proxy extends Subject {

    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    void operation() {
        //前置处理
        this.preOperation();
        //具体操作
        subject.operation();
        //后置处理
        this.postOperation();
    }

    void preOperation() {
        System.out.println("pre operation......");
    }

    void postOperation() {
        System.out.println("post operation......");
    }
}
