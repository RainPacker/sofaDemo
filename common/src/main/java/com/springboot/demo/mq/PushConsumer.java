package com.springboot.demo.mq;

import com.springboot.msg.MessageProcessor;
import com.springboot.msg.impl.MessageProcessorImpl;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

public class PushConsumer {

    public static void main(String[] args) throws MQClientException {
        MessageProcessor messageProcessor = new MessageProcessorImpl();
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("ProducerGroupName");
        consumer.setNamesrvAddr("localhost:9876");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.subscribe("TopicTest", "*");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                            ConsumeConcurrentlyContext context) {
               // System.out.printf(Thread.currentThread().getName() + "Receive New Messages :" + msgs + "%n" + "msg" + msgs.get(0));
                MessageExt ext = msgs.get(0);
                boolean result = messageProcessor.handle(ext);
                if (!result) {
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
    }
}