/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.designpatterns.decorate;

/**
 * 鸡蛋类（具体装饰者角色）
 * @author rain
 * @version : Egg.java, v 0.1 2020年12月29日 下午3:01 rain Exp $
 */
public class Egg extends  Garnish {

    public Egg(FastFood fastFood) {
        super(fastFood, 1, "鸡蛋");
    }

    float cost() {
        return getPrice()+getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return super.getDesc()+getFastFood().getDesc();
    }
}
