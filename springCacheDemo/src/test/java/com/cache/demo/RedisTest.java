/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cache.demo;

import com.cache.demo.utils.RedisUtil;
import org.junit.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author rain
 * @version : RedisTest.java, v 0.1 2020年10月15日 17:15 rain Exp $
 */
@Resource
public class RedisTest extends BaseTest {
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private RedissonClient redissonClient;

    @Test
    public  void testSadd(){
        Long start=System.currentTimeMillis();

        for(int i=0 ; i<1000000; i++){
            RedisUtil.sAdd("set_a",i+"");
        }
        Long end=System.currentTimeMillis();
        System.out.println("用时"+(end-start));
    }

    @Test
    public   void  testRedisClient(){
        int  i=0;
        RLock lock = redissonClient.getLock("lock");//redission 分布式锁

        try {
            lock.lock();
            i= i+1;
            System.out.println(i);

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
}