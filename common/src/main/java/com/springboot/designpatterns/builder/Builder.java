package com.springboot.designpatterns.builder;

/**
 * File Name: Builder
 * Package Name: com.springboot.designPatterns.builder
 * Date: 2020/3/23 10:46
 * 建造者模式
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
abstract class Builder {
    /**
     * 第一步：装CPU
     */
    public abstract void buildCPU();

    /**
     * 第二步：装主板
     */
    public abstract void buildMainBoard();

    /**
     * 第三步：装硬盘
     */
    public abstract void buildHD();

    /**
     * 获得组装好的电脑
     *
     * @return
     */
    public abstract Computer getComputer();
}
