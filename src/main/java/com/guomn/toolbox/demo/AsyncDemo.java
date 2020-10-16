package com.guomn.toolbox.demo;

import java.util.concurrent.CompletableFuture;

/**
 * @author: 郭梦男
 * @create: 2020-10-16 11:46
 **/
public class AsyncDemo {

    public static void main(String[] args) {
//        CompletableFuture.runAsync(() -> System.out.println("helloworld"))
//        .thenAccept(System.out::println);

        CompletableFuture.supplyAsync(() -> {
            return function1();
        }).thenAccept((s) -> function2(s));


    }

    private static void function2(String s) {
        System.out.println(s);
    }

    private static String function1() {
        return "hello world";
    }
}
