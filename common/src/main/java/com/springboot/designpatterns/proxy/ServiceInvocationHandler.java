package com.springboot.designpatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * File Name: ServiceInvocationHandler
 * Package Name: com.springboot.designPatterns.proxy
 * Date: 2020/3/23 14:32
 * 代理模式=动态代理
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class ServiceInvocationHandler implements InvocationHandler {
    /**
     * 被代理的对象
     */
    private Object srcObject;

    public ServiceInvocationHandler(Object srcObject) {
        this.srcObject = srcObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始执行" + method.getName() + "方法");
        //执行原对象的相关操作，容易忘记
        Object returnObj = method.invoke(srcObject, args);
        System.out.println(method.getName() + "方法执行完毕");
        return returnObj;
    }
}
