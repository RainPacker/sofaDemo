/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.designpatterns.decorate;

/**
 * 培根（具体装饰角色）
 * @author rain
 * @version : Bacon.java, v 0.1 2020年12月29日 下午3:03 rain Exp $
 */
public class Bacon  extends  Garnish{
    public Bacon(FastFood fastFood ) {
        super(fastFood, 2, "培根");
    }

    float cost() {
        return getPrice()+ getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return super.getDesc()+getFastFood().getDesc();
    }
}
