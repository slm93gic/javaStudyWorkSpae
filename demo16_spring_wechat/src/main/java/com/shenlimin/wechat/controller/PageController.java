package com.shenlimin.wechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("name", "张三");
        map.addAttribute("bookTitle", "十万个为什么");
        // return模板文件的名称，对应src/main/resources/templates/welcome.ftlh
        return "index";
    }

}
