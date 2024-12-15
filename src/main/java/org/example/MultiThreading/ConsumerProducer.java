package org.example.MultiThreading;

import java.util.LinkedList;
import java.util.Queue;

public class ConsumerProducer {
    private static volatile boolean running = true;

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int maxSize = 5;

        Thread producer = new Thread(() -> {
            int value = 0;
            while (running) {
                synchronized (queue) {
                    while (queue.size() == maxSize) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Produced: " + value);
                    queue.add(value++);
                    queue.notify();
                }
            }
            System.out.println("Producer stopped.");
        });

        Thread consumer = new Thread(() -> {
            while (running) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int value = queue.poll();
                    System.out.println("Consumed: " + value);
                    queue.notify();
                }
            }
            System.out.println("Consumer stopped.");
        });

        producer.start();
        consumer.start();


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        stopThreads();
    }


    private static void stopThreads() {
        running = false;
        synchronized (ConsumerProducer.class) {

            ConsumerProducer.class.notifyAll();
        }
    }
}
