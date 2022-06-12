package com.shenlimin.wechat.controller;

import cn.hutool.crypto.digest.DigestUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;


/**
 * 用于微信的校验
 */
@Controller
@RequestMapping("/weixin")
public class ReceiverController {


    @Value("${weixin4j.config.token}")
    private String token;


    @GetMapping(value = "receiver")
    public void receiver(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nonce = request.getParameter("nonce");
        String timestamp = request.getParameter("timestamp");
        String signature = request.getParameter("signature");
        String[] arr = new String[]{nonce, token, timestamp};
        Arrays.sort(arr);

        if (signature.equals(DigestUtil.sha1Hex(arr[0] + arr[1] + arr[2]))) {
            String echostr = request.getParameter("echostr");
            response.getWriter().write(echostr);
        }
    }


}
