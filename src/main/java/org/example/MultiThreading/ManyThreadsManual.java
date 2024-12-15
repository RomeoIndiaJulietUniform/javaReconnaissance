package org.example.MultiThreading;

import java.util.Arrays;

public class ManyThreadsManual {

    private static final Object lock = new Object();

    private static final int max_counter = 100;

    private static int count = 1;

    private static class ThreadRunner extends Thread{

          public void run(){
              while(true){
                  synchronized (lock){
                      if(count > 100){
                          lock.notifyAll();
                          break;
                      }

                      count++;
                      lock.notify();

                      System.out.println("Thread name " + Thread.currentThread().getName() + " value  " + count);

                      try{
                          lock.wait();
                      }
                      catch (InterruptedException e){
                          System.out.println(e.getMessage());
                      }
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
