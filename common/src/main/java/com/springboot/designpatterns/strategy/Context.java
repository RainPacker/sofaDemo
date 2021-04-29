package com.springboot.designpatterns.strategy;

/**
 * File Name: Context
 * Package Name: com.springboot.designPatterns.strategy
 * Date: 2020/3/23 13:51
 * 策略模式
 * 上下文，维护一个对策略类对象的引用
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface() {
        strategy.algorithmInterface();
    }
}
