/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.designpatterns.decorate;

/**
 * 炒饭（具体构件角色）
 * @author rain
 * @version : FireRice.java, v 0.1 2020年12月29日 下午2:34 rain Exp $
 */
public class FireRice  extends  FastFood{



    public FireRice(){
        super(10, "炒饭");
    }

    public float cost() {
        return getPrice();
    }
}
