package org.sky.controller;

import lombok.extern.slf4j.Slf4j;
import org.sky.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ShowController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

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

}
