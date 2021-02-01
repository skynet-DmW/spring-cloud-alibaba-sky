package org.sky.sentinel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EchoFallBack {


    public static String showSentinelFallback(Throwable e) {
        log.error("错误信息：{}", e.getMessage(), e);
        return "熔断处理，业务异常处理逻辑";
    }


}