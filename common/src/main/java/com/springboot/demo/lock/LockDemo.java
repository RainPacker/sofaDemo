/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.springboot.demo.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author rain
 * @version : LockDemo.java, v 0.1 2021年02月26日 下午1:42 rain Exp $
 */
public class LockDemo {
    public static void main(String[] args) throws InterruptedException {

        Phone phone = new Phone();
        //synchronized 锁也是可重入锁
        //同一线程在外部获取锁的时候，在进入内层方法会自动获取锁的
        new Thread(phone::sendSMS,"t1").start();
        new Thread(phone::sendSMS,"t2").start();
        TimeUnit.SECONDS.sleep(2);

        new Thread(phone,"t3").start();
        new Thread(phone,"t4").start();


    }
}
class Phone implements  Runnable {

    public synchronized   void  sendSMS(){
        System.out.println(Thread.currentThread().getId()+"\tsendSMS");
        sendEamil();
    }

    public synchronized  void  sendEamil(){
        System.out.println(Thread.currentThread().getId()+"\t####sendEamil");
    }
    ReentrantLock lock = new ReentrantLock();//非公平锁

    @Override
    public void run() {
        t1();
    }
    public  void  t1(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t invoke t1");
            t2();
        }finally {
            lock.unlock();
        }
    }
    public  void  t2(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t###invoke t2");

        }finally {
            lock.unlock();
        }
    }

}
