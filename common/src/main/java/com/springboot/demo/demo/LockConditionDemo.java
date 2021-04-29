/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.springboot.demo.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 需求实现：使用多线程实现 连续输出AA 5次 BB 10 次 CC 15次  重复10组
 *
 * @author rain
 * @version : LockConditionDemo.java, v 0.1 2021年03月02日 上午10:31 rain Exp $
 */
public class LockConditionDemo {

    ReentrantLock lock = new ReentrantLock();

    Condition A      = lock.newCondition();
    Condition B      = lock.newCondition();
    Condition C      = lock.newCondition();
    //线程变量
    int       number = 1;

    public void print5() {
        lock.lock();

        try {
            //
            while (number != 1) {
                A.await();
            }
            for (int i = 0; i < 5 ; i++) {
                System.out.print("A");
            }
            number = 2;
            B.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 打印10次B
     * 先
     */
    public  void  print10(){
        lock.lock();
        try {
            while (number !=2){
                B.await();
            }
            for (int i = 0; i < 10 ; i++) {
                System.out.print("B");
            }
            number =3;
            C.signal();

        } catch (Exception e) {

        }
        finally {
            lock.unlock();
        }

    }

    public  void  print15(){
        lock.lock();
        try {
        while (number !=3){
            C.await();
        }
            for (int i = 0; i < 15 ; i++) {
                System.out.print("C");
            }
            System.out.print("\n");
            number =1;


        A.signal();
        } catch (Exception e) {
        lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockConditionDemo lockConditionDemo  =new LockConditionDemo();



            //定义三个线程
            new Thread(()->{
                for (int i = 0; i < 10 ; i++) {
                    lockConditionDemo.print5();

                }
            }
                    ,"A").start();
            new Thread(()->{
                for (int i = 0; i < 10 ; i++) {
                    lockConditionDemo.print10();

                }
            },"B").start();
            new Thread(()->{
                for (int i = 0; i < 10 ; i++) {
                    lockConditionDemo.print15();

                }
            },"C").start();




    }
}
