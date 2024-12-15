package org.example.MultiThreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ManyThreadReentrant {


    static  ReentrantLock newLock = new ReentrantLock();

    static final Condition condition = newLock.newCondition();

    private static final int max_counter = 100;

    private static int count = 1;

    private static class ThreadRunner extends Thread{

        public void run(){
            while(true){
               try {
                   newLock.lock();
                   if (count > 100) {
                       condition.signalAll();
                       break;
                   }

                   count++;

                   condition.signal();
                   condition.await();

                   System.out.println("Thread name " + Thread.currentThread().getName() + " value  " + count);
               }
                    catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                    finally{
                        newLock.unlock();
                }

            }
        }

    }

    public static void main(String[] args){

        ThreadRunner[] thread = new ThreadRunner[11];

        for(int i = 1; i <= 10 ; i++){
            thread[i] = new ThreadRunner();
            thread[i].setName("Thread No. " + i);
            thread[i].start();
        }

        for(int i = 1; i <= 10 ; i++){
            try{
                thread[i].join();
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
        }

        System.out.println("Hello Boss Done");

    }
}
