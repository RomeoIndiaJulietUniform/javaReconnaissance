package org.example.MultiThreading;

public class SynchronizationBasics extends Thread{

    private  int count = 0;

    synchronized void incCount(){
        count++;
    }

    synchronized int getCount(){
         return count;
    }

    public static class incTest implements Runnable{

        private final SynchronizationBasics t1;

        public incTest(SynchronizationBasics t1){
            this.t1 = t1;
        }

        @Override
        public void run(){
            for(int i = 0; i < 100; i++){
                t1.incCount();
            }
        }

    }


    public static void main(String[] args) throws InterruptedException{


        SynchronizationBasics syncBase = new SynchronizationBasics();

        incTest t1 = new incTest(syncBase);



        Thread testThread = new Thread(t1);

        Thread testThread2 = new Thread(t1);

        testThread.start();
        testThread2.start();

        testThread.join();

        testThread2.join();


        System.out.println(syncBase.getCount());

    }
}
