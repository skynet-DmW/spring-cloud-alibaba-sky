package org.sky.consumer.controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsumerEchoFallBack {


    public static String echoSentinelFallback(Throwable e) {
        log.error("错误信息：{}", e.getMessage(), e);
        return "熔断处理，业务异常处理逻辑";
    }


}