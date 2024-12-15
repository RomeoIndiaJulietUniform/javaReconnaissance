package org.example.MultiThreading.Concurrent;

import java.util.concurrent.*;

public class FutureTest {

    private static int count = 0;

    static class incCount implements Callable<Integer>{

        @Override
        public Integer call() throws Exception{
          return ++count;
        }

    }


    public static void main(String[] args) throws ExecutionException {

        ExecutorService sec = Executors.newFixedThreadPool(4);

        Future<Integer> fr = sec.submit(new incCount());

        try{
            System.out.println("Papa Quebec  " + fr.get());
        }
        catch (Exception e){
            e.getMessage();
        }

        sec.shutdown();

        System.out.println("Bye bye");
    }
}

