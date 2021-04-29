/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.springboot.demo.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 手写自旋锁
 * @author rain
 * @version th: SpinLockDemo.java, v 0.1 2021年02月26日 下午2:41 rain Exp $
 */
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void  myLock(){

        System.out.println(Thread.currentThread().getName()+"\t"+"comming");
        Thread thread = Thread.currentThread();

        while (!atomicReference.compareAndSet(null,thread)){
           // System.out.println(thread.getName()+"waiting...");
        }

    }

    public  void  myUnLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(thread.getName()+"invoke myUnLock...");
    }

    public static void main(String[] args) throws InterruptedException {
         SpinLockDemo spinLockDemo = new SpinLockDemo();

         new Thread(()->{
             spinLockDemo.myLock();
             try {
                 TimeUnit.SECONDS.sleep(3);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             spinLockDemo.myUnLock();

         },"t1").start();

         TimeUnit.SECONDS.sleep(1);
         new Thread(()->{
             spinLockDemo.myLock();

             spinLockDemo.myUnLock();
         },"t2").start();
    }
}
