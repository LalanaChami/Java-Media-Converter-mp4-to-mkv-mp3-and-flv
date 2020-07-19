package MediaConvertor;

import MediaConvertor.Watcher.Watcher;
import MediaConvertor.Watcher.WatcherInterface;

import java.io.IOException;

public class WatcherAdapter {
    //used adapter pattern to
    WatcherInterface watch = new Watcher();
// Watcher wat = new Watcher();



    public void adapted_mp4TOflv(){
        try {
            watch.check_mp4TOflv();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void adapted_mp4TOmkv(){
        try {
            watch.check_mp4TOmkv();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void adapted_mp4TOmp3(){
        try {
            watch.check_mp4TOmp3();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


