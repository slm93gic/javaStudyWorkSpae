package com.shenlimin.wechat.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class Utils {

    /**
     * 获取参数
     *
     * @param request
     * @return
     */
    public static Map<String, Object> getParameters(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        Enumeration<String> enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            Object value = request.getParameter(key);
            if (!StringUtils.isEmpty(value)) {
                map.put(key, value);
            }
        }
        return map;
    }

}
