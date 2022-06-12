package com.slm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SsoController {


    @RequestMapping("index")
    public String index() {
        return "login";
    }

    @RequestMapping("login")
    @ResponseBody
    public String login(String userName, String password) {
        return "Login ok";
    }


}
