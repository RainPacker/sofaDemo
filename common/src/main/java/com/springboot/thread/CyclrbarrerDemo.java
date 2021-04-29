/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.thread;

import java.util.Date;
import java.util.concurrent.CyclicBarrier;

/**
 * @author rain
 * @version : CyclrbarrerDemo.java, v 0.1 2020年07月29日 21:58 rain Exp $
 */
public class CyclrbarrerDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("开始分析。。。");
        });
        new DataImportThread(cyclicBarrier, "file1").start();
        new DataImportThread(cyclicBarrier, "file2").start();
        new DataImportThread(cyclicBarrier, "file3").start();
        new DataImportThread(cyclicBarrier, "file4").start();
        new DataImportThread(cyclicBarrier, "file5").start();
        new DataImportThread(cyclicBarrier, "file6").start();
    }
}