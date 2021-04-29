package com.springboot.demo.forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * Project Name: demo
 * File Name: CountDemo
 * Package Name: com.springboot.demo.forkJoin
 * Date: 2020/3/16 12:33
 * Author: Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class CountDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int start = 0;
        int end = 20000000;
        long starTime = System.currentTimeMillis();
        CountTask task = new CountTask(start, end);
        ForkJoinPool pool = ForkJoinPool.commonPool();
        Future<Integer> ans = pool.submit(task);
        int sum = ans.get();
        long usedTime = System.currentTimeMillis() - starTime;
        System.out.println("和为"+sum+"用时："+usedTime+"ms");

        int j = 1 >> 1;
        int k = 3 >> 1;
        int l = 10 >> 1;
        System.out.printf("" + j + " k:" + k + " l:" + l);

    }
}
