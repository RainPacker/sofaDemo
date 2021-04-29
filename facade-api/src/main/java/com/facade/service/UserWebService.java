/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.facade.service;

import com.facade.service.model.User;

import javax.jws.WebService;
import java.util.List;

/**
 * @author rain
 * @version : UserWebService.java, v 0.1 2020年11月25日 下午4:50 rain Exp $
 */
@WebService
public interface UserWebService {
    List<User> getByage(Integer age);
    String sayHi(String name);
}
