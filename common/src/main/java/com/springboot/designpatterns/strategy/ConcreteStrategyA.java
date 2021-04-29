package com.springboot.designpatterns.strategy;

/**
 * File Name: ConcreteStrategyA
 * Package Name: com.springboot.designPatterns.strategy
 * Date: 2020/3/23 13:49
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class ConcreteStrategyA extends Strategy {
    @Override
    public void algorithmInterface() {
        System.out.println("算法A的实现");
    }
}
