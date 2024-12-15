package org.example.MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ManyThreads {

    private static final int max_count = 100;
    private static int count = 0;
    public static final Object lock = new Object();


   static class ThreadTest extends Thread{

        @Override
        public void run(){
            while(true){
                synchronized (lock){
                    if (count >= max_count) {
                        lock.notify();
                        break;
                    }
                    count++;
                    System.out.println("Current Thread name  " + Thread.currentThread().getName() + " value " + count);
                    lock.notifyAll();
                    try{
                        lock.wait();
                    }
                    catch (InterruptedException e){
                        System.out.println(e.getStackTrace());
                        break;
                    }
                }
            }
        }

   }


    public static void main(String[] args) throws InterruptedException{

        ExecutorService service = Executors.newFixedThreadPool(10);

        for(int i = 0;  i < 10 ; i++){
            service.submit(new ThreadTest());
        }

        service.shutdown();

        if (service.awaitTermination(1, java.util.concurrent.TimeUnit.MINUTES)) {
            System.out.println("All threads executed successfully.");
        } else {
            System.out.println("Timeout occurred while waiting for threads to finish.");
        }

    }
}
