package com.shenlimin.wechat.entity.msg;

import com.shenlimin.wechat.constant.MsgType;
import com.shenlimin.wechat.entity.Articles;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@XStreamAlias("xml")
public class NewsMessage extends BaseMessage {

    @XStreamAlias("Articles")
    private List<Articles> articles;

    @XStreamAlias("ArticleCount")
    private int articleCount;

    public NewsMessage(Map<String, String> map, List<Articles> articles) {
        super(map);
        this.setMsgType(MsgType.NEWS);
        this.articleCount = articles.size();
        this.articles = articles;
    }


}
