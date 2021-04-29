/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.springboot.demo.demo;

/**
 * @author rain
 * @version : StringDemo.java, v 0.1 2021年03月18日 下午4:33 rain Exp $
 */
public class StringDemo {

     public static void main(String[] args) {
          String s =new StringBuilder("58").append("tongcheng").toString();

          System.out.println(s);
          System.out.println(s.intern());
          System.out.println(s == s.intern());
          String s2 =  new StringBuilder("ja").append("va").toString();
          System.out.println(s2);
          System.out.println(s2.intern());
          System.out.println(s2 == s2.intern());
     }

}
