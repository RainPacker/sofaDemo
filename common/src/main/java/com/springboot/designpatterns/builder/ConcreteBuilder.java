package com.springboot.designpatterns.builder;

/**
 * File Name: ConcreteBuilder
 * Package Name: com.springboot.designPatterns.builder
 * Date: 2020/3/23 10:50
 * 建造者模式
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class ConcreteBuilder extends Builder {
    Computer computer = new Computer();

    @Override
    public void buildCPU() {
        computer.add("装CPU");
    }

    @Override
    public void buildMainBoard() {
        computer.add("装主板");
    }

    @Override
    public void buildHD() {
        computer.add("装硬盘");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
