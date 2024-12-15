package org.example.MultiThreading.Concurrent;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerExecutorService {

    private static Deque<Integer> dq = new ArrayDeque<>();

    private synchronized static void producer(int val){
        dq.offerFirst(val);
    }

    private synchronized static int consumer(){
        return dq.pollLast();
    }

    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i = 0 ; i < 50 ; i++){
            final  int val = i;

            if(i%2 == 0){
                executorService.submit(()->{
                    producer(val);
                });
            }
            else{
                executorService.submit(()->{
                   System.out.println(consumer() + " Felon at 6");
                });
            }
        }

        executorService.shutdown();
    }

}
