package org.example.MultiThreading;

public class NumberPrinting {

    public static void main(String[] args) {
        Thread primeNumber = new Thread(() -> {
            for (int i = 2; i < 100; i++) {
                boolean isPrime = true;

                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    System.out.println("Prime: " + i);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread evenNumber = new Thread(() -> {
            for (int i = 0; i < 40; i += 2) {
                System.out.println("Even: " + i);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        primeNumber.start();
        evenNumber.start();
    }
}