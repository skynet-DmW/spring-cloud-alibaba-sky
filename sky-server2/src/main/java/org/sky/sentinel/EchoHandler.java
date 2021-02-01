package org.sky.sentinel;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EchoHandler {


    public static String showSentinelHandler(BlockException e) {
        log.error("错误信息：{}", e.getMessage(), e);
        return "限流异常处理";
    }

}
