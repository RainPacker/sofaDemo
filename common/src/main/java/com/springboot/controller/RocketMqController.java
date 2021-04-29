/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.controller;


import com.facade.service.HelloService;
import com.springboot.msg.RocketMQProducer;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author rain
 * @version RocketMqController: RocketMqController.java, v 0.1 2020年04月27日 09:39 rain Exp $
 */
@RestController
@Slf4j
public class RocketMqController {
  //  @Autowired
  //  @Qualifier("rocketMQProducer")
  //  RocketMQProducer rocketMQProducer;
    //@Reference(version = "1.0.0", url = "dubbo://127.0.0.1:20881")
    //HelloService     helloService;
    @Resource
    private RocketMQTemplate rocketMQTemplate;



    @GetMapping("/test")
    public Object TestSend() {
       // DefaultMQProducer producer = rocketMQProducer.getRocketMQProducer();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String body = "hi RocketMQ, now is  " + sdf.format(new Date()) + ".";
        Message message = new Message("topic2020", "test",sdf.toLocalizedPattern(), body.getBytes());
        org.springframework.messaging.Message<String> stringMessage = MessageBuilder.withPayload(body+"_2").build();
        //  rocketMQTemplate.convertAndSend(body);
        log.info("发送MQ 消息:{}",body);
        try {
       // rocketMQTemplate.convertAndSend("topic2020",body);
            SendResult send = rocketMQTemplate.getProducer().send(message);
            rocketMQTemplate.send("topic2020",stringMessage);
            // rocketMQTemplate.sendMessageInTransaction()
       // rocketMQTemplate.

       // log.info(helloService.sayHello("111"));
            return  send;

         //   producer.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sdf;//helloService.sayHello("zyy");

    }
}
