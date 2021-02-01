package org.sky.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.sky.service.EchoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DubboController {

    @DubboReference(version = "1.0.0", check = false, group = "DUBBO_NACOS", timeout = 5000)
    private EchoService echoService;


    @GetMapping("echo")
    public String echo() {
        return this.echoService.echo("你好，server1，我是server2，我通过dubbo来找你了！");
    }


}