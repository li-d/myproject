package com.mycompany.common.design.sington;

/**
 * 线程安全的单例模式
 * 1 私有构造方法
 * 2 私有的静态属性
 * 3 公有的获取自己实例的静态方法
 */
public class SafeSington {

    private SafeSington() {
    }

    private static SafeSington instance = null;

    public static SafeSington getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (SafeSington.class) {
            if (instance == null) {
                instance = new SafeSington();
            }
        }
        return instance;
    }
}
