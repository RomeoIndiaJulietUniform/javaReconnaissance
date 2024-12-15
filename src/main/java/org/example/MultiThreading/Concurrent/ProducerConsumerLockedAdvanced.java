package org.example.MultiThreading.Concurrent;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ProducerConsumerLockedAdvanced {

    private static Deque<Integer> dq = new ArrayDeque<>();

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition producer = lock.newCondition();
    private static Condition consumer = lock.newCondition();

    private static int max_size = Integer.MAX_VALUE;

    private static void Produce(int val) throws InterruptedException{
        lock.lock();
        try{
            if(dq.size() == max_size){
                producer.await();
            }

            Thread.sleep(50);

            System.out.println("Serra Alpha  : " + val);

            dq.offerFirst(val);

            consumer.signal();
        }
        finally {
            lock.unlock();
        }



    }


    private static int Consumer() throws InterruptedException{
        lock.lock();
       try{
           if(dq.isEmpty()){
               consumer.await();
           }

           producer.signal();

           int val = dq.pollLast();

           System.out.println("Papa Quebec : " + val);

           Thread.sleep(65);

           return val;

       }
       finally {


           lock.unlock();

       }
    }


    public static void main(String[] args) throws InterruptedException{
        Thread prod = new Thread(()->{
           for(int i = 0 ; i < 40; i++){
               try {
                   Produce(i);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });




        List<Integer> ansArr = new ArrayList<>();

        Thread consume = new Thread(()->{
           for(int i = 0; i < 40; i++){
               try {
                   ansArr.add(Consumer());
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });

        consume.start();
        prod.start();


        prod.join();
        consume.join();

//        for (int i = 0; i < ansArr.size(); i++) {
//            System.out.println("Papa November " + ansArr.get(i));
//        }
//
//        System.out.println("Bye Bye");
    }



}
