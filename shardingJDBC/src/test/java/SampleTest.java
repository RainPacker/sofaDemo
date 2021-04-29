import com.zyy.sharding.ShardingApp;
import com.zyy.sharding.mapper.ConfigMapper;
import com.zyy.sharding.mapper.DemoMapper;
import com.zyy.sharding.mapper.UserMapper;
import com.zyy.sharding.model.Config;
import com.zyy.sharding.model.Demo;
import com.zyy.sharding.model.User;

import com.zyy.sharding.order.entity.TOrder;
import com.zyy.sharding.order.mapper.TOrderMapper;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleTest {

    @Autowired
    private UserMapper   userMapper;
    @Autowired
    private DemoMapper   demoMapper;
    @Autowired
    private   ConfigMapper configMapper;
    @Autowired
    private TOrderMapper tOrderMapper;

    @Test
    @ShardingTransactionType(TransactionType.XA)
    // @Transactional(rollbackFor = Exception.class)
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setAge(i);
            user.setName("zk" + i);
            user.setEmail("254856090" + i + "@qq.com");
            userMapper.insert(user);
        }
        List<User> userList = userMapper.selectList(null);
        Assert.assertNotNull(userList);
        // Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
        Config config = new Config();
        config.setKey("22");
        config.setValue("ddddd");
        //    configMapper.insert(config);
        List<Config> configs = configMapper.selectList(null);
        configs.forEach(System.out::println);

    }

    @Test
    public void testDemo() {

        List<Demo> list = demoMapper.selectList(null);
        list.forEach(System.out::println);
        Demo demo = new Demo();
        demo.setId("111");
        demo.setRemark("11112222222");
        demoMapper.insert(demo);

    }

    @Test
    public void testUserFind() {
        List<User> list = userMapper.getByage(2);
        list.forEach(System.out::println);
    }

    @Test
    public void testOrder() {
        for (int i = 0; i < 10; i++) {
            TOrder order = new TOrder();
            order.setCreateTime(new Date());
            order.setUserId(Long.valueOf(i));
            tOrderMapper.insert(order);
        }

    }

}
