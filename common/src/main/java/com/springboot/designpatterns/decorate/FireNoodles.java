/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.designpatterns.decorate;

/**
 * 炒面（具体构件）
 * @author rain
 * @version : FireNoodles.java, v 0.1 2020年12月29日 下午2:43 rain Exp $
 */
public class FireNoodles extends  FastFood {
    public FireNoodles() {
        super(11,"炒面");
    }

    float cost() {
        return getPrice();
    }

}
