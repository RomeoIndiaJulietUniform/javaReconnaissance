package org.example.MultiThreading;

public class Deadlock {

    static final Object lock1 = new Object();
    static final Object lock2 = new Object();


    static class Deadlock1 extends Thread{


        @Override
        public void run(){
            while(true){
                synchronized (lock1){

                    System.out.println("Lock1 entered  Deadlock1!");

                    try{
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e){
                        System.out.println(e);
                    }

                    synchronized (lock2){
                        System.out.println("Entered lock2 Deadlock1");
                    }
                }
            }
        }

    }


    static class Deadlock2 extends Thread{

        @Override
        public void run(){


            while(true){
                synchronized (lock2){

                    System.out.println("Lock1 entered  Deadlock2!");

                    try{
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e){
                        System.out.println(e);
                    }

                    synchronized (lock1){
                        System.out.println("Entered lock2 Deadlock2");
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException{

        Deadlock1 t1 = new Deadlock1();
        Deadlock2 t2 = new Deadlock2();

        t2.start();


        t1.start();

        t1.join();
        t2.join();



        System.out.println("Heeeeeeeeeeeee");
    }


}
