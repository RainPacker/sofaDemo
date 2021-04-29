/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.springboot.demo;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author rain
 * @version : QuickSortDemo.java, v 0.1 2021年03月24日 上午9:41 rain Exp $
 */
public class QuickSortDemo {

    public static void main(String[] args) {
        Integer [] a = {1, 34, 5, 76, 8, 6, 9, 7, 6, 3};
        //对数组a 使用快速排序 法
       List<Integer> nums = new ArrayList<>(Arrays.asList(a));
      //  Collections.addAll(nums,a);
        System.out.println(JSON.toJSONString(nums));

        // quickSort(nums).forEach(System.out::println);
        System.out.println(JSON.toJSONString(quickSort(nums)));


    }
    public static List<Integer> quickSort(List<Integer> nums){

        if(nums.size()<2){
            return  nums;
        }
       int  mid  =  nums.size()>>1;
        int base = nums.get(mid);
        nums.remove(mid);//每次设定从中间取走一个 和剩下的数据进行比较，将比我大的放在右边，比base 小的放在左边 ，重复 直到全部数据 都比较完
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < nums.size() ; i++) {
            int  current = nums.get(i);
           if( nums.get(i)>base){
               right.add(current);
           }else{
               left.add(current);
           }

        }
        List<Integer> target = new ArrayList();

        target.addAll(quickSort(left));
        target.add(base);
        target.addAll(quickSort(right));


        return   target;


    }
}
