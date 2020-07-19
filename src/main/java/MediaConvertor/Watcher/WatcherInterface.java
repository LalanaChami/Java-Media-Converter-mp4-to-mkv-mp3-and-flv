package MediaConvertor.Watcher;

import MediaConvertor.Watcher;

import java.io.IOException;

public interface WatcherInterface {
    public void check_mp4TOflv() throws IOException, InterruptedException ;
    public void check_mp4TOmkv() throws IOException, InterruptedException ;
    public void check_mp4TOmp3() throws IOException, InterruptedException ;

}
