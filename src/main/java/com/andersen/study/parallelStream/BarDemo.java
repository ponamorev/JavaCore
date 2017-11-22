package com.andersen.study.parallelStream;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

// Show using a class CyclicBarrier
class BarDemo {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, new BarAction());

        System.out.println("Start execute threads..");

        new MyThreadBar(barrier, "A");
        new MyThreadBar(barrier, "B");
        new MyThreadBar(barrier, "C");
        new MyThreadBar(barrier, "X");
        new MyThreadBar(barrier, "Y");
        new MyThreadBar(barrier, "Z");
    }
}

// thread with a CyclicBarrier type barrier
class MyThreadBar implements Runnable {
    private CyclicBarrier barrier;
    private String name;

    MyThreadBar(CyclicBarrier cyc, String nm) {
        barrier = cyc;
        name = nm;
        new Thread(this).start();
    }

    public void run() {
        System.out.println(name);

        try {
            barrier.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            System.out.println(e);
        }
    }
}

// An object of this class is called when
// a CyclicBarrier type barrier is reached
class BarAction implements Runnable {
    public void run() {
        System.out.println("Barrier is reached!");
    }
}