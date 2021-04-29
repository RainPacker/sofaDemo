package com.es; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */


import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author rain
 * @version : com.redis.test.BaseTest.java, v 0.1 2020年10月15日 17:16 rain Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EsApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTest {
}