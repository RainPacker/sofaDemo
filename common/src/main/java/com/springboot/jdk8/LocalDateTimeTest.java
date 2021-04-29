/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.jdk8;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rain
 * @version : LocalDateTimeTest.java, v 0.1 2020年08月11日 16:05 rain Exp $
 */
public class LocalDateTimeTest {

    public static void main(String[] args) {

        LocalDate localDate=LocalDate.now();
        System.out.println(localDate);
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDate localDate1=LocalDate.of(2019,11,11);
        System.out.println(localDate1);

        LocalTime localTime=LocalTime.now();
        System.out.println(localTime);
        localDateTime.plusYears(1);
        localDateTime.minus(1, ChronoUnit.DAYS);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");



      LocalDate localDate2=  LocalDate.now();
        String format = formatter.format(localDate2);
        System.out.println(format);

        //字符转成LocalDateTime
        String time="2018-05-18 23:24:25";
        DateTimeFormatter formater2=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(time, formater2);
        System.out.println(parse);
        String format1 = formatter.format(parse);
        String format12 = formater2.format(parse);
        System.out.println(format1);
        System.out.println(format12);
        //date 转 LocalDateTime

        Date date=new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(instant, zoneId);
        System.out.println(localDateTime1);
        System.out.println(formater2.format(localDateTime1));

        //localDateTime  转 Date
        LocalDateTime localDateTime3=LocalDateTime.now();
        Instant instant1 = localDateTime3.atZone(zoneId).toInstant();
        Date from = Date.from(instant1);
        System.out.println(from);

        //比较时间差
      //  在jdk1.8以后，对表示日期时间的类型进行了重新分类，这里出现了2个新的类，Duraction 和Period
       // Duraction表示：时间的区间，用来度量秒和纳秒之间的时间值
       // Period表示：一段时间的区间，用来度量年月日和几天之间的时间值

        LocalDate birthday=LocalDate.of(1991,1,30);
        LocalDate now=LocalDate.now();
        System.out.println("当前时间为："+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        Period period=Period.between(birthday,now);
        System.out.println(period);
        System.out.println(period.getYears()+"年"+period.getMonths()+"个月"+period.getDays()+"天");
        System.out.println(now.toEpochDay()-birthday.toEpochDay());

        Map map =new HashMap<>();
        map.put("1",1);
        map.put("2",1);
        map.put("3",1);

       testSlot();
       method(1,"2");




    }


    public static void testSlot() {
        int a,b;
        {
            int d = 11;
            int e = 22;
            int f = d * e;
            if((a=5)<10&&(b=7)>0){
                f=d*e;

            }
        }


        //int g = a +b;
    }

    public static void method(int argOne, String argTwo) {
        int I1 = 1, I2 = 2, I3 = 3, I4 = 4;
        { // L1, L2再代码块外面不可见。其使用的变量槽可以被后面的I1,I2,I3和I4复用
            long L1 = 1L, L2 = 2L;
            System.out.println(L2);
        }
       // int I1 = 1, I2 = 2, I3 = 3, I4 = 4;
    }


}
