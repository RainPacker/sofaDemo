/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.designpatterns.observe;

import java.util.Observable;
import java.util.Observer;

/**
 * @author rain
 * @version : Teacher.java, v 0.1 2020年07月11日 09:18 rain Exp $
 */
public class Teacher implements Observer {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        GPer gper = (GPer) o;
        Question question = (Question) arg;
        System.out.println("=====================");
        System.out.println(name + " 老师你好，\n 你收到一个来自" + gper.getName() + "的 提问，问题内容\n"
                + question.getContent() + " 提问人：" + question.getUserName());
    }
}