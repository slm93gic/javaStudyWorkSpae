package com.shenlimin.wechat.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

@Data
public class Music {

    @XStreamAlias("Title")
    private String title;//	音乐标题

    @XStreamAlias("Description")
    private String description;//音乐描述

    @XStreamAlias("MusicURL")
    private String musicURL;//音乐链接

    @XStreamAlias("HQMusicUrl")
    private String hQMusicUrl;//高质量音乐链接，WIFI环境优先使用该链接播放音乐

    @XStreamAlias("ThumbMediaId")
    private String thumbMediaId;//	缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id

}
