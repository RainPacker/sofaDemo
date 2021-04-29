/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.demo.benlife;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Period;

/**
 * @author rain
 * @version : AppConfig.java, v 0.1 2020年08月17日 11:30 rain Exp $
 */

@Configuration
public class AppConfig {

    @Bean(initMethod ="myInit" ,destroyMethod ="myDestory")
    public Person getPerson(){
        return  new Person();
    }
}