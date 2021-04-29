/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.zyy.sofa.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @author rain
 * @version : MyPreciseShardingAlgorithm.java, v 0.1 2020年06月19日 15:53 rain Exp $
 */
@Slf4j
public class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {

        for (String name : collection) {

            //订单号取模加1 与 订单表t_order_1 和 t_order_2的尾号做比对，如相等，就直接返回t_order_1 或 t_order_2
            String preStr = String.valueOf(preciseShardingValue.getValue());
            System.out.println(preStr);
            log.info("lpreStr:" + preStr);
            preStr = preStr.substring(preStr.length() - 1, preStr.length());
            Long preL = Long.valueOf(preStr);
            log.info("last str" + preStr);

            if (name.endsWith(String.valueOf(preL % 3))) {
                log.info("name:" + name);
                return name;
            }
        }
        return null;

    }
}