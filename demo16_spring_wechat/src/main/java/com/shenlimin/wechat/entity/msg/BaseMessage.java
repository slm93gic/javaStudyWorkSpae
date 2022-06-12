package com.shenlimin.wechat.entity.msg;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.Map;

@Data
public class BaseMessage {

    @XStreamAlias("ToUserName")
    private String toUserName;

    @XStreamAlias("FromUserName")
    private String fromUserName;

    @XStreamAlias("CreateTime")
    private long createTime;

    @XStreamAlias("MsgType")
    private String msgType;

    public BaseMessage(Map<String, String> map) {
        this.toUserName = map.get("FromUserName");
        this.fromUserName = map.get("ToUserName");
        this.createTime = System.currentTimeMillis() / 1000;
    }

    @Override
    public String toString() {
        return messageToxml(this);
    }

    /**
     * 将发送消息封装成对应的xml格式
     */
    private String messageToxml(BaseMessage message) {
        XStream xstream = new XStream();
        xstream.processAnnotations(message.getClass());
        xstream.alias("xml", message.getClass());
        return xstream.toXML(message);
    }
}
