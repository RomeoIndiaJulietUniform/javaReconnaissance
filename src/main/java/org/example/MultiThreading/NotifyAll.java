package org.example.MultiThreading;

class ThreadTest1 extends Thread{


    public void run(){

        synchronized (this){

            System.out.println("Thread is currently running!!!!!");

            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println("Subclass " + e);
            }

            notify();

        }



    }


}



public class NotifyAll {

    public static void main(String[] args){

        ThreadTest1 t1 = new ThreadTest1();


        ThreadTest1 t2 = new ThreadTest1();


        synchronized (t1){

            t1.start();

            try {
                t1.wait();
            } catch (InterruptedException e) {
                System.out.println(e.getStackTrace());
            }

            System.out.println("Hello World");

        }


        synchronized (t1){

            t2.start();

            try {
                t2.wait();
            } catch (InterruptedException e) {
                System.out.println(e.getStackTrace());
            }

            System.out.println("Hello World");

        }




    }
}
