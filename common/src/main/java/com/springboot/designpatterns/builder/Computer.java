package com.springboot.designpatterns.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * File Name: Computer
 * Package Name: com.springboot.designPatterns.builder
 * Date: 2020/3/23 10:27
 * 建造者模式
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class Computer {

    public List<String> parts = new ArrayList<>();

    public void add(String part) {
        parts.add(part);
    }

    public void print() {
        for (int i = 0; i < parts.size(); i++) {
            System.out.println("组件:" + parts.get(i) + "装好了...");
        }
        System.out.println("电脑组装完毕...");
    }

}
