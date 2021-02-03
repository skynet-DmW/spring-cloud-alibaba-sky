package org.sky.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.sky.service.ShowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DubboController {

    @DubboReference(version = "1.0.0", check = false, group = "DUBBO_NACOS", timeout = 5000)
    private ShowService showService;


    @GetMapping("/show")
    public String show() {
        return this.showService.show("你好，server2，我是server1，我通过dubbo来找你了！");
    }


}
