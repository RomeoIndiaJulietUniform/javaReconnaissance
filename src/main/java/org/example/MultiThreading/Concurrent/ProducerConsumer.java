package org.example.MultiThreading.Concurrent;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ProducerConsumer {

    private static Deque<Integer> dq = new ArrayDeque<>();

    private synchronized static void producer(int val){
        dq.offerFirst(val);
    }

    private synchronized static int consumer(){
        return dq.pollLast();
    }

    public static void main(String[] args) throws InterruptedException{

        Thread prod = new Thread(()->{
           for(int i = 0; i < 10 ; i++){
               producer(i);
           }
        });

        prod.start();

        List<Integer> ans_arr = new ArrayList<>();

        Thread cons = new Thread(()->{
           for(int i = 0; i < 10 ; i++){
               ans_arr.add(consumer());
           }
        });


        cons.start();


        prod.join();
        cons.join();


        for(int i = 0; i < ans_arr.size() ; i++){
            System.out.println("Papa Novemeber " + ans_arr.get(i));
        }


        System.out.println("Bye Bye");

    }
}
