/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.msg.impl;

import com.springboot.msg.MessageProcessor;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

/**
 * @author rain
 * @version MessageProcessorImpl: MessageProcessorImpl.java, v 0.1 2020年04月27日 09:28 rain Exp $
 */
@Service
public class MessageProcessorImpl implements MessageProcessor {
    @Override
    public boolean handle(MessageExt messageExt) {
        // 收到的body（消息体），字节类型，需转为String
        String result = new String(messageExt.getBody());
        System.out.println("监听到了消息，消息为：" + result);
        return true;
    }
}