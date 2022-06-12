package com.shenlimin.wechat.config;

import lombok.Data;

@Data
public class AccessToken {

    private String accessToken;
    private long expireTime;

    public AccessToken(String accessToken, String expireIn) {
        super();
        this.accessToken = accessToken;
        this.expireTime = System.currentTimeMillis() + Integer.parseInt(expireIn) * 1000;
    }

    /**
     * 是否过期
     *
     * @return
     */
    public boolean isExpired() {
        return System.currentTimeMillis() > expireTime;
    }


//
//    /
//
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//
//    public TokenAccess() {
//        // this.appid = Configuration.getOAuthAppId();//从配置文件中读取
//    }
//
//    @Override
//    public Token get() {
//        String accessToken = stringRedisTemplate.opsForValue().get(ACCESS_TOKEN_KEY);
//        log.info("wechat access_token:{}", accessToken);
//        return JSON.parseObject(accessToken, Token.class);
//    }
//
//    @Override
//    public void refresh(Token token) {
//        log.info("refresh wechat access_token:{}", token.toString());
//        String accessToken = JSON.toJSONString(token);
//        // ticket.getExpires_in() - 600L，是为了提前10分钟过期
//        stringRedisTemplate.opsForValue().set(ACCESS_TOKEN_KEY, accessToken, token.getExpires_in() - 600L, TimeUnit.SECONDS);
//    }
}
