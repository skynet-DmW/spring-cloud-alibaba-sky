package org.sky.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.sky.sentinel.EchoFallBack;
import org.sky.sentinel.EchoHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelController {


    @Value("${spring.application.name}")
    private String appName;


    @GetMapping("/show/sentinel")
    @SentinelResource(value = "echoSentinel",
            blockHandlerClass = EchoHandler.class,
            blockHandler = "showSentinelHandler",
            fallbackClass = EchoFallBack.class,
            fallback = "showSentinelFallback"
    )
    public String sentinel() {
        return appName;
    }


    @GetMapping("/show/sentinelError")
    @SentinelResource(value = "echoSentinel",
            blockHandlerClass = EchoHandler.class,
            blockHandler = "showSentinelHandler",
            fallbackClass = EchoFallBack.class,
            fallback = "showSentinelFallback"
    )
    public String sentinelError() {
        int i = 0 / 0;
        return appName;
    }


}
