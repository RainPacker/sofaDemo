package com.springboot.designpatterns.builder;

/**
 * File Name: Director
 * Package Name: com.springboot.designPatterns.builder
 * Date: 2020/3/23 10:58
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class Director {

    public void construct(Builder builder) {
        builder.buildCPU();
        builder.buildMainBoard();
        builder.buildHD();
    }
}
