package com.guomn.toolbox.demo.ameituan;

public class Demo {
    public static void main(String[] args) {
        ThreadDemo t1 = new ThreadDemo(1);
        ThreadDemo t2 = new ThreadDemo(2);
        ThreadDemo t3 = new ThreadDemo(3);

        t1.run();
        t2.run();
        t3.run();
    }
}
