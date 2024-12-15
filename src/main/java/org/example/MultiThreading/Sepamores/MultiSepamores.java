package org.example.MultiThreading.Sepamores;

import java.util.concurrent.Semaphore;

public class MultiSepamores {


   static Semaphore semaphore = new Semaphore(4);

    public static class Printer extends Thread{

        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName() + " is in line ");

            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + " acquired Lock ");

            semaphore.release();

            System.out.println(Thread.currentThread().getName() + " releasing Lock ");

        }
    }

    public static void main(String[] args) throws InterruptedException{

        Printer t1 = new Printer();
        Printer t2 = new Printer();

        Printer t3 = new Printer();
        Printer t4 = new Printer();

        t1.start();
        t2.start();
        t3.start();
        t4.start();



        t1.join();
        t2.join();
        t3.join();
        t4.join();


        System.out.println("Bye Bye Bro");


    }
}
