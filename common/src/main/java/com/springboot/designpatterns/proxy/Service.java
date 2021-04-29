package com.springboot.designpatterns.proxy;

/**
 * File Name: Service
 * Package Name: com.springboot.designPatterns.proxy
 * Date: 2020/3/23 14:21
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class Service implements IService {
    @Override
    public void service() {
        System.out.println("被代理对象执行相关操作");
    }
}
