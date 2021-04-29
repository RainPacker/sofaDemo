/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author rain
 * @version : CoundownLathcTest.java, v 0.1 2020年07月29日 17:27 rain Exp $
 */
public class CoundownLathcTest extends Thread {

    static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new CoundownLathcTest().start();
        }
        countDownLatch.await();

    }

    @Override
    public void run() {

        countDownLatch.countDown();
        System.out.println(Thread.currentThread().getName() + "");
    }
}
