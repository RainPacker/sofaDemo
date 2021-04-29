/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.springboot.demo.jmm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author rain
 * @version : VolatileDemo.java, v 0.1 2021年02月20日 上午9:56 rain Exp $
 */
public class VolatileDemo {

    public static void main(String[] args) {
        MyData myData  =new MyData();
        //多个线程
        for (int i = 0; i <20 ; i++) {
            new Thread(()->{
                for (int j = 0; j <1000 ; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();

                }

            },String.valueOf(i)).start();

        }
       //保证上线程都执行结束
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println("the final number is :"+myData.number+" "+myData.atomicInteger);


    }

    //volatile 可见性保证
    public static void seeOKbyVolatile() {
        MyData myData = new MyData();
        //子线程操作变量
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" coming...");
            try {
                TimeUnit.SECONDS.sleep(6);
                myData.addTo60();
                System.out.println("myData numer update to "+myData.number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"AA").start();
        //注意： 如果变量number 没有vlatile 修饰 主线程将无法感应的number值发生变化 一直循环中
        while (myData.number==0){
        //
        }
        System.out.println(Thread.currentThread().getName()+"mission over..."+myData.number);
    }

}
  class  MyData{
    volatile int number =0;
    AtomicInteger atomicInteger = new AtomicInteger();
    public  void addTo60(){
        this.number =60;
    }
    //注意：number 是添加vlatile 的但是不保证原子性
    public   void  addPlusPlus(){
        number++;
    }
    public  void  addAtomic(){
        atomicInteger.getAndIncrement();
    }
}
