/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cache.demo;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.matchers.JUnitMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author rain
 * @version : MvcTest.java, v 0.1 2020年12月03日 上午10:09 rain Exp $
 */
public class MvcTest extends BaseTest {

    @Autowired
    private MockMvc mockMvc;




    @Test
    public  void  test1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/getItem/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().string(CoreMatchers.containsString("\"itemId\":\"id1\""))).andReturn();


    }
}