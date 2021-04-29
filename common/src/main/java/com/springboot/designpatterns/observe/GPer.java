/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.designpatterns.observe;

import java.util.Observable;

/**
 * JDK 观察者模式
 *
 * @author rain
 * @version : GPer.java, v 0.1 2020年07月11日 09:06 rain Exp $
 */
public class GPer extends Observable {
    private        String name = "GPer生态圈";
    private static GPer   gPer = null;

    private GPer() {
    }

    public static GPer getInstance() {
        if (gPer == null) {
            gPer = new GPer();
        }
        return gPer;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    public void publishQuestion(Question question) {
        System.out.println(question.getUserName() + "在" + this.name + "提交了一个问题");
        setChanged();
        notifyObservers(question);
    }
}