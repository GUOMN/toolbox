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

        CompletableFuture.supplyAsync(() -> "helloworld")
                .thenAccept(System.out::println);


    }
}
