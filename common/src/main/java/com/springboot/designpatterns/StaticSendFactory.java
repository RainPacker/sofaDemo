package com.springboot.designpatterns;

/**
 * File Name: StaticSendFactory
 * Package Name: com.springboot.designPatterns
 * Date: 2020/3/23 10:07
 * 静态工厂方法模式    提供静态方法不用实例化调用
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class StaticSendFactory {
    public static Sender produceMail() {
        return new MailSender();
    }

    public static Sender produceSms() {
        return new SmsSender();
    }
}
