/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.springboot.msg;

import org.apache.rocketmq.common.message.MessageExt;

/**
 * @author rain
 * @version MessageProcessor: MessageProcessor.java, v 0.1 2020年04月27日 09:27 rain Exp $
 */

public interface MessageProcessor {

    boolean handle(MessageExt messageExt);
}