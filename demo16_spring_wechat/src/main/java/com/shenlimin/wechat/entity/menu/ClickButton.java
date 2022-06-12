package com.shenlimin.wechat.entity.menu;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClickButton extends AbstractButton {
    private String type = "click";
    private String key;

    public ClickButton(String name, String key) {
        super(name);
        this.key = key;
    }
}
