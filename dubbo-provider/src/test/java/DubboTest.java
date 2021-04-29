/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */

import com.demo.dubbo.DubboProvider;
import com.facade.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author rain
 * @version : DubboTest.java, v 0.1 2020年08月05日 09:20 rain Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DubboProvider.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DubboTest {
    @Reference
    private HelloService helloService;

    @Test
    public void testHello() {
        String s = helloService.sayHello("11");
        System.out.println(s);

    }
}
