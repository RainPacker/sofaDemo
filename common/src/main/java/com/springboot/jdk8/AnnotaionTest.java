/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.jdk8;

import com.springboot.jdk8.AnnotaionTest.MyAnotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * @author rain
 * @version : AnnotaionTest.java, v 0.1 2020年10月28日 15:04 rain Exp $
 */
public class AnnotaionTest {

    @Target({ElementType.METHOD,ElementType.FIELD,ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface MyAnotaion{
        String value();
    }

    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException,
            InstantiationException, NoSuchFieldException {
        Class<?> aClass = Class.forName("com.springboot.jdk8.Product");
        System.out.println(aClass);
        System.out.println(aClass.getName());
        for (Method declaredMethod : aClass.getDeclaredMethods()) {
            System.out.println(declaredMethod);
        }

        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(Long.class, Integer.class, BigDecimal.class, String.class,
                String.class);
        Product o = (Product) declaredConstructor.newInstance(10L, 1, new BigDecimal(10), "菜果", "水果");
        System.out.println(o.getName());

        //
       Product  objec2 = (Product) aClass.newInstance();

       objec2.setName("213123");
        System.out.println(objec2.getName());
        Method getName = aClass.getDeclaredMethod("getName");
        Method setName = aClass.getDeclaredMethod("setName", String.class);
        setName.invoke(objec2, "香蕉");
        System.out.println(getName.invoke(objec2));
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(objec2,"香蕉你个");
        System.out.println(getName.invoke(objec2));

        Class<?> a = Class.forName("com.springboot.jdk8.AnnotaionTest$App");
        MyAnotaion annotation = a.getAnnotation(MyAnotaion.class);
        System.out.println(annotation.value());
        Field id = a.getDeclaredField("id");
        MyAnotaion declaredAnnotation = id.getDeclaredAnnotation(MyAnotaion.class);
        System.out.println(declaredAnnotation.value());
        Field name1 = a.getDeclaredField("name");
        MyAnotaion declaredAnnotation1 = name1.getDeclaredAnnotation(MyAnotaion.class);
        System.out.println(declaredAnnotation1.value());

    }

    @MyAnotaion("1232")
    class App{
        @MyAnotaion("id")
        private String id;
        @MyAnotaion("anmewrwerwer")
        private String name;
    }
}
