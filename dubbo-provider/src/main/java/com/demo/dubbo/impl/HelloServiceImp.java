package com.demo.dubbo.impl;

import cn.hutool.core.date.DateUtil;
import com.facade.service.HelloService;
import org.apache.dubbo.config.annotation.Service;

/**
 * Project Name: demo
 * File Name: HelloServiceImp
 * Package Name: com.springboot.dubbo.imp
 * Date: 2020/3/17 16:57
 * Author: Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
@Service(version = "1.0.0",interfaceClass = HelloService.class )
public class HelloServiceImp implements HelloService {
    /**
     * sayHello
     *
     * @param s
     * @return
     */
    @Override
    public String sayHello(String s) {
        System.out.println(s);
        return String.format("hello,%s :%s", s, DateUtil.now());
    }

}
