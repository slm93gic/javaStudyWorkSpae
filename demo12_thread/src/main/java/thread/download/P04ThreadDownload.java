package thread.download;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

/**
 * 多线程1下载图片
 * p2
 */
public class P04ThreadDownload extends Thread {

    WebDownloader downloader = new WebDownloader();

    private String url;
    private String fileName;

    P04ThreadDownload(String url, String fileName) {
        this.fileName = fileName;
        this.url = url;
    }

    @Override
    public void run() {
        downloader.download(url, fileName);
        System.out.println("下载的文件名：" + fileName);
    }

    public static void main(String[] args) {
        String url = "https://img-s-msn-com.akamaized.net/tenant/amp/entityid/BB1gGPSo.img?h=600&w=799&m=6&q=60&o=f&l=f";
        P04ThreadDownload thread1 = new P04ThreadDownload(url, "p1.jpg");
        P04ThreadDownload thread2 = new P04ThreadDownload(url, "p2.jpg");
        P04ThreadDownload thread3 = new P04ThreadDownload(url, "p3.jpg");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}


