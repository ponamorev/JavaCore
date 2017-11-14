package com.andersen.study.chap11;

import com.sun.org.apache.bcel.internal.generic.NEW;

// Создание второго потока исполнения
class NewThread implements Runnable {
    Thread t;

    NewThread() {
        // создание нового, второго потока исполнения
        t = new Thread(this, "Демонстрационный поток");
        System.out.println("Дочерний поток создан: " + t);
        t.start();
    }

    // Точка входа во второй поток
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Дочерний поток: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.err.println("Дочерний поток прерван!");
        }

        System.out.println("Дочерний поток завершён!");
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        new NewThread(); // создание нового потока в главном потоке

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Главный поток: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println("Главный поток прерван!");
        }

        System.out.println("Главный поток завершён!");
    }
}
