package org.sky.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.sky.bean.User;
import org.sky.sentinel.EchoFallBack;
import org.sky.sentinel.EchoHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ShowController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private User user;


    @GetMapping("/show/app-name")
    public String echoAppName() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("sky-server1");
        return serviceInstance.getHost() + ":" +serviceInstance.getPort();
    }


    @GetMapping("/show/user")
    public User user() {
        log.info("用户 user：{}", user);
        return user;
    }


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