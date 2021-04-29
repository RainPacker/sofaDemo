/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */

import com.zyy.sharding.mapper.UserMapper;
import com.zyy.sharding.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.when;

/**
 * @author rain
 * @version : MockTest.java, v 0.1 2020年08月03日 16:31 rain Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MockTest.class})
public class MockTest {

    @Mock
    private UserMapper userMapper;

    @Before
    public void setUp() {
        User mockUser = new User();
        mockUser.setName("john");
        mockUser.setId(1L);
        when(userMapper.selectById(1)).thenReturn(mockUser).thenThrow(Exception.class);
    }

    @Test
    public void testDemo() {

        System.out.println(userMapper.selectById(1));

    }

}