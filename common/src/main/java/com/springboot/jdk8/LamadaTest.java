/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.jdk8;

/**
 * @author rain
 * @version : LamadaTest.java, v 0.1 2020年08月24日 14:52 rain Exp $
 */
public class LamadaTest {

    public static void  test(String word,IlamaTool ilamaTool){
           ilamaTool.test(word);
    }

    public static void main(String[] args) {
            test("hello world", System.out::println);

    }
}