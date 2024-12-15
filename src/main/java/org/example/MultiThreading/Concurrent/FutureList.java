package org.example.MultiThreading.Concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureList {

    static class OmegaRadio implements Callable<String> {

        int i = 0;

        @Override
        public String call() throws InterruptedException{
            i++;
            return "Alpha Romeo Seirra " + i;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException{

        ExecutorService service = Executors.newFixedThreadPool(10);

        List<Future<String>> arr = new ArrayList<>();

        for(int i = 0 ; i < 100 ; i++){
            Future<String> temp = service.submit(new OmegaRadio());

            arr.add(temp);
        }


        int n = arr.size();

        for(int i = 0; i < n ; i++){
            Future<String> it =  arr.get(i);

            System.out.println("Papa Quebec Whiskey " + it.get());
        }

        service.shutdown();

        System.out.println("Hii Bro Bye Bye!!");

    }
}
