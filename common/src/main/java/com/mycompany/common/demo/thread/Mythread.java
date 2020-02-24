package com.mycompany.common.demo.thread;

public class Mythread implements Runnable {

    public Mythread() {
        System.out.println("构造函数:" + Thread.currentThread().getName());

    }

    @Override
    public void run() {
        System.out.println("run:" + Thread.currentThread().getName());
    }
}
