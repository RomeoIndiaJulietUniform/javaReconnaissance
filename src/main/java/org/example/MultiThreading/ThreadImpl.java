package org.example.MultiThreading;

public class ThreadImpl extends Thread {

    public void run(){
        for(int i = 0; i < 100000000 ; i++){
            System.out.println("Thread 1 " + i);
        }
    }



    public static void main(String[] args){
        ThreadImpl t1 = new ThreadImpl();

        t1.start();

        for(int i = 0 ; i < 100000000 ; i++){
            System.out.println("Thread 2  " + i);
        }
    }

}




