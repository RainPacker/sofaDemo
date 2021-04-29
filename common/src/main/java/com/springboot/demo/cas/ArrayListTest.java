/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.springboot.demo.cas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author rain
 * @version : ArrayListTest.java, v 0.1 2021年02月24日 上午10:05 rain Exp $
 */
public class ArrayListTest {

    public static void main(String[] args) {
       // 线程不安全 则会出现java.util.ConcurrentModificationException
        List<String> list = new ArrayList();//线程不安全
        List<String> list3 = Collections.synchronizedList(new ArrayList<>());//线程安全
        //写时复制
        List<String> list4  = new CopyOnWriteArrayList<>();
        List<String> list2 = new Vector<>();//线程安全


        for (int i = 0; i <50 ; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString());
                System.out.println(list);
            },String.valueOf(i)).start();

        }

    }
}
