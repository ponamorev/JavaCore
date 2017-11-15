package com.andersen.study.chap11;
//  This program wouldn't be synchronized while
//  method call() haven't
//  an access modifier 'synchronized'

//  Now synchronized block is used in the program
//  Previous version is commented
class Callme {
    void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Прервано.");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {
    private String msg;
    private final Callme target;
    Thread t;

    Caller(Callme targ, String ms) {
        target = targ;
        msg = ms;
        t = new Thread(this);
        t.start();
    }

    /*public void run() {
        target.call(msg);
    }*/

    // synchronized calling the method call()
    public void run() {
        synchronized (target) {
            target.call(msg);
        }
    }
}

public class Synch {
    public static void main(String[] args) {
        Callme target = new Callme();
        Caller ob1 = new Caller(target, "Добро пожаловать");
        Caller ob2 = new Caller(target, "в синхронизированный");
        Caller ob3 = new Caller(target, "мир!");

        // Wait to end threads
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Прервано.");
        }
    }
}
