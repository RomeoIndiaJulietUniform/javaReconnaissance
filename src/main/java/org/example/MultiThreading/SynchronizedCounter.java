package org.example.MultiThreading;

public class SynchronizedCounter {
    static class Counter{

        private int counter = 0;

        public synchronized void inc(){
            counter++;
        }


        public int getCount(){
            return counter;
        }
    }


    public static void main(String[] args) throws InterruptedException{


        Counter count = new Counter();


        Runnable task = () ->{

            for(int i = 0; i < 70000 ; i++){
                count.inc();
            }

        };


        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();


        System.out.println("Sum is " + count.getCount());
    }

}