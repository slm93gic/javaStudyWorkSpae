package com.shenlimin.wechat.controller;

import com.shenlimin.wechat.constant.MsgType;
import com.shenlimin.wechat.entity.Articles;
import com.shenlimin.wechat.entity.msg.NewsMessage;
import com.shenlimin.wechat.entity.msg.TextMessage;
import com.shenlimin.wechat.factory.MessageFactory;
import com.shenlimin.wechat.factory.RobotFactory;
import com.shenlimin.wechat.utils.robot.TulingRobot;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/weixin")
public class MessageController extends MessageFactory {

    @PostMapping("receiver")
    public void receiverMsg(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        //将微信请求xml转为map格式，获取所需的参数
        Map<String, String> map = parseXml2Map(request);
        System.out.println(map);
        String type = map.get("MsgType");
        String content = map.get("Content");

        if (MsgType.TEXT.equals(type)) {
            if ("帅哥".equals(content)) {
                DealResponse(response, newsHandler(map));
            } else {
                DealResponse(response, textHandler(map));
            }

        } else { //图文消息

        }

    }


    /**
     * 文本消息
     *
     * @param map
     * @return
     */
    @Override
    public String textHandler(Map<String, String> map) {
        String Content = map.get("Content");
        RobotFactory factory = new TulingRobot();
        String message = factory.message(Content);
        TextMessage textMessage = new TextMessage(map, message);
        return textMessage.toString();
    }


    @Override
    public String newsHandler(Map<String, String> map) {
        List<Articles> list = new ArrayList<>();
        String picUrl = "http://mmbiz.qpic.cn/mmbiz_jpg/jiczgP3yDufeRnFYicRACeicAtMSo4eEg3QRUftDcm7k1YtH18WetTUzQrBjPQeE4s3clkyHkiaepImuupo5iawWYyg/0";
        list.add(new Articles("标题1", "我是内容介绍", picUrl, "www.baidu.com"));
        return new NewsMessage(map, list).toString();
    }

    @Override
    public String eventHandler(Map<String, String> map) {
        return null;
    }


    /**
     * @param response
     * @param message
     */
    private void DealResponse(HttpServletResponse response, String message) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.close();
    }


    /**
     * 将请求消息转化为map
     */
    private Map<String, String> parseXml2Map(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        SAXReader reader = new SAXReader();
        InputStream in = null;
        try {
            in = request.getInputStream();
            Document doc = reader.read(in);
            Element root = doc.getRootElement();
            List<Element> list = root.elements();
            for (Element element : list) {
                map.put(element.getName(), element.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }


}
