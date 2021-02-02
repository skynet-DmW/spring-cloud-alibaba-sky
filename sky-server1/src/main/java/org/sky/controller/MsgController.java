package org.sky.controller;

import org.sky.service.MsgSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("msg")
public class MsgController {

    @Autowired
    private MsgSendService msgSendService;


    @GetMapping("normal")
    public ResponseEntity<String> normal(String content) {
        msgSendService.sendNormal(content);
        return ResponseEntity.ok().body("normal ok");
    }


    @GetMapping("orderly")
    public String orderly(String content) {
        msgSendService.sendOrderly(content, "orderly");
        return "orderly ok";
    }


    @GetMapping("transaction")
    public String transaction(String content, int status) {
        msgSendService.sendTransaction(content, status);
        return "transaction ok";
    }


}

