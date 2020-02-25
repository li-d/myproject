package com.mycompany.common.design.sington;

/**
 * 单线程的单例模式
 * 1 私有构造方法
 * 2 持有自己类的私有属性
 * 3 获取自己类实例的静态方法
 */
public class SingtonDemo {

    private SingtonDemo() {
    }


    private static SingtonDemo instance = null;

    public static SingtonDemo getInstance() {
        if (instance == null) {
            instance = new SingtonDemo();
        }
        return instance;
    }
}
