package com.shenlimin.wechat.entity.msg;

import com.shenlimin.wechat.constant.MsgType;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
@XStreamAlias("xml")
public class VoiceMessage extends BaseMessage{

    @XStreamAlias("MediaId")
    private String mediaId;

    public VoiceMessage(Map<String, String> map,String mediaId) {
        super(map);
        this.setMsgType(MsgType.VOICE);
        this.mediaId = mediaId;
    }


}
