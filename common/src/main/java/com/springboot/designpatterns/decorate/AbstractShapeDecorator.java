package com.springboot.designpatterns.decorate;

/**
 * File Name: ShapeDecorator
 * Package Name: com.springboot.designPatterns.decorate
 * Date: 2020/3/23 15:52
 * 抽象的装饰器
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
abstract class AbstractShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public AbstractShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
