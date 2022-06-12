package thread.download;

/**
 * 多线程2下载图片
 */
public class P05RunableDownload implements Runnable {

    WebDownloader downloader = new WebDownloader();

    private final String url;
    private final String fileName;

    P05RunableDownload(String url, String fileName) {
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
        P05RunableDownload runable1 = new P05RunableDownload(url, "p1.jpg");
        P05RunableDownload runable2 = new P05RunableDownload(url, "p2.jpg");
        P05RunableDownload runable3 = new P05RunableDownload(url, "p3.jpg");
        new Thread(runable1).start();
        new Thread(runable2).start();
        new Thread(runable3).start();
    }
}


