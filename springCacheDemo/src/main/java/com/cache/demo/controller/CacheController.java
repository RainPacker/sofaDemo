/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cache.demo.controller;

import com.cache.demo.entity.Item;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rain
 * @version : CacheController.java, v 0.1 2020年05月05日 09:12 rain Exp $
 */
@RestController
public class CacheController {

    @GetMapping("/getItem/{id}")
    public  Item getitem(@PathVariable String id){
        Item item = new Item();
        item.setItemId("id" + id);
        item.setItemName("test");
        return item;
    }

    @GetMapping("/item/{id}")
    @Cacheable(value = "item")
    public Item getById(@PathVariable String id) {
        System.out.println("######getById#####");
        Item item = new Item();
        item.setItemId("id" + id);
        item.setItemName("test");
        return item;
    }

    @GetMapping("item/update/{id}")
    @CachePut(value = "item")
    public Item updateItem(@PathVariable String id) {
        System.out.println("######updateItem#####");
        Item item = new Item();
        item.setItemId("id" + id);
        item.setItemName("upadata");
        return item;
    }




}