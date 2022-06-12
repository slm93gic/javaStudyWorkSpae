package com.shenlimin.wechat.entity.msg;

import com.shenlimin.wechat.constant.MsgType;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@XStreamAlias("xml")
public class ImageMessage extends BaseMessage{

    @XStreamAlias("CreateTime")
    private String mediaId;

    public ImageMessage(Map<String, String> map,String mediaId) {
        super(map);
        this.setMsgType(MsgType.IMAGE);
        this.mediaId = mediaId;
    }


}
