/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cache.demo.entity;

import java.io.Serializable;

/**
 * @author rain
 * @version : Item.java, v 0.1 2020年05月05日 09:14 rain Exp $
 */
public class Item implements Serializable {
    private String itemId;
    private String itemName;

    /**
     * Getter method for property <tt>itemId</tt>.
     *
     * @return property value of itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * Setter method for property <tt>itemId</tt>.
     *
     * @param itemId value to be assigned to property itemId
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * Getter method for property <tt>itemName</tt>.
     *
     * @return property value of itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Setter method for property <tt>itemName</tt>.
     *
     * @param itemName value to be assigned to property itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}