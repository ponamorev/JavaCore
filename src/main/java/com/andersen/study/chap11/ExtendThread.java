package com.andersen.study.chap11;
// Создание второго потока исполнения через расширение класса Thread
class NewThreadTwo extends Thread {
    NewThreadTwo() {
        // создание нового потока исполнения
        super("Демонстрационный поток");
        System.out.println("Дочерний поток: " + this);
        start(); // запуск потока на исполнение
    }

    // Точка входа во второй поток исполнения
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

public class ExtendThread {
    public static void main(String[] args) {
        new NewThreadTwo(); // создание нового потока исполнения

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
