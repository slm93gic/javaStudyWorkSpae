package com.shenlimin.wechat.entity.menu;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 拍照或者相册发图
 */
@Getter
@Setter
public class PhotoOrAlbumButton extends AbstractButton {

    private String type = "pic_photo_or_album";
    private String key;
    private List<AbstractButton> sub_button = new ArrayList<>();

    public PhotoOrAlbumButton(String name, String key) {
        super(name);
        this.key = key;
    }
}
