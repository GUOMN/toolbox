//package com.guomn.toolbox.demo.Boss;
//
//import io.netty.util.concurrent.CompleteFuture;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.lang.invoke.MethodHandles;
//import java.util.Random;
//import java.util.concurrent.CompletableFuture;
//import java.util.function.Consumer;
//
///**
// * @author: 郭梦男
// * @create: 2020-08-15 11:26
// **/
//public class Demo5 {
//    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
//    // todo
//    public String translate(String content) {
////        Consumer<String> consumer = (str) -> return str;
//        String result;
//        CompletableFuture.supplyAsync(() -> baidu(content))
//                .applyToEitherAsync(() -> google(content))
//
//        CompleteFuture<> future = CompleteFuture
//        baidu(content);
//        google(content);
//        youdao(content);
//        return "";
//    }
//
//    public String baidu(String content) {
//        randomSleep();
//        return "result";
//    }
//
//    public String google(String content) {
//        randomSleep();
//        return "result";
//    }
//
//    public String youdao(String content) {
//        randomSleep();
//        return "result";
//    }
//
//    private void randomSleep() {
//        try {
//            Thread.sleep(new Random().nextInt(3000));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
