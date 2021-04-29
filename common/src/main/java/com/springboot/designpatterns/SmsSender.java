package com.springboot.designpatterns;

/**
 * File Name: SmsSender
 * Package Name: com.springboot.designPatterns
 * Date: 2020/3/23 09:56
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("This is sms sender...");
    }
}
