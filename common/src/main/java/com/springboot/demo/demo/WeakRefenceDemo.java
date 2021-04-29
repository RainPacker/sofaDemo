/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.springboot.demo.demo;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * @author rain
 * @version : WeakRefenceDemo.java, v 0.1 2021年03月08日 下午5:50 rain Exp $
 */
public class WeakRefenceDemo {

    public static void main(String[] args) {
        Object  o = new Object();
        //虚引用 需要配合 RefencQueen 使用
        ReferenceQueue<Object>  queue=new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o,queue);//创建了一个虚引用
       o =null;
        System.out.println(o);
        System.out.println(phantomReference.get());
        System.out.println(queue.poll());
        System.gc();

        System.out.println(o);
        System.out.println(phantomReference.get());
        System.out.println(queue.poll());
    }

    public static void weakHasMapTest() {
        //弱引用map
        WeakHashMap<Integer ,String> map = new WeakHashMap<>();
        Integer key = new Integer(111);
        String name = "weakHasMap";
        map.put(key, name);
        System.out.println(map);
        //
        key =null;
        System.out.println(map);
        System.gc();
        System.out.println(map);
    }

    public static void weakRefenceSample() {
        //弱引 gc会自动回收
        Object  o = new Object();
        WeakReference<Object> o1= new WeakReference<>(o);
        System.out.println(o);
        System.out.println(o1.get());
        o=null;
        System.gc();
        System.out.println("===========");
        System.out.println(o);
        System.out.println(o1.get());
    }
}
