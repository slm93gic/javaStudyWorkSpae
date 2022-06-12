package com.shenlimin.wechat.factory;

import java.util.Map;

public abstract class MessageFactory {


    /**
     * 文本消息
     */
    public abstract String textHandler(Map<String, String> map);

    /**
     * 图问消息
     */
    public abstract String newsHandler(Map<String, String> map);

    /**
     * EVENT事件
     */
    public abstract String eventHandler(Map<String, String> map);

//
//    /**
//     * 语音消息
//     */
//    public void voiceMessage(Object obj) {
//
//    }
//
//    /**
//     * 视频消息
//     */
//    public void videoMessage(Object obj) {
//
//    }
//
//    /**
//     * 小视频消息
//     */
//    public void shortVideoMessage(Object obj) {
//    }
//
//    /**
//     * 地理位置消息
//     */
//    public void locationMessage(Object obj) {
//    }
//
//    /**
//     * 链接消息
//     */
//    public void linkMessage(Object obj) {
//
//    }

}
