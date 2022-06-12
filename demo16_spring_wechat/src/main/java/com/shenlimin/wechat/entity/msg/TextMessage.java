package com.shenlimin.wechat.entity.msg;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@XStreamAlias("xml")
public class TextMessage extends BaseMessage {

    @XStreamAlias("Content")
    private String content;// 文本消息内容

    public TextMessage(Map<String, String> map, String content) {
        super(map);
        this.setMsgType("text");
        this.content = content;
    }


}
