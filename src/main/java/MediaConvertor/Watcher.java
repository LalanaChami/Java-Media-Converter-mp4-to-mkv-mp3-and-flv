package MediaConvertor;

import MediaConvertor.mp4TOmp3;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Watcher  {

    public static void main(String[] args) {

        BasicConfigurator.configure();

        Watcher watch = new Watcher();
        watch.threadAssigner();

//        watch.check_mp4TOflv();
//        watch.check_mp4TOmkv();
//        watch.check_mp4TOmp3();


    }

    public void threadAssigner(){

        Runnable thread1 = () -> {
            try {
                check_mp4TOflv() ;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread t1 = new Thread(thread1);
        t1.start();


        Runnable thread2 = () -> {
            try {
                check_mp4TOmkv();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread t2 = new Thread(thread2);
        t2.start();


        Runnable thread3 = () -> {
            try {
                check_mp4TOmp3();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread t3 = new Thread(thread3);
        t3.start();


        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }



    //checks wheather new mp4 is added to mp4TOflv file
   public void check_mp4TOflv() throws IOException, InterruptedException {

        Path faxFolder = Paths.get("/Users/admin/Documents/mediaConvertor/media/mp4Toflv/");
        WatchService watchService = FileSystems.getDefault().newWatchService();
        faxFolder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        boolean valid = true;
        do {
            WatchKey watchKey = watchService.take();

            for (WatchEvent event : watchKey.pollEvents()) {
                WatchEvent.Kind kind = event.kind();
                if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {
                    String fileName = event.context().toString();

                    //if the newly added file extension is .mp4 encode() is called
                    if ( fileName.toString().endsWith(".mp4")){
                        System.out.println("New File Added : " + fileName);

                       // mp4TOflv flv =new mp4TOflv();
                       // flv.encode(fileName);

                    } else {
                        System.out.println("File created in valid : " + fileName+" is a not supported file format");
                    }

                }
            }
            valid = watchKey.reset();

        } while (valid);

    }

    //checks wheather new mp4 is added to mp4TOmkv file
   public void check_mp4TOmkv() throws IOException, InterruptedException {

        Path faxFolder = Paths.get("/Users/admin/Documents/mediaConvertor/media/mp4Tomkv/");
        WatchService watchService = FileSystems.getDefault().newWatchService();
        faxFolder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        boolean valid = true;
        do {
            WatchKey watchKey = watchService.take();

            for (WatchEvent event : watchKey.pollEvents()) {
                WatchEvent.Kind kind = event.kind();
                if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {
                    String fileName = event.context().toString();

                    //if the newly added file extension is .mp4 encode() is called
                    if ( fileName.toString().endsWith(".mp4")){
                        System.out.println("New File Added : " + fileName);

                      //  mp4TOmkv mkv =new mp4TOmkv();
                      //  mkv.encode(fileName);


                    } else {
                        System.out.println("File created in valid : " + fileName+" is a not supported file format");
                    }

                }
            }
            valid = watchKey.reset();

        } while (valid);

    }

    //checks wheather new mp4 is added to mp4TOmp3 file
    public void check_mp4TOmp3() throws IOException, InterruptedException {

        Path faxFolder = Paths.get("/Users/admin/Documents/mediaConvertor/media/mp4Tomp3/");
        WatchService watchService = FileSystems.getDefault().newWatchService();
        faxFolder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        boolean valid = true;
        do {
            WatchKey watchKey = watchService.take();

            for (WatchEvent event : watchKey.pollEvents()) {
                WatchEvent.Kind kind = event.kind();
                if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {
                    String fileName = event.context().toString();

                    //if the newly added file extension is .mp4 encode() is called
                    if ( fileName.toString().endsWith(".mp4")){
                        System.out.println("New File Added : " + fileName);

                        mp4TOmp3 mp3 =new mp4TOmp3();
                       // mp3.encode(fileName);


                    } else {
                        System.out.println("File created in valid : " + fileName+" is a not supported file format");
                    }

                }
            }
            valid = watchKey.reset();

        } while (valid);

    }
}