/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.springboot.demo.cas;

import com.springboot.jdk8.Product;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author rain
 * @version : CasDemo.java, v 0.1 2021年02月20日 下午2:42 rain Exp $
 */
public class CasDemo {
    static  AtomicReference<Integer> atomicReferencei = new AtomicReference<>(1);
    static  AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);
    public static void main(String[] args) {
        //cas 是什么 比较并交换
        AtomicInteger atomicInteger = new AtomicInteger(5);
        boolean b = atomicInteger.compareAndSet(5, 2021);
        System.out.println(b);

        //cas 具有aba 的问题



        Product p1= new Product(10L, 1, new BigDecimal(10), "菜果", "水果");
        Product p2= new Product(10L, 1, new BigDecimal(10), "菜果", "水果");
        //原子引用
        AtomicReference<Product>  atomicReference = new AtomicReference<>();
        atomicReference.set(p1);
        System.out.println( atomicReference.compareAndSet(p1, p2)+"\t"+atomicReference.get().toString());
        System.out.println( atomicReference.compareAndSet(p1, p2)+"\t"+atomicReference.get().toString());
        //#####ABA 问题模拟出现
       //aba问题
        new Thread(()->{
            atomicReferencei.compareAndSet(1,2);
            atomicReferencei.compareAndSet(2,1);

        },"t1").start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReferencei.compareAndSet(1,2020)+"\t"+atomicReferencei.get());
        },"t2").start();

        //###ABA 问题解决

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"第一次获取版本号："+stamp);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean  b1 = atomicStampedReference.compareAndSet(100, 2021, 1, atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName()+"第二次获取版本号："+atomicStampedReference.getStamp()+"\t"+b1);
            boolean b2 = atomicStampedReference.compareAndSet(2021, 100, 2, atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName()+"第三次获取版本号："+atomicStampedReference.getStamp()+"\t"+b2);

        },"t3").start();
        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"第一次获取版本号："+stamp);
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = atomicStampedReference.compareAndSet(100, 2021, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName()+"修改结果："+result+"\t"+ atomicStampedReference.getReference()+"\t 最新版本号"+atomicStampedReference.getStamp());


        },"t4").start();


    }
}
