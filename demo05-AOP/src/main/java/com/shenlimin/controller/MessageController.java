package com.shenlimin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MessageController {

    @RequestMapping(value = "/send", produces = "text/json;charset=UTF-8")
    public String send_message() throws Exception {
        log.info("执行了controller.send_message方法");
        return "hello world";
    }
}

