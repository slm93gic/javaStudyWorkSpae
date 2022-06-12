package com.shenlimin;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class RequestUtils {

    /**
     *
     */
    public static String get(String url) throws Exception {
        return sendHttpRequest(url, null, "GET");
    }

    /**
     *
     */
    public static String get(String url, Map<String, Object> params) throws Exception {
        return sendHttpRequest(url, params, "GET");
    }

    /**
     *
     */
    public static String post(String url) throws Exception {
        return sendHttpRequest(url, null, "POST");
    }

    /**
     *
     */
    public static String post(String url, Map<String, Object> params) throws Exception {
        return sendHttpRequest(url, params, "POST");
    }

    /**
     *
     */
    public static String sendHttpRequest(String requestUrl, Map<String, Object> params, String way) throws Exception {
        URL url = new URL(requestUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(way);
        if (!(null == params)) {
            String param = getParams(params);
            connection.setDoInput(true);
            connection.getOutputStream().write(param.getBytes(StandardCharsets.UTF_8));
        }
        connection.connect();

        StringBuilder buffer = new StringBuilder();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            inputStream = connection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) inputStream.close();
                if (inputStreamReader != null) inputStreamReader.close();
                if (bufferedReader != null) bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return buffer.toString();
    }

    /**
     *
     */
    private static String getParams(Map<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (entry.getValue() != null) {
                sb.append("&").append(entry.getKey()).append("=").append(entry.getValue());
            }
        }

        if (sb.length() != 0) {
            return sb.substring(1, sb.length() - 1).toString();
        }
        return "";
    }


}
