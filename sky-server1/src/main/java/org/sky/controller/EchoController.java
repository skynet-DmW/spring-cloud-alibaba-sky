package org.sky.controller;

import lombok.extern.slf4j.Slf4j;
import org.sky.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Slf4j
public class EchoController {

    @Autowired
    private User user;


    @GetMapping("/show/user")
    public User user() {
        log.info("用户 user：{}", user);
        return user;
    }


}
