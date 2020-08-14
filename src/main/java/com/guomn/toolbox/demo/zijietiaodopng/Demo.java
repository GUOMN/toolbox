package com.guomn.toolbox.demo.zijietiaodopng;

/**
 * @author: 郭梦男
 * @create: 2020-08-09 15:34
 **/
public class Demo {
    static DemoFactory factory = new DemoFactory();

    public static void main(String[] args) {
        factory.getProduct("1").doSomething();
    }
}
