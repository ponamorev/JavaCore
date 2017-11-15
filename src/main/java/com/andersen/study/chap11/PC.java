package com.andersen.study.chap11;
// Wrong realisation consumer and producer is changed
// Right realisation is done, changes is noted in comments
class Q {
    private int n;
    // Add in right realisation
    private boolean valueSet = false;

    synchronized void get() {
        // Add in right realisation
        while (!valueSet)
            try {
                wait();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("The exception has been caught.");
            }

        System.out.println("Got: " + n);
        valueSet = false;
        notify();
    }

    synchronized void put(int n) {
        // Add in right realisation
        while (valueSet)
            try {
                wait();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("The exception has been caught.");
            }

        this.n = n;
        valueSet = true;
        System.out.println("Sent: " + n);
        notify();
    }
}

class Producer implements Runnable {
    private Q q;

    Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 0;
        while (true) q.put(i++);
    }
}

class Consumer implements Runnable {
    private Q q;

    Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        while (true) q.get();
    }
}

public class PC {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);

        System.out.println("For stop press Ctrl+F2.");
    }
}
