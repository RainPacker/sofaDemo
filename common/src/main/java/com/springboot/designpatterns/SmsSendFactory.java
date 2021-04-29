package com.springboot.designpatterns;

/**
 * File Name: SmsSendFactory
 * Package Name: com.springboot.designPatterns
 * Date: 2020/3/23 10:19
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class SmsSendFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
