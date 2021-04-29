/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.springboot.demo.lock;

import org.apache.cxf.binding.soap.Soap11;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author rain
 * @version : ReadWriteLockDemo.java, v 0.1 2021年02月26日 下午3:21 rain Exp $
 */
public class ReadWriteLockDemo {

    private ReentrantReadWriteLock readWriteLock =new ReentrantReadWriteLock();
    private Map<String,String> map =new HashMap<>();




    public  void writeVal(String key,String val){

        readWriteLock.writeLock().lock();
       
        try{
            System.out.println(Thread.currentThread().getName()+"正在写入\t"+key);
            map.put(key,val);

            System.out.println(Thread.currentThread().getName()+"写入完成");
        }finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public  void readVal(String key){
        readWriteLock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"正在读");
            String res = map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取完成\t"+res);

        }finally {
            readWriteLock.readLock().unlock();
        }

    }

    public static void main(String[] args) {
           ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();
        for (int i = 0; i <5 ; i++) {
            final  int tempI = i;
            new Thread(()->{
                readWriteLockDemo.writeVal(tempI+"",tempI+"");
            },String.valueOf(i)).start();
        }
        for (int i = 0; i <5 ; i++) {
            final  int tempI = i;
            new Thread(()->{
                readWriteLockDemo.readVal(tempI+"");
            },String.valueOf(i)).start();
        }
    }
}
