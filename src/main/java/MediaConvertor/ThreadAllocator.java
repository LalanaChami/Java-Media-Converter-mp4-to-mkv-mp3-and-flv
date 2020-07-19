package MediaConvertor;

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

        Watcher watch = new Watcher();

        Runnable thread1 = () -> {
            try {

                watch.check_mp4TOflv();
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
                watch.check_mp4TOmkv();
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
                watch.check_mp4TOmp3();
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
}
