package org.example.MultiThreading;




class ThreadTest extends Thread{


    public void run(){

        synchronized (this){

            System.out.println("Thread is currently running!!!!!");

            try{
                Thread.sleep(10000);
            }
            catch (InterruptedException e){
                System.out.println("Subclass " + e);
            }

            notify();

        }



    }


}





public class Notify {


    public static void main(String[] args){

        ThreadTest t1 = new ThreadTest();


        synchronized (t1){

            t1.start();

            try {
                t1.wait();
            } catch (InterruptedException e) {
                System.out.println(e.getStackTrace());
            }

            System.out.println("Hello World");

        }



    }
}
