/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.zyy.sofa.service.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.facade.service.UserWebService;
import com.facade.service.model.User;
import com.zyy.sofa.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.List;

/**
 * @author rain
 * @version : UserWebServiceImpl.java, v 0.1 2020年11月25日 下午4:51 rain Exp $
 */
@WebService
@Service
@SofaService(interfaceType = UserWebService.class,bindings = {@SofaServiceBinding(bindingType = "bolt")})
public class UserWebServiceImpl  implements UserWebService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getByage(Integer age) {
        List<User> users = userMapper.getByage(age);



        return users;
    }

    @Override
    public String sayHi(String name) {

        return name;
    }
}
