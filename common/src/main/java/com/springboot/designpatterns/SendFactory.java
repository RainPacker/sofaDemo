package com.springboot.designpatterns;

/**
 * File Name: SendFactory
 * Package Name: com.springboot.designPatterns
 * Date: 2020/3/23 10:02
 * 多个工厂方法模式
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class SendFactory {

    public Sender produceMail() {
        return new MailSender();
    }

    public Sender produceSms() {
        return new SmsSender();
    }
}
