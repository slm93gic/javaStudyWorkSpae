package com.shenlimin.service.impl;

import com.shenlimin.service.IBuy;
import org.springframework.stereotype.Component;

@Component
public class Girl implements IBuy {

    @Override
    public void buy() {
        System.out.println("女孩买的帅哥");
    }
}
