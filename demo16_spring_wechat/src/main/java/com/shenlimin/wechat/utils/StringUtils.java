package com.shenlimin.wechat.utils;


import cn.hutool.core.util.StrUtil;

public class StringUtils extends StrUtil {

    /**
     * @throws
     * @Description: (判断是否为空)
     * @author: SLM
     * @date: 2019年12月12日 下午1:01:01
     */
    public static boolean isEmpty(Object obj) {
        return (obj == null || "".equals(obj) || "null".equals(obj) || "undefined".equals(obj) || ((obj + "").trim().length() == 0));
    }

}
