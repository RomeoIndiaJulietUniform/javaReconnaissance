package org.example.MultiThreading;

public class RunnableImpl implements Runnable{

    public void run(){
        for(int i = 0 ; i < 100; i++){
            System.out.println("Master Two Pointer  " + i);

            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }


    public static void main(String[] args){

         RunnableImpl runimpl = new RunnableImpl();

         Thread t2 = new Thread(runimpl);

         t2.start();

         for(int i = 0; i < 100 ; i++){
             System.out.println("Master Segment Tree  " + i);
         }

        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

    }


}


