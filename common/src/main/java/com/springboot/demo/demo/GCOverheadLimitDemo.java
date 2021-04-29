/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.springboot.demo.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * java.lang.OutOfMemoryError: GC overhead limit exceeded
 * @author rain
 * @version : GCOverheadLimitDemo.java, v 0.1 2021年03月09日 下午5:36 rain Exp $
 */
public class GCOverheadLimitDemo {
    /**
     * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+UseSerialGC   DefNew +Tenured  串行
     * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+UseParNewGC   ParNew +Serial Old  并行+ 串行
     * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+UseParallelGC   PSYoungGen +ParOldGen   并行+并行
     * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+UseParallelOldGC   PSYoungGen +ParOldGen   并行+并行
     * 并发
     * //标记清楚  并发高 产生碎片
     *  -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC
     *  G1
     *   -Xms10m -Xmx10m -XX:+PrintCommandLineFlags -XX:+PrintGCDetails -XX:+UseG1GC
     *
     * @param args
     */

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i =0;
        try {
            while (true){
                list.add(String.valueOf(++i).intern());
            }
        } catch (Exception e) {
            System.out.println("********"+i);
            e.printStackTrace();
            throw e;

        }
    }
}
