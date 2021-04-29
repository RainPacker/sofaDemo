package com.springboot.designpatterns;

/**
 * File Name: Singleton
 * Package Name: com.springboot.designPatterns
 * Date: 2020/3/23 09:38
 * 单例
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class Singleton {

    /**
     * 在类的内部可以访问私有结构，所以可以在类的内部产生实例化对象
     */
    private static Singleton instance = new Singleton();

    /**
     * private 声明构造
     */
    private Singleton() {

    }

    /**
     * 返回对象实例
     */
    public static Singleton getInstance() {
        return instance;
    }

    public void print() {
        System.out.println("Hello Singleton...");
    }
}
