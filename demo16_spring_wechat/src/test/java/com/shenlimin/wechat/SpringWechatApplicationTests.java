package com.shenlimin.wechat;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.shenlimin.wechat.constant.MsgType;
import com.shenlimin.wechat.entity.menu.*;
import com.shenlimin.wechat.entity.msg.ImageMessage;
import com.shenlimin.wechat.entity.msg.TextMessage;
import com.shenlimin.wechat.config.WXServices;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringWechatApplicationTests {


    @Test
    void testButton() {
        //菜单对象
        Button btn = new Button();
        //一级菜单
        btn.getButton().add(new ClickButton("一级点击", "1"));
        btn.getButton().add(new ViewButton("自己的系统", "http://rmj6wf.natappfree.cc/"));

        //第三个有子菜单的菜单
        SubButton subButton = new SubButton("有子菜单");
        subButton.getSub_button().add(new PhotoOrAlbumButton("传图", "31"));
        subButton.getSub_button().add(new ClickButton("点击", "32"));
        subButton.getSub_button().add(new ViewButton("网易新闻", "http://news.163.com"));
        btn.getButton().add(subButton);
        //转换为json
        JSONObject jsonObject = JSONUtil.parseObj(btn);
        System.out.println(jsonObject.toString());

        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
        url = url.replace("ACCESS_TOKEN", WXServices.getAccessToken());
        String post = HttpUtil.post(url, jsonObject.toString());
        System.out.println(post);


    }

    @Test
    void contextLoads() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("ToUserName", "ToUserName");
        map.put("FromUserName", "FromUserName");
        TextMessage message = new TextMessage(map, "你好");
        System.out.println(message);

        ImageMessage imageMessage = new ImageMessage(map, "123");
        System.out.println(imageMessage);
    }


    @Test
    void testAccessToken() {
        System.out.println(WXServices.getAccessToken());
        System.out.println(WXServices.getAccessToken());
    }

}
