/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.thread;

import java.util.concurrent.Semaphore;

/**
 * @author rain
 * @version : SemaphoreDemo.java, v 0.1 2020年07月29日 17:55 rain Exp $
 */
public class SemaphoreDemo {

    static class Car extends Thread {
        private int       num;
        private Semaphore semaphore;

        public Car(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            //获取车位
            try {
                semaphore.acquire();
                System.out.println("第" + num + "车抢占一个车位");
                Thread.sleep(2000);
                System.out.println("第" + num + "车开走喽");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Car(i, semaphore).start();

        }
    }

}