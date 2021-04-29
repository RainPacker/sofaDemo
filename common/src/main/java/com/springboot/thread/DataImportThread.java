/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author rain
 * @version : DataImportThread.java, v 0.1 2020年07月29日 21:58 rain Exp $
 */
public class DataImportThread extends Thread {
    public DataImportThread(CyclicBarrier cyclicBarrier, String path) {
        this.cyclicBarrier = cyclicBarrier;
        this.path = path;
    }

    private CyclicBarrier cyclicBarrier;
    private String        path;

    @Override
    public void run() {
        System.out.println("开始导入" + path + " 数据 ");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}