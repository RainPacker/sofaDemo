/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.designpatterns.decorate;

/**
 * @author rain
 * @version 点餐: OderClient.java, v 0.1 2020年12月29日 下午3:05 rain Exp $
 */
public class OderClient {

    public static void main(String[] args) {
        //点一分炒饭
        FastFood food = new FireRice();

        //打印价格信息
        System.out.println(food.getDesc()+" "+food.cost()+"元");

        //为炒饭加一个鸡蛋
       food= new Egg(food);
        //为炒饭加一个培根
        food= new Bacon(food);

        //打印价格信息
        System.out.println(food.getDesc()+" "+food.cost()+"元");


    }
}
