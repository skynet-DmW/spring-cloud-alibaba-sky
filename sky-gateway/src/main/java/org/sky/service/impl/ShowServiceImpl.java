package org.sky.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.sky.service.ShowService;

/**
 * created by albert on 2021/2/1
 */
@DubboService(version = "1.0.0", group = "DUBBO_NACOS", timeout = 5000)
public class ShowServiceImpl implements ShowService {


    @Override
    public String show(String message) {
        return message;
    }

}
