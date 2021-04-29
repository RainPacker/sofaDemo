/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */

import com.facade.service.model.User;
import com.zyy.sofa.mapper.UserMapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @author rain
 * @version : MockTest.java, v 0.1 2020年08月03日 16:31 rain Exp $
 */
@RunWith(JUnit4ClassRunner.class)
@SpringBootTest(classes = {MockTest.class})
public class MockTest {

    @Mock
    private UserMapper userMapper;

    @Before
    public void setUp() {
        User mockUser = new User();
        Mockito.mock(User.class);
        mockUser.setName("john");
        mockUser.setId(1L);
        when(userMapper.selectById(any())).thenReturn(mockUser).thenReturn(mockUser);

    }

    @Test
    public void testDemo() {

        System.out.println(userMapper.selectById(12222));
        Mockito.spy(User.class);



    }

}
