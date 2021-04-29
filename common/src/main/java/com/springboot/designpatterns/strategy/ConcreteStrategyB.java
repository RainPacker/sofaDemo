package com.springboot.designpatterns.strategy;

/**
 * File Name: ConcreteStrategyB
 * Package Name: com.springboot.designPatterns.strategy
 * Date: 2020/3/23 13:50
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class ConcreteStrategyB extends Strategy {
    @Override
    public void algorithmInterface() {
        System.out.println("算法B的实现");
    }
}
