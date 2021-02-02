package org.sky.service.impl;

import org.apache.rocketmq.common.message.MessageConst;
import org.sky.config.mq.MsgModel;
import org.sky.config.mq.MsgSource;
import org.sky.service.MsgSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
public class MsgSendServiceImpl implements MsgSendService {

    @Autowired
    private MsgSource msgSource;


    public void sendNormal(String content) {
        Message<String> msg = MessageBuilder.withPayload(content).build();
        msgSource.normalMsg().send(msg);
    }


    public void sendOrderly(String content, String tag) {
        MsgModel msgModel = new MsgModel(content, System.currentTimeMillis());
        Message<MsgModel> msg = MessageBuilder.withPayload(msgModel)
                .setHeader(MessageConst.PROPERTY_TAGS, tag)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build();
        msgSource.orderlyMsg().send(msg);
    }


    public void sendTransaction(String content, int status) {
        MsgModel msgModel = new MsgModel(content, System.currentTimeMillis());
        Message<MsgModel> msg = MessageBuilder.withPayload(msgModel)
                .setHeader("status", status)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build();
        msgSource.transactionMsg().send(msg);
    }

}
