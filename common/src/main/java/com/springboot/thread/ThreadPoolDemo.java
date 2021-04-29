package com.springboot.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * File Name: ThreadPoolDemo
 * Package Name: com.springboot.thread
 * Date: 2020/3/24 11:13
 *
 * @author Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {

        // ExecutorService executorService = Executors.newCachedThreadPool();
        // ExecutorService executorService = new ThreadPoolExecutor(4,4,new LinkedBlockingDeque<>(10))
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        int cpuNums = Runtime.getRuntime().availableProcessors();
        System.out.println("availableProcessors:" + cpuNums);
        ExecutorService executorService = new ThreadPoolExecutor(cpuNums * 2, cpuNums * 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        //  singleThreadPool.execute(()-> System.out.println(Thread.currentThread().getName()));
        // singleThreadPool.shutdown();
        Future<Integer> submit = executorService.submit(new MyTask());
        executorService.shutdown();
        try {
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
