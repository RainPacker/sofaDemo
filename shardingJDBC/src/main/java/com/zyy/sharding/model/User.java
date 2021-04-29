/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.zyy.sharding.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author rain
 * @version : User.java, v 0.1 2020年06月18日 17:02 rain Exp $
 */
@Data
public class User {
    private Long    id;
    private String  name;
    private Integer age;
    private String  email;
}