package org.sky.nacos.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("echo")
public class EchoController {


    @GetMapping(value = "{string}")
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }


}