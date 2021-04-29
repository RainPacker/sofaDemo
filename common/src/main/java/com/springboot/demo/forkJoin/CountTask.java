package com.springboot.demo.forkJoin;

import java.util.concurrent.RecursiveTask;

/**
 * Project Name: demo
 * File Name: CountTask
 * Package Name: com.springboot.demo.forkJoin
 * Date: 2020/3/16 11:06
 * Author: Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class CountTask extends RecursiveTask<Integer> {

    private int start;
    private int end;

    private static final int THRED_HOLD = 30;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= THRED_HOLD;
        if (canCompute) { // 不需要拆分
            for (int i = start; i <= end; i++) {
                sum += i;
            }

            System.out.println("thread: " + Thread.currentThread() + " start: " + start + " end: " + end);
        } else {
            int mid = (end + start) / 2;
            CountTask left = new CountTask(start, mid);
            CountTask right = new CountTask(mid + 1, end);
            //left.fork();
            //right.fork();
            invokeAll(left,right);

            sum = left.join() + right.join();
        }
        return sum;
    }
}
