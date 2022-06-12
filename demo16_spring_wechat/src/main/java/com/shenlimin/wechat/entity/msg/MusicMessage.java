package com.shenlimin.wechat.entity.msg;

import com.shenlimin.wechat.constant.MsgType;
import com.shenlimin.wechat.entity.Music;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@XStreamAlias("xml")
public class MusicMessage extends BaseMessage {

    @XStreamAlias("Music")
    private Music music;

    public MusicMessage(Map<String, String> map, Music music) {
        super(map);
        this.music = music;
        this.setMsgType(MsgType.MUSIC);
    }


}

