/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.springboot.demo.jmm;

/**
 * @author rain
 * @version : SingledDemo.java, v 0.1 2021年02月20日 下午2:19 rain Exp $
 */
public class SingledDemo {
    private static volatile    SingledDemo instance =null;
    private SingledDemo(){
        System.out.println(Thread.currentThread().getName()+" 执行SingleDemo");
    }
    //DCL 双端检测
    public    static  SingledDemo  getInstance(){
        if(instance ==null){
            synchronized (SingledDemo.class){
                if(instance ==null){
                    instance = new SingledDemo();
                }

            }

        }
        return  instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {

            new Thread(SingledDemo::getInstance,String.valueOf(i)).start();
        }
    }
}
