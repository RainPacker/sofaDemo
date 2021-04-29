/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.jdk8;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author rain
 * @version : StreamTest.java, v 0.1 2020年07月29日 16:59 rain Exp $
 */
public class StreamTest {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
       // List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).filter(e->e.length()>2).collect(Collectors.toList());
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).filter(e->e.length()>2).collect(Collectors.toCollection(ArrayList::new));

        filtered.forEach(System.out::println);



        Product prod1 = new Product(1L, 1, new BigDecimal("15.5"), "面包", "零食");
        Product prod2 = new Product(2L, 2, new BigDecimal("20"), "饼干", "零食");
        Product prod3 = new Product(3L, 3, new BigDecimal("30"), "月饼", "零食");
        Product prod4 = new Product(4L, 3, new BigDecimal("10"), "青岛啤酒", "啤酒");
        Product prod5 = new Product(5L, 10, new BigDecimal("15"), "百威啤酒", "啤酒");
        List<Product> prodList = Lists.newArrayList(prod1, prod2, prod3, prod4, prod5);
        //按照类目分组
        Map<String, List<Product>> collect1 = prodList.stream().collect(Collectors.groupingBy(Product::getCategory));
        System.out.println(JSON.toJSONString(collect1));
        //按照属性类目分组
        Map<String, List<Product>> collect2 = prodList.stream().collect(Collectors.groupingBy(item -> item.getCategory() + item.getName()));
        System.out.println(JSON.toJSONString(collect2));
        //map
        List<Product> collect3 = prodList.stream().peek(item -> item.setName("test")).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect3));

        //分组求和
        Map<String, Integer> collect4 = prodList.stream().collect(
                Collectors.groupingBy(Product::getCategory, Collectors.summingInt(Product::getNum)));
        System.out.println(JSON.toJSONString(collect4));
         String e ="2020199998W";
        int c = e.charAt(e.length() - 1);
        System.out.println(c);
    }
}
