/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.zyy.sofa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.facade.service.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author rain
 * @version : UserMapper.java, v 0.1 2020年06月18日 17:03 rain Exp $
 */
public interface UserMapper extends BaseMapper<User> {
    public List<User> getByage(@Param("age") Integer age);

     void addBatch(@Param("users") List<User> users);

     Page<User> selectPage(Page<User> page);


}
