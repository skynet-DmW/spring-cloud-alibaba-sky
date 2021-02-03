package org.sky.config.mq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MsgSource {


    /**
     * 普通消息
     * @return
     */
    @Output("normal-msg")
    MessageChannel normalMsg();


    /**
     * 顺序消息
     * @return
     */
    @Output("orderly-msg")
    MessageChannel orderlyMsg();


    /**
     * 事务消息
     * @return
     */
    @Output("transaction-msg")
    MessageChannel transactionMsg();

}
