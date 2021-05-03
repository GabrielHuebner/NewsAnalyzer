package newsreader.downloader;

import java.util.List;

public class SequentialDownloader extends Downloader {

    @Override
    public int process(List<String> urls) {
        int count = 0;
        for (String url : urls) {
            if(url == null){
                continue;
            }
            String fileName = saveUrl2File(url);
            if(fileName != null)
                count++;
        }
        return count;
    }
}
