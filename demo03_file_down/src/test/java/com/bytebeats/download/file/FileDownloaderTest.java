package com.bytebeats.download.file;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.bytebeats.download.file.config.FileDownloaderConfiguration;

public class FileDownloaderTest {


    public static void main(String[] args) {
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put(null, null);

    }

    public static void main1(String[] args) {


        FileDownloader fileDownloader = FileDownloader.getInstance();
        FileDownloaderConfiguration configuration = FileDownloaderConfiguration
                .newBuilder()
                .readTimeout(10 * 1000)
                .connectTimeout(10 * 1000)
                .corePoolSize(4)
                .downloadDestinationDir(new File("D:/Download"))
                .build();
        fileDownloader.init(configuration);

        String url = "http://pmcvs.weather.com.cn/download/down?dataCode=OCF12H&elements=ME&time=20210603060000&type=L88&accessKeyID=b9348a16013ba81c&format=dat&version=1.0&signature=HWkRZb7QK%2Fg7dvR6AvFKb42yhSk%3D&signatureMethod=HMAC-SHA1&signatureNonce=a6aaae8c-3417-493b-8caa-d9434bb94739&timestamp=1622670848795&fc=original";

        url = "https://csdnimg.cn/release/blogv2/dist/pc/img/tobarCollect.png";
        String filename = "1622670848795_MSP3_PMSC_OCF12H_ME_L88_GLB_20210603060000_00000-36000.dat";
        filename = "tobarCollect.png";
        boolean result = fileDownloader.download(url, filename);
        System.out.println("download result:" + result);
        fileDownloader.destroy();    //close it when you not need
    }
}
