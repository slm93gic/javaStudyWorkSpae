package com.shenlimin.service.impl;

import com.shenlimin.service.IBuy;
import org.springframework.stereotype.Component;


@Component
public class Boy implements IBuy {

    @Override
    public void buy() {
        System.out.println("男孩买到的轩逸");
    }
}
