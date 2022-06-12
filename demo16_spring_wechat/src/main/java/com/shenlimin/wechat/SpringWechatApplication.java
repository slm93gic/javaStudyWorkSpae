package com.shenlimin.wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class SpringWechatApplication {

    public static void main(String[] args) {
        Integer a = 10;
        int b = 10;
        System.out.println(a.equals(b));
        System.out.println(a == b);
        //SpringApplication.run(SpringWechatApplication.class, args);
    }

}
