package com.springboot.designpatterns.decorate;

/**
 * File Name: Rectangle
 * Package Name: com.springboot.designPatterns.decorate
 * Date: 2020/3/23 15:46
 * 装饰器模式
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle...");
    }
}
