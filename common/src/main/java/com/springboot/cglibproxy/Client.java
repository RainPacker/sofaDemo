/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.cglibproxy;

/**
 * @author rain
 * @version : Client.java, v 0.1 2020年12月25日 下午2:03 rain Exp $
 */
public class Client {

    public static void main(String[] args) {
        //模拟用户从代理点买火车票
            ProxyFactory  proxyFactory =new ProxyFactory();
        Transstation transstation = proxyFactory.getObj();
        transstation.sellTicket();
    }
}
