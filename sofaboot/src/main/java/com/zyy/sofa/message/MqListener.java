/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.zyy.sofa.message;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author rain
 * @version : MqListener.java, v 0.1 2021年02月04日 下午5:19 rain Exp $
 */
@Slf4j
@RocketMQMessageListener(topic = "topic2020", consumerGroup = "consumeGroup2", messageModel = MessageModel.CLUSTERING)
@Component
public class MqListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String msg) {
        log.info("收到消息"+msg);
        System.out.println("收到消息"+msg);

    }
}
