package com.springboot.designpatterns.proxy;

/**
 * File Name: ProxyService
 * Package Name: com.springboot.designPatterns.proxy
 * Date: 2020/3/23 14:22
 * 静态代理
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class ProxyService implements IService {
    /**
     * 持有被代理对象的引用
     */
    private IService service;

    /**
     * 默认代理Service类
     */
    public ProxyService() {
        this.service = new Service();
    }

    /**
     * 也可以代理实现相同接口的其他类
     *
     * @param service
     */
    public ProxyService(IService service) {
        this.service = service;
    }

    @Override
    public void service() {
        System.out.println("开始执行service()方法");
        service.service();
        System.out.println("service()方法执行完毕");
    }
}
