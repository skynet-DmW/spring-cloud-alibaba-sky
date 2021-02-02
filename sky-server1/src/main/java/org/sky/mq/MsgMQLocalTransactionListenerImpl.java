package org.sky.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;

import java.util.Objects;

@RocketMQTransactionListener(
        txProducerGroup = "transaction-group"
)
@Slf4j
public class MsgMQLocalTransactionListenerImpl implements RocketMQLocalTransactionListener {

    /**
     * 发送prepare消息成功此方法被回调，该方法用于执行本地事务
     *
     * @param msg 回传的消息，利用transactionId即可获取到该消息的唯一Id
     * @param arg 调用send方法时传递的参数，当send时候若有额外的参数可以传递到send方法中，这里能获取到
     * @return 返回事务状态，COMMIT：提交 ROLLBACK：回滚 UNKNOW：回调
     */
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        String status = Objects.requireNonNull(msg.getHeaders().get("status")).toString();
        log.info("executeLocalTransaction: msg:{}, arg:{}, status:{}", msg, arg, status);
        switch (status) {
            case "1":
                log.info("事务执行状态未知");
                return RocketMQLocalTransactionState.UNKNOWN;
            case "2":
                log.info("事务执行状态成功");
                return RocketMQLocalTransactionState.COMMIT;
            case "3":
                log.info("事务执行状态失败");
                return RocketMQLocalTransactionState.ROLLBACK;

        }
        return RocketMQLocalTransactionState.ROLLBACK;
    }

    /**
     * @param msg 通过获取transactionId来判断这条消息的本地事务执行状态
     * @return 返回事务状态，COMMIT：提交 ROLLBACK：回滚 UNKNOW：回调
     */
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
        log.info("checkLocalTransaction:{}", msg);
        return RocketMQLocalTransactionState.COMMIT;
    }
}
