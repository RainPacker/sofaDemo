/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.cglibproxy;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author rain
 * @version : ProxyFactory.java, v 0.1 2020年12月25日 下午2:02 rain Exp $
 */
public class ProxyFactory  implements MethodInterceptor {
    private  Transstation transstation =new Transstation();

    public  Transstation getObj(){
            //创建Enhancer
        Enhancer enhancer =new Enhancer();
        //指定父类的字节码对象
        enhancer.setSuperclass(Transstation.class);
        //设置回调函数
        enhancer.setCallback(this);
        //创建对象
         Transstation proxyObj = (Transstation) enhancer.create();

        return  proxyObj;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代售点收取费用。。。");
        Object object = method.invoke(transstation, objects);

        return object;
    }
}
