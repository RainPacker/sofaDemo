package com.springboot.designpatterns;

/**
 * File Name: MailSendFactory
 * Package Name: com.springboot.designPatterns
 * Date: 2020/3/23 10:17
 * 抽象工厂模式
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class MailSendFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
