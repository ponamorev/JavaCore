package com.andersen.study.parallelStream;

import java.util.concurrent.CountDownLatch;

// Show using a class CountDownLatch
class CDLDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        System.out.println("Start execute thread..");

        new MyThread(countDownLatch);

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Completion execute thread..");
    }
}

class MyThread implements Runnable {
    CountDownLatch latch;

    MyThread(CountDownLatch count) {
        latch = count;
        new Thread(this).start();
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            latch.countDown(); // countdown
        }
    }
}