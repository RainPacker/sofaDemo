/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.demo;

import com.facade.service.HelloService;
import com.springboot.DemoApplication;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author rain
 * @version : TestHelloService.java, v 0.1 2020年08月05日 09:29 rain Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestHelloService {
    @Reference(version = "1.0.0", url = "dubbo://127.0.0.1:20881")
    private HelloService helloService;

    @Test
    public void testHelloService() {

        String s = helloService.sayHello("333333");
        System.out.println(s);
    }
}
