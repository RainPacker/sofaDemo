/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.designpatterns.decorate;

/**
 * 快餐（抽象构件角色）
 * @author rain
 * @version : FastFood.java, v 0.1 2020年12月29日 下午2:31 rain Exp $
 */
public abstract class FastFood {

    private float price;
    private String desc;

    public  FastFood(){

    }
    public FastFood(float price, String desc) {
        this.price = price;
        this.desc = desc;
    }

    /**
     * Getter method for property <tt>price</tt>.
     *
     * @return property value of price
     */
    public float getPrice() {
        return price;
    }

    /**
     * Setter method for property <tt>price</tt>.
     *
     * @param price value to be assigned to property price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Getter method for property <tt>desc</tt>.
     *
     * @return property value of desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Setter method for property <tt>desc</tt>.
     *
     * @param desc value to be assigned to property desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    abstract float cost();
}
