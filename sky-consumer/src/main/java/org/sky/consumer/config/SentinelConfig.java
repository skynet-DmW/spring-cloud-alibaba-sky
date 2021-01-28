//package org.sky.consumer.config;
//
//import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
//import org.sky.consumer.handler.CustomUrlBlockHandler;
//import org.springframework.boot.SpringBootConfiguration;
//
//import javax.annotation.PostConstruct;
//
///**
// * created by albert on 2021/1/27
// */
//@SpringBootConfiguration
//public class SentinelConfig {
//
//    @PostConstruct
//    public void callbackManager() {
//        WebCallbackManager.setUrlBlockHandler(new CustomUrlBlockHandler());
//    }
//
//}
