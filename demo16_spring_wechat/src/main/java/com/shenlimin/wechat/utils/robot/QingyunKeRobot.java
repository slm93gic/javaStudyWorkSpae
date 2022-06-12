package com.shenlimin.wechat.utils.robot;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.shenlimin.wechat.factory.RobotFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 青云客机器人
 */
public class QingyunKeRobot extends RobotFactory {


    private final static String ROBOT_URL = "http://api.qingyunke.com/api.php";

    @Override
    public String message(String msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("appid", 0);
        map.put("key", "free");
        map.put("msg", msg);
        String post = HttpUtil.get(ROBOT_URL, map);
        return JSONUtil.parseObj(post).get("content").toString();
    }
}
