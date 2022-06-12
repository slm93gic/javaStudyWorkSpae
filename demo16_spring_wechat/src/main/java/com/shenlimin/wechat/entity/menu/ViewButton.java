package com.shenlimin.wechat.entity.menu;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewButton extends AbstractButton {

    private String type = "view";
    private String url;

    public ViewButton(String name, String url) {
        super(name);
        this.url = url;
    }
}
