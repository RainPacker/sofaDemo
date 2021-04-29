import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.facade.service.model.User;
import com.zyy.sofa.SofaApp;
import com.zyy.sofa.config.ConstantValue;
import com.zyy.sofa.mapper.ConfigMapper;
import com.zyy.sofa.mapper.DemoMapper;
import com.zyy.sofa.mapper.UserMapper;
import com.zyy.sofa.model.Config;
import com.zyy.sofa.model.Demo;
import com.zyy.sofa.order.entity.TOrder;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(JUnit4ClassRunner.class)
@SpringBootTest(classes = SofaApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleTest  {

    @Autowired
    private UserMapper   userMapper;
    @Autowired
    private DemoMapper   demoMapper;
    @Autowired
    private ConfigMapper configMapper;
    //  @Autowired
    //    private ITOrderService tOrderService;
   @Before
    public  void init(){
       System.out.println("init....");
       System.setProperty("jasypt.encryptor.password", ConstantValue.JASYPT_ENCRYPTOR_PASSWORD);
    }

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
        System.out.println(JSON.toJSONString(list, SerializerFeature.PrettyFormat,SerializerFeature.WriteDateUseDateFormat));
    }

    @Test
    public void testOrder() {
        for (int i = 0; i < 10; i++) {
            TOrder order = new TOrder();
            order.setCreateTime(new Date());
            order.setUserId(Long.valueOf(i));
            //tOrderService.save(order);
        }

    }

    @Test
    public  void  testBathcInser(){
        Long s = System.currentTimeMillis();
        List<User> users =new ArrayList<>(10000);
        for (int i = 0; i < 10000; i++) {
           User user =new User();
            user.setId(Long.valueOf(i));
            user.setAge(i);
            user.setName("rain.zhang"+i);
            user.setEmail("254856090"+i+"@qq.com");
            user.setCreateTime(new Date());
            users.add(user);

        }
        userMapper.addBatch(users);
        System.out.println("插入10000条用时:"+(System.currentTimeMillis() - s));


    }

    @Test
    public  void  batchDel(){
        Long s = System.currentTimeMillis();
       List<Integer>  list =new ArrayList<>(10000);
        for (int i = 0; i < 10000 ; i++) {
            list.add(i);
        }

        int count = userMapper.deleteBatchIds(list);
        System.out.println("删除10000条用时:"+(System.currentTimeMillis() - s)+"实际删除条数："+count);
    }

}
