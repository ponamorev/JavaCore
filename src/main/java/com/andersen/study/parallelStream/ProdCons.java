package com.andersen.study.parallelStream;

import java.util.concurrent.Semaphore;

// Realization producer and consumer which use a
// semaphore for synchronization control
class Q {
    private int n;

    // start with unavailable consumer semaphore
    private static Semaphore semConsumer = new Semaphore(0);
    private static Semaphore semProducer = new Semaphore(1);

    void get() {
        try {
            semConsumer.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Got: " + n);
        semProducer.release();
    }

    void pun(int n) {
        try {
            semProducer.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.n = n;
        System.out.println("Sent: " + n);
        semConsumer.release();
    }
}

class Producer implements Runnable {
    private Q q;

    Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        for (int i = 0; i < 20; i++)
            q.pun(i);
    }
}

class Consumer implements Runnable {
    private Q q;

    Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        for (int i = 0; i < 20; i++) q.get();
    }
}

class ProdCons {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}
