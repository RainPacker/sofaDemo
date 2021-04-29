package com.cache.demo.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Value("${redis.url}")
    private String redisUrl;
    @Value("${spring.redis.password}")
    private  String pwd;
     @Bean
     public RedissonClient redissonClient() {
         Config config = new Config();
         System.out.println(redisUrl);
         config.useSingleServer().setAddress(redisUrl).setPassword(pwd);
      //   config.useClusterServers()//集群模式
      //           .setScanInterval(2000)
      //          .addNodeAddress("redis://127.0.0.1:6379").setPassword("rain");
                // .addNodeAddress(redisUrl).setPassword(pwd);

         return Redisson.create(config);
     }

 }