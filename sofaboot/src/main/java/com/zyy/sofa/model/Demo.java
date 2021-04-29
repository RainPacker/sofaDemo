/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.zyy.sofa.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author rain
 * @version : Demo.java, v 0.1 2020年06月19日 09:28 rain Exp $
 */
@Data
@TableName("t_desc")
public class Demo {
    String id;
    String remark;

}