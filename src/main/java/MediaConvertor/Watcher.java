package MediaConvertor;

//In the watcher class java NIO dependency is used to watch the IO functions of the folder
//NIO is a Non blocking IO dependency that allows to watch events in a folder

import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.nio.file.*;

public class Watcher {

    public static void main(String[] args) throws IOException, InterruptedException {
        BasicConfigurator.configure();

        Watcher watch = new Watcher();
        watch.check_mp4TOflv();
       // watch.check_mp4TOmkv();
       // watch.check_mp4TOmp3();
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


                        mp4toflv flv =new mp4toflv();
                        flv.encode(fileName);

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

                        mp4tomkv mkv = new mp4tomkv();
                        mkv.encode(fileName);


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

                        mp4TOmp3 mp3 = new mp4TOmp3();
                        mp3.encode(fileName);


                    } else {
                        System.out.println("File created in valid : " + fileName+" is a not supported file format");
                    }

                }
            }
            valid = watchKey.reset();

        } while (valid);

    }
}
