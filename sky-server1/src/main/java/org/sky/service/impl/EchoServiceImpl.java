package org.sky.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.sky.service.EchoService;

/**
 * created by albert on 2021/2/1
 */
@DubboService(version = "1.0.0", group = "DUBBO_NACOS", timeout = 5000)
public class EchoServiceImpl implements EchoService {


    @Override
    public String echo(String message) {
        return message;
    }

}
