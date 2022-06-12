//package com.shenlimin.wechat.controller;
//
//import com.shenlimin.wechat.config.TokenAccess;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.weixin4j.model.base.Token;
//
//@Controller
//@Slf4j
//@RequestMapping("/wx")
//public class IndexController {
//
//    @Autowired
//    private TokenAccess tokenAccess;
//
//    @RequestMapping("/token")
//    public Token toIndex() {
//        return tokenAccess.get();
//    }
//
//    @RequestMapping("/toHome")
//    public String toHome() {
//        return "home";
//    }
//}
