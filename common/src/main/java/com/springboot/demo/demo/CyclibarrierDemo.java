/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.springboot.demo.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author rain
 * @version : CyclibarrierDemo.java, v 0.1 2021年02月26日 下午9:56 rain Exp $
 */
public class CyclibarrierDemo {


    public static void main(String[] args) {

        //等到目标
        CyclicBarrier cyclicBarrier =new CyclicBarrier(7,()->{
            System.out.println("召换神龙。。。");
        });
        for(int i =1; i<=7;i++){
            final  int tempInt = i;
            new Thread(()->{
                System.out.println("收集到第"+tempInt+"个龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

    }
}
