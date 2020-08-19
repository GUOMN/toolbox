package com.guomn.toolbox.demo;

/**
 * @author: 郭梦男
 * @create: 2020-08-18 18:07
 **/
public class Subclass extends Abstract{

//    @Override
    public static void sayHello() {
        System.out.println("i am sub class");
    }
    @Override
    public void common() {
        System.out.println("==> i am sub class");
    }

    public static void main(String[] args) {
        Abstract b = new Subclass();
        Abstract.sayHello();
        Subclass.sayHello();
        b.sayHello();
        b.common();
    }
}
