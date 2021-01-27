package org.sky.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ProviderEchoController {


    @GetMapping(value = "echo/{string}")
    public String echo(@PathVariable String string) {
//        throw new RuntimeException("我出错了");
        return "Hello Nacos Discovery " + string;
    }


}