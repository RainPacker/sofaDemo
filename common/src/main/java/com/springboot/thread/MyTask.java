package com.springboot.thread;

import java.util.concurrent.Callable;

/**
 * File Name: MyTask
 * Package Name: com.springboot.thread
 * Date: 2020/3/24 11:05
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class MyTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程执行" + Thread.currentThread().getName());
        int i = 0;
        for (i = 0; i < 100; i++) {
            i++;
        }
        return i;

    }
}
