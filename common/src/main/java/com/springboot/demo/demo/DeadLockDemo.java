/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.springboot.demo.demo;

import java.util.concurrent.TimeUnit;

/**
 * @author rain
 * @version : DeadLockDemo.java, v 0.1 2021年03月08日 下午2:09 rain Exp $
 */

class MyResource implements Runnable {
    private String lockA;
    private String lockB;

    public MyResource(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"已经持有"+lockA+"的锁尝试获取"+lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"已经持有"+lockA+"的锁尝试获取"+lockB);

            }
        }

    }
}
public class DeadLockDemo {

    public static void main(String[] args) {
        String lockA= "lockA";
        String lockB ="lockB";
        new Thread(new MyResource(lockA,lockB),"AA").start();
        new Thread(new MyResource(lockB,lockA),"BB").start();
    }

}
