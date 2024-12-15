package org.example.MultiThreading.Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest {

    private static int count = 0;

    private static final int max_count = 100;

    static void IncCount(){

        while(count < max_count){

            count++;
            System.out.println("Thread Name  " + Thread.currentThread().getName() + " value " + count);

        }

    }

    public static void main(String[] args){
        ExecutorService service = Executors.newFixedThreadPool(10);


        for(int i = 0; i < 10 ; i++){
             service.execute(()->IncCount());
        }

        service.shutdown();

        try {
            if (!service.awaitTermination(60, java.util.concurrent.TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }

        System.out.println("Papa Quebec");
    }
}
