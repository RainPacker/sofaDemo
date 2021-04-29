/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.zyy.sofa.service.impl;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.zyy.sofa.service.Demo;
import org.springframework.stereotype.Service;

/**
 * @author rain
 * @version : DemoImpl.java, v 0.1 2020年12月18日 下午5:46 rain Exp $
 */
@Service
@SofaService(interfaceType = Demo.class,bindings = {@SofaServiceBinding(bindingType = "bolt")})
public class DemoImpl  implements Demo {
    @Override
    public void sayHi() {
        System.out.println("Hello");
    }
}