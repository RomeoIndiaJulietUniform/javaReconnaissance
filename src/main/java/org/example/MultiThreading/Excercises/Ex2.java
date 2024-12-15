package org.example.MultiThreading.Excercises;

public class Ex2 {

    static int count = 0;

    public static synchronized void incCounter(int value){

        count += value;

        System.out.println("Thread " + Thread.currentThread().getName() + " count val " + count);

    }

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(() -> {
           for(int i = 0; i < 5 ; i++){
               incCounter(2);
           }
        });

        t1.setName("Oscar Mike November Seirra");

        Thread t2 = new Thread(() -> {
             for(int i = 0; i < 5 ; i++){
                 incCounter(20);
             }
        });

        t2.setName("Seirra Whiskey Juliet Papa");


        t1.start();
        t2.start();


        t1.join();
        t2.join();

        System.out.println("Papa Tango Charlie Done");

    }
}
