package com.springboot.designpatterns;

/**
 * File Name: MailSender
 * Package Name: com.springboot.designPatterns
 * Date: 2020/3/23 09:55
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("This is mail sender...");
    }
}
