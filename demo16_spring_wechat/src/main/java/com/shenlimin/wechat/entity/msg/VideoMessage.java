package com.shenlimin.wechat.entity.msg;

import com.shenlimin.wechat.constant.MsgType;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@XStreamAlias("xml")
public class VideoMessage extends BaseMessage {

    @XStreamAlias("MediaId")
    private String mediaId;//	视频消息媒体id，可以调用获取临时素材接口拉取数据。

    @XStreamAlias("Title")
    private String title;

    @XStreamAlias("Description")
    private String description;

    public VideoMessage(Map<String, String> map, String mediaId, String title, String description) {
        super(map);
        this.setMsgType(MsgType.VIDEO);
        this.mediaId = mediaId;
        this.title = title;
        this.description = description;
    }


}
