package com.shenlimin.wechat.constant;

public interface MsgType {

    /**
     * 文本消息
     */
    public static final String TEXT = "text";
    /**
     * 图片消息
     */
    public static final String IMAGE = "image";
    /**
     * 语音消息
     */
    public static final String VOICE = "voice";
    /**
     * 视频消息
     */
    public static final String VIDEO = "video";
    /**
     * 小视频消息
     */
    public static final String SHORT_VIDEO = "shortvideo";
    /**
     * 地理位置消息
     */
    public static final String LOCATION = "location";
    /**
     * 链接消息
     */
    public static final String LINK = "link";

    /**
     * 音乐类型
     */
    public static final String MUSIC = "music";

    /**
     * 音乐类型
     */
    public static final String NEWS = "news";


    public static class EVENT {
        /**
         * 事件中的view
         */
        public static final String VIEW = "view";

        /**
         * 事件中的点击
         */
        public static final String CLICK = "click";
    }

}

