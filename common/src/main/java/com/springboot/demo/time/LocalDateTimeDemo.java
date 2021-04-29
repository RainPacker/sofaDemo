package com.springboot.demo.time;

import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * Project Name: demo
 * File Name: DateDemo
 * Package Name: com.springboot.demo.time
 * Date: 2020/3/13 09:37
 * Author: Rain.zhang
 * Copyright (c) 2020,All Rights Reserved.
 */
public class LocalDateTimeDemo {
    static {

        Properties properties =new Properties();
        try {
            properties.load(LocalDateTimeDemo.class.getClassLoader().getResourceAsStream("webservice/webservice.properties"));

            System.out.println(properties);
            properties.list(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Properties sys =System.getProperties();
        sys.list(System.out);

    }

    public static void main(String[] args) {
        LocalDateTime rightNow = LocalDateTime.now();
        String date = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(rightNow);

        System.out.println(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        System.out.println(formatter.format(rightNow));
        //把 rightNow 转换成 Date
        ZoneId zoneId=ZoneId.systemDefault();
        Instant instant=rightNow.atZone(zoneId).toInstant();
        java.util.Date from = Date.from(instant);

        Map<String,String> map =new HashMap<>();
        map.put("a","a");
        map.put("b","b");
        map.put("c","c");
        map.put("d","d");

        for (Entry<String, String> entry : map.entrySet()) {

            String key = entry.getKey();
            String value = entry.getValue();

        }





    }

}
