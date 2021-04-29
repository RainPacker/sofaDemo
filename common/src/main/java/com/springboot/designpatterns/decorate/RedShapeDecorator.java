package com.springboot.designpatterns.decorate;

/**
 * File Name: RedShapeDecorator
 * Package Name: com.springboot.designPatterns.decorate
 * Date: 2020/3/23 15:54
 * 自定义装饰器
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class RedShapeDecorator extends AbstractShapeDecorator {
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Border Color: Red");
    }
}
