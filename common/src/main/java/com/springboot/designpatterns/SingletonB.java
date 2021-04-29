package com.springboot.designpatterns;

/**
 * File Name: SingletonB
 * Package Name: com.springboot.designPatterns
 * Date: 2020/3/23 09:40
 * 单例，懒汉式  当第一次去使用Singleton对象的时候才会为其产生实例化对象的操作
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class SingletonB {
    /**
     * 声明变量
     */
    private static volatile SingletonB singleton = null;

    /**
     * 私有构造方法
     */
    private SingletonB() {

    }

    public static SingletonB getInstance() {
        if (null == singleton) {
            synchronized (SingletonB.class) {
                singleton = new SingletonB();
            }
        }
        return singleton;
    }

    public void print() {
        System.out.println("Hello World");
    }

}
