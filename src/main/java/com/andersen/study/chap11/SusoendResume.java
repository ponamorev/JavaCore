package com.andersen.study.chap11;
// Suspend and resume of execution thread by modern way
class NewThreadFive implements Runnable {
    String name; // execution thread name
    Thread thread;
    boolean suspendFlag;

    NewThreadFive(String threadName) {
        name = threadName;
        thread = new Thread(this, name);
        System.out.println("New thread: " + thread);
        suspendFlag = false;
        thread.start();
    }

    // Entry point in thread
    public void run() {
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag)
                        wait();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted.");
        }

        System.out.println(name + " has been finished.");
    }

    synchronized void mySuspend() {
        suspendFlag = true;
    }

    synchronized void myResume() {
        suspendFlag = false;
        notify();
    }
}

public class SusoendResume {
    public static void main(String[] args) {
        NewThreadFive ob1 = new NewThreadFive("One");
        NewThreadFive ob2 = new NewThreadFive("Two");

        try {
            Thread.sleep(1000);
            ob1.mySuspend();
            System.out.println("Suspend of thread \"One\"");
            Thread.sleep(1000);
            ob1.myResume();
            System.out.println("Resume of thread \"One\"");
            ob2.mySuspend();
            System.out.println("Suspend of thread \"Two\"");
            Thread.sleep(1000);
            ob2.myResume();
            System.out.println("Resume of thread \"Two\"");
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        // Wait to finish threads
        try {
            System.out.println("Wait to finish threads.");
            ob1.thread.join();
            ob2.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        System.out.println("Main thread has been finished.");
    }
}
