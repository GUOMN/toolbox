package com.guomn.toolbox.demo.ameituan;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程轮流打印
 */
public class ThreadDemo implements Runnable{
    private int flag;
    private static final AtomicInteger count = new AtomicInteger(0);

    public ThreadDemo(int flag) {
        this.flag = flag;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (!Thread.interrupted() && count.get() < 100) {
            if (count.get() % flag == 0) {
                System.out.println(Thread.currentThread().getName() + "===this is thread " + flag + " ==== count:" + count.get());
                count.incrementAndGet();
            }else {
            }
        }

    }
}
