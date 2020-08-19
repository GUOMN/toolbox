package com.guomn.toolbox.demo.Boss;

/**
 * @author: 郭梦男
 * @create: 2020-08-15 08:50
 **/
public class Demo3 {
    static Object o1 = new Object();
    static Object o2 = new Object();

    public static void main(String[] args) {
        Resource1 r1 = new Resource1();
        Resource2 r2 = new Resource2();
        r1.run();
        r2.run();
    }

    static class Resource1 implements Runnable{
        @Override
        public void run() {
            while(true) {
                synchronized (o1) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o2) {
                        System.out.println("解除死锁");
                    }
                }
            }
        }
    }
    static class Resource2 implements Runnable{
        @Override
        public void run() {
            while(true) {
                synchronized (o2) {
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o1) {
                        System.out.println("解除死锁");
                    }
                }
            }
        }
    }
}
