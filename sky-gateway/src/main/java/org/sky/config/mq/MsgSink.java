package org.sky.config.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MsgSink {


    /**
     * 普通消息
     *
     * @return
     */
    @Input("normal-msg")
    SubscribableChannel normalMsg();


    /**
     * 顺序消息
     *
     * @return
     */
    @Input("orderly-msg")
    SubscribableChannel orderlyMsg();


    /**
     * 事务消息
     *
     * @return
     */
    @Input("transaction-msg")
    SubscribableChannel transactionMsg();
}

