package com.andersen.study.parallelStream;

import java.util.concurrent.Exchanger;

// Show using a class Exchanger<V>
class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new UseString(exchanger);
        new MakeString(exchanger);
    }
}

// Thread type thread forms a symbols string
class MakeString implements Runnable {
    private Exchanger<String> ex;
    private String makingString;

    MakeString(Exchanger<String> exchange) {
        ex = exchange;
        makingString = "";
        new Thread(this).start();
    }

    public void run() {
        char ch = 'A';
        for (int i = 0; i < 3; i++) {
            // fill a buffer
            for (int j = 0; j < 5; j++)
                makingString += (char) ch++;
            try {
                // exchange filled buffer to empty buffer
                makingString = ex.exchange(makingString);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

// Thread type thread uses a symbols string
class UseString implements Runnable {
    private Exchanger<String> ex;
    private String usingString;

    UseString(Exchanger<String> exchange) {
        ex = exchange;
        usingString = "";
        new Thread(this).start();
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                // exchange empty buffer to filled buffer
                usingString = ex.exchange("");
                System.out.println("Got: " + usingString);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}