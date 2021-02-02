package org.sky.mq;

import lombok.extern.slf4j.Slf4j;
import org.sky.config.mq.MsgModel;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReceiveService {


    @StreamListener("normal-msg")
    public void normalMsg(String msg) {
        log.info("normalMsg:{}", msg);
    }


    @StreamListener("orderly-msg")
    public void orderlyMsg(@Payload MsgModel msg) {
        log.info("orderlyMsg:{}", msg);
    }


    @StreamListener("transaction-msg")
    public void transactionMsg(MsgModel msg) {
        log.info("transactionMsg:{}", msg);
    }

}

