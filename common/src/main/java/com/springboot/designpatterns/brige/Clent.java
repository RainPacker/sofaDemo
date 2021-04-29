/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.designpatterns.brige;

/**
 * @author rain
 * @version : Clent.java, v 0.1 2020年12月29日 下午4:11 rain Exp $
 */
public class Clent {

    public static void main(String[] args) {
        OperatingSystem operatingSystem =new Mac(new AviFile());
        operatingSystem.play("战狼");
    }
}
