package com.springboot.designpatterns.decorate;

/**
 * File Name: Circle
 * Package Name: com.springboot.designPatterns.decorate
 * Date: 2020/3/23 15:49
 * 装饰器模式
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle...");
    }
}
