package org.sky.service;

public interface MsgSendService {


    /**
     * 普通发送
     *
     * @param content
     */
    void sendNormal(String content);

    /**
     * 顺序发送
     *
     * @param content
     * @param tag
     */
    void sendOrderly(String content, String tag);

    /**
     * 事务消息消息，这条消息去到MQ 在本地事务没有执行成功之前，对于消费者来说是不可见，无法消费的，这里的事务操作是指确保
     * 本地事务执行成功之后，消息发送到MQ并可以被消费
     * 对于消费者来说，只要消费MQ的MQ信息就好，但是要确保，事务消息的消费结果是幂等性的，即多次消费结果都一样，MQ不确保消息被消费一次
     *
     * @param content
     * @param status
     */
    void sendTransaction(String content, int status);
}

