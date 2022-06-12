package thread.download;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

public class WebDownloader {

    public void download(String url, String fileName) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
