package com.andersen.study.parallelStream;

import java.util.concurrent.Semaphore;

class SemDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        new IncThread(semaphore, "A");
        new DecThread(semaphore, "B");
    }
}

// common resource
class Shared {
    static int count = 0;
}

// thread increase count
class IncThread implements Runnable {
    private String name;
    private Semaphore semaphore;
    IncThread(Semaphore s, String n) {
        semaphore = s;
        name = n;
        new Thread(this).start();
    }

    public void run() {
        System.out.println("Start execute thread " + name);
        try {

            // get resolution
            System.out.println("Thread " + name + " waits a resolution.");
            semaphore.acquire();
            System.out.println("Thread " + name + " gets a resolution.");

            // get access to common resource
            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);

                // enable switching context if it's possible
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        // release a resolution
        System.out.println("Thread " + name + " releases a resolution.");
        semaphore.release();
    }
}

// thread decrease count
class DecThread implements Runnable {
    private String name;
    private Semaphore semaphore;

    DecThread(Semaphore s, String n) {
        semaphore = s;
        name = n;
        new Thread(this).start();
    }

    public void run() {
        System.out.println("Start execute thread " + name);
        try {

            // get resolution
            System.out.println("Thread " + name + " waits a resolution.");
            semaphore.acquire();
            System.out.println("Thread " + name + " gets a resolution.");

            // get access to common resource
            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);

                // enable switching context if it's possible
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        // release a resolution
        System.out.println("Thread " + name + " releases a resolution.");
        semaphore.release();
    }
}