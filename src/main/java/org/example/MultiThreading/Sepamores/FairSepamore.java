package org.example.MultiThreading.Sepamores;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class FairSepamore {

    private static Semaphore semaphore = new Semaphore(4,true);


    private static void randGen() throws InterruptedException{
        System.out.println("Thread " + Thread.currentThread().getName() + " is waiting ");
        semaphore.acquire();
        System.out.println("Thread " + Thread.currentThread().getName() + " has entered ");
        System.out.println("Papa Quebec Whiskey November Charlie " + Math.random());
        semaphore.release();
        System.out.println("Thread " + Thread.currentThread().getName() + " is outside now ");
    }


    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i = 0; i < 10 ; i++){
            executorService.submit(() ->{
                try {
                    randGen();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService.shutdown();
    }


}
