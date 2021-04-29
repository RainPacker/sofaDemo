/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.springboot.demo.demo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author rain
 * @version : SemaphoreDemo.java, v 0.1 2021年02月28日 上午9:28 rain Exp $
 */
public class SemaphoreDemo {




    public static void main(String[] args) {
        Semaphore semaphore =new Semaphore(3);
        for(int i =0; i<=10;i++){

            new Thread(()->{
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"获取到车位");
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+"驶离车位");
                semaphore.release();

            },String.valueOf(i)).start();
        }
    }

}
