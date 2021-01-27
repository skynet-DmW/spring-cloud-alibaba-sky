package org.sky.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class ConsumerEchoController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String appName;


    @GetMapping("/echo/app-name")
    public String echoAppName() {
        // 通过LoadBalanceClient和RestTemplate的组合进行访问
        ServiceInstance serviceInstance = loadBalancerClient.choose("sky-provider");
        String path = String.format("http://%s:%s/echo/%s", serviceInstance.getHost(), serviceInstance.getPort(), appName);
        log.info("请求 path：{}", path);
        return restTemplate.getForObject(path, String.class);
    }


    @GetMapping("/echo/sentinel")
    @SentinelResource(value = "echoSentinel",
            blockHandlerClass = ConsumerEchoHandler.class,
            blockHandler = "echoSentinelHandler",
            fallbackClass = ConsumerEchoFallBack.class,
            fallback = "echoSentinelFallback"
    )
    public String echoSentinel () {
        return appName;
    }


}