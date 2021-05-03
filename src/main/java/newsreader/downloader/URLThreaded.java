package newsreader.downloader;

import java.util.concurrent.Callable;

public class URLThreaded implements Callable {
    private String url;
    private Downloader downloader;

    public URLThreaded(String url, Downloader downloader){
        this.url = url;
        this.downloader = downloader;
    }

    @Override
    public String call() throws Exception {
        return downloader.saveUrl2File(url);
    }
}
