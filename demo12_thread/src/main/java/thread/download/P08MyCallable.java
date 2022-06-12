package thread.download;

/**
 * 创建线程的方式3
 */

import java.util.concurrent.*;

public class P08MyCallable implements Callable<Boolean> {


    WebDownloader downloader = new WebDownloader();
    //创建服务
    private static final ExecutorService executorService = Executors.newFixedThreadPool(3);

    private String url;
    private String fileName;

    P08MyCallable(String url, String fileName) {
        this.fileName = fileName;
        this.url = url;
    }


    @Override
    public Boolean call() throws Exception {
        downloader.download(url, fileName);
        System.out.println("下载的文件名：" + fileName);
        return false;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String url = "http://p9.itc.cn/images01/20200909/1e5d1f4b881749ceaf91877914e4d3bf.jpeg";
        P08MyCallable thread1 = new P08MyCallable(url, "p1.jpeg");
        P08MyCallable thread2 = new P08MyCallable(url, "p2.jpeg");
        P08MyCallable thread3 = new P08MyCallable(url, "p3.jpeg");

        Future<Boolean> r1 = executorService.submit(thread1);
        Future<Boolean> r2 = executorService.submit(thread2);
        Future<Boolean> r3 = executorService.submit(thread3);
        Boolean aBoolean1 = r1.get();
        Boolean aBoolean2 = r2.get();
        Boolean aBoolean3 = r3.get();
        executorService.shutdown();
    }
}
