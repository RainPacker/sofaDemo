/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.springboot.demo.demo;

import org.apache.commons.lang3.StringUtils;

import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author rain
 * @version : BlockQueenDemo.java, v 0.1 2021年03月02日 下午1:35 rain Exp $
 */
class  MyResouce {
    private volatile  boolean FLAG =true;//生产消费标记

    private AtomicInteger atomicInteger =new AtomicInteger();
    private  BlockingQueue<String>  blockingQueue=null;



    public MyResouce(BlockingQueue queue) {
        this.blockingQueue = queue;
        System.out.println(blockingQueue.getClass().getName());
    }

    //生产者
    public  void  produces() throws InterruptedException {


        int i ;
        while (FLAG){
             i= atomicInteger.incrementAndGet();
            boolean offer = blockingQueue.offer(i + "", 2, TimeUnit.SECONDS);
            if(offer){
                System.out.println(Thread.currentThread().getName()+"\t生产成功--"+i);
            }else {
                System.out.println(Thread.currentThread().getName()+"\t生产制作--"+i);
            }

        }
        System.out.println();
        System.out.println();
        System.out.println("停止生产");

    }
    public  void consume() throws InterruptedException {
        String res;
        while (FLAG){
             res = blockingQueue.poll(2, TimeUnit.SECONDS);
             if(res==null|| StringUtils.equalsIgnoreCase(res,"")){
                 FLAG =false;
                 System.out.println(Thread.currentThread().getName()+"\t 超过2秒没有取到"+res);
                 System.out.println();
                 System.out.println();
             }
            System.out.println(Thread.currentThread().getName()+"\t消费成功"+res);

        }

        System.out.println("消息结束");
    }

    public void stop() {
        this.FLAG = false;
    }
}

class MyCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(3);
        return 1024;
    }
}
public class BlockQueenDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println(Runtime.getRuntime().availableProcessors());

        long totalMemory = Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("totalMemory(-X:ms):"+totalMemory/(double)1024/1024+"M");
        System.out.println("maxMemory(-X:mx):"+maxMemory/(double)1024/1024+"M");

        // ExecutorService threadPool = Executors.newFixedThreadPool(5);//JDK 自提供应该慎用
        //超出最大 3+4 出现拒绝
       // /ExecutorService threadPool = new ThreadPoolExecutor(2,3,1,TimeUnit.SECONDS,new LinkedBlockingDeque<>(4),Executors.defaultThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());
      //  ExecutorService threadPool = new ThreadPoolExecutor(2,3,1,TimeUnit.SECONDS,new LinkedBlockingDeque<>(4),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        ExecutorService threadPool = new ThreadPoolExecutor(2,3,1,TimeUnit.SECONDS,new LinkedBlockingDeque<>(4),Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardOldestPolicy());
       // ExecutorService threadPool = new ThreadPoolExecutor(2,3,1,TimeUnit.SECONDS,new LinkedBlockingDeque<>(4),Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());


       try {
           for (int i = 0; i <9 ; i++) {
               threadPool.execute(()->{
                   System.out.println(Thread.currentThread().getName()+"办理业务");
               });
           }
       }finally {
           threadPool.shutdown();
       }

    }

    public static void futureTaskTest() throws InterruptedException, ExecutionException {
        FutureTask<Integer> task = new FutureTask(new MyCallable());
        new Thread(task).start();
        new Thread(task).start();//注意多个线程执行同一个task 只执行一次
        Integer integer = task.get();
        System.out.println(integer);
    }

    public static void testArrayBlockKingQueue() throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        System.out.println(queue);
        MyResouce myResouce = new MyResouce(queue);
        new Thread(()->{
            try {
                myResouce.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
        new Thread(()->{
            try {
                myResouce.produces();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();

        TimeUnit.SECONDS.sleep(5);
        myResouce.stop();
    }

}
