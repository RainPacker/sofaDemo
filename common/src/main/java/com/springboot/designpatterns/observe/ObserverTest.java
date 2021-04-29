/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.designpatterns.observe;

/**
 * @author rain
 * @version : ObserverTest.java, v 0.1 2020年07月11日 09:30 rain Exp $
 */
public class ObserverTest {
    public static void main(String[] args) {
        GPer gPer = GPer.getInstance();
        Teacher tom = new Teacher("tom");
        Question question = new Question();
        question.setUserName("xiaoming");
        question.setContent("观者者模式适用哪些范围");
        gPer.addObserver(tom);
        gPer.publishQuestion(question);
    }
}