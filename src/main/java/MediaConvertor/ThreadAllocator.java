package MediaConvertor;

import MediaConvertor.Watcher.Watcher;

import java.io.IOException;

public class ThreadAllocator {

    private static ThreadAllocator instance;

    //created a private constructor to cerate singleton pattern
    private ThreadAllocator() {

    }

    public static ThreadAllocator getInstance(){
        if(instance == null ){
            instance = new ThreadAllocator();
        }
        return instance;
    }

    public void threadAssigner(){

        WatcherAdapter watch=new WatcherAdapter();



        Runnable thread1 = () -> {


                watch.adapted_mp4TOflv();


        };
        Thread t1 = new Thread(thread1);
        t1.start();


        Runnable thread2 = () -> {

                watch.adapted_mp4TOmkv();


        };
        Thread t2 = new Thread(thread2);
        t2.start();


        Runnable thread3 = () -> {

                watch.adapted_mp4TOmp3();



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
}
