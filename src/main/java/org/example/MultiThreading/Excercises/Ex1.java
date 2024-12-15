package org.example.MultiThreading.Excercises;

public class Ex1 extends Thread {

    public static void main(String[] args) throws InterruptedException{

        Runnable t1 =() -> {
            for (int i = 0; i <= 10; i++) {
                System.out.println("Thread " + Thread.currentThread().getName()+  " output is  " + i);
            }
        };

        Thread tt1 = new Thread(t1, "Oscar Mike");

        Runnable t2 = ()->{
            for(int i = 11; i <= 20 ; i++){
                System.out.println("Thread " + Thread.currentThread().getName()+  " output is  " + i);
            }
        };



        Thread tt2 = new Thread(t2,"November Whiskey move ahead ");

        tt1.start();
        tt2.start();

        tt1.join();
        tt2.join();


        System.out.println("Done Bro");
    }

}
