package com.shenlimin.wechat.utils.robot;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.shenlimin.wechat.factory.RobotFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 图灵机器人
 */
public class TulingRobot extends RobotFactory {

    private final static String ROBOT_URL = "http://openapi.tuling123.com/openapi/api/v2";

    @Override
    public String message(String msg) {
        JSONObject params = new JSONObject();
        params.putOnce("reqType", 0);
        params.putOnce("perception", setMsg(msg));
        params.putOnce("userInfo", setUserInfo());
        String post = HttpUtil.post(ROBOT_URL, params.toString());
        Object results = JSONUtil.parseObj(post).get("results");
        return JSONUtil.parseArray(results).getJSONObject(0).getJSONObject("values").get("text").toString();
    }

    private Map setMsg(String msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("inputText", setText(msg));
        map.put("inputImage", setInputImage());
        map.put("selfInfo", setLocation());
        return map;
    }

    private Map setUserInfo() {
        Map<String, Object> map = new HashMap<>();
        map.put("apiKey", "b0fa08693239485595cc83b4ee82f20e");
        map.put("userId", "b0fa08693239485595cc83b4ee82f20e");
        return map;
    }

    private static Map setText(String msg) {
        Map<String, Object> text = new HashMap<>();
        text.put("text", msg);
        return text;
    }

    private static Map setLocation() {
        Map<String, Object> map = new HashMap<>();
        map.put("city", "北京");
        map.put("province", "北京");
        map.put("street", "信息路");
        return map;
    }

    private static Map setInputImage() {
        Map<String, Object> map = new HashMap<>();
        map.put("url", "imageUrl");
        return map;
    }
}
