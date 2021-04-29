/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.designpatterns.decorate;

/**
 * 装饰者类(抽象装饰者角色)
 * @author rain
 * @version : Garnish.java, v 0.1 2020年12月29日 下午2:51 rain Exp $
 */
public abstract class Garnish extends  FastFood {


        private  FastFood fastFood;

    public Garnish(FastFood fastFood,float price, String desc) {
        super(price, desc);
        this.fastFood = fastFood;
    }

    /**
     * Getter method for property <tt>fastFood</tt>.
     *
     * @return property value of fastFood
     */
    public FastFood getFastFood() {
        return fastFood;
    }

    /**
     * Setter method for property <tt>fastFood</tt>.
     *
     * @param fastFood value to be assigned to property fastFood
     */
    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }
}
