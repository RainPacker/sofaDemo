/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.demo.dubbo;

import com.demo.benlife.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author rain
 * @version : DubboProvider.java, v 0.1 2020年05月02日 22:14 rain Exp $
 */
@SpringBootApplication
public class DubboProvider {
    public static void main(String[] args) {
        SpringApplication.run(DubboProvider.class, args);
    }



    @Bean(initMethod ="myInit" ,destroyMethod ="myDestory")
    public Person getPerson(){
        return  new Person();
    }
}