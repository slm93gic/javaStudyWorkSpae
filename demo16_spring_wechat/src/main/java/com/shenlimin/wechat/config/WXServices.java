package com.shenlimin.wechat.config;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WXServices {

    public static final String appid = "wx7b00bc69da12112f";
    public static final String secret = "892a27c07744f7da45eb649e548c2751";
    private static AccessToken token;

    /**
     * 获取token
     */
    private static void getTokenByUrl() {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + secret + "";
        String result = HttpUtil.get(url);
        JSONObject jsonObject = JSONUtil.parseObj(result);
        String accessToken = jsonObject.getStr("access_token");
        String expireIn = jsonObject.getStr("expires_in");
        token = new AccessToken(accessToken, expireIn);
    }


    /**
     * 获取accessToken
     */
    public static String getAccessToken() {
        if (token == null || token.isExpired()) {
            getTokenByUrl();
        }
        return token.getAccessToken();
    }


}
