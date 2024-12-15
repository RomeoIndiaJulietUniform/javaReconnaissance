package org.example.MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutionServiceToySorter {

    public static void main(String[] args){

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i = 0 ; i < 5 ; i++){

            int loop_number = i;
            executorService.submit(()->{
               System.out.println("Thread number  " + Thread.currentThread().getName() + " loop number " + loop_number);
            });
        }


        executorService.shutdown();

    }


}
