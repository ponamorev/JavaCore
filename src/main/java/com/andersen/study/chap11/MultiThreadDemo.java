package com.andersen.study.chap11;
// Создание нескольких потоков исполнения
class NewThreadThree implements Runnable {
    String name;

    Thread t;

    NewThreadThree(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("Новый поток: " + t);
        t.start();
    }

    // Точка входа в поток исполнения
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println("Поток " + name + " прерван!");
        }

        System.out.println("Поток " + name + " завершён!");
    }
}

public class MultiThreadDemo {
    public static void main(String[] args) {
        new NewThreadThree("Один"); // Запуск потоков на исполнение
        new NewThreadThree("Два");
        new NewThreadThree("Три");

        try {
            // Ожидание завершения других потоков
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            System.err.println("Главный поток прерван!");
        }

        System.out.println("Главный поток завершён!");
    }
}
