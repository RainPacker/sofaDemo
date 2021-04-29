/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.demo;

import com.springboot.demo.demo.C;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

/**
 * @author rain
 * @version : TsetDemo.java, v 0.1 2020年12月03日 上午11:32 rain Exp $
 */
public class TsetDemo {



    @Test
    public void testC() {

        // 一般匹配符
        int s = new C().add(1, 1);
        // allOf：所有条件必须都成立，测试才通过
        assertThat(s, allOf(greaterThan(1), lessThan(3)));
        // anyOf：只要有一个条件成立，测试就通过
        assertThat(s, anyOf(greaterThan(1), lessThan(1)));
        // anything：无论什么条件，测试都通过
        assertThat(s, anything());
        // is：变量的值等于指定值时，测试通过
        assertThat(s, is(2));
        // not：和is相反，变量的值不等于指定值时，测试通过
        assertThat(s, not(1));

        // 数值匹配符
        double d = new C().div(10, 3);
        // closeTo：浮点型变量的值在3.0±0.5范围内，测试通过
        assertThat(d, closeTo(3.0, 0.5));
        // greaterThan：变量的值大于指定值时，测试通过
        assertThat(d, greaterThan(3.0));
        // lessThan：变量的值小于指定值时，测试通过
        assertThat(d, lessThan(3.5));
        // greaterThanOrEuqalTo：变量的值大于等于指定值时，测试通过
        assertThat(d, greaterThanOrEqualTo(3.3));
        // lessThanOrEqualTo：变量的值小于等于指定值时，测试通过
        assertThat(d, lessThanOrEqualTo(3.4));

        // 字符串匹配符
        String n = new C().getName("Magci");
        // containsString：字符串变量中包含指定字符串时，测试通过
        assertThat(n, containsString("ci"));
        // startsWith：字符串变量以指定字符串开头时，测试通过
        assertThat(n, startsWith("Ma"));
        // endsWith：字符串变量以指定字符串结尾时，测试通过
        assertThat(n, endsWith("i"));
        // euqalTo：字符串变量等于指定字符串时，测试通过
        assertThat(n, equalTo("Magci"));
        // equalToIgnoringCase：字符串变量在忽略大小写的情况下等于指定字符串时，测试通过
        assertThat(n, equalToIgnoringCase("magci"));
        // equalToIgnoringWhiteSpace：字符串变量在忽略头尾任意空格的情况下等于指定字符串时，测试通过
        assertThat(n, equalToIgnoringWhiteSpace(" Magci   "));

        // 集合匹配符
        List<String> l = new C().getList("Magci");
        // hasItem：Iterable变量中含有指定元素时，测试通过
        assertThat(l, hasItem("Magci"));

        Map<String, String> m = new C().getMap("mgc", "Magci");
        // hasEntry：Map变量中含有指定键值对时，测试通过
        assertThat(m, hasEntry("mgc", "Magci"));
        // hasKey：Map变量中含有指定键时，测试通过
        assertThat(m, hasKey("mgc"));
        // hasValue：Map变量中含有指定值时，测试通过
        assertThat(m, hasValue("Magci"));
    }
}