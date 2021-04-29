/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */

import com.alibaba.fastjson.JSON;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.facade.service.UserService;
import com.facade.service.model.User;
import com.zyy.sofa.SofaApp;
import com.zyy.sofa.service.impl.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author rain
 * @version : UserServiceTest.java, v 0.1 2020年08月05日 11:26 rain Exp $
 */
@RunWith(JUnit4ClassRunner.class)
@SpringBootTest(classes = SofaApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {
   // @Reference(version = "1.0.0", url = "dubbo://127.0.0.1:20880", timeout = 8000)
   // @SofaReference(binding=@SofaReferenceBinding(directUrl = "127.0.0.1:12200"))
    @SofaReference
    private UserService userService;
    @Autowired
    private TestService testService;

    @Test
    public void userServiceGetList() {
        Long s = System.currentTimeMillis();
        System.out.println(s);
        List<User> byage = userService.getByage(1);
        System.out.println(JSON.toJSONString(byage));
        System.out.println(System.currentTimeMillis() - s);
        testService.getById(1);
    }


}
