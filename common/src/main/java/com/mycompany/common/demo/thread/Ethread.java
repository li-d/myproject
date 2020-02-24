package com.mycompany.common.demo.thread;

public class Ethread extends Thread {


    public Ethread() {
        System.out.println("构造:" + Thread.currentThread().getName());
        System.out.println("构造:" + this.getName());

    }

    @Override
    public void run() {
        super.run();
        System.out.println("调用方当前线程的名字：" + Thread.currentThread().getName() + "   run==" + Thread.currentThread().isAlive());
        System.out.println("当前线程的名字：" + this.getName() + "  run==" + this.isAlive());
    }
}
